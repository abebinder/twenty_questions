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

  



  

  public static void main(String[] args) throws FileNotFoundException {

      Tree<String> myTree = new Tree();

      Scanner myScanner = new Scanner(new File("words.txt"));
      while (myScanner.hasNext()) {
          myTree.addNode(myScanner.next());
      }

      //myTree.inorderTraversal();

  }
}
