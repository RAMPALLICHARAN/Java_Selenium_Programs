package Sample_Day7_Programs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class File_Text {
	public static void main(String[] args) {
	File File1 = new File("C:\\Users\\91830\\Downloads\\Sample.txt\\");
	try {
	BufferedReader Reading_Floder = new BufferedReader(new FileReader(File1));
	String line = Reading_Floder.readLine();
	while (line != null) {
		System.out.println("The Contents in the file is " + line);
		line = Reading_Floder.readLine();
	}
	Reading_Floder.close();
	}
	catch(FileNotFoundException e) {
		System.out.println("The File NotFound" + e.getMessage());
	}
	catch(IOException e)
	{
		System.out.println("IO error occurred while reading the file");
	}
	finally {
		System.out.println("This is the complete execution");
	}
	
	}

}


