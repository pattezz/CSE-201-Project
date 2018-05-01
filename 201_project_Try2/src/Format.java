import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Format {
	
	public static void main(String[] args) throws FileNotFoundException {
		format("Strings.txt");
	}

	public static void format(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		
		while(in.hasNext()) {
			String line = in.nextLine() + " ";
			if (line.charAt(0) != '>') {
				line.trim();
				System.out.println(line);
			}
		}
		in.close();
	}
}
