package laborator3;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
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
		
//			System.out.println(doc.getRootElement().getValue());
			List<Element> children = doc.getRootElement().getChildren();
			System.out.println(children.size());
			for (Element element : children) {
				System.out.println("element : " + element.getChildText("Title") + "\n");
			}
			
		}catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
	}

}
