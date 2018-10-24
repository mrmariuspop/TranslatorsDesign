package laborator4;

import java.io.File;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;

public class Main {

	public static void main(String[] args) {
		File myFile = new File("recipe.xml");
		
		try{
			
			SAXBuilder sb = new SAXBuilder(XMLReaders.XSDVALIDATING);
			Document doc = sb.build(myFile);
		
			System.out.println(doc.getRootElement().getValue());
			
		}catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
	}

}
