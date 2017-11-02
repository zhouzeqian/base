package com.llc.controller;

import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;

@RestController
@RequestMapping("activiti")
public class ActivitiController {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	@Autowired
	RepositoryService repositoryService;
	@Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;

    
    @RequestMapping("test")
    public Map<String,Object> test() {
    	Map<String,Object> map=Maps.newHashMap();
    	// 部署流程，只要是符合BPMN2规范的XML文件，理论上都可以被ACTIVITI部署
        repositoryService.createDeployment().addClasspathResource("com/llc/diagrams/MyProcess.bpmn").deploy();
        // 开启流程，myprocess是流程的ID
        runtimeService.startProcessInstanceByKey("myProcess");
        // 查询历史表中的Task
        List<Task> task = taskService.createTaskQuery().list();
        log.info(task.toString());
        Task task1 = task.get(0);
        map.put("第一环节", task1.getId()+"  "+task1.getName());
        taskService.complete(task1.getId());
        task1 = taskService.createTaskQuery().executionId(task1.getExecutionId()).singleResult();
        map.put("第二环节", task1.getId()+"  "+task1.getName());
		return map;
    	
    }
   
}
