package dataStructures.binaryTree;

import java.util.*;

public class
BinaryTree {
     static  public class Node {
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }
   // static Node root;

    public static void main(String[] args) {
        Node node =new Node(1);
        node.left=new Node(2);
        node.left.left=new Node(3);
        node.left.right=new Node(7);
        node.right=new Node(4);
        node.right.left=new Node(5);
        node.right.right=new Node(6);
        BinaryTree tree= new BinaryTree();
        //tree.dfs(node);
//        print(root);
       // System.out.println(height(root));
       // System.out.println(tree.exist(node,3));;
        System.out.println(tree.findMin(node));

    }
    // recursive dfs
    public static void print(Node node){
        if(node==null){
            return;
        }
        //System.out.print(node.val+" ");
        print(node.left);
        //System.out.print(node.val+" ");
        print(node.right);
        System.out.print(node.val+" ");
    }
    public static int height(Node node){
        if(node==null){
            return 0;
        }


            /* compute  height of each subtree */
            int lheight = height(node.left);
            int rheight = height(node.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
    }
    // preorder dfs using stack
    public  void dfs(Node root){
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        Stack<Node> st= new Stack<>();
        st.push(root);
        while (!st.isEmpty()){
            Node curr= st.pop();
            System.out.println(curr.val);
            if(curr.right!=null){
                st.push(curr.right);
            }
            if(curr.left!=null){
                st.push(curr.left);
            }
        }
    }


    // bfs

    public void bfsByQueue(Node node){
        if(node==null){
            System.out.println("empty tree");
            return;
        }
        Deque<Node > dq= new ArrayDeque<>();
        dq.addLast(node);
        while(!dq.isEmpty()){
            Node curr= dq.pollFirst();
            System.out.println(curr.val);
            if(curr.left!=null){
                dq.addLast(curr.left);
            }
            if(curr.right!=null){
                dq.addLast(curr.right);
            }
        }
    }
    public boolean exist(Node node, int key){
        if(node==null){
            //System.out.println("empty tree");
            return false;
        }
        Deque<Node > dq= new ArrayDeque<>();
        dq.addLast(node);
        while(!dq.isEmpty()){
            Node curr= dq.pollFirst();
            if(curr.val==key){
                return true;
            }
            //System.out.println(curr.val);
            if(curr.left!=null){
                dq.addLast(curr.left);
            }
            if(curr.right!=null){
                dq.addLast(curr.right);
            }
        }
        return false;
    }
    // sum of the given tree
    public int  findSumRecursively(Node root){
        if(root==null){
            return 0;
        }
        return root.val+findSumRecursively(root.left)+findSumRecursively(root.right);

    }
    // min value in given tree
    public int findMin(Node root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int minLeft=findMin(root.left);
        int minRight=findMin(root.right);
        int Min=Math.min(minRight,minLeft);
        return Math.min(root.val,Min);
    }
    // max root to leaf path
    public int findMaxPath(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        if(root.left==null && root.right==null){
            return root.val;
        }
        return root.val+Math.max(findMaxPath(root.left),findMaxPath(root.right));
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> wraperList= new ArrayList<List<Integer>>();
        Deque<Node> dq= new ArrayDeque<>();
        if(root==null){
            return wraperList;
        }
        dq.add(root);
        while (!dq.isEmpty()){
            List<Integer> list= new ArrayList<>();
            for (int i = 0; i < dq.size(); i++) {

                if(dq.peek().left!=null){
                    dq.add(dq.peek().left);
                }
                if(dq.peek().right!=null){
                    dq.add(dq.peek().right);
                }
                list.add(dq.poll().val);
            }
            wraperList.add(list);
        }
        return wraperList;

    }


}
