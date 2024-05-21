package LAB7.exercise;

import java.util.Iterator;

public class TreeDemo {
    public static void main(String[] args) {
        // Represent each leaf as a one-node tree
        BinaryTreeInterface<String> dTree = new BinaryTree<>();
        dTree.setTree("D");
        BinaryTreeInterface<String> fTree = new BinaryTree<>();
        fTree.setTree("F");
        BinaryTreeInterface<String> gTree = new BinaryTree<>();
        gTree.setTree("G");
        BinaryTreeInterface<String> hTree = new BinaryTree<>();
        hTree.setTree("H");
        BinaryTreeInterface<String> emptyTree = new BinaryTree<>();

        // Form larger subtrees
        BinaryTreeInterface<String> eTree = new BinaryTree<>();
        eTree.setTree("E", fTree, gTree); // Subtree rooted at E
        BinaryTreeInterface<String> bTree = new BinaryTree<>();
        bTree.setTree("B", dTree, eTree); // Subtree rooted at B
        BinaryTreeInterface<String> cTree = new BinaryTree<>();
        cTree.setTree("C", emptyTree, hTree); // Subtree rooted at C
        BinaryTreeInterface<String> aTree = new BinaryTree<>();
        aTree.setTree("A", bTree, cTree); // Desired tree rooted at A

        // Display root, height, number of nodes
        System.out.println("Root of tree contains " + aTree.getRootData());
        System.out.println("Height of tree is " + aTree.getHeight());
        System.out.println("Tree has " + aTree.getNumberOfNodes() + " nodes");

        // Display nodes in inorder
        System.out.println("An inorder traversal visits nodes in this order:");
        Iterator<String> inorder = aTree.getInorderIterator();
        while (inorder.hasNext())
            System.out.print(inorder.next() + " ");
        System.out.println();

        // Display nodes in preorder
        System.out.println("A preorder traversal visits nodes in this order:");
        Iterator<String> preorder = aTree.getPreorderIterator();
        while (preorder.hasNext())
            System.out.print(preorder.next() + " ");
        System.out.println();

        // Display nodes in postorder
        System.out.println("A postorder traversal visits nodes in this order:");
        Iterator<String> postorder = aTree.getPostorderIterator();
        while (postorder.hasNext())
            System.out.print(postorder.next() + " ");
        System.out.println();
    }
}
