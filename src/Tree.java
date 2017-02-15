import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Tree<T extends Comparable> {

  private TreeNode<T> root;

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
  
  public void addNode(T new_question, TreeNode<T> previous_node, boolean distinguishingBoolean) {
    TreeNode<T> new_node = new TreeNode<T>(new_question);
    
    if (distinguishingBoolean == true){
    	previous_node.addLeftChild(new_node);
    }
    else{
    	previous_node.addRightChild(new_node);
    }
    
    
  }

  



  

  
}
