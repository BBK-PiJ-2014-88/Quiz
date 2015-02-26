package unitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ QuestionTest.class, QuizTest.class, QuizServerTest.class, SetUpClientPlayerClientTest.class})
public class AllTestsSuite {

} 