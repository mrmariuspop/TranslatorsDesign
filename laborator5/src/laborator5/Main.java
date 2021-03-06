package laborator5;

import java.io.File;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

public class Main {

	public static void main(String[] args) {
		File myFile = new File("recipe.xml");

		try{
		
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build(myFile);
		//System.out.println(doc.getRootElement().getValue());
		
		Element rssRoot = doc.getRootElement();
	    List<Namespace> defaultNS = rssRoot.getNamespacesIntroduced();
	    
	    for (int i = 0; i< defaultNS.size(); i++)
	    {
	    	System.out.println(defaultNS.get(i).getPrefix());
	    	System.out.println(defaultNS.get(i).getURI());
	    }
	    
		
		XPathFactory xPathFactory = XPathFactory.instance();
		
		//String xPathExpression = "/Recipes/Recipe[2]/Ingredients/Ingredient[last()]/@name";
		
		String xPathExpression = "//*";
		
		XPathExpression expr = xPathFactory.compile(xPathExpression);
		List<Object> evaluate = expr.evaluate(doc);
	
		for (Object object : evaluate) {
			
			Element elem = (Element) object;
			//System.out.println(elem.getValue());
			
		}
		
		
	}catch(Exception e)
	{
		System.out.println(e.toString());
		
	}
	}

}
