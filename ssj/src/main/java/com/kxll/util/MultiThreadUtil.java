package com.kxll.util;

import org.springframework.core.task.TaskExecutor;

public class MultiThreadUtil {
	private TaskExecutor taskExecutor;

	public TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void printMessages(Runnable r, int i) {
		taskExecutor.execute(r);
		System.out.println("新增线程:" + i);
	}
}
