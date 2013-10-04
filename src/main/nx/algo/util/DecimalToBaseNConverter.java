package nx.algo.util;

import java.util.Stack;

public class DecimalToBaseNConverter 
{
	public static int[] convert(int decimal_, int radix_)
	{
		Stack<Integer> mods = new Stack<Integer>();
		
		int mod = 0;
		while(decimal_>=radix_)
		{
			mod = decimal_%radix_;
			decimal_ = decimal_/radix_;
			mods.add(mod);
		}
		
		mods.add(decimal_);
		
		int[] output = new int[mods.size()];
		for (int i = 0; i < output.length; i++)
		{
			output[i] = mods.pop();
		}
		
		return output;
	}

}
