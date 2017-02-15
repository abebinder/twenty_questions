import java.util.*;
import java.io.*;
public class TwentyQuestions {
	Queue<String> qandAQueue;
	ArrayList<String>questionsList=new ArrayList<String>();
	Tree<String> questionTree=new Tree<String>();
	
	public void writeArrayListToQuestions(){
		File file=new File("questions.txt");
		try{
		FileWriter fw=new FileWriter(file);
		BufferedWriter bw=new BufferedWriter(fw);
		for(int i=0; i<questionsList.size();i++){
			if(i<questionsList.size()-1){
			bw.write(questionsList.get(i));
			bw.newLine();
			}
			else{
				bw.write(questionsList.get(i));
				bw.close();
			}
		}
		bw.close();
		
		} catch(Exception e){System.out.println(e);}
	}
	
	public int getCurrentQuestionFromList(String s){
		for(int i=0; i<questionsList.size(); i++){
			if(questionsList.get(i).equals(s)){
				return i;
			}
		}
		return 0;
	}

	
	public void play(){
		readIn();
		convertListToTree();
		Scanner sc=new Scanner(System.in);
		TreeNode<String>current=questionTree.getRoot();
		while(true){
			String question=current.getValue();
		
			System.out.println(question);
			String user_input=sc.nextLine();
			if(user_input.equals("yes")&&current.getLeftChild()!=null){
				current=current.getLeftChild();
			}
			else if(user_input.equals("no")&&current.getRightChild()!=null){
				current=current.getRightChild();
			}
			else if(user_input.equals("no")&&current.left_child==null){
				System.out.println("enter a new object");
				String specific_item=sc.nextLine();
				System.out.println("what distinguishe it");
				String broad_question=sc.nextLine();
				System.out.println("does your new object answer yes or no");
				String answer=sc.nextLine();
				boolean distinguishing_boolean=false;
				if(answer.equals("yes")){
					distinguishing_boolean=true;
				}
				else{
					distinguishing_boolean=false;
				}
				int index=getCurrentQuestionFromList(question);
				questionsList.set(index,broad_question);
				questionsList.add("");
				questionsList.add("is it a "+specific_item);
				questionsList.add("");
				questionsList.add("");
				questionsList.add(question);
				questionsList.add("");
				questionsList.add("");
				if(distinguishing_boolean){
					questionsList.set(index+1, questionsList.size()-6+"");
					questionsList.set(index+2, questionsList.size()-3+"");
					writeArrayListToQuestions();
					return;
				}
				else{
					questionsList.set(index+1, questionsList.size()-3+"");
					questionsList.set(index+2, questionsList.size()-6+"");
					writeArrayListToQuestions();
					return;
				}
			}
		}
	}

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
		for(int i=0; i<questionsList.size(); i+=3){
			String question=questionsList.get(i);
			int yesLine=0;
			int noLine=0;
			if(!questionsList.get(i+1).equals("")){
			yesLine=Integer.parseInt(questionsList.get(i+1));
			noLine=Integer.parseInt(questionsList.get(i+2));
			}
			if(i==0){
				TreeNode<String> root=new TreeNode<String>(question);
				questionTree.root=root;
				String yesQuestion=questionsList.get(yesLine);
				String noQuestion=questionsList.get(noLine);
				TreeNode<String> no= new TreeNode<String>(noQuestion);
				TreeNode<String> yes= new TreeNode<String>(yesQuestion);
				questionTree.root.left_child=yes;
				questionTree.root.right_child=no;
			}
			if(i!=0){
				TreeNode<String> current=questionTree.find(question, questionTree.root);
				if(current!=null){
					if(!questionsList.get(i+1).equals("")){
						current.left_child=new TreeNode<String>(questionsList.get(yesLine));
						current.right_child=new TreeNode<String>(questionsList.get(noLine));
					}
				}
			}
		}
	}
}






