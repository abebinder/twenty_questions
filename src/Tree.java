import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Tree<T extends Comparable> {

  public TreeNode<T> root;

  public Tree() {
    root = null;
  }

  public TreeNode<T> getRoot(){
      return root;
  }

  public void addNodeAbe(T new_question, TreeNode<T> currentNode, boolean left){
	  if(root==null){
		  root.value=new_question;
	  }
	  if(root!=null){
		  TreeNode<T> current=root;
		  if(current.left_child==null)
		  if(left){
			 currentNode.left_child.value=new_question;
		  }
		  if(!left){
			  currentNode.right_child.value=new_question;
		  }
	  }
  }
  
  public TreeNode<T> find(T question, TreeNode<T> node){
	  if(node!=null){
		  if(node.getValue().equals(question)){
			  return node;
		  }
		  else{
			  TreeNode<T> foundNode=find(question, node.left_child);
			  if(foundNode==null){
				  foundNode=find(question, node.right_child);
			  }
			  return foundNode;
		  }
		  
	  }
	  else{
		  return null;
	  }
	  
  }
  
  public void addNode(T broad_question,T specific_item, TreeNode<T> previous_node, boolean distinguishingBoolean) {
	    TreeNode<T> new_broad_question = new TreeNode<T>(broad_question);
	    TreeNode<T> new_specific_question = new TreeNode<T>(specific_item);
	    
	    if (distinguishingBoolean == true){
	    	new_broad_question.addRightChild(previous_node.getLeftChild());
	    	previous_node.addLeftChild(new_broad_question);
	    	new_broad_question.addLeftChild(new_specific_question);
	    	
	    }
	    else{
	    	new_broad_question.addLeftChild(previous_node.getLeftChild());
	    	previous_node.addLeftChild(new_broad_question);
	    	new_broad_question.addRightChild(new_specific_question); 
	    }
	    
	    
	    
	  }
    
    
  }

  



  

  

