
public class ForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
