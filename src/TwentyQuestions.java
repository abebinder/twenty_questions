import java.util.*;
import java.io.*;
public class TwentyQuestions {
	Queue<String> qandAQueue;
	ArrayList<String>questionsList=new ArrayList<String>();
	Tree<String> questionTree=new Tree<String>();

	public void play(){
		readIn();
		convertListToTree();
		Scanner sc=new Scanner(System.in);
		TreeNode<String>current=questionTree.getRoot();
		while(true){
			if(current.getLeftChild()==null&&current.getRightChild()==null){
				System.out.println("enter a new object");
				String specific_item=sc.nextLine();
				System.out.println("what distinguishe it");
				String broad_question=sc.nextLine();
				System.out.println("does your new object answer yes or no");
				String answer=sc.nextLine();
				
				
			}
			String question=current.getValue();
			System.out.println(question);
			String user_input=sc.nextLine();
			if(user_input.equals("yes")){
				current=current.getLeftChild();
			}
			else{
				current=current.getRightChild();
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






