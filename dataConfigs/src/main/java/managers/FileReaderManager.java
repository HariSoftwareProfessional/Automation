package managers;

import java.io.IOException;

import dataProviders.CsvFileReader;
import dataProviders.ExcelFileReader;
import dataProviders.JsonFileReader;
import dataProviders.PropertyFileReader;
import dataProviders.TextFileReaderAppender;

public class FileReaderManager {
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static PropertyFileReader propertyFileConfigReader;
	private static TextFileReaderAppender textFileConfigReaderAppender;
	private static ExcelFileReader excelFileDataReader;
	private static JsonFileReader jsonFileDataReader;
	private static CsvFileReader csvFileDataReader;

	private FileReaderManager() {

	}

	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	public PropertyFileReader getPropertyFileDataReader() {
		return (propertyFileConfigReader == null) ? new PropertyFileReader() : propertyFileConfigReader;
	}

	public TextFileReaderAppender getTextFileConfigReader() {
		return (textFileConfigReaderAppender == null) ? new TextFileReaderAppender() : textFileConfigReaderAppender;
	}

	public ExcelFileReader getExcelFileReader() throws IOException {
		return (excelFileDataReader == null) ? new ExcelFileReader() : excelFileDataReader;
	}

	public JsonFileReader getJsonFileDataReader() throws IOException {
		return (jsonFileDataReader == null) ? new JsonFileReader() : jsonFileDataReader;
	}

	public CsvFileReader getCsvFileDataReader() throws IOException {
		return (csvFileDataReader == null) ? new CsvFileReader() : csvFileDataReader;
	}
}
