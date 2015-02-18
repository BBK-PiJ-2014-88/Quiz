package server;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import quiz.*;

/**
 * 
 * @author Sergio
 * This is the central Quiz Server
 * Client objects invoke methods on a Quiz Server Object in the registry
 * 
 */
public class QuizServer extends UnicastRemoteObject implements QuizRemoteInterface  {

HashMap<Integer, Quiz> quizList = new HashMap<Integer, Quiz>();
	
	public QuizServer() throws RemoteException{
		super();
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

	public boolean addQuiz(Quiz quizToAdd, int id){
		quizList.put(id, quizToAdd);
		flush();
		System.out.println("Added quiz to server");
		return true;
	}
	 
	public Quiz getQuiz(int id){
		return (Quiz) quizList.get(id);
	}
	public boolean deleteQuiz(int id){
		quizList.remove(id);
		flush();
		System.out.println("Deletred quiz from server");
		return true;
	}
	
	/**
	 * Creates a unique ID to assign to a new Quiz created by the user. Iterates over the existing
	 * ID's and finds the smallest number which isn't already being used as an ID
	 */
	public int createQuizId(){
		Set keySet = quizList.keySet();
		int iD = 1;
		boolean idFound = false;
		while (!idFound){
			if (keySet.contains(iD)){
				iD++;
			}
			else{
				idFound = true;
			}
		}
		return iD;
	}
	
	public int getNumberOfQuizzes(){
		return quizList.size();
	}
	
	/**
	 * Creates a String array where each Quiz in the Quiz Server 
	 * is represented by a string consisting of its QuizName and QuizId
	 */
	public String[] getEachQuizString(){
		int position = 0;
		String[] result = new String[quizList.size()];
			for (Quiz quiz: quizList.values()){
				result[position] = new String("[Quiz id]: " + quiz.getQuizId() + " [Quiz name]: " + quiz.getName());
				position++;
			}
		return result;
	}
	public void addHighScore(PlayerAttempt highScore, int id){
		quizList.get(id).addPlayerAttempt(highScore);
		flush();
		System.out.println("Added player Attempt");
		System.out.println(quizList.get(id));
	}
	
	/**
	 * Writes the QuizList to a file
	 */
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
