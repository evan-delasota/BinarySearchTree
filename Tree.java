class Node {
  Node left;
  Node right;
  int value;

  Node(int value) {
    this.value = value;
    left = null;
    right = null;
  }

}

class Tree {
  Node root;

  Tree() {
    root = null;
    
  }

  int height(Node root) {
    if (root == null) {
      return 0;
    } else {
      int leftHeight = height(root.left);
      int rightHeight = height(root.right);

      if (leftHeight > rightHeight) {
        return (leftHeight + 1);
      } else {
        return (rightHeight + 1);
      }

    }
  }

  void displayHeight() {
    System.out.println("\nTree height: " + height(root));
  }
  // Outputs the values of each node for every level of the tree
  void printLevel(Node root, int level) {
    if (root == null) {
      return;
    }

    if (level == 1) {
      System.out.print(root.value + " ");
    } else {
      printLevel(root.left, level - 1);
      printLevel(root.right, level - 1);
    }

  }
  // Level-order tree display
  void levelOrderDisplay() {
    int treeHeight = height(root);
    System.out.println("\nLevel order tree display: ");

    for (int i = 0; i <= treeHeight; ++i) {
      printLevel(root, i);
    }
    System.out.println();

  }

  void preOrder(Node root) {
    if (root == null) {
      return;
    }

    System.out.print(root.value + " ");

    preOrder(root.left);

    preOrder(root.right);

  }

  public void preOrderDisplay() {
    System.out.println("\nPre-order tree display: ");
    preOrder(root);
    System.out.println();

  }

  void inOrder(Node root) {
    if (root == null) {
      return;
    }

    inOrder(root.left);

    System.out.print(root.value + " ");

    inOrder(root.right);

  }

  public void inOrderDisplay() {
    System.out.println("\nIn-order tree display: ");
    inOrder(root);
    System.out.println();

  }

  void postOrder(Node root) {
    if (root == null) {
      return;
    }

    postOrder(root.left);

    postOrder(root.right);

    System.out.print(root.value + " ");
  } 

  public void postOrderDisplay() {
    System.out.println("\nPost-order tree display: ");
    postOrder(root);
    System.out.println();
  }

  public Node search(Node root, int value) {
    if (root == null || root.value == value) {
      return root;
    }
    
    if (root.value > value) {
      return search(root.left, value);
    }
    return search(root.right, value);

  }

  public void insert(int value) {
    System.out.println("\nInserting " + value);
    root = insertRecursively(root, value);
  }

  Node insertRecursively(Node root, int value) {
    if (root == null) {
      root = new Node(value);
      return root;
    }

    if (value < root.value) {
      root.left = insertRecursively(root.left, value);
    } else if (value > root.value) {
      root.right = insertRecursively(root.right, value);
    }

    return root;
  }

  void delete(int value) {
    System.out.println("\nDeleting " + value);
    root = deleteRecursively(root, value);
  }

  Node deleteRecursively(Node root, int value) {
    if (root == null) {
      return null;
    }

    if (value == root.value) {
      // No child nodes
      if (root.left == null && root.right == null) {
        return null;
      }
      // no left child node
      if (root.left == null) {
        return root.left;
      }
      // No right child node
      if (root.right == null) {
        return root.right;
      }

      // Both left and right child nodes
      if (root.left != null && root.right != null) {
        int minValue = findMinValue(root.right);
        root.value = minValue;
        root.right = deleteRecursively(root.right, minValue);
        return root;
      }
    }

    if (value < root.value) {
      root.left = deleteRecursively(root.left, value);
      return root;
    } 
    root.right = deleteRecursively(root.right, value);
    return root;

  }

  private int findMinValue(Node root) {
    if (root.left == null) {
      return root.value;
    } else {
      return findMinValue(root.left);
    }
  }

}