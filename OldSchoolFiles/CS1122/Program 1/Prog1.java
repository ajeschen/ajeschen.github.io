import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Prog1 implements Runnable{
	static File outputFile = new File("output.txt");
	static File inputFile = new File("input.txt");
	ArrayList<House> Houses = new ArrayList<House>();
	
	public void run(File inputFile, File outputFile) {
		PutIntoArray(inputFile);
		sortAndOutput(outputFile);
		
	}
	
	public void PutIntoArray(File input) /*throws IOException*/ {
		Scanner scan = null;
		try {
			scan = new Scanner(input);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		while (scan.hasNext()) {
			int caseNum = scan.nextInt();
			int price = scan.nextInt();
			double dist = scan.nextDouble();
			int size = scan.nextInt();
			Houses.add(new House(caseNum,price,dist,size));
		}
		if (scan != null) {
			scan.close();
		}
		testFile();
	}
	
	public void sortAndOutput(File output) /*throws IOException*/ {
		PrintWriter pwt = null;
		try {
			pwt = new PrintWriter(output);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		Collections.sort(Houses);
		System.out.println(Houses.get(0).getPrice() + " THIS IS THE FIRST AFTER SORTING");
		testFile();
		for(int i = 0; i < Houses.size(); i++){
			if(Houses.get(i).getPrice() > 150000){
				Houses.remove(i);
				System.out.println("REMOVED BC PRICE");
			}
		}
		for(int i = 0; i < Houses.size(); i++){
			if(Houses.get(i).getSize() < 1100){
				Houses.remove(i);
				System.out.println("REMOVED BC SIZE");
			}
		}
		for(int i = 0; i < Houses.size(); i++){
			if(Houses.get(i).getDistance() > 30.0){
				Houses.remove(i);
				System.out.println("REMOVED BC DISTANCE");
			}
		}
		
		
		int count = 0;
		
		testFile();
		int price;
		int price2;
		for(int i = 0; i < Houses.size(); i++){
			price = Houses.get(i).getPrice();
			price2 = Houses.get(i+1).getPrice();
			
			
		}
		
		
		ArrayList<House> FINAL = new ArrayList<House>();
		for(int j = 0; j < Houses.size(); j++){
		}
		
		
		if (pwt != null) {
			pwt.close();
		}
	}
	public void testFile(){
		DecimalFormat df = new DecimalFormat("00.0");
		System.out.println("TEST INPUT FILE");
		for(int i = 0; i < Houses.size(); i++){
			System.out.printf(Houses.get(i).getCaseNum() + " " + Houses.get(i).getPrice() + " " + df.format(Houses.get(i).getDistance()) + " " + Houses.get(i).getSize() + "\n");
			
		}
		System.out.println("END INPUT FILE TEST");
	}
	public static void main(String args[]){
		Prog1 program = new Prog1();
		program.run(inputFile, outputFile);
		
		
		
	}
}
