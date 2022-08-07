package mockInterviews;
/*
      1
      2 3
      4 5 6 7

      1
      3 2
      7 6 5 4
 */
public class Symetrical {

    /*
          isPresent(Node, key){
            while(node!=null){
            if(node.val==key) return true;
              if(node.val>key)  node=node.left
              else node=node.right
             }
             return false;
          }

          // insert a key
           insert(root, key){

             // iterate till the leaf node where key has to be attached
             Node add= new Node(key);
             if(node==null){
             return add;
             Node prev=null;
             while( node!=null){
               if(node.val>key) prev=node  node=node.left
               else node= prev = node node.right;

           }
           if(key>prev.val) prev.right= add;
           else prev.left= add;

            post: left,root. right,

            void postOrder(root){
              if( root=null){
                return;
              }
              postOrder(root.left);
              postOrder(root.right)
              sout(node.val);

            }



     */
    //1,2,2,3
    static  int firstOccurance(int[] arr, int key){
         int low=0;
         int high= arr.length-1;
         int last=-1;
         int res=-1;
         while (low<=high){
             int mid= low+(high-low)/2;
             if(arr[mid]==key){
                 res= mid;
                 high= mid-1;
             }
             else if(arr[mid]>key){
                 high=mid-1;
             }
             else {
                 low=mid+1;
             }
         }
         return res;
     }
    static  int lastOccurance(int[] arr, int key){
        int low=0;
        int high= arr.length-1;

        int res=-1;
        while (low<=high){
            int mid= low+(high-low)/2;
            if(arr[mid]==key){
                res= mid;
                low=mid+1;
            }
            else if(arr[mid]>key){
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3};
        System.out.println(firstOccurance(arr,9));
        System.out.println(lastOccurance(arr,9));
    }
}
