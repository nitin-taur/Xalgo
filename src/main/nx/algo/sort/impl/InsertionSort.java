package nx.algo.sort.impl;

import java.util.Comparator;

public class InsertionSort<T> implements ISort<T>
{
  private final static InsertionSort<Object> RawInstance = new InsertionSort<Object>();
	
	@SuppressWarnings("unchecked")
	public static <T> InsertionSort<T> getInstance()
	{
		return (InsertionSort<T>) RawInstance;
	}
	
	@Override
	public T[] sort(T[] array_, Comparator<T> comparator_)
	{
		for (int i = 1; i < array_.length; i++)
		{
			T v = array_[i];
			int j = i;
			
			while(j>0 && comparator_.compare(array_[j-1], v)>0)
			{
				array_[j] = array_[j-1];
				j--;
			}
			array_[j] = v;
		}
		
		return array_;
	}
}