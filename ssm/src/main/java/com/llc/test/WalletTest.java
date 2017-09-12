package com.llc.test;

import com.llc.util.HttpClientUtil;

public class WalletTest extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		HttpClientUtil.getInstance().sendHttpsGet("http://localhost:8585/practice/wallet/receivables");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WalletTest[] wts = new WalletTest[5];
		for (int i = 0; i < wts.length; i++) {
			wts[i] = new WalletTest();
			wts[i].start();
		}

		
	}

}
