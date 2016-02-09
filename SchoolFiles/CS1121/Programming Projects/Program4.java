
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Program4 {
	static String outputFileName = "OutputFile.txt";
	static String filename = "p2.txt";
	ArrayList<String> program = new ArrayList<String>();

	public static void main(String[] args) /*throws IOException*/ {
		Program4 program = new Program4();
		program.loadProgram(filename);
		program.run(outputFileName);
	}
	
	ArrayList< String > getProgram() {
		return program;
	}

	public void loadProgram(String filename) /*throws IOException*/ {
		File fin = new File(filename);
		Scanner scan = null;
		try {
			scan = new Scanner(fin);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String label = "";
		while (scan.hasNext()) {
			label = scan.next();
			if (label.equals("")) {
				return;
			}
			program.add(label);
		}
		if (scan != null) {
			scan.close();
		}
	}

	public void run(String filepath) /*throws IOException*/ {
		File fout = new File(filepath);
		PrintWriter pwt = null;
		try {
			pwt = new PrintWriter(fout);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String label = "";
		int x = 0;
		int count = 0;
		for (int i = 0; i < program.size(); i++) {
			count++;
			label = program.get(i);
			if (label.equals("RST")) {
				x = 0;
			} else if (label.equals("INC")) {
				x++;
			} else if (label.equals("DEC")) {
				x--;
			} else if (label.equals("LSH")) {
				x = x * 2;
			} else if (label.equals("RSH")) {
				x = x / 2;
			}
			else if (label.equals("OUT")) {
				System.out.println("["+x+"]");	
				pwt.println("["+x+"]");
			}
			else if (label.equals("LST")) {
				
				Output(pwt);
				
				
				pwt.println();
				System.out.println();
			}
			else if (label.equals("END")) {
				System.out.println("[" + x + "]");
				pwt.println("["+x+"]");
			}
			else {
				Error(count, label, pwt, x);
				break;
			}
		}
		if (pwt != null) {
			pwt.close();
		}
	}

	public void Output(PrintWriter pwt) /*throws IOException*/ {
		int count = 0;
		String label = "";
		pwt.println();
		System.out.println();
		for (int i = 0; i < program.size(); i++) {
			label = program.get(i);
			count++;
			if (label.equals("RST") || label.equals("INC") || label.equals("DEC") || label.equals("LSH") || label.equals("RSH") || label.equals("OUT") || label.equals("LST") || label.equals("END")) {
				System.out.println(count + " " + label);
				pwt.println(count + " " + label);
			}
		}
		//pwt.println();
		//System.out.println();
	}
	
	public void Error (int count, String label, PrintWriter pwt, int x) {
		//System.out.println("["+x+"]");
		System.out.println("SYNTAX ERROR: LINE " + count + " " + label);
		//pwt.println("["+x+"]");
		pwt.println("SYNTAX ERROR: LINE " + count + " " + label);
		//pwt.println();
	}
}
