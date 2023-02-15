public class A1p3 implements Runnable {
	static int sm;//number of characters that the user inputs
	static int num_threads;//number of threads that the user inputs
	static char []sa;//array to store the sm random characters
	//notice that the above three memebers are static so we only have one copy no matter how many objects of A2p3 are created
	int index;
	
	A1p3(int id) {
		index=id;
	}//constructor
	
	public void run() {//implement the method run in Runnable interface
		for(int i = index*sm/num_threads; i<(index+1)*sm/num_threads; i++) {
			sa[i]=(sa[i]>'A')?(char)(sa[i]+'a'-'A'-1):'z';
		}//even though we may create multiple children threads from main, all these threads access the same array sa (since we only have one static array sa)
	}//run
	
	static void generateString() {
		for(int i=0;i<sm;i++) sa[i]=(char)((int)(Math.random()*26)+'A');//initialize with random upper case characters
	}//generateString
	
	static void printString() {
		for(int i=0;i<sm;i++) System.out.print(sa[i]);
		System.out.println();
	}//printString

	public static void main(String [] args)	{
		if(args.length!=2) {
			System.err.println("need two command line arguments m and n.");
			System.exit(0);
		}
		sm=Integer.parseInt(args[0]);//number of characters that the user inputs
		if(sm<=0 || sm%60!=0) {
			System.err.println("m should be a multiple of 60.");
			System.exit(0);
		}
		sa=new char [sm];//create the unique and only array we will let the main thread and the children threads use
		num_threads=Integer.parseInt(args[1]);//number of threads that the user inputs
		if(num_threads<2 || num_threads>6) {
			System.err.println("number of threads should be between 2 and 6.");
			System.exit(0);
		}
		generateString();//put sm random chars into the array sa
		System.out.printf("Using %d threads to handle %d chars.\n",num_threads,sm);
		System.out.println("Original random upper case string:");
		printString();//print the original string of sm random chars
		A1p3 at[]=new A1p3[num_threads];//create array to hold task objects
		Thread arrT [] = new Thread[num_threads];//create array to hold Thread objects
		for(int i=0;i<num_threads;i++) {
			at[i]=new A1p3(i);//create each individual task object (each task is to convert part of the array of random characters and that which part depends on the argument i)
			arrT[i]=new Thread(at[i]);//create each individual Thread object
			arrT[i].start();//start the thread
		}//for i
		for(int i=0;i<num_threads;i++) {
			try {
				arrT[i].join();//wait for all threads to finish (i.e. wait for all conversion tasks to finish)
			}
			catch (InterruptedException e) {
				System.out.println(arrT[i].getName() + " failed to join.");
			}
		}//for i
		System.out.println("Reverse-offset lower case string:");
		printString();//print the converted string
	}//main
}//class
