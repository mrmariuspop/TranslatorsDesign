package laborator10;
import mypackage.ObjectFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

	public static void main(String[] args) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance("mypackage");
		Marshaller msh = jc.createMarshaller();
		ObjectFactory of = new ObjectFactory();
		
	}

}
