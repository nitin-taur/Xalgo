package nx.ds;

public interface BlockingQueque<T>
{
  /**
	 * Blocks if queue has no elements, else return element in insertion order FIFO.
	 */
	T take();
	
	/**
	 * @param t_ put element in back of queue. Call blocks if queue is full
	 */
	void put(T t_);
}
