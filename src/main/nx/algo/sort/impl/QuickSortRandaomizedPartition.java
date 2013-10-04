package nx.algo.sort.impl;

import java.util.Random;

import nx.algo.util.CollectionUtils;


public class QuickSortRandaomizedPartition<T> extends QuickSort<T>
{
  private static final Random r  = new Random();
	private final static QuickSortRandaomizedPartition<Object> RawInstance = new QuickSortRandaomizedPartition<Object>();
	
	@SuppressWarnings("unchecked")
	public static <T> QuickSort<T> getInstance()
	{
		return (QuickSortRandaomizedPartition<T>) RawInstance;
	}
	
	@Override
	protected T choosePivot(T[] array_, final int low_, final int high_)
	{
		CollectionUtils.swap(array_, r.nextInt(high_), low_);
		return array_[low_];
	}
}