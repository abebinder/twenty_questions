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

  public void addNode(T new_question, TreeNode<T> previous_node, boolean distinguishingBoolean) {
    TreeNode<T> new_node = new TreeNode<T>(new_question);
    
    if (distinguishingBoolean == true){
    	previous_node.addLeftChild(new_node);
    }
    else{
    	previous_node.addRightChild(new_node);
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
