package dataStructures.binaryTree.bst;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBsts {
    // approach 1:
    /*
       steps: 1) store inorder of bst 1 and 2 in array.
              2) merge 2 sorted array.
              3) do inorder to bst
     */
    public Node  merge(Node root1, Node root2)
    {
        ArrayList<Integer> ls1= new ArrayList<>();
        ArrayList<Integer> ls2= new ArrayList<>();
        ArrayList<Integer> ls3= new ArrayList<>();
        // store inorder
        inOrder(root1,ls1);
        inOrder(root2,ls2);
        // merge 2 lists
        merge(ls1,ls2,ls3);
        // inorder to bst
        return inOrdertoBst(ls3,0, ls1.size()-1);
    }
    // inorder to bst
    Node  inOrdertoBst(List<Integer> ls, int start, int end){
        if(start>end){
            return null;
        }
        int mid= start+(end-start)/2;
        Node root= new Node(ls.get(mid));
        root.left= inOrdertoBst(ls,start,mid-1);
        root.right= inOrdertoBst(ls,mid+1,end);
        return root;
    }
    // merge 2 sorted lists
    void merge(List<Integer> ls1, List<Integer> ls2,List<Integer> ls3){
        int i=0, j=0;
        while (i<ls1.size() && j<ls2.size()){
            if(ls1.get(i)<ls2.get(j)){
                ls3.add(ls1.get(i));
                i++;
            }
            else {
                ls3.add(ls2.get(j++));
            }

        }
        while(i<ls1.size()){
            ls3.add(ls1.get(i++));
        }
        while (j<ls2.size()){
            ls3.add(ls2.get(j++));
        }
    }
    // inorder traversal
    void inOrder(Node root, List<Integer> ls){
        if(root==null){
            return;
        }
        inOrder(root.left,ls);
        ls.add(root.val );
        inOrder(root.right,ls);
    }
    //--------------------------------------------------------------
    // approach 2:
         /*
         steps: 1) flatten binary 2 binary trees into linked lists
                2) merge 2 sorted lists into single one
                3) make the binary search tree from that
          */


}
