package com.kxll.util;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class XlsUtil {

	public static void write(File file, List<Map<String, Object>> list) {
		try {
			// 打开文件
			WritableWorkbook book = Workbook.createWorkbook(file);
			// 生成名为“第一页”的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("第一页", 0);
			// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0)

			int i = 0;
			for (Map<String, Object> map : list) {
				int j = 0;
				for (String key : map.keySet()) {
					Label label = new Label(j, i, map.get(key).toString());
					sheet.addCell(label);
					j++;
				}
				i++;
			}
			/*
			 * 生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
			 */
//			jxl.write.Number number = new jxl.write.Number(1, 1, 555.12541);
//			sheet.addCell(number);
			// 写入数据并关闭文件
			book.write();
			book.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Map<String, Object>> list=Lists.newArrayList();
		Map<String, Object> map=Maps.newHashMap();
		map.put("time", DateFormatUtils.format(Calendar.getInstance(), "yyyyMMddHHmmss"));
		map.put("name", "zzq");
		list.add(map);
		write(new File("D:/test.xls"), list);
	}

}
