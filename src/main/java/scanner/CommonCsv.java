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

		CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
		csvPrinter.printRecord( "Anna","Comen","1897");
		csvPrinter.printRecord( "Ilia","Burda","1456");
		csvPrinter.printRecord( "Nikola","Vern","4584");
        csvPrinter.printRecord( "Karl","Marks","1456");
        csvPrinter.printRecord( "Maria","Astahova","5412");
        csvPrinter.printRecord( "Olga","Caren","1897");


		csvPrinter.flush();
	}
	public static void readData() throws IOException {
		try (
				Reader reader = newBufferedReader(Paths.get("C:/csv/writtenTwoByOne.csv"));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
						.withHeader("FName", "LName", "Group")
						.withIgnoreHeaderCase()
						.withTrim());
		) {
			for (CSVRecord csvRecord : csvParser) {
				// Accessing values by the names assigned to each column
				String name = csvRecord.get("FName");
				String email = csvRecord.get("LName");
				String phone = csvRecord.get("Group");

				System.out.println("FName : " + name);
				System.out.println("LName : " + email);
				System.out.println("Group : " + phone);
				System.out.println("\n");
			}
		}
	}
}
