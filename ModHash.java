import java.util.concurrent.ThreadLocalRandom;
public class ModHash {
	private long p, a, b;
	private int m;

	public ModHash(int m, long p, long a, long b){
		this.a = a;
		this.b = b;
		this.p = p;
		this.m = m;
	}

	public static ModHash GetFunc(int m, long p){
		long a = ThreadLocalRandom.current().nextLong(1, p-1); //1<=a<=p-1
		long b = ThreadLocalRandom.current().nextLong(0, p-1); //0<=b<=p-1
		return new ModHash(m, p, a, b);
	}
	
	public int Hash(long key) {
		return  (int) ((a*key+b)%p)%m;
	}
}
