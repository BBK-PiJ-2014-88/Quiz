package unitTests;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import server.QuizServer;
import quiz.*;

public class QuizServerTest {

	@Before
	public void buildUp(){
		try {
			QuizServer serverTester = new QuizServer();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
