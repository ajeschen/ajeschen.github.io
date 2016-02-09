import java.util.Scanner;


public class PigLatinInator implements PigLatinAble {

   public String pigLatinify( String word ) {
      
      String result = "";
      word = word.toLowerCase( );
      

      String[] words = word.split("\\s+");
      for (int i = 0; i < words.length; i++) {
          words[i] = words[i].replaceAll("[^\\w]", "");
      }
      
      for (int j = 0; j<words.length; j++) {
      	result+= pigLatinifyWord(words[j]) + " ";
      }
      result = result.substring(0, result.length()-1);
      return result;
      
      
      
   }
   
   public static void main( String[ ] args ) {
      PigLatinInator self = new PigLatinInator( );
      Scanner input = new Scanner( System.in );
      System.out.print( "Enter a word: " );
      String word = input.nextLine( );
      System.out.println("\n Your word in Pig Latin is " 
                     + self.pigLatinify( word ) );
   }

public String pigLatinifyWord(String word) {
	String result = "";
    word = word.toLowerCase( );
    
	if (word.length( ) == 1 || word.substring( 0, 1 ).equals( "a" )
            || word.substring( 0, 1 ).equals( "e" )
            || word.substring( 0, 1 ).equals( "i" )
            || word.substring( 0, 1 ).equals( "o" )
            || word.substring( 0, 1 ).equals( "u" )) {
		result = word + "way";
	} else {
		result = word.substring( 1 ) + word.substring( 0, 1 ) + "ay";
	}

return result;
}

}
