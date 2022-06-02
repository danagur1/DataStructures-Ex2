public class DoubleHashTable extends OAHashTable {
	ModHash hash_func1;
	ModHash hash_func2;
	public DoubleHashTable(int m, long p) {
		super(m);
		hash_func1 = ModHash.GetFunc(m, p);
		hash_func2 = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (hash_func1.Hash(x) + i * hash_func2.Hash(x)) % m;
	}
}
