/**
 * A class that analyzes words.
 */

public class WordAnalyzer {

   private String word;

   /**
    * Getter method.
    * @return the word being analyzed.
    */
   public String getWord( ) {
      // TODO Auto-generated method stub
      return word; //BUG 1 FIX
   }

   /**
    * Setter method.
    * @return sets the word being analyzed.
    */
   public void setWord( String word ) {
      this.word = word;
   }

   /**
   * Gets the first repeated character. A character is <i>repeated</i>
   * if it occurs at least twice in adjacent positions. For example,
   * 'l' is repeated in "hollow", but 'o' is not. 
   * @return the first repeated character, or 0 if none found
   */
   public char firstRepeatedCharacter( ) {
      char Result = 0; // Not found
      int count = 1; //BUG 5 FIX STEP 1
      for ( int i = 0; i < word.length( ); i++ ) {
    	 
    	 count++; //BUG 5 FIX STEP 2
    	 
         char ch = word.charAt( i );
         if ( ch == word.charAt( i + 1 ) ) {
            return ch; //BUG 5 FIX STEP 3
         }
         
         if(count == word.length()){ //BUG 5
        	 Result = 0;			//FIX STEP
        	 return Result;			//4
         }
      }
      return Result;
   }

   /**
   * Gets the first multiply occurring character. A character is <i>multiple</i>
   * if it occurs at least twice in the word, not necessarily in adjacent positions. 
   * For example, both 'o' and 'l' are multiple in "hollow", but 'h' is not. 
   * @return the first repeated character, or 0 if none found
   */
   public char firstMultipleCharacter( ) {
      char Result = 0; // Not found

      for ( int i = 0; Result == 0 && i < word.length( ); i++ ) {
         char ch = word.charAt( i );
         if ( find( ch, i ) > 0 ) { //BUG 2 FIX
            Result = ch;
         }
      }
      return Result;
   }

   private int find( char c, int pos ) {
      int Result = -1; // Not found
      for ( int i = pos; Result == -1 && i < word.length( ); i++ ) {
         if ( word.charAt( i ) == c ) {
            Result = i;
         }
      }
      return Result;
   }

   /**
   * Counts the groups of repeated characters. For example, "mississippi!!!" has 
   * four such groups: ss, ss, pp and !!!.
   * @return the number of repeated character groups 
   */
   public int repeatedCharacterGroupCount( ) {
      int Result = 0;
      int count = 0; //BUG 3 FIX STEP 1
      for ( int i = 1; i < word.length( ) - 1; i++ ) {
         if ( word.charAt( i ) == word.charAt( i + 1 ) ) { // found a repetition
        	 count++; //BUG 3 FIX STEP 2
            if ( word.charAt( i - 1 ) != word.charAt( i ) ) { // start of a
                                                              // repetition
               Result++;
            }
         }
      }
      count = count+2;
      if(count == word.length()){ Result++; } //BUG 3 FIX STEP 3
      return Result;
   }

   /**
   * A palindrome is a word that is spelled the same forwards and backwards.
   * Example: "radar" is a palindrome
   * 
   * @return true if the word is a palindrome.
   */
   public boolean palindrome( ) {
      boolean Result = true; // Assume palindrome til proven false
      int front = 0;
      int back = word.length( ) - 1;

      while ( front <= back ) { //BUG 4 FIX STEP 1
         if ( word.charAt( front ) == word.charAt( back ) ) {
            front++;
            back--;
         }
         else{ Result = false; break; } //BUG 4 FIX STEP 2
      }
      return Result;
   }

}
