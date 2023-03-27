

public class Excelunittest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xls_Reader reader=new Xls_Reader("src\\main\\java\\userinfo.xlsx");
		String sheetname="Sheet1";
		
		String data=reader.getCellData(sheetname, 0, 2);
		System.out.println(data);
		
		int rowCount=reader.getRowCount(sheetname);
		System.out.println(rowCount);
	}

}
