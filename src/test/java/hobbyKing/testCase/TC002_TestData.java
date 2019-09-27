
  package hobbyKing.testCase;
  
  import java.io.IOException;
  
  import org.testng.annotations.DataProvider; import
  org.testng.annotations.Factory;
  
  import hobbyKing.utilities.XLUtils;
  
  public class TC002_TestData extends BaseClass {
  
  @DataProvider(name = "LoginData")
  public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/hobbyKing/testData/LoginData.xlsx";

		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rowcount][colcount];

		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;

	}
  
	@Factory(dataProvider = "LoginData")
	public String[] createInstances(String hkusername, String hkpassword, String countrytobeselected) {
      return new String[] {hkusername, hkpassword, countrytobeselected};
	  }
  
  }
 