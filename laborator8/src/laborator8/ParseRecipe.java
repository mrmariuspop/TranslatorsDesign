package laborator8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.transform.JDOMResult;
import org.jdom2.transform.JDOMSource;

public class ParseRecipe {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws IOException, JDOMException, TransformerException {
		// TODO Auto-generated method stub

		Workbook wb = new XSSFWorkbook();
		CreationHelper ch = wb.getCreationHelper();
		Sheet sh = wb.createSheet("MySheet");
		CellStyle cs1 = wb.createCellStyle();
		CellStyle cs2 = wb.createCellStyle();
		DataFormat df = wb.createDataFormat();
		Font f1 = wb.createFont();
		Font f2 = wb.createFont();

		f1.setFontHeightInPoints((short) 12);
		f1.setColor(IndexedColors.RED.getIndex());
		f1.setBoldweight(Font.BOLDWEIGHT_BOLD);

		f2.setFontHeightInPoints((short) 10);
		f2.setColor(IndexedColors.BLUE.getIndex());
		f2.setItalic(true);

		cs1.setFont(f1);
		cs1.setDataFormat(df.getFormat("#,##0.0"));

		cs2.setFont(f2);
		cs2.setBorderBottom(cs2.BORDER_THIN);
		cs2.setDataFormat(df.getFormat("text"));
		
		File myFile = new File("recipe.xml");
		
try{
			
			
		
//			System.out.println(doc.getRootElement().getValue());
			
			
		}catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
		
	
		
SAXBuilder sb = new SAXBuilder();
Document doc = sb.build(myFile);
		
		for (int i = 0; i < 3; i++) {
			Row r = sh.createRow(i);
			Cell c2 = r.createCell(i);
			c2.setCellStyle(cs2);
			
			List<Element> children = doc.getRootElement().getChildren();
			System.out.println(children.size());
				c2.setCellValue(children.get(i).getChildText("Title"));
			
			
		}
		
		
		
		FileOutputStream outf = new FileOutputStream("src/RecipesXSL.xlsx");
		wb.write(outf);
		outf.close();
		System.out.println("WbSaved");
	}

}
