package nx.util.number;

/**
 * This class creates bitmask on enum. User can flip bits at 'ordinal+1' position. For example:
 * <pre>
 *  enum Alphabet{	A,B,C,D,E,F;}
	
	BitMaskEnum<Alphabet> mask = new BitMaskEnum<Alphabet>(); // A=false,B=false,C=false,D=false,E=false,F=false,
	mask.set(Alphabet.A); // A=true,B=false,C=false,D=false,E=false,F=false,
	mask.set(Alphabet.E); // A=true,B=false,C=false,D=false,E=true,F=false,
	mask.unset(Alphabet.A);// A=false,B=false,C=false,D=false,E=true,F=false,
 * </pre>
 * @author Integral Development Corporation
 *
 * @param <E>
 */
public class BitMaskEnum<E extends Enum<E>>
{
	private int mask = 0;
	
	/**
	 * Set bit for specified enum entry and return mask.
	 * @param e
	 * @return underlying mask value after set.
	 */
	public int set(Enum<E> e)
	{
		mask = mask | getBitIndexMask(e);
		return mask;
	}
	
	/**
	 * Check if bit is set for specified enum entry
	 * @param e
	 * @return true is bit for specified enum is set
	 */
	public boolean isSet(Enum<E> e)
	{
		int temp = mask;
		return (temp & getBitIndexMask(e)) == getBitIndexMask(e);
	}

	/**
	 * Flip bit for specified enum entry and return mask.
	 * @param e
	 * @return underlying mask value after flip
	 */
	public int flip(Enum<E> e)
	{
		mask = mask & ~getBitIndexMask(e);
		return mask;
	}
	
	/**
	 *  Flip all bit of underlying mask and return mask.
	 * @return underlying mask value after flip.
	 */
	public int flipAll()
	{
		mask = ~mask;
		return mask;
	}
	
	/**
	 * Unset bit for specified enum entry and return mask.
	 * @param e
	 * @return underlying mask value after unset
	 */
	public int unset(Enum<E> e)
	{
		if(isSet(e))
		{
			flip(e);
		}
		return mask;
	}
	
	/**
	 * @return underlying mask value.
	 */
	public int getMask()
	{
		return mask;
	}
	
	private int getBitIndexMask(Enum<E> e)
	{
		return 1 << e.ordinal()+1;
	}
}
