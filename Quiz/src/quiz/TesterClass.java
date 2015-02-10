package quiz;

public class TesterClass {

	public static void main(String[] args) {
		new TesterClass().launch();

	}
	public void launch(){
		String[] ans = {"hello", "goodbye", "what", "good"};
		String[] answrong = {"hello", "goodbye", "what", "how", "ans"};
		Question question1 = new Question("How are you", answrong, 3);
		System.out.println(question1.getQuestion());
		String[] x = (question1.getAnswers());
		for (String y: x){
			System.out.println(y);
		}
		System.out.println(question1.getCorrectAnswer());
	}

}
