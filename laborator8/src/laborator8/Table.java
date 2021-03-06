package laborator8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

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

public class Table {
	
	protected static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	
	public static void main(String[] args) throws IOException {
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
			for (int j = 0; j < 5; j++) {
				Cell c1 = r.createCell(j);
				c1.setCellStyle(cs2);
				if (i == 0 && j == 0 ) c1.setCellValue("AnStudiu");
				else
				if (i == 0 && j == 1 ) c1.setCellValue("Grupa");
				else
				if (i == 0 && j == 2 ) c1.setCellValue("Subgrupa");
				else
				if (i == 0 && j == 3 ) c1.setCellValue("Nume");
				else
				if (i == 0 && j == 4 ) c1.setCellValue("Prenume");
				else c1.setCellValue(getSaltString());
			}
		}
		
		FileOutputStream out = new FileOutputStream("src/TableStudent.xlsx");
		wb.write(out);
		out.close();
		System.out.println("WbSaved");
		
		
	}
}
