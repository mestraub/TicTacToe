/**
 * all documentation is the one supplied
 * hash table should use prime number
 * 
 * chaining for collision control
 * 
 * when have time later look at resizing for next prime
 * 
 */
package proj4;

import java.util.Arrays;

/**
 * @author Megan
 *
 */
public class Hashtable <K,V> {
	
	static final int DEFAULT_SIZE = 1009;
	Hashnode<K,V>[] hashTable;
	int collisions;
	int entries;
	
	public Hashtable(){
		this(DEFAULT_SIZE);
		entries = 0;
		collisions = 0;
	}
	
	@SuppressWarnings("unchecked") //removes warning about hash nodes
	public Hashtable(int size){
		//hashTable = (K[]) new Object[numSize]; // cast object array to make it generic
		//gets around compilation error
		
		collisions = 0;
		entries = 0;
		hashTable = new Hashnode[size];
	}
	
	/**
	 * Retrieves the object associated with this key. If the key maps to nothing, it should 
	 * return null.
	 * 
	 * @param key Key we're using for retrieval
	 */
	public V get (K key){
		
		if(hashTable[getPositionInHashtable(key)] != null)
			return hashTable[getPositionInHashtable(key)].value;
		else
			return null;
	}
	
	/**
	 * Returns true if the key is contained in the table, false otherwise.
	 * 
	 * @param key Key we're looking for
	 * @return true if key maps to a value.
	 */
	public boolean containsKey(K key){
		
		int currentPos = getPositionInHashtable(key);
		return hashTable[currentPos] != null && (hashTable[currentPos].key == key);
		/*
		for (int i = 0; i < hashTable.length; i++){
			if (hashTable[i] == key)
				return true;
		}
		
		return false;
		*/
	}
	
	/**
	 * Puts a key value pair in the hashtable. 
	 * If this key already corresponds to a value, that value is overwritten.
	 * 
	 * @param key The key used for retreival later
	 * @param value Corresponding value.
	 */
	public void put (K key, V value){
			
		if (containsKey(key)){
			hashTable[getPositionInHashtable(key)].value = value;
			System.out.println("I am in if");
		} else {
			hashTable[getPositionInHashtable(key)] = new Hashnode<K,V> (key, value);
			entries++;
			System.out.println("I am in else");
		}
		
		/*
		if (entries > hashTable.length / 2){
			System.out.println("rehashing the table");
			resize(hashTable.length);
		}
		*/
	}
	
	/**
	 * Returns the size of the array used to back your hashtable. 
	 * The array slots need not be full to count.
	 * 
	 * @return Size of the hashtable array.
	 */
	public int numSlots(){
		return hashTable.length;
	}
	
	/**
	 * Returns the number of things actually stored in this hashtable.
	 * 
	 * @return Number of elements stored.
	 */
	public int numEntries(){
		return entries;
	}
	
	/**
	 * Returns the number of times a collision has occurred. 
	 * If you are handling collisions using by storing multiple entries on one cell, 
	 * you may return the number of doubled up entries. 
	 * If you are handling collisions by rehashing (using a secondary hash function when collisions are detected) 
	 * have an instance variable that keeps track of how often this has happened.
	 * 
	 * @return Number of collisions.
	 */
	public int numCollisions(){
		return collisions;
	}
	
	/**
	 * This method should tell you where in the hashtable this key will be stored, ASSUMING NO COLLISIONS. 
	 * Depending on how you design your project, this may be as simple as key.hashCode() % array.length.
	 * 
	 * @param key The key we're trying to figure out where to store
	 * @return The index in the array we would store this key.
	 */
	public int getPositionInHashtable(K key){
		
		return key.hashCode() % hashTable.length;
	}
	
	/*
	//resize the array when full
	public void resize(int size){
		
		Hashnode<K,V>[] oldArray = hashTable;
		
		int newSize = size * 5;
		
		hashTable = new Hashnode[newSize];
		entries = 0;
		
		for (int i = 0; i < oldArray.length; i++){
			if(oldArray [i] != null){
				put(oldArray[i].key, oldArray[i].value);
			} 
		}
		
	}
	*/
	
	//creates an empty hash table
	public void createEmpty(){
		for (int i = 0; i < hashTable.length; i++){
			hashTable[i] = null;
		}
		
		entries = 0;
		collisions = 0;
	}
	
	private class Hashnode<K,V>{
		
		private K key;
		private V value;
		
		Hashnode (K key, V value){
			this.key = key;
			this.value = value;
		}
		
	}
}
