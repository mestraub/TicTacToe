package proj4;

import java.util.Arrays;

/**
 * A generic hashtable class, mapping keys to values.
 * 
 * @version 04/28/14
 * @author Megan Straub <mstraub1@umbc.edu>
 * CMSC 341 - Spring 2014 - Project 4
 * Section 4
 *
 */
public class Hashtable <K,V> {
	
	/**
	 * The default size of the hashtable.
	 */
	public static final int DEFAULT_SIZE = 101;
	
	/**
	 * The generic hashnode that contains keys and values.
	 */
	public Hashnode<K,V>[] hashTable;
	
	/**
	 * The number of collisions in the hashtable.
	 */
	public int collisions;
	
	/**
	 * The number of entries in the hashtable.
	 */
	public int entries;
	
	/**
	 * A constructor for Hashtable.
	 */
	public Hashtable(){
		this(DEFAULT_SIZE);
		entries = 0;
		collisions = 0;
	}
	
	/**
	 * A second constructor for Hastable that sets the size of the hashtable.
	 * 
	 * @param size the size of the hashtable
	 */
	@SuppressWarnings("unchecked") //removes warning about hash nodes
	public Hashtable(int size){
		collisions = 0;
		entries = 0;
		hashTable = new Hashnode[size];
	}
	
	/**
	 * Retrieves the object associated with this key. 
	 * If the key maps to nothing, it returns null.
	 * 
	 * @param key the key being used for retrieval
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
	 * @param key the key being searched for
	 * @return true if key maps to a value
	 */
	public boolean containsKey(K key){
		
		int currentPos = getPositionInHashtable(key);
		return hashTable[currentPos] != null && (hashTable[currentPos].key == key);
	}
	
	/**
	 * 
	 * Inserts a key value pair into the hashtable. If the key already corresponds to a value,
	 * that value is overwritten.
	 * 
	 * @param key the key being used for retrieval
	 * @param value the corresponding value
	 */
	public void put (K key, V value){
			
		if (containsKey(key)){
			hashTable[getPositionInHashtable(key)].value = value;
		} else {
			hashTable[getPositionInHashtable(key)] = new Hashnode<K,V> (key, value);
			entries++;
		}
		
		if(entries > (hashTable.length/2)){ //resizes the hashtable to the next available prime
			resize();
		}
	}
	
	/**
	 * Returns the size of the array.
	 * 
	 * @return size of the hashtable array
	 */
	public int numSlots(){
		return hashTable.length;
	}
	
	/**
	 * Returns the number of things actually stored in the hashtable.
	 * 
	 * @return number of filled elements stored
	 */
	public int numEntries(){
		return entries;
	}
	
	/**
	 * Returns the number of times a collision has occurred. 
	 * 
	 * @return number of collisions
	 */
	public int numCollisions(){
		return collisions;
	}
	
	/**
	 * This method determines where the key will be stored in the hashtable. 
	 * Collisions are handled by linear probing.
	 * 
	 * @param key the key to be stored
	 * @return the index in the array the key is stored
	 */
	public int getPositionInHashtable(K key){
		
		int offset = 1;
		int currentPosition = key.hashCode() % hashTable.length;
		
		while(hashTable[currentPosition] != null && !hashTable[currentPosition].key.equals(key)){
			currentPosition += offset;
			offset += 2;
			collisions++;
				
			if (currentPosition >= hashTable.length)
				currentPosition -= hashTable.length;
		}
		return currentPosition;
	}
	
	/**
	 * An internal method that resizes the hashtable when it becomes too full.
	 */
	private void resize(){
		hashTable = Arrays.copyOf(hashTable, nextPrime(numSlots() * 2));
	}
	
	/**
	 * An internal method that is used when resizing the hashtable. This method finds
	 * a prime number at least as larage as n.
	 * 
	 * @param n the starting number for searching
	 * @return a prime number that is either large or equal to n
	 */
	private int nextPrime(int n){
		if (n % 2 == 0){
			n++;
		}
		
		for(; !isPrime (n); n+= 2)
			;
		
		return n;
	}
	
	/**
	 * An internal method that is used when resizing the hashtable. This method tests
	 * that the number found from nextPrime() is in fact a prime number.
	 * 
	 * @param n the number to be tested
	 * @return true if it is prime, false otherwise
	 */
	private boolean isPrime(int n){
		if (n == 2 | n == 3){
			return true;
		}
		
		if(n == 1 | n % 2 == 0){
			return false;
		}
		
		for (int i = 3; i * i <= n; i+= 2){
			if (n % i == 0)
				return false;
		}
		
		return true;
	}
	
	/**
	 * A private generic class that holds the keys and values of a hashtable.
	 */
	private class Hashnode<K,V>{
		
		/**
		 * The key of a hashtable.
		 */
		private K key;
		
		/**
		 * The value of a key in a hashtable.
		 */
		private V value;
		
		/**
		 * A constructor that sets the key and the value mapped to that key in a hashtable.
		 * 
		 * @param key the key of the value
		 * @param value the information hashed in the hashtable
		 */
		Hashnode (K key, V value){
			this.key = key;
			this.value = value;
		}	
	}
}
