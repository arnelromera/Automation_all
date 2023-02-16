package dataDriven.excelDataProvider1;
import java.io.IOException;
import java.util.ArrayList;

public class runDataFromDataProviderStoreInArray {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		dataProviderStoreInArray d = new dataProviderStoreInArray(); 
		ArrayList<String> data = d.getData("https://dev-front.machetalk.jp/liver/");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2)); 
	}

}
