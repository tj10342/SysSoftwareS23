public class A0p2 {
	public static void main(String [] args) {
		if(args.length!=2) {
			System.err.println("usage: need two command line arguments a and b.");
			System.exit(0);
		}
		int a,b,i,current_line=0;
		a=Integer.parseInt(args[0]);
		b=Integer.parseInt(args[1]);
		for(i=a;i<=b;i+=3) {
			System.out.print(i);
			current_line++;
			if(current_line<5) {
				if(i+3<=b) System.out.print(",");
				else System.out.println();
			}
			else {
				System.out.println();
				current_line=0;
			}
		}
	}//
}//
