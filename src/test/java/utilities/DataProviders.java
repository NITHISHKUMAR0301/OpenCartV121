package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="LoginData")
	public String[][] GetExcelData() throws IOException {
		String path = ".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtility Excluti = new ExcelUtility(path);
		int GetRowCount = Excluti.getRowCount("Sheet1");
		int GetColCount = Excluti.getCellCount("Sheet1", 1);
		String Exclarr[][] = new String [GetRowCount][GetColCount];
		for (int i=1; i<=GetRowCount; i++) {
			for (int j=0; j<GetColCount; j++) {
				Exclarr [i-1][j] = Excluti.getCellData("Sheet1", i, j);
			}
		}
		return Exclarr;
	}
}
