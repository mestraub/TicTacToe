/**
 * all documentation is the one supplied
 */
package proj4;

/**
 * @author Megan
 *
 */
public class Hashtable <K,V> {
	
	public Hashtable(){
		
	}
	
	/**
	 * Retrieves the object associated with this key. If the key maps to nothing, it should 
	 * return null.
	 * 
	 * @param key Key we're using for retrieval
	 */
	public V get (K key){
		return null;
	}
	
	/**
	 * Returns true if the key is contained in the table, false otherwise.
	 * 
	 * @param key Key we're looking for
	 * @return true if key maps to a value.
	 */
	public boolean containsKey(K key){
		return true;
	}
	
	/**
	 * Puts a key value pair in the hashtable. 
	 * If this key already corresponds to a value, that value is overwritten.
	 * 
	 * @param key The key used for retreival later
	 * @param value Corresponding value.
	 */
	public void put (K key, V value){
		
	}
	
	/**
	 * Returns the size of the array used to back your hashtable. 
	 * The array slots need not be full to count.
	 * 
	 * @return Size of the hashtable array.
	 */
	public int numSlots(){
		return 0;
	}
	
	/**
	 * Returns the number of things actually stored in this hashtable.
	 * 
	 * @return Number of elements stored.
	 */
	public int numEntries(){
		return 0;
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
		return 0;
	}
	
	/**
	 * This method should tell you where in the hashtable this key will be stored, ASSUMING NO COLLISIONS. 
	 * Depending on how you design your project, this may be as simple as key.hashCode() % array.length.
	 * 
	 * @param key The key we're trying to figure out where to store
	 * @return The index in the array we would store this key.
	 */
	public int getPositionInHashtable(K key){
		return 0;
	}
}
