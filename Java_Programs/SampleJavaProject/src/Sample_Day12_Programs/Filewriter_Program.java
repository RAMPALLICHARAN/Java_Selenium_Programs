package Sample_Day12_Programs;
	import java.io.FileWriter;
	import java.io.IOException;

	public class Filewriter_Program {
	    public static void main(String[] args) throws IOException {
	        String content = "This text is written using FileWriter.";
	        FileWriter writer = new FileWriter("C:\\Users\\91830\\Downloads\\Sample2.txt");
	        writer.write(content);
	        writer.close();
	        System.out.println("Content written successfully using FileWriter.    ");
	    }
	


}
