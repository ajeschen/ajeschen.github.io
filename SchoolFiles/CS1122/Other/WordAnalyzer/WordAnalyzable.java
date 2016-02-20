
/**
 * A class that analyzes words.
 */

public interface WordAnalyzable {

   /**
    * Getter method.
    * @return the word being analyzed.
    */
   public String getWord( );

   /**
    * Setter method.
    * @return sets the word being analyzed.
    */
   public void setWord( String word );

   /**
   * Gets the first repeated character. A character is <i>repeated</i>
   * if it occurs at least twice in adjacent positions. For example,
   * 'l' is repeated in "hollow", but 'o' is not.
   * @return the first repeated character, or 0 if none found
   */
   public char firstRepeatedCharacter( );

   /**
   * Gets the first multiply occurring character. A character is <i>multiple</i>
   * if it occurs at least twice in the word, not necessarily in adjacent positions.
   * For example, both 'o' and 'l' are multiple in "hollow", but 'h' is not.
   * @return the first repeated character, or 0 if none found
   */
   public char firstMultipleCharacter( );

   /**
   * Counts the groups of repeated characters. For example, "mississippi!!!" has
   * four such groups: ss, ss, pp and !!!.
   * @return the number of repeated character groups
   */
   public int repeatedCharacterGroupCount( );

   /**
   * A palindrome is a word that is spelled the same forwards and backwards.
   * Example: "radar" is a palindrome
   *
   * @return true if the word is a palindrome.
   */
   public boolean palindrome( );

}
