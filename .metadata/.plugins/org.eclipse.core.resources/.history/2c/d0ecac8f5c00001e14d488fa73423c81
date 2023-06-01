package phase1;

import java.io.File;
import java.io.IOException;

public class Task8_TextFileOpener {

	public static void main(String[] args) {
		try {
			File file = new File("D:\\DSANOTEPAD\\Bucketsort.java");
			File file2 = new File("D:\\DSANOTEPAD\\Radixsort.java");
			ProcessBuilder pb = new ProcessBuilder("Notepad.exe", file.getAbsolutePath());
			ProcessBuilder pb1 = new ProcessBuilder("Notepad.exe", file2.getAbsolutePath());
			pb.start();
			pb1.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
