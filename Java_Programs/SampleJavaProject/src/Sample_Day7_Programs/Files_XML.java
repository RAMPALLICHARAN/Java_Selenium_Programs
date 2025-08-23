package Sample_Day7_Programs;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class Files_XML {
    public static void main(String[] args) throws Exception {


        File file = new File("C:\\Users\\91830\\Downloads\\Sample.xml");


        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        Document doc = builder.parse(file);
        doc.getDocumentElement().normalize();

        NodeList list = doc.getElementsByTagName("month");

       
        for (int i = 0; i < list.getLength(); i++) {
            Element e = (Element) list.item(i);

            String name = e.getElementsByTagName("name").item(0).getTextContent();
            String year = e.getElementsByTagName("year").item(0).getTextContent();
            String day = e.getElementsByTagName("day").item(0).getTextContent();
            System.out.println(name + " " + year + " " + day);
        }
    }
}
