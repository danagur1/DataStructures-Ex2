public class AQPHashTable extends OAHashTable {
	ModHash hash_func;

	public AQPHashTable(int m, long p) {
		super(m);
		hash_func = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int s = (i%2==0) ? 1 : -1;
		int result = (hash_func.Hash(x) + (int)(s*i*i))%m;
		return (result<0) ? (result+m) : result;
	}
}
