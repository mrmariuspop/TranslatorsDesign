package laborator8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

public class Main {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws IOException {
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

		for (int i = 0; i < 5; i++) {
			Row r = sh.createRow(i);
			for (int j = 0; j < 5; j+=2) {
				Cell c1 = r.createCell(j);
				c1.setCellStyle(cs1);
				Cell c2 = r.createCell(j+1);
				c2.setCellStyle(cs2);
				c1.setCellValue((double) (i + j / 10));
				c2.setCellValue(ch.createRichTextString("Hello" + j));
			}
		}
		
		FileOutputStream out = new FileOutputStream("src/MyWorkbook.xlsx");
		wb.write(out);
		out.close();
		System.out.println("WbSaved");
	}

}
