package laborator6;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.transform.JDOMResult;
import org.jdom2.transform.JDOMSource;

public class Main {

	public static void main(String[] args) throws JDOMException, IOException, TransformerException {

		TransformerFactory tf = TransformerFactory.newInstance();
		//we go for the 2nd input  (the 2 steps refer to the preparation of the document)
		StreamSource ss = new StreamSource(new File("example.xslt"));
		Transformer tr = tf.newTransformer(ss);
		//we go for the first input
		SAXBuilder sb = new SAXBuilder();
		//we obtain a reference to the document that is built by SAXBuilder in the internal memory
		Document doc = sb.build(new File("recipe.xml"));
		JDOMSource in = new JDOMSource(doc);
		//we go for output 
		JDOMResult out = new JDOMResult();
		tr.transform(in, out);
		List<Content> result = out.getResult();
		System.out.println("Size = "+ result.size()+ "\n");
		XMLOutputter xo = new XMLOutputter();
		xo.setFormat(Format.getPrettyFormat());
		xo.output(result, System.out);
		
	}

}
