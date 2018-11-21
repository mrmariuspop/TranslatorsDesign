package laborator7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.FormattingResults;
import org.apache.fop.apps.MimeConstants;

public class XSLFOtoPDF {

	public static void main(String[] args) throws FOPException, TransformerException, FileNotFoundException {
		// TODO Auto-generated method stub
		File fo = new File("out.fo");
		FileOutputStream outStr = new FileOutputStream("result.pdf");
		//we go for the 2nd input  (the 2 steps refer to the preparation of the document)
		StreamSource ss = new StreamSource(new File("transformToPDF.xslt"));
		
		FopFactory ff = FopFactory.newInstance(new File(".").toURI());
		FOUserAgent ua = ff.newFOUserAgent();
		Fop fop = ff.newFop(MimeConstants.MIME_PDF, ua, outStr);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer tr = tf.newTransformer();
		
		Source in = new StreamSource(fo);
		Result out = new SAXResult(fop.getDefaultHandler());
		tr.transform(in, out);
		FormattingResults foRes = fop.getResults();
		System.out.println("Generated "+ foRes.getPageCount());
		
		
		
	}

}
