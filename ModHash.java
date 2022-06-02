import java.util.Random;
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
		Random rand = new Random();
		return new ModHash(m, p, rand.nextLong(1, p), rand.nextLong(1, p));
	}
	
	public int Hash(long key) {
		return  (int) ((a*key+b)%p)%m;
	}
}
