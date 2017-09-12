package com.llc.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;

public class AddressTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("D:/address.json"));
		StringBuffer sb = new StringBuffer();
		String data;
		while ((data = br.readLine()) != null) {
			sb.append(data);
		}
		List<Province> list = Lists.newArrayList();
		JSONArray ja = JSON.parseArray(sb.toString());
		for (int i = 0; i < ja.size(); i++) {
			if (ja.getJSONObject(i).getString("c") == null && ja.getJSONObject(i).getString("y") == null) {

				Province p = new Province();
				p.setId(ja.getJSONObject(i).getString("id"));
				p.setP(ja.getJSONObject(i).getString("p"));
				list.add(p);
			}
		}

		for (int i = 0; i < list.size(); i++) {
			List<City> city = Lists.newArrayList();
			for (int j = 0; j < ja.size(); j++) {
				if (ja.getJSONObject(j).getString("y") == null && ja.getJSONObject(j).getString("c") != null) {
					if (ja.getJSONObject(j).getString("p").equals(list.get(i).getP())) {
						City c = new City();
						c.setId(ja.getJSONObject(j).getString("id"));
						c.setC(ja.getJSONObject(j).getString("c"));
						city.add(c);
					}

				}
			}

			list.get(i).setCity(city);
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).getCity().size(); j++) {
				List<Area> area = Lists.newArrayList();
				for (int k = 0; k < ja.size(); k++) {
					if (ja.getJSONObject(k).getString("y") != null) {
						if (ja.getJSONObject(k).getString("p").equals(list.get(i).getP())
								&& ja.getJSONObject(k).getString("c").equals(list.get(i).getCity().get(j).getC())) {
							Area a = new Area();
							a.setId(ja.getJSONObject(k).getString("id"));
							a.setY(ja.getJSONObject(k).getString("y"));
							area.add(a);

						}
					}
				}
				list.get(i).getCity().get(j).setArea(area);
			}

		}
		for (int i = 0; i < ja.size(); i++) {
			if (ja.getJSONObject(i).getString("c") == null && ja.getJSONObject(i).getString("y") != null) {
				System.out.println(ja.getJSONObject(i).getString("id") + "   " + ja.getJSONObject(i).getString("y"));
			}
		}
		// System.out.println(JSON.toJSON(list));
		BufferedWriter bw = new BufferedWriter(new FileWriter("E:/address.json"));
		bw.write(JSON.toJSON(list).toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
