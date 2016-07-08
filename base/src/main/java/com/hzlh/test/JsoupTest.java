package com.hzlh.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupTest {
	public static void main(String[] args) {
		try {
			FileWriter fw=new FileWriter(new File("d:/2.txt"),true);
			Document doc = Jsoup.connect("http://www.shuotxts.com/8/0/949/index.html").timeout(10000).get();
		
			for (Element e : doc.getElementsByTag("a")) {
				if (e.attr("href").indexOf("/") == -1&&e.attr("href").indexOf("#")==-1&&e.attr("href").compareTo("5046212.html")>0){
					
					doc =Jsoup.connect("http://www.shuotxts.com/8/0/949/"+e.attr("href")).timeout(10000).get();
					fw.append(doc.title()+"\n");
					fw.append(doc.getElementById("content").text().replaceAll("    ", "")+"\n");
					System.out.println(doc.title());
					fw.flush();
				}
			}
			
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
