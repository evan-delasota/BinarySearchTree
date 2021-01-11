class Main {
  public static void main(String[] args) {
    Tree bst = new Tree();
    bst.insert(5);
    bst.insert(10);
    bst.insert(50);
    bst.insert(3);
    bst.insert(28);
    bst.insert(300);
    bst.insert(1);
    bst.levelOrderDisplay();

    bst.delete(50);

    bst.levelOrderDisplay();
    bst.preOrderDisplay();
    bst.inOrderDisplay();
    bst.postOrderDisplay();
  }
}