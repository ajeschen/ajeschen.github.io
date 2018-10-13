package Programs;
import java.util.Scanner;
//Alex Eschenauer

public class PostNet {
	public void zipToPostNet ( String zipcode ) {
		//YO IS UNUSED CODE
		String yo = "*****\n";
		//THIS IS AN ARRAY THAT HOLDS A STRING VALUE OF ALL THE NUMBERS FROM 0 TO 9, SO THAT WHEN I CALL ON THEM THEY WILL BE ABLE TO PRINT THE CORRESPONDING NUMBER
		String nums[] = {"0****\n ****\n **\n **\n **\n", "1**\n **\n **\n ****\n ****\n", "2**\n **\n ****\n **\n ****\n", "3**\n **\n ****\n ****\n **\n", "4**\n ****\n **\n **\n ****\n", "5**\n ****\n **\n ****\n **\n","6**\n ****\n ****\n **\n **\n", "7****\n **\n **\n **\n ****\n", "8****\n **\n **\n ****\n **\n", "9****\n **\n ****\n **\n **\n"};
		
		//BELOW I CONVERTED THE STRING TO INTERGERS
		String num1 = zipcode.substring(0,1);
		int first = Integer.parseInt(num1);
		String num2 = zipcode.substring(1,2);
		int second = Integer.parseInt(num2);
		String num3 = zipcode.substring(2,3);
		int third = Integer.parseInt(num3);
		String num4 = zipcode.substring(3,4);
		int fourth = Integer.parseInt(num4);
		String num5 = zipcode.substring(4,5);
		int fifth = Integer.parseInt(num5);
		
		//USED BELOW FOR TESTING PURPOSES
		//System.out.println(first);
		//System.out.println(second);
		//System.out.println(third);
		//System.out.println(fourth);
		//System.out.println(fifth);
		
		//THIS MAKES THE CHECK VALUE FOR THE LAST DIGIT OF THE BARCODE
		int sum = first+second+third+fourth+fifth;
		int remainder = sum%10;
		int check = 10-remainder;
		
		//THIS PRINTS OUT THE BARCODE BY TAKING THE ORIGINAL ARRAY AND PRINTING THE CORRESPONDING VALUE FOR EACH
		System.out.println(" ****");
		System.out.println(nums[first]+nums[second]+nums[third]+nums[fourth]+nums[fifth]+nums[check]+" ****\n");
	   }

	//THIS ASKS FOR THE ARRAY AS AN INPUT, AND THEN CALLS ON THE FUNCTION ABOVE TO PRINT IT OUT AND CALCULATE EVERYTHING
	   public static void main(String[] args) {
	      PostNet self = new PostNet( );
	      Scanner a = new Scanner(System.in);
	      System.out.println("Enter a 5 Digit Zip Code");
	      String s = a.nextLine();
	      self.zipToPostNet( s );
	   } 

}
