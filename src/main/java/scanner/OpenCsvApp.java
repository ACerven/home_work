package scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCsvApp {
	public static void main(String[] args) throws Exception {
		Path path = Paths.get("C:/csv/writtenOneByOne.csv");
		Files.createDirectories(path.getParent());
		if (!Files.exists(path))
			Files.createFile(path);

		OpenCsvApp openCsvApp = new OpenCsvApp();
		List<String[]> tak = CsvHelper.getData();
		openCsvApp.csvWriterOneByOne(tak, path);
		openCsvApp.readData(path);

	}

	public void csvWriterOneByOne(List<String[]> stringArray, Path path) throws Exception {
		CSVWriter writer = new CSVWriter(new FileWriter(path.toString()));
		writer.writeAll(stringArray);
		writer.close();
	}


	public void readData(Path path) throws Exception {
		BufferedReader bufferedReader = Files.newBufferedReader(path);
		CSVReader csvReader = new CSVReader(bufferedReader);
		List<String[]> list = new ArrayList<>();
		list = csvReader.readAll();
		csvReader.close();
		for(String[] row: list) {
			for (int i = 0; i < row.length; i++) {
				System.out.print(" " +row[i]);
			}
			System.out.println("");
		}
	}
}
