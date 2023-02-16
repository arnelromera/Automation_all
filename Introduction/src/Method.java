
public class Method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method d = new Method();
		String name = d.getData();
		System.out.println(name);
		ConditionalForLoop d1 = new ConditionalForLoop();
		d1.getUserData();
		getData1();
	}
	// you can change the void to string/integer...
	public String getData() // can be use in the other classes
	{
		System.out.println("Hello World");
		return "Arnel Romera";
	}
	
	//static method will move to class access
	public static String getData1() // can be use in the other classes
	{
		System.out.println("Hello World");
		return "Arnel Romera";
	}

}
