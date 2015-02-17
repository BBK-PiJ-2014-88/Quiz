package server;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
	//will remove this later
	public static void main(String[] args){
		QuizServer launcher = null;
		try {
			launcher = new QuizServer();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		launcher.launch();
	}
	public void launch(){
		
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
