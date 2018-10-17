package laborator3;

import java.io.File;
import java.io.FileWriter;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class DTDParse {

	public static void main(String[] args) {
		File myFile = new File("src/recipe.xml");
		
		try{
			
			SAXBuilder sb = new SAXBuilder(XMLReaders.DTDVALIDATING);
			Document doc = sb.build(myFile);
		
			System.out.println(doc.getRootElement().getValue());
			
		}catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
	}

}