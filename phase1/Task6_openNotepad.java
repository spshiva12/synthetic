package phase1;

import java.io.*;

public class Task6_openNotepad {
	public static void main(String[] args) {
		Runtime rs = Runtime.getRuntime();

		try {
			rs.exec("notepad");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
