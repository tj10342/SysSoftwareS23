public class A1p1 {
	public static void main(String [] args)	{
		if(args.length!=1) {
			System.err.println("need  command line argument a.");
			System.exit(0);
		};
		int num=1,a=Integer.parseInt(args[0]);
		System.out.println("Iterated list for "+a+" is:");
		System.out.print(a);
		while(a!=1) {
			if(a%2==1) {
				a=(3*a+1)/2;
			}
			else {//even
				a/=2;
			}
			System.out.print(","+a);
			num++;
		}
		System.out.println("\nLength of the list: "+num);
	}
}