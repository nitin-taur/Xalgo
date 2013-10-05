package nx.algo.sort;
import java.util.Comparator;

import nx.algo.sort.impl.InsertionSort;
import nx.algo.sort.impl.QuickSort;
import nx.algo.sort.impl.QuickSortRandaomizedPartition;
import nx.util.collection.Comparators;



public class Sort
{
  /**
	 * @param args
	 */
	public static void main(String[] args)
	{
		{
			Integer[] a = Sort.quickSort(new Integer[] {80,-2,-2,0,9,58,7,-3,400}, Comparators.INTEGERS);
			for (int i = 0; i < a.length; i++)
			{
				System.out.print(a[i]+",");
			}
		}
		
		{
			System.out.println("----------2--------");
			Integer[] a = Sort.quickSort(new Integer[] {69,8,100,4,-5,38,7,2}, Comparators.INTEGERS);
			for (int i = 0; i < a.length; i++)
			{
				System.out.print(a[i]+",");
			}
		}
	}
	
	/**
	 * Sort in-place, partition on left most element. Pivot is always left most element.
	 * @param array_
	 * @return
	 */
	public static <T> T[] quickSort(T[] array_, Comparator<T> comparator_)
	{
		return QuickSort.<T>getInstance().sort(array_, comparator_);
	}
	
	/**
	 * Sort in-place, partition on left most element. Pivot is randomly selected.
	 * @param array_
	 * @return
	 */
	public static <T> T[] quickSortRandaomized(T[] array_, Comparator<T> comparator_)
	{
		return QuickSortRandaomizedPartition.<T>getInstance().sort(array_, comparator_);
	}
	
	
	public static <T> T[] insertionSort(T[] array_, Comparator<T> comparator_)
	{
		return InsertionSort.<T>getInstance().sort(array_, comparator_);
	}
}
