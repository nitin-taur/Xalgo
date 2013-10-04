package nx.algo.util;

public class CollectionUtils
{

  public static <T> T[] swap(final T[] array_, final int i, final int j)
	{
		T temp = array_[i];
		array_[i] = array_[j];
		array_[j] = temp;
		return array_;
	}

}
