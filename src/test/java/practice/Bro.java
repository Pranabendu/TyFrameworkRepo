package practice;

/**
 * a
 * a e
 * a e i 
 * a e i o
 * a e i o u
 */

public class Bro {

	public static void main(String[] args) {
//		String [] ran = new String[10];
//		Random r = new Random();
//		for (int i = 0; i < 10; i++) {
//			int m = r.nextInt(10);
//			ran[i] = Integer.toString(m);
//		}
//		String mobileNo = "";
//		for(String n:ran) {
//			mobileNo = mobileNo+n;
//		}
//		System.out.println(mobileNo);
	
		
		String s = "aeiou";
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(s.charAt(j));
			}
			
			System.out.println();
		}
		
		
//		String s = "a4b3cd2";
//		for (int i = 0; i < s.length(); i++) {
//			String no = "";
//			if (s.charAt(i)>='1' && s.charAt(i)<='9') {
//				no = no + s.charAt(i);
//				
//				int num = Integer.parseInt(no);
//				for (int j = 0; j < num; j++) {
//					System.out.print(s.charAt(i-1));
//				}
//			}
//			else if(!(s.charAt(i+1)>='1' && s.charAt(i+1)<='9')) {
//				System.out.print(s.charAt(i));
//			}
//		}
		
		
//		for (int i = 0; i < s.length(); i++) {
//			String no = "";
//			if (Character.isDigit(s.charAt(i))) {
//				no = no + s.charAt(i);	
//				
//				int num = Integer.parseInt(no);
//				for (int j = 0; j < num; j++) {
//					System.out.print(s.charAt(i-1));
//				}
//			}
//			
//			else if(Character.isAlphabetic(s.charAt(i+1))){
//				System.out.print(s.charAt(i));
//			}
//			
//		}
	}

}