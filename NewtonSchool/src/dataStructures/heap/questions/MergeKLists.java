package dataStructures.heap.questions;

import java.util.Comparator;
import java.util.PriorityQueue;

/*

 */
public class MergeKLists {
    class Node{
        int data;
        Node left,right,next;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    class pair{
        Node node;
        int listIndex;
        public pair(Node node, int listIndex){
            this.listIndex=listIndex;
            this.node=node;
        }
    }
    class pairSort implements Comparator<pair>{

        @Override
        public int compare(pair o1, pair o2) {
            return o1.node.data-o2.node.data;
        }
    }
    Node mergeKList(Node[]arr,int K)
    {
        //Add your code here.
        PriorityQueue<pair> pq= new PriorityQueue<>(new pairSort());
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null){
                pq.add(new pair(arr[i],i));
            }
        }
        Node head=null;
        Node curr= null;
        while (!pq.isEmpty()){
            pair p= pq.poll();
            if(head==null){
                head=p.node;
                curr=head;
            }
            else{
                curr.next=p.node;
                curr=curr.next;
            }
            p.node=p.node.next;
            if(p.node!=null){
                pq.add(new pair(p.node,p.listIndex));
            }
        }
        return head;
    }

}
