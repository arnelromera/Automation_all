import java.util.ArrayList;

public class ArryList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Array list and Array
		//create object of the class = object.method
		ArrayList <String> a = new ArrayList<String>();
		a.add("Arman");
		a.add("Arnel");
		a.add("Jhaime");
		a.add("Julie");
		a.add("Jeff");
		System.out.println(a.get(3));
		
		//Declare String and important string method
		//String is an object 
		//String literal
		String s = "Romera Prado Arnel";
		//String s1 = "Romera Prado Arnel";
		
		//new
		//String s2 = new String("Welcome");
		//String s3 = new String("Welcome");
		
		String[] splittedString = s.split("Prado");
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1].trim()); //to remove extra spaces
		
		//displayed by characters
		for(int i=0; i<s.length(); i++)
		{
			System.out.println(s.charAt(i));
		}

		//displayed characters in reverse
		for(int i = s.length()-1; i<s.length(); i--)
		{
			System.out.println(s.charAt(i));
		}

		

	}

}
