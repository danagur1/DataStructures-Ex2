public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	protected int m;
	//hash table element to mark deleted element cell:
	private static final HashTableElement deleted = new HashTableElement(-1, -1); 
	
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		this.m = m;
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		for (int i=0; i<table.length; i++) { //search series:
			int j = Hash(key, i); //the hash result index
			if (table[j] == null) { //empty cell
				return null; //stop searching
			}
			else if (table[j].GetKey() == key) { 
				return table[j];
			}
		}
		return null; //series ended
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		long key = hte.GetKey();
		for (int i=0; i<table.length; i++) { //search series:
			int j = Hash(key, i); //the hash result index
			if ((table[j] == null) || (table[j].GetKey() == -1)) { //empty or deleted
				table[j] = hte;
				return;
			}
			else if (table[j].GetKey() == key) { //key exists in table
				throw new KeyAlreadyExistsException(hte);
			}
		} 
		throw new TableIsFullException(hte);
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		for (int i=0; i<table.length; i++) { //search series:
			int j = Hash(key, i); //the hash result index
			if (table[j] == null) { //empty cell
				throw new KeyDoesntExistException(key);
			}
			else if (table[j].GetKey() == key) { 
				table[j] = deleted;
			}
		}
		throw new KeyDoesntExistException(key); //series ended
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
