package LeetCode;

import java.util.*;

class main{
    public static void main(String[] a){

        RandomizedCollection rc = new RandomizedCollection();

        /*
        rc.insert(0);
        rc.remove(0);
        rc.insert(-1);
        rc.insert(0);
        rc.getRandom();
        rc.getRandom();
        rc.getRandom();
        rc.getRandom();
        rc.getRandom();
        rc.getRandom();
        rc.getRandom();
        rc.getRandom();
        rc.getRandom();
        rc.getRandom();
        */


         rc.insert(1);
         rc.remove(2);
         rc.insert(2);
         rc.getRandom();
         rc.remove(1);
         rc.insert(2);
         rc.getRandom();

        System.out.printf("hi");
    }
}

/**
 * Created by jesuszarate on 8/6/17.
 */
class RandomizedCollection {

    Random random;

    HashMap<Integer, HashSet> collection;
    List<Integer> values;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        collection = new HashMap<Integer, HashSet>();
        values = new ArrayList<Integer>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {

        if ( !collection.containsKey(val) ){
            HashSet<Integer> hs = new HashSet<>();
            hs.add(values.size());
            collection.put(val, hs);
            values.add(val);
            return true;
        }
        values.add(val);
        collection.get(val).add(values.size());

        return false;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if( !collection.containsKey(val) ){
            return false;
        }
        HashSet<Integer> hs = collection.get(val);
        int location = (int) collection.get(val).iterator().next();
        collection.get(val).remove(location);
        if(location < values.size() - 1) {
            int lastVal = values.size() - 1;
            values.set(location, values.get(lastVal));
            collection.get(values.get(lastVal)).remove(values.size() - 1);
            collection.get(values.get(lastVal)).add(location);
        }
        if (hs.isEmpty() ) collection.remove(val);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return values.size() > 0 ? values.get(random.nextInt(values.size())) : -1;

    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
