import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class WordAnalyzableTest extends TestCase{
	
	public void testSettingAndGettingWord(){ //BUG NUMBER 1
		WordAnalyzer a = new WordAnalyzer();
		a.setWord("Word");
		assertEquals("Word", a.getWord());
	}
	
	public void testFirstRepeatedCharacter(){ //BUG NUMBER 5
		WordAnalyzer a = new WordAnalyzer();
		a.setWord("hollow");
		assertEquals('l', a.firstRepeatedCharacter());
	}

	public void testFirstMultipleCharacter(){ //BUG NUMBER 2
		WordAnalyzer a = new WordAnalyzer();
		a.setWord("hollow");
		assertEquals('o', a.firstMultipleCharacter());
	}

	public void testRepeatedCharacterGroupCount(){
		WordAnalyzer a = new WordAnalyzer(); //BUG NUMBER 3
		a.setWord("aaaaa");
		assertEquals(1, a.repeatedCharacterGroupCount());
	}

	public void testPalindrome(){ //BUG NUMBER 4
		WordAnalyzer a = new WordAnalyzer();
		a.setWord("abcd");
		assertEquals(false, a.palindrome());
	}

	public static Test suite() { 
		return new TestSuite(WordAnalyzableTest.class);
    }
}
