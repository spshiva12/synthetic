package examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

public class FileSplitter {

	public static void main(String[] args) throws IOException {
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("Enter the number of parts to split the file into: ");
		String len = JOptionPane.showInputDialog("Enter the length of the combinations:");
		int numParts = Integer.parseInt(len);
//		scanner.close();

		String fileName = "output_4.txt";
		File inputFile = new File(fileName);
		long fileSize = inputFile.length();
		long partSize = fileSize / numParts;

		FileInputStream inputStream = new FileInputStream(inputFile);

		byte[] buffer = new byte[1024];
		int bytesRead;
		int partCount = 0;

		while ((bytesRead = inputStream.read(buffer)) > 0) {
			if (partCount == numParts) {
				break;
			}

			String partFileName = String.format("%s.part%d.txt", fileName, partCount);
			FileOutputStream outputStream = new FileOutputStream(partFileName);
			outputStream.write(buffer, 0, bytesRead);

			long bytesWritten = bytesRead;
			while (bytesWritten < partSize && (bytesRead = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, bytesRead);
				bytesWritten += bytesRead;
			}

			outputStream.close();
			partCount++;
		}

		inputStream.close();
	}

}
