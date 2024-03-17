package com.bway.SpringCoreDemo.utils;
import com.bway.SpringCoreDemo.model.Employee;

import java.util.List;

import java.util.Map;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception {

		//1. define your own excel file name
		response.addHeader("Content-Disposition", "attachment;filename=employee.xls");
		
		//2. read data given by Controller
		@SuppressWarnings("unchecked")
		List<Employee> list = (List<Employee>) model.get("eList");
		
		//3. create one sheet
		Sheet sheet = workbook.createSheet("EMPLOYEE");
		
		//4. create row#0 as header
		setHead(sheet);
		
		//5. create row#1 onwards from List<T> 
		setBody(sheet,list);
	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("EMPLOYEE FIRST NAME");
		row.createCell(2).setCellValue("EMPLOYEE LAST NAME");
		row.createCell(3).setCellValue("EMPLOYEE GENDER");
//		row.createCell(4).setCellValue("EMPLOYEE ADDRESS");
		row.createCell(4).setCellValue("EMPLOYEE PHONE");
		row.createCell(5).setCellValue("EMPLOYEE EMAIL");
	}
	
	private void setBody(Sheet sheet, List<Employee> list) {
		int rowNum = 1;
		for(Employee spec : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(spec.getId());
			row.createCell(1).setCellValue(spec.getFname());
			row.createCell(2).setCellValue(spec.getLname());
			row.createCell(3).setCellValue(spec.getGender());
//			row.createCell(4).setCellValue(spec.getAddress());
			row.createCell(4).setCellValue(spec.getPhone());
			row.createCell(5).setCellValue(spec.getEmail());
		}
	}

}
