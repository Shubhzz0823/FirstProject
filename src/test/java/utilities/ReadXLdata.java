package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
 

public class ReadXLdata {
	@DataProvider(name="sdata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		String excelSheetname=m.getName();
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetname);

		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		Row rowCell = sheetName.getRow(0);
		int totalColums = rowCell.getLastCellNum();
		System.out.println(totalColums);
		DataFormatter format = new DataFormatter();
		String TestData[][]=new String [totalRows][totalColums];

		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalColums; j++) {
				TestData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(TestData[i - 1][j]);
			}
		}
		return TestData;
		
		

	}

}
