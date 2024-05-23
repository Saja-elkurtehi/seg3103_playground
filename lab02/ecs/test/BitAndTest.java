import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Example of a parameterized test case.
 * Parameterized test cases are run multiple times with different data. Two
 * items are needed to set this up: a constructor for instances of this class
 * that assigns the parameters to instance variables, and a method with the
 * &#64;Parameters notation that returns a list of parameter arrays.
 *
 */
@RunWith(Parameterized.class)
public class BitAndTest
{
	/**
	 * Bit value for left side of binary operator
	 */
	private Bit leftBit;

	/**
	 * Bit value for right side of binary operator
	 */
	private Bit rightBit;

	/**
	 * Expected bit value for the result of AND
	 */
	private Bit expectedResult;

	/**
	 * Constructor for a parameterized test case.
	 * </p>
	 * <p>
	 * The constructor stores the parameters in instance variables for use by
	 * whichever test method is being run. Because we don't know exactly which
	 * method will be run (in general), the parameters have to be set up for all
	 * possible test methods for the set of values.
	 *
	 * @param leftBit
	 *            Bit value for left side of binary operator
	 * @param rightBit
	 *            Bit value for right side of binary operator
	 * @param expected
	 *            Expected bit value for the result of AND
	 */
	public BitAndTest(int leftBit, int rightBit, int expected)
	{
		this.leftBit = new Bit(leftBit);
		this.rightBit = new Bit(rightBit);
		this.expectedResult = new Bit(expected);
	}

	/**
	 * Set up parameters for the test cases.
	 * <p>
	 * The parameters are for the binary operator 'and'. Set up all possible
	 * combinations of the two input values (leftBit and rightBit), and the
	 * expected result. Therefore, there should be three parameters for each
	 * case:
	 * </p>
	 * <ol>
	 * <li>The first input bit value</li>
	 * <li>The second input bit value</li>
	 * <li>The expected result for: leftBit.and( rightBit )</li>
	 * </ol>
	 * <p>
	 * The five parameters are stored in an integer array for each run of the
	 * test cases. Each array is then added as a list item.
	 * </p>
	 * With 4 combinations of values for a binary operator, there will be four
	 * arrays of parameters.
	 *
	 * @return A list of integer arrays containing all 0-1 combination pairs for each test run.
	 */
	@Parameters
	public static List<Integer[]> data( )
	{
		List<Integer[]> params = new LinkedList<Integer[]>( );
		params.add(new Integer[] { 0, 0, 0 });
		params.add(new Integer[] { 0, 1, 0 });
		params.add(new Integer[] { 1, 0, 0 });
		params.add(new Integer[] { 1, 1, 1 });
		return params;
	}

	/**
	 * Test method for {@link Bit#and(Bit)}.
	 * The input and expected values are set by the constructor. Perform the
	 * operation to get the actual value, and assert that it is as expected.
	 */
	@Test
	public void testAnd()
	{
		Bit actualBit = leftBit.and(rightBit);
		Assert.assertEquals(expectedResult, actualBit);
	}

}