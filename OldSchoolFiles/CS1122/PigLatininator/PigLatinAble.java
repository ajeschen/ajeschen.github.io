/**
 * Convert English words into Pig Latin according to the following rules:
 *   1. Words that begin with consonants, the initial consonant is moved to the 
 *      end of the word, and "ay" is appended.
 *      For example:
 *         "pig" → "igpay"
 *         "banana" → "ananabay"
 *         "duck" → "uckday"
 *   2. Words that begin with a vowel ("a", "e", "i", "o", "u"), just add "way" 
 *      to the end.
 *      For example:
 *         "egg" → "eggway"
 *         "inbox" → "inboxway"
 *         "eight" → "eightway"
 */ 
public interface PigLatinAble {
   /**
    * Convert English words into Pig Latin.
    * 
    * @param text - A String containing words in English.
    * @return - The input text translated into pig latin.
    */
   public String pigLatinify ( String text );

   /**
    * Convert a single English word into Pig Latin.
    * 
    * @param word - A String containing a single word in English.
    * @return - The input word translated into pig latin.
    */
   public String pigLatinifyWord ( String word );
}
