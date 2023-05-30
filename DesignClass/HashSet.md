# Design HashSet | Classes
## Algo :
* Since we know our keys will be integer, we can use the (key%size) as our mod function to generate the hash
* Each Hash will be our index of our ARRAYLIST
* Each Index will have a LinkedList 
* say size = 1000 , 1 and 1001 will both be hashed to 1 and be stored in the index 1

## Code:
```
class MyHashSet {
    int size = 1000;
    List<LinkedList<Integer>> hash ;

    public MyHashSet() {
        this.hash = new ArrayList<>(this.size);
        for(int i = 0;i < size;i++){
            hash.add(new LinkedList<Integer>());
        }
    }
    private int search(int key){
        int index = getHash(key);
        int len = hash.get(index).size();
        for(int i = 0;i < len;i++){
            if(hash.get(index).get(i) == key){
                return i;
            }
        }
        return -1;
    }
    private int getHash(int key){
        return key % size;
    }
    public void add(int key) {
        if(this.contains(key)){
            return;
        }
        // hash the key to convert it to an index and then add it to the linked list on the index
        int index = getHash(key);
        hash.get(index).addLast(key);
    }
    
    public void remove(int key) {
        if(!this.contains(key)){
            return;
        }
        int index = getHash(key);
        int pos = search(key);
        hash.get(index).remove(pos);
    }
    
    public boolean contains(int key) {
        return search(key) == -1?false:true;
    }
}
```
