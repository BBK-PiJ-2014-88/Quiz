package server;

import java.util.HashMap;

import quiz.*;
import gui.*;

import java.io.*;

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
