package com.kxll.base;

public class MultiThread implements Runnable {

	private String msg;

	public MultiThread() {

	}

	public MultiThread(String msg) {
		this.msg=msg;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(msg);
	}

}
