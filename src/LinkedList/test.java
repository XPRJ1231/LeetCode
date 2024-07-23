package LinkedList;

public class test {
    public static void main(String[] args) {

        LRUCache obj = new LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        int param_1 = obj.get(1);
    }
}
