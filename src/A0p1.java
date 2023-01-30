public class A0p1 {
	public static void main(String [] args) {
		int i,j;
		for(i=0;i<14;i++) {
			System.out.print("hello");
			for(j=0;j<=i;j++) System.out.print(" ");
			System.out.print("world");
			if(i%2==1) System.out.print(".");
			System.out.println();
		}
	}
}
