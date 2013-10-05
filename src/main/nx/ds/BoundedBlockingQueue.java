package nx.ds;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue<T> implements BlockingQueque<T>
{
  private final T[] _queue; 
	private final Synchronizer _queueSynchronizer;
	private final int _capacity;
	private int _head=-1;
	private int _tail=-1;
	private int _size=0;
			
	public BoundedBlockingQueue(Class<T> type_, final int capacity_)
	{
		_queue = (T[]) Array.newInstance(type_, capacity_);
		_capacity = capacity_;
		_queueSynchronizer = new Synchronizer();
		System.out.println("BoundedBlockingQueue created with size = "+_queue.length);
	}
	
	@Override
	public T take()
	{
		_queueSynchronizer.lock();try
		{
			while(_size==0)
			{
				_queueSynchronizer.waitWhileQueueIsEmpty();
			}
			
			if(_size==_capacity)
			{
				_queueSynchronizer.signalQueueIsNotFull();
			}
			
			--_size;
			
			T toReturn = _queue[_head];
			
			if(_tail==_head)
			{
				_tail = _head = -1;
			}
			else
			{
				_head = (_head+1)%_capacity;
			}
			return toReturn;
		}
		finally{_queueSynchronizer.unlock();}
	}

	

	@Override
	public void put(T t_)
	{
		_queueSynchronizer.lock();try
		{
			while(_size == _capacity)
			{
				_queueSynchronizer.waitWhileQueueIfFull();
			}
			
			if(_size==0)
			{
				_queueSynchronizer.signalQueueIsNotEmpty();
			}
			
			++_size;
			
			_tail = (_tail+1)%_capacity;
			_queue[_tail] = t_;
			
			if(_head==-1)
			{
				_head = _tail;
			}
		}
		finally{_queueSynchronizer.unlock();}
	}

	private class Synchronizer
	{
		private final Lock _lock  = new ReentrantLock();
		private final Condition _transitFromFullElement;
		private final Condition _transitFromEmptyElement;
		
		public Synchronizer()
		{
			_transitFromEmptyElement = _lock.newCondition();
			_transitFromFullElement = _lock.newCondition();
		}
		
		void lock()
		{
			_lock.lock();
		}
		
		void unlock()
		{
			_lock.unlock();
		}
		
		void signalQueueIsNotFull()
		{
			System.out.println("Signaling queue is not full");
			_transitFromFullElement.signal();
		}
		
		void waitWhileQueueIfFull()
		{
			try
			{
				System.out.println("Waiting to put as queue is full");
				_transitFromFullElement.await();
			}
			catch (Exception e)
			{
				handleException(e);
			}
		}
		
		void signalQueueIsNotEmpty()
		{
			System.out.println("Signaling queue is not empty");
			_transitFromEmptyElement.signal();
		}
		
		void waitWhileQueueIsEmpty()
		{
			try
			{
				System.out.println("Waiting to take as queue is empty");
				_transitFromEmptyElement.await();
			}
			catch (Exception e)
			{
				handleException(e);
			}
		}

		void handleException(Exception e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static void main(String[] args)
	{
		
		final BoundedBlockingQueue<Integer> queue = new BoundedBlockingQueue<Integer>(Integer.class, 4);
		
		new Thread()
		{
			private Random r = new Random();
			public void run() 
			{
				for(int i= 0; i<=100; i++)
				{
					int nextInt = r.nextInt(10);
					System.out.println("Put: "+nextInt);
					queue.put(nextInt);
				}
			};
		}.start();
		
		new Thread()
		{
			public void run() {
				for(int i= 0; i<=100; i++)
				{
					System.out.println("Take:" + queue.take());
				}
			};
		}.start();
	}
}
