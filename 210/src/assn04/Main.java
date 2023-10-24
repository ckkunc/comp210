package assn04;

public class Main {
  public static void main(String[] args) {
    /*
    This is a basic example of how to create a BST and add values
    to it (which have been commented out).
    You should add more examples and use this class to debug your code
    */
    BST<Integer> bst = new NonEmptyBST<Integer>(3);
      bst = bst.insert(8);
      bst = bst.insert(1);
      bst = bst.insert(9);
      bst = bst.insert(4);
      System.out.println("PreOrderTraversal: ");
      bst.printPreOrderTraversal();
      System.out.println(" ");
      System.out.println("PostOrderTraversal: ");
      bst.printPostOrderTraversal();
      System.out.println(" ");
      System.out.println("The minimum is: " + bst.findMin());
  }

}
