package dataProviders;

import java.io.FileReader;

import com.opencsv.CSVReader;

import managers.FileReaderManager;

public class CsvFileReader {

	public final static String csvFilePath = FileReaderManager.getInstance().getPropertyFileDataReader()
			.getTestDataResourcePath() + "csvData/customer.csv";

	public static void readCsvDataLinebyLine() {
		try {
			FileReader fileReader = new FileReader(csvFilePath);
			CSVReader csvReader = new CSVReader(fileReader);
			String[] nextRecord;
			System.out.println("----Read Data from CSV file-------");
			// we are going to read data line by line
			while ((nextRecord = csvReader.readNext()) != null) {
				for (String cell : nextRecord) {
					System.out.println(cell);
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
