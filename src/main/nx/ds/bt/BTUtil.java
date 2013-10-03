package nx.ds.bt;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

import nx.element.Action;
import nx.element.Nothing;

public class BTUtil {

	public static <T> void preOrderTraverse(BTNode<T> root, Action<T> action)
	{
		Stack<BTNode<T>> s = new Stack<BTNode<T>>();
		if(root == null)
		{
			return;
		}
		
		s.push(root);
		while(!s.isEmpty())
		{
			BTNode<T> e = s.pop();
			action.invoke(e.getData());
			BTNode<T> l = e.getLeft();
			BTNode<T> r = e.getRight();
			if(r!=null)
				s.push(r);
			if(l!=null)
				s.push(l);
		}
	}
	
	public static <T> void inOrderTraverse(BTNode<T> root, Action<T> action)
	{
		Deque<BTNode<T>> q = new LinkedList<BTNode<T>>();
		if(root == null)
		{
			return;
		}
		
		q.add(root);
		while(!q.isEmpty())
		{
			BTNode<T> e = q.poll();
			action.invoke(e.getData());
			BTNode<T> l = e.getLeft();
			BTNode<T> r = e.getRight();
			if(l!=null)
				q.add(l);
			if(r!=null)
				q.add(r);
		}
	}
	
	public static <T> void inOrderTraverse(BTNode<T> root, Action<T> onDataAction, Action<Integer> levelEndAction)
	{
		Deque<BTNode<T>> q = new LinkedList<BTNode<T>>();
		if(root == null)
		{
			return;
		}
		int level = 1;
		q.add(root);
		q.add(null);
		while(!q.isEmpty())
		{
			BTNode<T> e = q.poll();
			if(e == null)
			{
				if(!q.isEmpty())
					q.add(null);
				levelEndAction.invoke(level++);
				continue;
			}
			onDataAction.invoke(e.getData());
			BTNode<T> l = e.getLeft();
			BTNode<T> r = e.getRight();
			if(l!=null)
				q.add(l);
			if(r!=null)
				q.add(r);
		}
	}
	
	public static <T> int findMaxWidth(BTNode<T> root)
	{
		final AtomicInteger levelWidth = new AtomicInteger();;
		final AtomicInteger maxWidth = new AtomicInteger();
		
		BTUtil.<T>inOrderTraverse(root, new Action<T>() {
			@Override
			public void invoke(T data) {
				levelWidth.incrementAndGet();
			}
		}, new Action<Integer>() {
			@Override
			public void invoke(Integer data) {
				if(levelWidth.get()>maxWidth.get())
				{
					maxWidth.set(levelWidth.get());
				}
				levelWidth.set(0);
			}
		});
		return maxWidth.get();
	}
}
