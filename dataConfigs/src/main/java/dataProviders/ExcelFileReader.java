package dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import managers.FileReaderManager;

public class ExcelFileReader {

	public static String excelPath = FileReaderManager.getInstance().getPropertyFileDataReader().getTestDataResourcePath()
			+ "exceldata/ExcelData.xlsx";

	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public ExcelFileReader() throws IOException {

		File src = new File(excelPath);
		FileInputStream fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);
	}

	public String getData(int sheetNumber, int row, int column) {
		sheet = workbook.getSheetAt(sheetNumber);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public String writeData(int sheetNumber, int row, int column, String message) throws IOException {
		sheet = workbook.getSheetAt(sheetNumber);
		sheet.getRow(row).createCell(column).setCellValue(message);
		FileOutputStream fout = new FileOutputStream(excelPath);
		workbook.write(fout);
		return message;
	}

}
