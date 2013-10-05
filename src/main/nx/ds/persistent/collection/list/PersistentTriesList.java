package nx.ds.persistent.collection.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import nx.util.number.DecimalToBaseNConverter;

public class PersistentTriesList<E>
{
	private final int _bf; // branching factor for the tries
	private final int _size; // number of elements in list
	private final Node<E> _root;

	public PersistentTriesList(int branchingFactor_)
	{
		this._bf = branchingFactor_;
		_size = 0;
		_root = null;
	}
	
	private PersistentTriesList(int branchingFactor_, int size_, Node<E> root_)
	{
		this._bf = branchingFactor_;
		_size = size_;
		_root = root_;
	}


	public int size()
	{
		return _size;
	}


	public boolean isEmpty()
	{
		return _size==0;
	}


	public boolean contains(Object o)
	{
		// TODO Auto-generated method stub
		return false;
	}


	public Iterator<E> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}


	public Object[] toArray()
	{
		// TODO Auto-generated method stub
		return null;
	}


	public <T> T[] toArray(T[] a)
	{
		// TODO Auto-generated method stub
		return null;
	}


	public PersistentTriesList<E> add(E e)
	{
		int index = _size +1;
		if(_root == null)
		{
			return new PersistentTriesList<E>(_bf, index, new Node<E>(e, null, null, null));
		}
		
		int[] path = DecimalToBaseNConverter.convert(index, _bf);
//		Node<E> newRoot = new Node<E>(_root._data,_root.);
		
		
		for (int i = 0; i < path.length; i++)
		{
			
		}
		return null;
	}


	public boolean remove(Object o)
	{
		// TODO Auto-generated method stub
		return false;
	}


	public boolean containsAll(Collection<?> c)
	{
		// TODO Auto-generated method stub
		return false;
	}


	public boolean addAll(Collection<? extends E> c)
	{
		// TODO Auto-generated method stub
		return false;
	}


	public boolean addAll(int index, Collection<? extends E> c)
	{
		// TODO Auto-generated method stub
		return false;
	}


	public boolean removeAll(Collection<?> c)
	{
		// TODO Auto-generated method stub
		return false;
	}


	public boolean retainAll(Collection<?> c)
	{
		// TODO Auto-generated method stub
		return false;
	}


	public void clear()
	{
		// TODO Auto-generated method stub

	}


	public E get(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}


	public E set(int index, E element)
	{
		// TODO Auto-generated method stub
		return null;
	}


	public void add(int index, E element)
	{
		// TODO Auto-generated method stub

	}


	public E remove(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}


	public int indexOf(Object o)
	{
		// TODO Auto-generated method stub
		return 0;
	}


	public int lastIndexOf(Object o)
	{
		// TODO Auto-generated method stub
		return 0;
	}


	public ListIterator<E> listIterator()
	{
		// TODO Auto-generated method stub
		return null;
	}


	public ListIterator<E> listIterator(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}


	public List<E> subList(int fromIndex, int toIndex)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private static class Node<E>
	{
	   private final E _data;
	   private final Node<E> _parent;
	   private final Node<E> _children;
	   private final Node<E> _next;

	   public Node(E data, Node<E> parent_, Node<E> children_, Node<E> next_)
	   {
	      this._data = data;
	      this._parent = parent_;
	      this._children = children_;
	      this._next = next_;
	   }
	   
	   public Node<E> cloneWithNewNextNode(Node<E> next_)
	   {
		   return new Node<E>(_data, _parent, _children, next_);
	   }
	   
	   public Node<E> cloneWithNewData(E data_)
	   {
		   return new Node<E>(data_, _parent, _children, _next);
	   }
	}
	
	private static <E> Node<E> replaceNthNode(Node<E> head_, Node<E> replacement_, int n_)
	{
		if(n_<0)
		{
			throw new RuntimeException("Position in list cannot be negative");
		}
				
		Stack<Node<E>> stack = new Stack<PersistentTriesList.Node<E>>();
		Node<E> current = head_;
		for (int i = 0; i < n_-1; i++)
		{
			stack.push(current);
			current = current._next;
		}
		
		Node<E> next = current._next; // current node is to replace
		current = replacement_.cloneWithNewNextNode(next); // new replaced node
		
		while(!stack.isEmpty())
		{
			Node<E> top = stack.pop();
			current = new Node<E>(top._data, top._parent, top._children, current);
		}
		
		return current;
	}
}
