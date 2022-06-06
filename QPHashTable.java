public class QPHashTable extends OAHashTable {
	ModHash hash_func;

	public QPHashTable(int m, long p) {
		super(m);
		hash_func = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int result = (hash_func.Hash(x) + i*i) % m;
		return (result<0) ? (result+m) : result;
	}
}
