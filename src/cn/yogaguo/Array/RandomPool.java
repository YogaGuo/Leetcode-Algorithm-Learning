package cn.yogaguo.Array;

import java.util.HashMap;

/**
 * 设计一种结构，有如下功能
 * insetr(key) 将某个key加入到该结构中，做到不重复加入
 * dalete(key) 将某个在结构中的某个key移除
 * getRandom() 等概率随机的返回结构中的任何一个key
 * 以上操作时间复杂度为O(1)
 * @author LENOVO
 * @param <K>
 *
 */
public class RandomPool<K> {
	private HashMap<K,Integer> keyindex;
	private HashMap<Integer,K> indexkey;
	private int size;
	public RandomPool(){
		keyindex=new HashMap<>();
		indexkey=new HashMap<>();
		this.size=0;
	}
	public  void insert(K key) {
		if(!this.keyindex.containsKey(key)) {
			this.keyindex.put(key, this.size);
			this.indexkey.put(this.size++, key);
		}
	}
   public K getRandomPool() {
	   if(this.size== 0) {
		   return null;
	   }
	   int randomIndex=(int)Math.random()*this.size;
	   return this.indexkey.get(randomIndex);
   }
   public void delete(K key) {
	   if(this.keyindex.containsKey(key)) {
		   int deleteIndex = this.keyindex.get(key);
		   int lastIndex = --this.size;
		    K lastkey = this.indexkey.get(lastIndex);
		    this.keyindex.put(lastkey, deleteIndex);
		    this.indexkey.put(deleteIndex,lastkey );
		    this.keyindex.remove(key);
		    this.indexkey.remove(lastkey);
	   }
   }
   public static void main(String[] args) {
	RandomPool<String> pool = new RandomPool<>();
	pool.insert("zzz");
	pool.insert("ooo");
	pool.insert("bb");
	pool.insert("pp");
	System.out.println(pool.getRandomPool()); 
	System.out.println(pool.getRandomPool()); 
  }
}
