package unitTests;

import static org.junit.Assert.*;
import quiz.*;

import org.junit.*;

public class QuestionTest {
	Question question1;
	String[] ans = {"good", "bad", "ok", "excellent"};
	
	@Before
	public void buildUp(){
		question1 = new Question("How are you?", ans, 2);
	}

	@Test
	public void testGetQuestion() {
		assertEquals("How are you?", question1.getQuestion());
	}

	@Test
	public void testGetAnswers() {
		assertArrayEquals(ans, question1.getAnswers());
	}
	
	@Test
	public void testGetCorrectAnswer() {
		assertEquals("ok", question1.getCorrectAnswer());
	}
	

}
