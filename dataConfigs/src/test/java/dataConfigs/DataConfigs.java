package dataConfigs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import dataProviders.CsvFileReader;
import dataProviders.ExcelFileReader;
import managers.FileReaderManager;

@SuppressWarnings({ "static-access", "unused" })
public class DataConfigs {

	@Test(priority = 1)
	public void PropertyFileDataConfiguration() {
		System.out.println("Reading data from property File");
		System.out.println(
				"url::" + FileReaderManager.getInstance().getPropertyFileDataReader().getValueFromPropertyFile("url"));
		System.out.println("restAssuredUrl::" + FileReaderManager.getInstance().getPropertyFileDataReader()
				.getValueFromPropertyFile("restAssuredTestUrl"));
		System.out.println("testDataResourcePath:" + FileReaderManager.getInstance().getPropertyFileDataReader()
				.getValueFromPropertyFile("testDataResourcePath"));
	}
	
	@Test(priority = 2)
	public  void TextFileReader() throws IOException{
		System.out.println("----Reading data from text file----");
		FileReaderManager.getInstance().getTextFileConfigReader().textFileReader();
	}
	
	
	@Test(priority=3)
	public static void textFileAppend() throws IOException{
		System.out.println("----Appending data to text File---");
		FileReaderManager.getInstance().getTextFileConfigReader().appendData();
	}
	
	@Test(priority=4)
	public void readWriteExcel() throws IOException{
		System.out.println("------reading and writing data to Excel File");
		ExcelFileReader excel = new ExcelFileReader();
	//	System.out.println("Excel Cell Value::"+excel.getData(0,1,2));
		System.out.println("Excel value::"+FileReaderManager.getInstance().getExcelFileReader().getData(0, 1, 2));
		excel.writeData(0,1,2,"Hari");
		FileReaderManager.getInstance().getExcelFileReader().writeData(0, 1, 2, "Hari");
		System.out.println("Data had been written in Excel File");
	
	}
	
	@Test(priority=5)
	public void jsonDataReader() throws FileNotFoundException, IOException, ParseException{
		System.out.println("------Reading data from json file--------");
		System.out.println("FirstName::"+FileReaderManager.getInstance().getJsonFileDataReader().JsonDataReader("firstName"));
		System.out.println("LastName::"+FileReaderManager.getInstance().getJsonFileDataReader().JsonDataReader("lastName"));
		System.out.println("phone::"+FileReaderManager.getInstance().getJsonFileDataReader().JsonDataReader("phone"));
		System.out.println("Email::"+FileReaderManager.getInstance().getJsonFileDataReader().JsonDataReader("Email"));
		System.out.println("Address::"+FileReaderManager.getInstance().getJsonFileDataReader().JsonDataReader("Address"));
		System.out.println("city::"+FileReaderManager.getInstance().getJsonFileDataReader().JsonDataReader("city"));
		System.out.println("province::"+FileReaderManager.getInstance().getJsonFileDataReader().JsonDataReader("province"));
		System.out.println("zip::"+FileReaderManager.getInstance().getJsonFileDataReader().JsonDataReader("zip"));
	}
	
	@Test(priority=6)
	public void csvDataReader() throws IOException{
		FileReaderManager.getInstance().getCsvFileDataReader().readCsvDataLinebyLine();
	//	CsvFileReader.readCsvDataLinebyLine();
	}

}
