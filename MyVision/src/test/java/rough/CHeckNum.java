package rough;

public class CHeckNum {
	public static String a = "1";
	public static String b = "1.1";
	public static String c = "1.56";
	
	public static void main(String[] args) {

		if(!a.contains(".")){
			a.concat(".00");
			System.out.println(a.concat(".00"));
		}
		if(b.contains(".") && ((b.length()-b.lastIndexOf(".")-1)==1)){
			//System.out.println(b.length()-b.lastIndexOf(".")-1);
			System.out.println(b.concat("0"));
		}
		if(c.contains(".") && ((c.length()-c.lastIndexOf(".")-1)==2)){
			//System.out.println(b.length()-b.lastIndexOf(".")-1);
			System.out.println(c);
		}
		
	}

}
