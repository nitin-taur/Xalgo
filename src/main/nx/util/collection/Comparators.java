package nx.util.collection;
import java.util.Comparator;


public class Comparators
{
  public static final Comparator<Integer> INTEGERS = new Comparator<Integer>()
	{
		@Override
		public int compare(Integer o1, Integer o2)
		{
			return o1.compareTo(o2);
		}
	};
	
	public static final Comparator<String> STRINGS = new Comparator<String>()
	{
		@Override
		public int compare(String o1, String o2)
		{
			return o1.compareTo(o2);
		}
	};
	
}
