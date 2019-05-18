package dataProviders;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import managers.FileReaderManager;

public class TextFileReaderAppender {
	public static String textFilePath = FileReaderManager.getInstance().getPropertyFileDataReader().getTestDataResourcePath()
			+ "textData/TextFile.txt";

	static BufferedReader reader;
	static FileReader fileReader;
	
	
	public static void readData() throws IOException{
		fileReader = new FileReader(textFilePath);
		reader = new BufferedReader(fileReader);
		String sCurrentLine;
		while((sCurrentLine = reader.readLine()) !=  null) {
			System.out.println(sCurrentLine);
		}
	}

	public void textFileReader() throws IOException{
		readData();
	}
	
	static BufferedWriter writer = null;
	static FileWriter fileWriter = null;
	
	public static void appendData() throws IOException{
		try {
			String data = "test data  added to the file @::"+java.time.LocalDateTime.now();
		File file = new File(textFilePath);
		if(!file.exists()) {
			file.createNewFile();
		}
		fileWriter = new FileWriter(file.getAbsoluteFile(), true);
		writer = new BufferedWriter(fileWriter);
		writer.write("\n"+data);
		System.out.println("File Append Done Successful");
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(writer != null)
					writer.close();
				
				if(fileWriter != null)
					fileWriter.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void textFileAppender() throws IOException{
		appendData();
	}
}
