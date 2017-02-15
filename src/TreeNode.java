

public class TreeNode<T extends Comparable> {

    public T value;
    public TreeNode<T> left_child;
    public TreeNode<T> right_child;

    public TreeNode(T _value) {
      value = _value;
      left_child = null;
      right_child = null;
    }

    public void addLeftChild(TreeNode<T> _child) {
      left_child = _child;
    }

    public void addRightChild(TreeNode<T> _child) {
      right_child = _child;
    }

    public TreeNode<T> getLeftChild() {
      return left_child;
    }

    public TreeNode<T> getRightChild() {
      return right_child;
    }

    public T getValue() {
      return value;
    }

    int count() {
      TreeNode right = getRightChild();
      TreeNode left = getLeftChild();
      int c = 1;
      if ( right != null ) c += right.count();
      if ( left != null ) c += left.count();
      return c;
    }

    public String toString() {
      return "TreeNode: " + value.toString();
    }









}
