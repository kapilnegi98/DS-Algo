package heap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
//worst case - n average - O(lambda);
	//linkedlist not arraylist beacuse linkedlist removal O(1) but arrayList O(n);
  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V value) throws Exception {
      // write your code here
    	int bi = hashFunction(key);
    	int di = findWithInBucket(key, bi);
    	if(di == -1) {
    		buckets[bi].add(new HMNode(key, value));
    		size++;
    	}else {
//    		buckets[bi].set(di, new HMNode(key, value));
    		buckets[bi].get(di).value = value;
    	}
    	double lambda = (size*1.0)/(buckets.length*1.0);
    	if(lambda > 2.0) {
    		resize();
    	}
    }
    public void resize() {
    	LinkedList
    }
    public int hashFunction(K key) {
    	return Math.abs(key.hashCode()) % buckets.length;
    }
    public int findWithInBucket(K key, int bi) {
    	for(int i = 0;i < buckets[bi].size();i++) {
    		if(buckets[bi].get(i).key.equals(key)) {
    			return i;
    		}
    	}
    	return -1;
    }
    public V get(K key) throws Exception {
      // write your code here
    	int bi = hashFunction(key);
    	int di = findWithInBucket(key, bi);
    	if(di == -1) {
    		return null;
    	}else {
    		return buckets[bi].get(di).value;
    	}
    }

    public boolean containsKey(K key) {
    	int bi = hashFunction(key);
    	int di = findWithInBucket(key, bi);
    	if(di == -1) {
    		return false;
    	}else {
    		return true;
    	}
    }

    public V remove(K key) throws Exception {
      // write your code here
    	int bi = hashFunction(key);
    	int di = findWithInBucket(key, bi);
    	if(di == -1) {
    		return null;
    	}else {
    		size--;
    		HMNode temp = buckets[bi].remove(di);
    		return temp.value;
    		
    	}
    }

    public ArrayList<K> keyset() throws Exception {
      // write your code here
    	ArrayList<K> keys = new ArrayList<>();
    	for(int i = 0;i < buckets.length;i++) {
    		LinkedList<HMNode> li = buckets[i]; 
    		for(int j = 0;j < li.size();j++) {
    			keys.add(li.get(j).key);
    		}
    	}
    	return keys;
    	
    }

    public int size() {
      // write your code here
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}