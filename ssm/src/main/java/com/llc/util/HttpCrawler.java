package com.llc.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.common.collect.Maps;

public class HttpCrawler {
	CloseableHttpClient httpclient = HttpClients.createDefault();

	// 模拟浏览器
	public String simulationBrowser(String url) {

		// 创建请求Get实例
		HttpGet httpGet = new HttpGet(url);

		// 设置头部信息进行浏览器模拟行为
		httpGet.setHeader("Accept", "text/html,application/xhtml+xml," + "application/xml;q=0.9,image/webp,*/*;q=0.8");
		httpGet.setHeader("Accept-Encoding", "gzip, deflate, sdch, br");
		httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		// httpGet.setHeader("Cookie", ".......");
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36"
				+ " (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");

		try {
			// 客户端执行httpGet方法，返回响应
			CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);

			// 得到服务响应状态码
			if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
				return EntityUtils.toString(closeableHttpResponse.getEntity());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpGet.abort();
		}
		return null;
	}

	public String simulationLogin(String url, Map<String, String> parm, String targetUrl) {

		// 创建Post请求实例
		HttpPost httpPost = new HttpPost(url);

		// 创建参数列表
		List<NameValuePair> nvps = new ArrayList<>();
		if (MapUtils.isEmpty(parm)) {
			for (String key : parm.keySet()) {
				nvps.add(new BasicNameValuePair(key, parm.get(key)));
			}
		}

		// 向对方服务器发送Post请求
		try {
			// 将参数进行封装，提交到服务器端
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF8"));
			CloseableHttpResponse httpResponse = httpclient.execute(httpPost);

			// 如果模拟登录成功
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				// System.out.println(EntityUtils.toString(httpResponse.getEntity()));
				httpResponse.getAllHeaders();
				return simulationBrowser(targetUrl);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpPost.abort(); // 释放资源
		}
		return null;
	}

	public static void main(String[] args) {
		HttpCrawler crawler = new HttpCrawler();
		Map<String, String> parm=Maps.newHashMap();
		parm.put("登录名", "xxx");
		parm.put("密码", "xxx");
		String html = crawler.simulationLogin("登录url", parm, "抓取的目标url");
		if (StringUtils.isNoneBlank(html)) {
			Document doc = Jsoup.parse(html);
			System.out.println(doc.title());
			System.out.println(doc.body().text());
		}

	}
}
