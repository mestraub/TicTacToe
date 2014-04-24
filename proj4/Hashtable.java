/**
 * all documentation is the one supplied
 * hash table should use prime number
 */
package proj4;

import java.util.Arrays;

/**
 * @author Megan
 *
 */
public class Hashtable <K,V> {
	
	static final int DEFAULT_SIZE = 31;
	Hashnode<K,V>[] hashTable;
	int collisions;
	
	public Hashtable(){
		this(DEFAULT_SIZE);
	}
	
	@SuppressWarnings("unchecked") //removes warning about hash nodes
	public Hashtable(int size){
		//hashTable = (K[]) new Object[numSize]; // cast object array to make it generic
		//gets around compilation error
		
		collisions = 0;
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
		
		for (int i = 0; i < hashTable.length; i++){
			if (hashTable[i] == key)
				return true;
		}
		
		return false;
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
		} else {
			hashTable[getPositionInHashtable(key)] = new Hashnode<K,V> (key, value);
		}
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
		int filledSlots = 0;
		
		for (int i = 0; i < hashTable.length; i++){
			if (hashTable[i] != null){
				filledSlots++;
			}
		}
				
		return filledSlots;
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
	
	//resize teh array when full
	public void resize(int size){
		
	}
	
	//creates an empty hash table
	public void createEmpty(){
		for (int i = 0; i < hashTable.length; i++){
			hashTable[i] = null;
		}
	}
	
	private class Hashnode<K,V>{
		
		private K key;
		private V value;
		
		Hashnode (K key, V value){
			this.key = key;
			this.value = value;
		}
		
	}

	/**
	 * @return
	 */
	/*
	public void print() {
		for (int i = 0; i < hashTable.length; i++){
			System.out.println(" key at " + i + " " + hashTable[i].key);
			System.out.println(" value at " + i + " " + hashTable[i].value);
		}
	}*/
}
