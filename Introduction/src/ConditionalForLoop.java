
public class ConditionalForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Conditional for loop
		
		int[] arr3 = {1,2,8,8,6,47,6,3,74,1,56,78};
		
		//check if array is multiple of 2
		for(int i = 0; i<arr3.length; i++)
		{
			if(arr3[i] % 2 == 0) {
				System.out.println(arr3[i]);
				//break;
			}
			else
			{
				System.out.println(arr3[i] + " is not multiple of 2");
			}
		}
	}
	public String getUserData() // can be use in the other classes
	{
		System.out.println("Other Method");
		return "Return to other class";
	}
}
