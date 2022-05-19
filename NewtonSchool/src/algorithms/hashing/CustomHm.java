package algorithms.hashing;

import java.util.LinkedList;

public class CustomHm {
    private class Hmnode{
        String key;
        Integer value;
        public Hmnode(String key, Integer value){
            this.key=key;
            this.value=value;
        }
    }
    LinkedList<Hmnode>[] bucket;
    int size;
    public CustomHm(){
        initialise(4);
        this.size=0;
    }
    void initialise(int cap){
        bucket= new LinkedList[cap];
        for (int i = 0; i < cap; i++) {
            bucket[i]= new LinkedList<>();
        }
    }
    public int getSize(){
        return this.size;
    }
    int getIndex(String key){
        return Math.abs(key.hashCode()%this.bucket.length);
    }
    double getLambda(){
        return this.size*(1.0)/bucket.length;
    }
    public void put(String key, Integer value){
        int index= getIndex(key);
        for (Hmnode node:
             bucket[index]) {
            if(node.key.equals(key)){
                node.value=value;
                return;
            }
        }
        Hmnode node = new Hmnode(key,value);
        bucket[index].add(node);
        this.size++;
        if(getLambda()>3){
            rehashing();
        }
    }
    public boolean ContainsKey(String key){
        int idx= getIndex(key);
        for (Hmnode node:
             bucket[idx]) {
            if(node.key.equals(key)) return true;
        }
        return false;
    }
    public void deleteKey(String key){
        int idx= getIndex(key);
        for (Hmnode node:
             bucket[idx]) {
            if(node.key.equals(key)) {
                bucket[idx].remove(node);
                this.size--;
            }
        }
    }
    Integer get(String key){
        int idx= getIndex(key);
        for (Hmnode node:
             this.bucket[idx]) {
            if(node.key.equals(key)){
                return node.value;
            }
        }
        return -1;
    }
    void rehashing(){
        LinkedList<Hmnode>[] old= this.bucket;
        this.size=0;
        LinkedList<Hmnode>[] bucket= new LinkedList[old.length*2];
        for(LinkedList<Hmnode> ll: old){
            for(Hmnode node:ll){
                put(node.key,node.value);
            }
        }

    }
    void display(){
        for(LinkedList<Hmnode> item: bucket){
            for(Hmnode node: item){
                System.out.println(node.key+"="+node.value);
            }
        }
    }

    public static void main(String[] args) {
        CustomHm hm= new CustomHm();
//        hm.put("Delhi",1);
//        hm.put("Mumbai",2);
//        hm.put("pune",3);
//        hm.put("Mohali",4);
//        hm.display();
//        System.out.println(hm.ContainsKey("pune"));
//        System.out.println(hm.getLambda());
//        hm.deleteKey("Mohali");
//        hm.display();
        System.out.println(hm.size);
    }

}
