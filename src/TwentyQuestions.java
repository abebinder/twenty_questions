import java.util.*;
import java.io.*;
public class TwentyQuestions {
	Queue<String> qandAQueue;
	ArrayList<String>questionsList=new ArrayList<String>();
	Tree<String> questionTree=new Tree<String>();

	public void printQueue(){
		if(qandAQueue.getSize()>0){
			String current=qandAQueue.deQueue();
			System.out.println(current);
		}

	}

	public void readIn(){
		try{
			File file=new File("questions.txt");
			Scanner sc=new Scanner(file);
			while(sc.hasNextLine()){
				String line=sc.nextLine();
				questionsList.add(line);
				
			}
			System.out.println(questionsList);
		}catch(Exception e){System.out.println(e);}
	}
	
	public void convertListToTree(){
		for(int i=0; i<questionsList.size(); i++){
		
		}
	}
	




}
