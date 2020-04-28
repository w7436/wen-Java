/**
 * @ClassName HashBucket
 * @Description TODO
 * @Author DELL
 * @Data 2020/4/28 19:53
 * @Version 1.0
 **/
public class HashBucket {

    public static class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //哈希桶中的成员数据
    Node[] table;
    int capacity;//捅的个数
    int size ;//有效元素的个数
    double loadFact = 0.75;
    public HashBucket( int capacity) {

        if(capacity < 10){
            this.capacity = capacity;
        }
        this.table = new Node[capacity];
        this.size = 0;
    }

    public int put(int key,int value){
        resize();
        //通过哈希函数计算桶号
        int bucketNo = hashFunc(key);
        //在当亲哈希桶中检测key是否存在
        Node cur = table[bucketNo];
        while(null != cur){
            if(cur.key == key){
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }else{
                cur = cur.next;
            }
        }
        //将key -value插入
        cur = new Node(key,value);
        cur.next = table[bucketNo];
        table[bucketNo] = cur;
        size++;
        return value;
    }
    private int hashFunc(int key) {
        return key % capacity;
    }

    //将哈希桶中为key的键值对删除
    public boolean remove(int key){
        //通过哈希函数计算key的桶号
        int bucketNo = hashFunc(key);
        //在当前桶中寻找该结点，将其删除
        Node cur = table[bucketNo];
        Node prev = null;
        while(null != cur){
            if(cur.key == key){
                //为头结点
                if(cur == table[bucketNo]){
                    table[bucketNo] = cur.next;
                }
                else{
                    prev.next = cur.next;
                }
                size--;
                return true;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        return false;
    }

    public boolean containsKey(int key){
        int bucketNo = hashFunc(key);
        Node cur = table[bucketNo];
        while(null != cur){
            if(cur.key == key){
                return true;
            }
            else{
                cur =cur.next;
            }
        }
        return false;
    }

    public boolean containValue(int value){
        //必须遍历所有的桶
        for(int bucketNo = 0;bucketNo < capacity;bucketNo++){
            Node cur = table[bucketNo];
            while(cur != null){
                if(cur.value == value){
                    return true;
                }
                else{
                    cur = cur.next;
                }
            }
        }
        return false;
    }

    public int size(){
        return size;
    }
    public boolean empty(){
        return size==0;
    }
    //大于装载因子进行扩容,2倍的方式
     public void resize(){
        if(size*10/capacity >loadFact*10){
            Node[] newTable = new Node[2*capacity];
            int newCap = 2*capacity;
            //将table中的元素搬移到newTable中
            for(int i = 0;i <capacity;i++){
                Node cur = table[i];
                while(cur != null){
                    table[i] = cur.next;

                    int bucketNo = cur.key%newCap;
                    //将cur插入新,头插
                    cur.next = newTable[bucketNo];
                    newTable[bucketNo] = cur;

                    //取table中i号桶下一个
                    cur = table[i];
                }
            }
            table = newTable;
            capacity = newCap;
        }
    }
    public  void Print(){
        for(int i = 0;i < capacity;i++){
            System.out.printf("table[%d]",i);
            Node cur=table[i];
            while(cur != null){
                System.out.printf(cur.key+","+cur.value);
                cur=cur.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        HashBucket ht = new HashBucket(5);

        ht.put(1,1);
        ht.put(2,2);
        ht.put(3,3);
        ht.put(4,5);
        ht.put(5,6);
        ht.put(7,7);
        ht.put(8,9);
        ht.put(0,0);
        ht.Print();

    }

}
