public class AQPHashTable extends OAHashTable {
	ModHash hash_func;

	public AQPHashTable(int m, long p) {
		super(m);
		hash_func = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (hash_func.Hash(x) + (int) Math.pow(-1, i)*i*i) % m;
	}
}
