package nx.algo.sort.impl;

import java.util.Comparator;

interface ISort<T>
{
  T[] sort(T[] array_, Comparator<T> comparator_);
}