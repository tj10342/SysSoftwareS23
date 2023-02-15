public class A1p2 {
	static int sm;
	static char []sa;
	
	static void generateString() {
		for(int i=0;i<sm;i++) sa[i]=(char)((int)(Math.random()*26)+'A');//initialize with random upper case characters
	}//generateString
	
	static void printString() {
		for(int i=0;i<sm;i++) System.out.print(sa[i]);
		System.out.println();
	}//printString
	
	static void convert1() {//convert the first one-third of the sm chars
		for(int i=0;i<sm/3;i++) {
			sa[i]=(sa[i]>'A')?(char)(sa[i]+'a'-'A'-1):'z';
		}
	}//convert1

	static void convert2() {//convert the middle one-third of the sm chars
		for(int i=sm/3;i<2*sm/3;i++) {
			sa[i]=(sa[i]>'A')?(char)(sa[i]+'a'-'A'-1):'z';
		}
	}//convert2

	static void convert3() {//convert the last one-third of the sm chars
		for(int i=2*sm/3;i<sm;i++) {
			sa[i]=(sa[i]>'A')?(char)(sa[i]+'a'-'A'-1):'z';
		}
	}//convert3

	public static void main(String [] args)	{
		if(args.length!=1) {
			System.err.println("need one command line argument m.");
			System.exit(0);
		};
		sm=Integer.parseInt(args[0]);//number of characters that the user inputs
		if(sm<=0 || sm%60!=0) {
			System.err.println("m should be a multiple of 60.");
			System.exit(0);
		}
		sa=new char [sm];
		generateString();//print the original string of sm random chars
		System.out.printf("Generated a string of %d chars.\n",sm);
		System.out.println("Original random upper case string:");
		printString();
		convert1();//call these three methods to do the conversion
		convert2();
		convert3();
		System.out.println("Reverse-offset lower case string:");
		printString();//print the converted string
	}//main
}//class
