package dataStructures.binaryTree.postClass;

import java.util.*;

public class VerticalOrderTraversal {
    public class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    public class tuple{
        int hd;
        Node node;
        public tuple(int hd, Node node){
            this.hd=hd;
            this.node=node;
        }
    }
    // this method doesn't sort the overlapping nodes, it first prints the child of left parts then of right.
    public void levelOrderTraversal(Node root){
        if(root==null){
            return;
        }
        TreeMap<Integer, ArrayList<Integer>> map= new TreeMap<>();
        Queue<tuple> q= new LinkedList<>();
        q.add(new tuple(0,root));
        while (!q.isEmpty()){
            tuple t= q.poll();
            int hd=t.hd;
            Node n= t.node;
//            if(map.containsKey(hd)){
//                //map.put(hd,map.get(hd).add(n.data));
//                map.get(hd).add(n.data);
//            }
//            else {
//                ArrayList<Integer> list= new ArrayList<>();
//                list.add(n.data);
//                map.put(hd,list);
//            }
            if(!map.containsKey(hd)){
                map.put(hd,new ArrayList<>());
            }
            map.get(hd).add(n.data);
            if(n.left!=null){
                q.add(new tuple(hd-1,n.left));
            }
            if(n.right!=null){
                q.add(new tuple(hd+1,n.right));
            }
        }

        for (Map.Entry<Integer,ArrayList<Integer>> item: 
             map.entrySet()) {
            ArrayList<Integer> list= item.getValue();
            for (Integer i:
                 list) {
                System.out.println(i+" ");
            }
            System.out.println();
        }
    }
}

