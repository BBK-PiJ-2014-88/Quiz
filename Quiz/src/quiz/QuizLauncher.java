package quiz;

import java.io.*;
import java.util.HashMap;

public class QuizLauncher {

HashMap<Integer, Quiz> quizList = new HashMap<Integer, Quiz>();
	
	public QuizLauncher(){
		File storageFile = new File("QuizStorage.txt");
		if (storageFile.exists()){
			System.out.println("File exists");
			try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(storageFile))){
				quizList = (HashMap<Integer, Quiz>) in.readObject();
				System.out.println("Read the QuizList from File");
			} catch(IOException e){
				e.printStackTrace();
			} catch (ClassNotFoundException ex){
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		new QuizLauncher().launch();
	}
	public void launch(){
		
	}
	public void addQuiz(Quiz quizToAdd, int id){
		
	}
	public Quiz getQuiz(int id){
		return null;
	}
	public void deleteQuiz(int id){
		
	}
	
	
	public void flush(){
		File storageFile = new File("QuizStorage.txt");
		if (storageFile.exists()){
			storageFile.delete();
		}
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(storageFile))){
			out.writeObject(quizList);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
