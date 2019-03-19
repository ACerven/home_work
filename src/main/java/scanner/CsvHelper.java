package scanner;

import java.util.ArrayList;
import java.util.List;

public class CsvHelper {
	public static List<String[]> getData() {
		List<String[]> data = new ArrayList<>();
		data.add(new String[]{"Anna","Comen","1897"});
		data.add(new String[]{"Ilia","Burda","1456"});
		data.add(new String[]{"Nikola","Vern","4584"});
		data.add(new String[]{"Karl","Marks","1456"});
		data.add(new String[]{"Maria","Astahova","5412"});
		data.add(new String[]{"Olga","Caren","1897"});
		return data;
	}
}
