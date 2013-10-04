package nx.algo.sort.impl;

import java.util.Comparator;

import nx.algo.util.CollectionUtils;


public class QuickSort<T> implements ISort<T>
{
  private final static QuickSort<Object> RawInstance = new QuickSort<Object>();
	
	@SuppressWarnings("unchecked")
	public static <T> QuickSort<T> getInstance()
	{
		return (QuickSort<T>) RawInstance;
	}
	
	@Override
	public T[] sort(T[] array_, Comparator<T> comparator_)
	{
		sort(array_, comparator_, 0, array_.length-1);
		return array_;
	}
	
	private void sort(T[] array_, Comparator<T> comparator_, int low_, int high_)
	{
		if(low_<high_)
		{
			int pivot = partition(array_, comparator_, low_, high_);
			sort(array_, comparator_, low_, pivot-1);
			sort(array_, comparator_, pivot+1, high_);
		}
	}
	
	protected int partition(T[] array_, Comparator<T> comparator_, final int low_, final int high_)
	{
		// 1. Choose pivot
		final T pivot = choosePivot(array_, low_, high_); 
		int left = low_;
		int right = high_;
		while(left<right)
		{
			// 2. move left upto element greater than pivot  
			while(left<=right && comparator_.compare(array_[left], pivot)<=0)
			{
				++left;
			}
		
			// 2. move right upto element less than pivot
			while(comparator_.compare(array_[right], pivot)>0)
			{
				--right;
			}
			
			if(left<right)
			{
				CollectionUtils.swap(array_, left, right);
			}
		}
		
		CollectionUtils.swap(array_, right, low_);
		
		return right;
	}
	
	protected T choosePivot(T[] array_, final int low_, final int high_)
	{
		return array_[low_];
	}
}
