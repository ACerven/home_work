package scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static java.nio.file.Files.newBufferedReader;

public class CommonCsv {
	public static void main(String[] args) throws Exception {
		writeData();
		readData();
	}

	public static void writeData() throws Exception {
		Path path = Paths.get("C:/csv/writtenTwoByOne.csv");
		Files.createDirectories(path.getParent());
		if (!Files.exists(path))
			Files.createFile(path);
		BufferedWriter writer = Files.newBufferedWriter(path);

		CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
				.withHeader("ID", "Name", "Designation", "Company"));
		csvPrinter.printRecord("1", "Sundar Pichai ♥", "CEO", "Google");
		csvPrinter.printRecord("2", "Satya Nadella", "CEO", "Microsoft");
		csvPrinter.printRecord("3", "Tim cook", "CEO", "Apple");

		csvPrinter.printRecord(Arrays.asList("4", "Mark Zuckerberg", "CEO", "Facebook"));

		csvPrinter.flush();
	}
	public static void readData() throws IOException {
		try (
				Reader reader = newBufferedReader(Paths.get("C:/csv/writtenTwoByOne.csv"));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
						.withHeader("Name", "Email", "Phone", "Country")
						.withIgnoreHeaderCase()
						.withTrim());
		) {
			for (CSVRecord csvRecord : csvParser) {
				// Accessing values by the names assigned to each column
				String name = csvRecord.get("Name");
				String email = csvRecord.get("Email");
				String phone = csvRecord.get("Phone");
				String country = csvRecord.get("Country");

				System.out.println("Record No - " + csvRecord.getRecordNumber());
				System.out.println("---------------");
				System.out.println("Name : " + name);
				System.out.println("Email : " + email);
				System.out.println("Phone : " + phone);
				System.out.println("Country : " + country);
				System.out.println("---------------\n\n");
			}
		}
	}
}
