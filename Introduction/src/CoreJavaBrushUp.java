public class CoreJavaBrushUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myNum = 5;
		String website = "マシェLIVE（マシェライブ） | 配信者と視聴者をつなぐライブ配信";
		char letter = 'r';
		double dec = 5.99;
		boolean myCard = true;
		
		System.out.println(myNum + " is the value stored in the myNum varialbe");
		System.out.println(website);
		System.out.println(letter);
		System.out.println(dec);
		System.out.println(myCard); 
		
		
		//Array 1
		int[] arr = new int[5]; //
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		arr[3] = 3;
		arr[4] = 5;
		
		// for loop
		for(int i = 0; i<arr.length; i++)
		{
			System.out.println(arr[i]);
		}
		
		//Int Array 2
		int[] arr2 = {1,2,4,3,6,1,6,2,8};
		System.out.println(arr2[1]);
		
		//for loop
		for(int i = 0; i<arr2.length; i++) 
		{
			System.out.println(arr2[i]);
		}
		
		// String Array
		String[] name = {"Gian", "Stacy", "Aira"};
		for(int i = 0; i<name.length; i++)
		{
			System.out.println(name[i]);
		}
		
		//Enhance for loop
		for( String s: name)
		{
			System.out.println(s);
		}
		
	}
}
 