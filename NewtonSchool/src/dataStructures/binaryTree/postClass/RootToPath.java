package dataStructures.binaryTree.postClass;

import java.util.ArrayList;



public class RootToPath {
    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> list= new ArrayList<>();
        if(A==null){
            return list;
        }
        addPath(A,list,B);
        return list;

    }
    boolean addPath(TreeNode root,ArrayList<Integer> list, int b){
        if(root==null){
            return false;
        }
        list.add(root.data);
        if(root.data==b){
            return true;
        }
        if(addPath(root.left,list,b) || addPath(root.right,list,b)){
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
}
