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
	
	//the following methods should actually return boolean values. therefore when clients call them, 
	//they have a way of knowing they have been successful
	public boolean addQuiz(Quiz quizToAdd, int id){
		return false;
	}
	public Quiz getQuiz(int id){
		return null;
	}
	public boolean deleteQuiz(int id){
		return false;
	}
	
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
