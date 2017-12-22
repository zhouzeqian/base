package com.llc.websocket;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.beust.jcommander.internal.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.llc.entity.Message;

@Component
public class SystemWebSocketHandler implements WebSocketHandler {
	private Logger log = LoggerFactory.getLogger(SystemWebSocketHandler.class);
	@Resource
	private ThreadPoolTaskExecutor taskExecutor;

	public static final HashMap<Integer, WebSocketSession> userSocketSessionMap = Maps.newHashMap();

	/**
	 * 建立连接后
	 */
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		Integer uid = (Integer) session.getAttributes().get("uid");
		String name = (String) session.getAttributes().get("name");
		log.info("用户" + name + "已上线");
		if (userSocketSessionMap.get(uid) == null) {
			userSocketSessionMap.put(uid, session);
		}

		// 更新在线用户列表
		Iterator<Entry<Integer, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
		List<Map<String, Object>> list = Lists.newArrayList();
		while (it.hasNext()) {
			Map<String, Object> map = Maps.newTreeMap();
			Entry<Integer, WebSocketSession> entry = it.next();
			map.put("uid", entry.getKey());
			map.put("name", entry.getValue().getAttributes().get("name"));
			list.add(map);
		}
		Map<String, Object> maps = Maps.newTreeMap();
		maps.put("onlineUsers", list);
		broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(maps)));
	}

	/**
	 * 消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
	 */
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		if (message.getPayloadLength() == 0)
			return;
		Message msg = new Gson().fromJson(message.getPayload().toString(), Message.class);
		msg.setSendTime(new Date());
		sendMessageToUser(msg.getToId(),
				new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
	}

	/**
	 * 消息传输错误处理
	 */
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
		Iterator<Entry<Integer, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
		// 更新在线用户列表
		List<Map<String, Object>> list = Lists.newArrayList();
		// 移除Socket会话
		while (it.hasNext()) {
			Entry<Integer, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				log.info("Socket会话已经移除:用户ID" + entry.getKey());
				break;
			} else {
				Map<String, Object> map = Maps.newTreeMap();
				map.put("uid", entry.getKey());
				map.put("name", entry.getValue().getAttributes().get("name"));
				list.add(map);
			}

		}
		Map<String, Object> maps = Maps.newTreeMap();
		maps.put("onlineUsers", list);
		broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(maps)));

	}

	/**
	 * 关闭连接后
	 */
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		log.info("Websocket:" + session.getId() + "已经关闭");
		Iterator<Entry<Integer, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
		// 移除Socket会话
		while (it.hasNext()) {
			Entry<Integer, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				log.info("Socket会话已经移除:用户ID" + entry.getKey());
				break;
			}
		}
	}

	public boolean supportsPartialMessages() {
		return false;
	}

	/**
	 * 给所有在线用户发送消息
	 * 
	 * @param message
	 * @throws IOException
	 */
	public void broadcast(final TextMessage message) throws IOException {
		// 线程池多线程群发 lambda表达式
		userSocketSessionMap.entrySet().forEach(userOnline -> {
			taskExecutor.execute(new Thread(() -> {
				if (userOnline.getValue().isOpen()) {
					try {
						userOnline.getValue().sendMessage(message);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}));
		});
	}

	/**
	 * 给某个用户发送消息
	 * 
	 * @param userName
	 * @param message
	 * @throws IOException
	 */
	public void sendMessageToUser(Integer uid, TextMessage message) throws IOException {
		WebSocketSession session = userSocketSessionMap.get(uid);
		if (session != null && session.isOpen()) {
			session.sendMessage(message);
		}
	}

}
