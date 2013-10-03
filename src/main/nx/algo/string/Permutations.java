package nx.algo.string;

public class Permutations {

	public static void main(String[] args) {
//		permutationsInOrder("Nit");
		int i = 2<<3>>2;
System.out.println(i);
	}
	
	public static void permutationsInOrder(String s)
	{
		permutationsInOrder("", s);
	}
	private static void permutationsInOrder(String prefix, String s)
	{
		int len = s.length();
		if(len==0)
		{
			System.out.println(prefix);
		}
		else
		{
			for (int i = 0; i < len; i++) {
				permutationsInOrder(prefix + s.charAt(i), s.substring(0, i)+s.substring(i+1));
			}
			
		}
	}
}
