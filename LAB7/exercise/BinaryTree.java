package LAB7.exercise;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
   A class that implements the ADT binary tree.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class BinaryTree<T> implements BinaryTreeInterface<T>
{
   private BinaryNode<T> root;

   public BinaryTree()
   {
      root = null;
   } // end default constructor

   public BinaryTree(T rootData)
   {
      root = new BinaryNode<>(rootData);
   } // end constructor

   public BinaryTree(T rootData, BinaryTree<T> leftTree, 
                                 BinaryTree<T> rightTree)
   {
      privateSetTree(rootData, leftTree, rightTree);
   } // end constructor

   public void setTree(T rootData)
   {
      root = new BinaryNode<>(rootData);
   } // end setTree

   public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                                   BinaryTreeInterface<T> rightTree)
   {
      privateSetTree(rootData, (BinaryTree<T>)leftTree, 
                               (BinaryTree<T>)rightTree);
   } // end setTree

   private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      root = new BinaryNode<>(rootData);

      if ((leftTree != null) && !leftTree.isEmpty())
         root.setLeftChild(leftTree.root);

      if ((rightTree != null) && !rightTree.isEmpty())
      {
         if (rightTree != leftTree)
            root.setRightChild(rightTree.root);
         else
            root.setRightChild(rightTree.root.copy());
      } // end if

      if ((leftTree != null) && (leftTree != this))
         leftTree.clear();

      if ((rightTree != null) && (rightTree != this))
         rightTree.clear();
   } // end privateSetTree


   /*  < Implementations of getRootData, getHeight, getNumberOfNodes, isEmpty, clear are here. >
   . . . */

   public T getRootData()
   {
      if (isEmpty())
         throw new EmptyTreeException();
      else
         return root.getData();
   } // end getRootData

   public boolean isEmpty()
   {
      return root == null;
   } // end isEmpty

   public void clear()
   {
      root = null;
   } // end clear

   protected void setRootData(T rootData)
   {
      root.setData(rootData);
   } // end setRootData

   protected void setRootNode(BinaryNode<T> rootNode)
   {
      root = rootNode;
   } // end setRootNode

   protected BinaryNode<T> getRootNode()
   {
      return root;
   } // end getRootNode

   public int getHeight()
   {
      return root.getHeight();
   } // end getHeight

   public int getNumberOfNodes()
   {
      return root.getNumberOfNodes();
   } // end getNumberOfNodes


    /*  < Implementations of the methods specified in TreeIteratorInterface are here. >
   . . . */

   public void inorderTraverse()
   {
      inorderTraverse(root);
   } // end inorderTraverse

   private void inorderTraverse(BinaryNode<T> node)
   {
      if (node != null)
      {
         inorderTraverse(node.getLeftChild());
         System.out.println(node.getData());
         inorderTraverse(node.getRightChild());
      } // end if
   } // end inorderTraverse

   public Iterator<T> getInorderIterator()
   {
      return new InorderIterator();
   } // end getInorderIterator

   public void iterativeInorderTraverse()
   {
      StackInterface<BinaryNode<T>> nodeStack = (StackInterface) new LinkedStack<>();
      BinaryNode<T> currentNode = root;

      while (!nodeStack.isEmpty() || (currentNode != null))
      {
         // Find leftmost node with no left child
         while (currentNode != null)
         {
            nodeStack.push(currentNode);
            currentNode = currentNode.getLeftChild();
         } // end while

         // Visit leftmost node, then traverse its right subtree
         if (!nodeStack.isEmpty())
         {
            BinaryNode<T> nextNode = nodeStack.pop();
            assert nextNode != null; // Since nodeStack was not empty
            // before the pop
            System.out.println(nextNode.getData());
            currentNode = nextNode.getRightChild();
         } // end if
      } // end while
   } // end iterativeInorderTraverse

   private class InorderIterator implements Iterator<T>
   {
      private StackInterface<BinaryNode<T>> nodeStack;
      private BinaryNode<T> currentNode;

      public InorderIterator()
      {
         nodeStack = (StackInterface) new LinkedStack<>();
         currentNode = root;
      } // end default constructor

      public boolean hasNext()
      {
         return !nodeStack.isEmpty() || (currentNode != null);
      } // end hasNext

      public T next()
      {
         BinaryNode<T> nextNode = null;

         // Find leftmost node with no left child
         while (currentNode != null)
         {
            nodeStack.push(currentNode);
            currentNode = currentNode.getLeftChild();
         } // end while

         // Get leftmost node, then move to its right subtree
         if (!nodeStack.isEmpty())
         {
            nextNode = nodeStack.pop();
            assert nextNode != null; // Since nodeStack was not empty
            // before the pop
            currentNode = nextNode.getRightChild();
         }
         else
            throw new NoSuchElementException();

         return nextNode.getData();
      } // end next

      public void remove()
      {
         throw new UnsupportedOperationException();
      } // end remove
   } // end InorderIterator
   private class PreorderIterator implements Iterator<T> {
        private Stack<BinaryNode<T>> nodeStack;

        public PreorderIterator() {
            nodeStack = new Stack<>();
            if (root != null) {
                nodeStack.push(root);
            }
        }

        public boolean hasNext() {
            return !nodeStack.isEmpty();
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            BinaryNode<T> nextNode = nodeStack.pop();
            if (nextNode.getRightChild() != null) {
                nodeStack.push(nextNode.getRightChild());
            }
            if (nextNode.getLeftChild() != null) {
                nodeStack.push(nextNode.getLeftChild());
            }
            return nextNode.getData();
        }
    }
    private class PostorderIterator implements Iterator<T> {
      private Stack<BinaryNode<T>> nodeStack;
      private BinaryNode<T> currentNode;
      private BinaryNode<T> lastVisitedNode;

      public PostorderIterator() {
          nodeStack = new Stack<>();
          currentNode = root;
      }

      public boolean hasNext() {
          return !nodeStack.isEmpty() || currentNode != null;
      }

      public T next() {
          while (currentNode != null || !nodeStack.isEmpty()) {
              if (currentNode != null) {
                  nodeStack.push(currentNode);
                  currentNode = currentNode.getLeftChild();
              } else {
                  BinaryNode<T> peekNode = nodeStack.peek();
                  if (peekNode.getRightChild() != null && lastVisitedNode != peekNode.getRightChild()) {
                      currentNode = peekNode.getRightChild();
                  } else {
                      lastVisitedNode = nodeStack.pop();
                      return lastVisitedNode.getData();
                  }
              }
          }
          throw new NoSuchElementException();
      }
  }

  public Iterator<T> getPreorderIterator() {
      return new PreorderIterator();
  }

  public Iterator<T> getPostorderIterator() {
      return new PostorderIterator();
  }

} // end BinaryTree