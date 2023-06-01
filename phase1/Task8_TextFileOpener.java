package phase1;

import java.io.File;
import java.io.IOException;

public class Task8_TextFileOpener {

	public static void main(String[] args) {
		try {
			File file = new File("D:\\Synth-Dat-R");
			ProcessBuilder pb = new ProcessBuilder("Free-File-Splitter-v5.0.1189.exe", file.getAbsolutePath());			
			pb.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
