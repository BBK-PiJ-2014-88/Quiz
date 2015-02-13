package server;

import java.util.HashMap;

import quiz.*;
import gui.*;

import java.io.*;

public class QuizServer {
	HashMap<Integer, Quiz> QuizList = new HashMap<Integer, Quiz>();
	
	public QuizServer(){
		File storageFile = new File("QuizStorage.txt");
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(storageFile))){
			QuizList = (HashMap<Integer, Quiz>) in.readObject();
		} catch(IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException ex){
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		new QuizServer().launch();
	}
	public void launch(){
		
	}

}
