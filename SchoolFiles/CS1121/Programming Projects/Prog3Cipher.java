//ALEX ESCHENAUER
//PROGRAM 3 CIPHER
public class Prog3Cipher {

		char charCode;
		String secretKey;
		char[] orig = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		char [][] cipherTable = new char[26][26];
		static char START = 'H'; //CHANGE THIS TO ANYTHING YOU WANT
		
		public Prog3Cipher(char code, String key){ //THIS PROGRAM MAKES AND PRINTS THE CIPHER TABLE, BASED ON WHAT BEGINNING LETTER YOU GAVE
			charCode = code;
			secretKey = key; //THIS SETS THE SECRET KEY TO WHATEVER YOU PUT IN AS A PARAMETER INTO THE PROGRAM 
			for(int row = 0; row<cipherTable.length; row++){ //THE FOLLOWING CREATES THE TABLE
				char shift = (char)(code+row);
				if(shift > 'Z'){
					shift -=26;
				}
				for(int column = 0; column < cipherTable[row].length; column++){
					cipherTable[row][column] = (char)(shift + column);
					if(cipherTable[row][column] > 'Z'){
						cipherTable[row][column] -=26;
					}
				}
			}
			for(int row = 0; row< cipherTable.length; row++){
				for(int column = 0; column <cipherTable[row].length; column++){
					System.out.print(cipherTable[row][column] + " ");
				}
				System.out.println();
			}
			
		}
		
		String decode( String message ) { //THIS DECODES THE STRING THAT HAS BEEN GIVEN TO IT.
		      String result = "";
		      message = message.toUpperCase();
		      for (int i = 0, j = 0; i < message.length(); i++) {
		            char keyChar = secretKey.charAt(j);
		            char valueChar = message.charAt(i);
		            if(valueChar == ' '){ //THIS ADDS SPACES IF THERE IS ONE AT THAT POINT IN THE MESSAGE
		        		result+= " ";
		        	}
		            if(valueChar < 'A' || valueChar > 'Z') //THIS WORKS BACKWARDS FROM THE ENCODE. WHAT THIS DOES IS IT 
		            	//FIRST DETERMINES IF IT IS A VALUE IT CAN WORK WITH, THEN IT GOES FROM 0-26 IN A LOOP AND SEES IF THE 
		            	//CIPHERTABLE ROW OF KEYCHAR AND FINDS THE COLUMN WHERE IT IS EQUAL TO THE CORRESPONDING MESSAGE CHARACTER
		            	//AND THEN ADDS THE DECODED LETTER TO THE RESULT
		            	continue;
		           
		            for(int k = 0; k<26; k++){
		            	int p = keyChar - 'A';
		            	if(cipherTable[p][k]==valueChar){
		            		result+=orig[k];
		            	}
		            }
		            j =(j+1) % secretKey.length();
		        }
		      return result;
		}
		
		String encode( String message ) { //THIS ENCODES THE STRING GIVEN TO IT
			String key2 = secretKey;
			String result = "";
			message = message.toUpperCase(); //THIS MAKES IT ALL UPPERCASE LETTERS, SO THAT IT WORKS
			
	        for (int i = 0, j = 0; i < message.length(); i++) { //THIS TAKES THE FIRST CHAR OF THE KEY AND THE MESSAGE, 
	        		//AND THEN FINDS WHERE THEY INTERSECT ON THE TABLE TO SET THAT AS THE FIRST OF THE ENCODED MESSAGE
	        	char keyChar = secretKey.charAt(j);
	        	char valueChar = message.charAt(i);
	        	if(valueChar == ' '){
	        		result+= " ";
	        	}
	        	if (valueChar < 'A' || valueChar > 'Z')
	        		continue;
	        	int k = keyChar - 'A';
	        	int c = valueChar - 'A';
	            result += cipherTable[k][c];
	            j = (j + 1) % key2.length();
	        }
			
			
		      return result; //THIS RETURNS THE ENCODED MESSAGE
		}
		
		
		public static void main(String[] args){
			
			
			String key1 = "BABBAGE"; //CHANGE THIS TO WHATEVER
			Prog3Cipher self = new Prog3Cipher( START, key1 );
			
		      // Should print "PHXXF MQYBPKNJ"
		      System.out.println( self.encode( "Happy Birthday" ) );
		      // Should print "HAPPY BIRTHDAY"
		      System.out.println( self.decode( self.encode( "Happy Birthday" ) ) );

		}
	}

