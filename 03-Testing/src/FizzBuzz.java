
public class FizzBuzz {
	public static String fizzBuzz(int n) {
		
		/*for(int a =0;a<=n; a++ ) {
			
			if(a%5==0 && a%3==0) {
				System.out.println("FizzBuzz");
			}
			else if(a%3==0) {
				System.out.println("Fizz");
			}
			else if(a%5==0) {
				System.out.println("Buzz");
			}
			else {
				System.out.println(a);
			}
			System.out.println(","+" ");
		}
		return null;	
		*/
		
		//return Integer.toString(n);
		
		//if (n==1) return "1";
		
		//if (n==3) return "Fizz";
		
		//
		if(n%3==0) {
				return "Fizz";
		
		}
		else {
			return Integer.toString(n);
		}
	}	

}
