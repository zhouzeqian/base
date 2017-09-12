package com.llc.util;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsUtil {

	public static void readXls(String fileName, int rownum, int cellnum) throws Exception {

		Workbook wb = null;
		if (fileName.endsWith(".xls"))
			wb = new HSSFWorkbook(new FileInputStream(fileName));
		if (fileName.endsWith(".xlsx"))
			wb = new XSSFWorkbook(new FileInputStream(fileName));
		Sheet sheet = wb.getSheetAt(0);
		StringBuffer sb=new StringBuffer();
		for (int i = rownum; i <= sheet.getLastRowNum(); i++) {
//			String open_id = sheet.getRow(i).getCell(8).getStringCellValue();
//			String filename = "C:/Users/Administrator/Desktop/个人二维码/"+ sheet.getRow(i).getCell(3).getStringCellValue() + ".png";
//			QRCodeUtil.GetQRCode(open_id, 600, 600, filename);
//			System.out.println(i + "---" + sheet.getRow(i).getCell(3).getStringCellValue() + "---"
//					+ sheet.getRow(i).getCell(8).getStringCellValue());
			System.out.println(sheet.getRow(i).getCell(0).getStringCellValue());
			sb.append("'"+sheet.getRow(i).getCell(0).getStringCellValue()+"',");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}

	public static void main(String[] args) {
		try {
			readXls("C:/Users/Administrator/Desktop/20170901.xlsx", 2, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
