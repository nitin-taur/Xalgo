package nx.test.ds.util;

import junit.framework.Assert;
import nx.algo.util.DecimalToBaseNConverter;

import org.junit.Test;

public class TestDecimalToBaseNConverter 
{

	@Test
	public void checkBase3For_100()
	{
		assertSameNumberForGivenRadix(3, 100, new int[]{1,0,2,0,1});
	}

	@Test
	public void checkBase3For_508()
	{
		assertSameNumberForGivenRadix(3, 508, new int[]{2,0,0,2,1,1});
	}
	
	@Test
	public void checkBase3For_534545()
	{
		assertSameNumberForGivenRadix(3, 534545, new int[]{1,0,0,0,0,1,1,0,2,0,2,2,2});
	}
	
	@Test
	public void checkBase7For_534545()
	{
		assertSameNumberForGivenRadix(7, 534545, new int[]{4,3,5,4,3,0,4});
	}
	
	@Test
	public void checkBase7For_8656543()
	{
		assertSameNumberForGivenRadix(7, 8656543, new int[]{1,3,3,4,0,2,5,1,0});
	}
	
	@Test
	public void checkBase32For_8656543()
	{
		assertSameNumberForGivenRadix(32, 8656543, new int[]{8,8,5,19,21});
	}
	
	@Test
	public void checkBase32For_98865465()
	{
		assertSameNumberForGivenRadix(32, 98865465, new int[]{2,30,9,4,9,25});
	}
	
	@Test
	public void checkBase36For_98865465()
	{
		assertSameNumberForGivenRadix(36, 98865465, new int[]{1,22,31,1,2,33});
		
		System.out.print(98865464 + "=");
		int[] array = DecimalToBaseNConverter.convert(98865464, 36);
		for (int i = 0; i < array.length; i++)
		{
			System.out.print("|"+array[i]);
		}
	}
	
	private void assertSameNumberForGivenRadix(int radix_, int number_, int[] expectedOutPut_) 
	{
		int[] actual = DecimalToBaseNConverter.convert(number_, radix_);
		Assert.assertEquals(expectedOutPut_.length, actual.length);
		System.out.print(String.format("(%d)base(%d)", number_, radix_) + " = ");
		for (int i = 0; i < expectedOutPut_.length; i++) 
		{
			Assert.assertEquals(expectedOutPut_[i], actual[i]);
			System.out.print("|"+actual[i]);
		}
		System.out.println();
	}
}
