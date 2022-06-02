public class LPHashTable extends OAHashTable {
	ModHash hash_func;
	public LPHashTable(int m, long p) {
		super(m);
		hash_func = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (hash_func.Hash(x) + i) % m;
	}	
}
