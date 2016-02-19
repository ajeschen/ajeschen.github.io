import java.util.Random;

/**
 * By: Alex Eschenauer
 */

public class AlienBlurbs {
	
	
	public static String whatzit = "q";
	public static String whoozit = "x";
	public static String blurb;
	
	//This is the main method
	public static void main(String[] args) {
	        printBlurbs();
	}

	//This method calls on the other methods to print a sentence of blurbs
	public static void printBlurbs(){
	    Random r = new Random();
	    int n = r.nextInt(12)+1;
	    System.out.print("Blurbs:");
	    for(int i = 0; i < n; i++){
	        System.out.print(" " + (Blurb()));
	        blurb="";
	        whoozit = "x";
	        whatzit = "q";
	    }
	}
	
	//This is the blurb method. It starts as a whoozit and then adds a whatzit.
	public static String Blurb(){
	String blurb = (Whoozit());
	    blurb += Whatzit();
	    addWhatzit(blurb);
	    return blurb;
	}

	//This adds any extra whatzits to the string
	public static void addWhatzit(String blurb){
	    Random r = new Random();
	    if(r.nextInt(3) < 2){
	        blurb += (Whatzit());
	        addWhatzit(blurb);
	    }
	}

	//This is the Whoozit method, which is recursive
	public static String Whoozit() {
	    Random r = new Random();
	    if(r.nextInt(3) < 2){
	        whoozit += "y";
	        Whoozit();
	    }
	    return whoozit;
	}
	
	//This is the Whatzit method
	public static String Whatzit(){
		 Random r = new Random();
		 if(r.nextInt(2)==0)
		    whatzit += "z";
		 else whatzit += "d";
		 whatzit += Whoozit();;
		 return whatzit;
	}
}
