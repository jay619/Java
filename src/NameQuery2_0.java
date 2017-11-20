/*
 * Shah Jaynish
 * CSC-220 Data Structures
 * Baby Names Query
 * Extra Credit Assignment
 * 12/18/2015
 * shahjaynish@gmail.com
 */

import java.io.FileReader;
import java.util.*;

public class NameQuery2_0 {

	public static void lookup(int year, String name, String gender)
			throws Exception {
		String file = "babynamesranking" + year + ".txt";
		Scanner fileReader = new Scanner(new FileReader(file));

		Map<String, String> mapBoys = new LinkedHashMap<String, String>();
		Map<String, String> mapGirls = new LinkedHashMap<String, String>();

		while (fileReader.hasNext()) {
			String[] columns = fileReader.nextLine().split("[\\W]");
			mapBoys.put(columns[2], columns[3]);
			mapGirls.put(columns[5], columns[7]);
		}
		// System.out.println(mapBoys.keySet());
		// System.out.println(mapGirls.keySet());
		fileReader.close();

		if (gender.equals("M"))
			System.out.println(name + " ranked #" + mapBoys.get(name)
					+ " in year " + year);
		else if (gender.equals("F"))
			System.out.println(name + " ranked #" + mapGirls.get(name)
					+ " in year " + year);

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String doOver = "";
			System.out.print("Enter Year: ");
			int year = sc.nextInt();
			System.out.print("Enter Gender(M/F): ");
			String gender = sc.next();
			System.out.print("Enter Name: ");
			String name = sc.next();
			lookup(year, name, gender);
			System.out.print("Do another inquiry?(Y/N): ");
			doOver = sc.next();
			if (doOver.equalsIgnoreCase("N"))
				break;
		}
		sc.close();

	}
}