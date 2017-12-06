package final1;

import java.util.ArrayList;
import java.util.Iterator;


import java.util.Iterator;

public class linkedDictonary<K, V> implements dictionaryInterface<K, V>{

	private int numOfEntries; // Number of pairs of entries in the hashTable
	private Node<K,V>[] hashTable; // creates the hashTable array
	private int hashTableSize; // The size of the hashTable
	private final static int DEFAULT_CAPACITY = 5;
	
	@SuppressWarnings("hiding")
	private class Node<K, V>{
		
		private K key;
		private V value;
		private boolean flag;
		/**
		 * @return the key
		 */
		public K getKey() {
			return key;
		}

		/**
		 * @return the value
		 */
		public V getValue() {
			return value;
		}

		/**
		 * @return the flag
		 */
		public boolean getFlag() {
			return flag;
		}

		/**
		 * @param key the key to set
		 */
		public void setKey(K key) {
			this.key = key;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(V value) {
			this.value = value;
		}

		/**
		 * @param flag the flag to set
		 */
		public void setFlag(boolean flag) {
			this.flag = flag;
		}

		
		public Node(K newKey, V newValue, boolean newFlag) {
			
			newKey = getKey();
			newValue = getValue();
			newFlag = getFlag();
		}
		
		
		
	}
	
	public linkedDictonary() {
		this(DEFAULT_CAPACITY);
		
	}
	
	public linkedDictonary(int initialCapacity) {
		//Node tableNode = new Node(key, value, flag);
		//tableNode
		hashTableSize = getNextPrime(initialCapacity);
		numOfEntries = getSize();
		@SuppressWarnings("unchecked")
		Node<K, V>[] temp = (Node<K, V>[])new Node[hashTableSize]; // A temp variable that type casts the Node array into an array of size hashTableSize
		hashTable = temp; // hashTable array is assigned to temp
	}
	
	/**
	 * Method will accept an integer and find it's next prime number
	 * @param nextPrime   A number that will become the next prime number
	 * @return temp	      Temporary variable to return the next prime number
	 */
	 private int getNextPrime(int nextPrime) {
		// TODO Auto-generated method stub
		 boolean isPrime = false;
		 int i = 2;
		 int temp = nextPrime; // temporary variable will store the old hashTable size
		 if(nextPrime % i == 0) {
		 while(!isPrime) {
			 
		 if(nextPrime % i == 0) {
			 i++;
		 }
		 
		 if(nextPrime % i != 0) {
			 temp = nextPrime + i;
			 isPrime = true;
		 }
		 }
		 }
		 
		return temp;
	}

	 /**
	  *  Method that will check to see if a current integer value is prime
	  * @param nextPrime   An integer value that will be passed into the method
	  * @return isPrime    A return type that will return false if the number is not prime, or true if the number is prime
	  */
	 private boolean isPrime(int nextPrime) {
		 boolean isPrime = false;
		 int i = 2;
		 if(nextPrime % i != 0) {
			 isPrime = true;
		 }
		return isPrime;
		 
	 }
	/** Adds a new entry to this dictionary. If the given search key already
    exists in the dictionary, replaces the corresponding value.
    @param key    An object search key of the new entry.
    @param value  An object associated with the search key.
    @return  Either null if the new entry was added to the dictionary
             or the value that was associated with key if that value
             was replaced. */
	@SuppressWarnings("unchecked")
	@Override
	public V add(K key, V value) {
		// TODO Auto-generated method stub
		V temporary;
		int hash; // will store the value of the hash
		int index = numOfEntries; // will store the value of the hashTable index
	    boolean unflagged = true; // will mark an index as flagged
		
		if(hashTableSize == numOfEntries) {	// condition stating if hash table is too full, then rehash
			
			for(int i = 0; i <= getNextPrime(hashTableSize) - 1; i++) {
				temporary = hashTable[i].getValue();
				hash = hashTable[i].hashCode();
				index = hash % getNextPrime(hashTableSize);
				
				}
			
		}
		
		if(hashTable[index].getFlag()) {
			hashTable[index] = new Node(key, value, unflagged);
			hashTable[index].setFlag(unflagged);
			numOfEntries++;
			
		}
		
		return temporary;
	}

	private int getHashIndex(K key){
	 	int hashIndex = key.hashCode() % hashTable.length;
	 	if (hashIndex < 0)
	 	hashIndex = hashIndex + hashTable.length;
		return hashIndex;
	 	} 
	 	
	 	
	  	@Override
	 	//removes item from the hash table
	 public V remove(K key) {
	 		// TODO Auto-generated method stub
	 		V removedvalue = null;
	 		int index = getHashIndex(key);
			if(index != -1) {
	 			removedvalue = hashTable[index].getValue();
	 		hashTable[index] = null;
	 		numOfEntries--;
	 		}
	 		else {
	 		System.out.print("the array is empty");
	  		return null;
	 		}
	 		return removedvalue;
	  	}

	@SuppressWarnings("unchecked")
	@Override
	public V getValue(K key) {
		// TODO Auto-generated method stub
		
		getKeyIterator();
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<K> getKeyIterator() {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < numOfEntries; i++) {
			getValue(hashTable[i].getKey());
		}
		return null;
	}

	@Override
	public Iterator<V> getValueIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	
}
}
