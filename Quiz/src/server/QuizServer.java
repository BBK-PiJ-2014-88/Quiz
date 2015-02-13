package server;

import java.io.*;
import java.util.HashMap;

import quiz.Quiz;

/**
 * 
 * @author Sergio
 * This is the central Quiz Server
 */
public class QuizServer {

HashMap<Integer, Quiz> quizList = new HashMap<Integer, Quiz>();
	
	public QuizServer(){
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
		new QuizServer().launch();
	}
	public void launch(){
		
	}
	
	//the following methods should actually return boolean values. therefore when clients call them, 
	//they have a way of knowing they have been successful
	public void addQuiz(Quiz quizToAdd, int id){
		
	}
	public Quiz getQuiz(int id){
		return null;
	}
	public void deleteQuiz(int id){
		
	}
	
	
	private void flush(){
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
