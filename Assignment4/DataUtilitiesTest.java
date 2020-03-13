package org.jfree.data;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesTest {
	static Values2D doubleValue2x2;
	static Values2D doubleObjectValue2x2;
	static Values2D intValue2x2;
	static Values2D stringValues2x2;
	
	static KeyedValues positiveValues3;
	static KeyedValues positiveValuesExpected3;
	static KeyedValues zeroValues3;
	static KeyedValues negativeValues3;
	static KeyedValues oneNullTwoPositiveValues3;
	
	@BeforeClass
	public static void setup() {
		Mockery mockingContext = new Mockery();
		doubleValue2x2 = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(doubleValue2x2).getRowCount();
				will(returnValue(2));
				allowing(doubleValue2x2).getColumnCount();
				will(returnValue(2));
				allowing(doubleValue2x2).getValue(0, 0);
				will(returnValue(1.5));
				allowing(doubleValue2x2).getValue(0, 1);
				will(returnValue(2.5));
				allowing(doubleValue2x2).getValue(1, 0);
				will(returnValue(3.5));
				allowing(doubleValue2x2).getValue(1, 1);
				will(returnValue(4.5));
			}
		});
		Mockery mockingContextDoubleObject = new Mockery();
		doubleObjectValue2x2 = mockingContextDoubleObject.mock(Values2D.class);
		mockingContextDoubleObject.checking(new Expectations() {
			{
				allowing(doubleObjectValue2x2).getRowCount();
				will(returnValue(2));
				allowing(doubleObjectValue2x2).getColumnCount();
				will(returnValue(2));
				allowing(doubleObjectValue2x2).getValue(0, 0);
				will(returnValue(null));
				allowing(doubleObjectValue2x2).getValue(0, 1);
				will(returnValue(new Double(2.5)));
				allowing(doubleObjectValue2x2).getValue(1, 0);
				will(returnValue(new Double(3.5)));
				allowing(doubleObjectValue2x2).getValue(1, 1);
				will(returnValue(new Double(4.5)));
			}
		});
		
		Mockery mockingContextInt = new Mockery();
		intValue2x2 = mockingContextInt.mock(Values2D.class);
		mockingContextInt.checking(new Expectations() {
			{
				allowing(intValue2x2).getRowCount();
				will(returnValue(2));
				allowing(intValue2x2).getColumnCount();
				will(returnValue(2));
				allowing(intValue2x2).getValue(0, 0);
				will(returnValue(1));
				allowing(intValue2x2).getValue(0, 1);
				will(returnValue(2));
				allowing(intValue2x2).getValue(1, 0);
				will(returnValue(3));
				allowing(intValue2x2).getValue(1, 1);
				will(returnValue(4));
			}
		});
		
		Mockery mockingContextString = new Mockery();
		stringValues2x2 = mockingContextString.mock(Values2D.class);
		mockingContextString.checking(new Expectations() {
			{
				allowing(stringValues2x2).getRowCount();
				will(returnValue(2));
				allowing(stringValues2x2).getColumnCount();
				will(returnValue(2));
				allowing(stringValues2x2).getValue(0, 0);
				will(returnValue("No"));
				allowing(stringValues2x2).getValue(0, 1);
				will(returnValue("double"));
				allowing(stringValues2x2).getValue(1, 0);
				will(returnValue("values"));
				allowing(stringValues2x2).getValue(1, 1);
				will(returnValue("here"));
			}
	});
	

	Mockery mockingContextKeyExpected = new Mockery();
	positiveValuesExpected3 = mockingContextKeyExpected.mock(KeyedValues.class);
	mockingContextKeyExpected.checking(new Expectations() {
		{
			Integer arr[] = {0,1,2};
			allowing(positiveValuesExpected3).getItemCount();
			will(returnValue(3));
			allowing(positiveValuesExpected3).getKeys();
			will(returnValue(Arrays.asList(arr)));
			allowing(positiveValuesExpected3).getKey(0);
			will(returnValue(0));
			allowing(positiveValuesExpected3).getKey(1);
			will(returnValue(1));
			allowing(positiveValuesExpected3).getKey(2);
			will(returnValue(2));
			allowing(positiveValuesExpected3).getIndex(0);
			will(returnValue(0));
			allowing(positiveValuesExpected3).getIndex(1);
			will(returnValue(1));
			allowing(positiveValuesExpected3).getIndex(2);
			will(returnValue(2));
			allowing(positiveValuesExpected3).getValue(0);
			will(returnValue(0.3125));
			allowing(positiveValuesExpected3).getValue(1);
			will(returnValue(0.875));
			allowing(positiveValuesExpected3).getValue(2);
			will(returnValue(1.0));
		}
});
	/*
	 * 	0	5.0
	 *  1	9.0
	 *  2	2.0
	 */
	Mockery mockingContextKeyPositive = new Mockery();
	positiveValues3 = mockingContextKeyPositive.mock(KeyedValues.class);
	mockingContextKeyPositive.checking(new Expectations() {
		{
			Integer arr[] = {0,1,2};
			allowing(positiveValues3).getItemCount();
			will(returnValue(3));
			allowing(positiveValues3).getKeys();
			will(returnValue(Arrays.asList(arr)));
			allowing(positiveValues3).getKey(0);
			will(returnValue(0));
			allowing(positiveValues3).getKey(1);
			will(returnValue(1));
			allowing(positiveValues3).getKey(2);
			will(returnValue(2));
			allowing(positiveValues3).getIndex(0);
			will(returnValue(0));
			allowing(positiveValues3).getIndex(1);
			will(returnValue(1));
			allowing(positiveValues3).getIndex(2);
			will(returnValue(2));
			allowing(positiveValues3).getValue(0);
			will(returnValue(5.0));
			allowing(positiveValues3).getValue(1);
			will(returnValue(9.0));
			allowing(positiveValues3).getValue(2);
			will(returnValue(2.0));
		}
});
	/*
	 * 	0	0.0
	 *  1	0.0
	 *  2	0.0
	 */
	Mockery mockingContextKeyZero = new Mockery();
	zeroValues3 = mockingContextKeyZero.mock(KeyedValues.class);
	mockingContextKeyZero.checking(new Expectations() {
		{
			Integer arr[] = {0,1,2};
			allowing(zeroValues3).getItemCount();
			will(returnValue(3));
			allowing(zeroValues3).getKeys();
			will(returnValue(Arrays.asList(arr)));
			allowing(zeroValues3).getKey(0);
			will(returnValue(0));
			allowing(zeroValues3).getKey(1);
			will(returnValue(1));
			allowing(zeroValues3).getKey(2);
			will(returnValue(2));
			allowing(zeroValues3).getIndex(0);
			will(returnValue(0));
			allowing(zeroValues3).getIndex(1);
			will(returnValue(1));
			allowing(zeroValues3).getIndex(2);
			will(returnValue(2));
			allowing(zeroValues3).getValue(0);
			will(returnValue(0.0));
			allowing(zeroValues3).getValue(1);
			will(returnValue(0.0));
			allowing(zeroValues3).getValue(2);
			will(returnValue(0.0));
		}
});
	/*
	 * 	0	null
	 *  1	9.0
	 *  2	2.0
	 */
	Mockery mockingContextKeyNull = new Mockery();
	oneNullTwoPositiveValues3 = mockingContextKeyNull.mock(KeyedValues.class);
	mockingContextKeyNull.checking(new Expectations() {
		{
			Integer arr[] = {0,1,2};
			allowing(oneNullTwoPositiveValues3).getItemCount();
			will(returnValue(3));
			allowing(oneNullTwoPositiveValues3).getKeys();
			will(returnValue(Arrays.asList(arr)));
			allowing(oneNullTwoPositiveValues3).getKey(0);
			will(returnValue(0));
			allowing(oneNullTwoPositiveValues3).getKey(1);
			will(returnValue(1));
			allowing(oneNullTwoPositiveValues3).getKey(2);
			will(returnValue(2));
			allowing(oneNullTwoPositiveValues3).getIndex(0);
			will(returnValue(0));
			allowing(oneNullTwoPositiveValues3).getIndex(1);
			will(returnValue(1));
			allowing(oneNullTwoPositiveValues3).getIndex(2);
			will(returnValue(2));
			allowing(oneNullTwoPositiveValues3).getValue(0);
			will(returnValue(null));
			allowing(oneNullTwoPositiveValues3).getValue(1);
			will(returnValue(9.0));
			allowing(oneNullTwoPositiveValues3).getValue(2);
			will(returnValue(2.0));
		}
});
	/*
	 * 	0	-5.0
	 *  1	-9.0
	 *  2	-2.0
	 */
	Mockery mockingContextKeyNegative = new Mockery();
	negativeValues3 = mockingContextKeyNegative.mock(KeyedValues.class);
	mockingContextKeyNegative.checking(new Expectations() {
		{
			Integer arr[] = {0,1,2};
			allowing(negativeValues3).getItemCount();
			will(returnValue(3));
			allowing(negativeValues3).getKeys();
			will(returnValue(Arrays.asList(arr)));
			allowing(negativeValues3).getKey(0);
			will(returnValue(0));
			allowing(negativeValues3).getKey(1);
			will(returnValue(1));
			allowing(negativeValues3).getKey(2);
			will(returnValue(2));
			allowing(negativeValues3).getIndex(0);
			will(returnValue(0));
			allowing(negativeValues3).getIndex(1);
			will(returnValue(1));
			allowing(negativeValues3).getIndex(2);
			will(returnValue(2));
			allowing(negativeValues3).getValue(0);
			will(returnValue(-5.0));
			allowing(negativeValues3).getValue(1);
			will(returnValue(-9.0));
			allowing(negativeValues3).getValue(2);
			will(returnValue(-2.0));
		}
});
}

	
	/**
	 * calculate column total for a Values2D object with positive double values - Equivalence Class Testing
	 */
	@Test
	public void calculateColumnTotalForTwoValuesForZeroethColumnWithDoublePrimative() {
		double actualResult = DataUtilities.calculateColumnTotal(doubleValue2x2, 0);
		double expectedResult = 5.0;
		String message = "sum of zeroth column of a double 2x2 Values2D .";
		assertEquals(message, expectedResult, actualResult, .000000001d);
	}
	
	/**
	 * calculate column total for a Values2D object with positive Double values - Equivalence Class Testing
	 */
	@Test
	public void calculateColumnTotalForTwoValuesForZeroethColumnWithDoubleObject() {
		double actualResult = DataUtilities.calculateColumnTotal(doubleObjectValue2x2, 0);
		double expectedResult = 5.0;
		String message = "sum of zeroth column of a Double 2x2 Values2D .";
		assertEquals(message, expectedResult, actualResult, .000000001d);
	}
	
	/**
	 * calculate column total for a Values2D object with positive int values - Equivalence Class Testing
	 */
	@Test
	public void calculateColumnTotalForTwoValuesForZeroethColumnWithIntPrimitive() {
		double actualResult = DataUtilities.calculateColumnTotal(intValue2x2, 0);
		double expectedResult = 4.0;
		String message = "sum of zeroth column of a int 2x2 Values2D .";
		assertEquals(message, expectedResult, actualResult, .000000001d);
	}

	/**
	 * calculate column total for a Values2D object with string values - Equivalence Class Testing
	 * Test causes error since IllegalStateException due to the function trying to return
	 * a string instead of a Number, expected that is should throw an InvalidParameterException
	 */
	@Test(expected = InvalidParameterException.class)
	public void calculateColumnTotalForTwoValuesForZeroethColumnWithString() {
		DataUtilities.calculateColumnTotal(stringValues2x2,0);
	}
	
	/**
	 * calculate row total for a Values2D object with positive double values - Equivalence Class Testing
	 */
	@Test
	public void calculateRowTotalForTwoValuesForZeroethRowWithDoublePrimative() {
		double actualResult = DataUtilities.calculateRowTotal(doubleValue2x2, 0);
		double expectedResult = 4.0;
		String message = "sum of zeroth row of a double 2x2 Values2D .";
		assertEquals(message, expectedResult, actualResult, .000000001d);
	}
	
	/**
	 * calculate row total for a Values2D object with positive Double values - Equivalence Class Testing
	 */
	@Test
	public void calculateRowTotalForTwoValuesForZeroethRowWithDoubleObject() {
		double actualResult = DataUtilities.calculateRowTotal(doubleObjectValue2x2, 0);
		double expectedResult = 4.0;
		String message = "sum of zeroth row of a Double 2x2 Values2D .";
		assertEquals(message, expectedResult, actualResult, .000000001d);
	}
	
	/**
	 * calculate row total for a Values2D object with positive int values - Equivalence Class Testing
	 */
	@Test
	public void calculateRowTotalForTwoValuesForZeroethRowWithIntPrimitive() {
		double actualResult = DataUtilities.calculateRowTotal(intValue2x2, 0);
		double expectedResult = 3.0;
		String message = "sum of zeroth row of a int 2x2 Values2D .";
		assertEquals(message, expectedResult, actualResult, .000000001d);
	}

	/**
	 * calculate row total for a Values2D object with string values - Equivalence Class Testing
	 * Test causes error since IllegalStateException due to the function trying to return
	 * a string instead of a Number, expected that is should throw an InvalidParameterException
	 */
	@Test(expected = InvalidParameterException.class)
	public void calculateRowTotalForTwoValuesForZeroethRowWithString() {
		DataUtilities.calculateRowTotal(stringValues2x2,0);
	}
	
	/**
	 * check first cumulative percentage for KeyedValues with 3 positive doubles - Equivalence Class Testing
	 */
	@Test
	public void getCumulativePercentagesUsing3PositiveDoubleValuesFirst() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(positiveValues3);	
		String message = "first cumulative percentage of a KeyedValues of size 3 with positive values.";
		assertSame(message, positiveValuesExpected3.getValue(0), actual.getValue(0));		
	}
	
	/**
	 * check second cumulative percentage for KeyedValues with 3 positive doubles - Equivalence Class Testing
	 */
	@Test
	public void getCumulativePercentagesUsing3PositiveDoubleValuesSecond() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(positiveValues3);
		String message = "second cumulative percentage of a KeyedValues of size 3 with positive values.";
		assertSame(message, positiveValuesExpected3.getValue(1), actual.getValue(1));
	
	}
	
	/**
	 * check third cumulative percentage for KeyedValues with 3 positive doubles - Equivalence Class Testing
	 */
	@Test
	public void getCumulativePercentagesUsing3PositiveDoubleValuesThird() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(positiveValues3);
		String message = "third cumulative percentage of a KeyedValues of size 3 with positive values.";
		assertSame(message, positiveValuesExpected3.getValue(2), actual.getValue(2));
	}
	
	/**
	 * check first cumulative percentage for KeyedValues with 3 negative doubles - Equivalence Class Testing
	 */
	@Test
	public void getCumulativePercentagesUsing3NegativeDoubleValuesFirst() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(negativeValues3);
		String message = "first cumulative percentage of a KeyedValues of size 3 with negative values.";
		assertSame(message, positiveValuesExpected3.getValue(0), actual.getValue(0));
		
	}
	
	/**
	 * check second cumulative percentage for KeyedValues with 3 negative doubles - Equivalence Class Testing
	 */
	@Test
	public void getCumulativePercentagesUsing3NegativeDoubleValuesSecond() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(negativeValues3);	
		String message = "second cumulative percentage of a KeyedValues of size 3 with negative values.";
		assertSame(message, positiveValuesExpected3.getValue(1), actual.getValue(1));
	
	}
	
	/**
	 * check third cumulative percentage for KeyedValues with 3 negative doubles - Equivalence Class Testing
	 */
	@Test
	public void getCumulativePercentagesUsing3NegativeDoubleValuesThird() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(negativeValues3);	
		String message = "third cumulative percentage of a KeyedValues of size 3 with negative values.";
		assertSame(message, positiveValuesExpected3.getValue(2), actual.getValue(2));
	}
	
	/**
	 * cumulative percentage for KeyedValues with 3 zero doubles - Boundary Value Testing
	 * should return an InvalidParameterException - since those inputs would lead to a divide by zero
	 *  but returns no exception
	 */
	@Test(expected = InvalidParameterException.class)
	public void getCumulativePercentagesUsing3ZeroDoubleValues() {
		DataUtilities.getCumulativePercentages(zeroValues3);	
	}	
	
	/**
	 * cumulative percentage for KeyedValues with one null doubles - Boundary Value Testing
	 * should return an InvalidParameterException - since javadocs specify no null values allowed
	 *  but returns no exception
	 */
	@Test(expected = InvalidParameterException.class)
	public void getCumulativePercentagesUsing1Null2PositiveDoubleValues() {
		DataUtilities.getCumulativePercentages(oneNullTwoPositiveValues3);	
	}	
	
	/**
	 * cumulative percentage for null KeyedValues 
	 * Whiteboxtesting
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getCumulativePercentagesUsing1Null() {
		DataUtilities.getCumulativePercentages(null);	
	}	
	
	/**
	 *  test createNumberArray function by passing double [] object
	 *  Equivalent class test
	 */
	@Test
	public void test_createNumberArray1D_passing_doubleArray() {
		double [] doubleArray = {1.5,2.5,3.5};
		Number [] actualResult = DataUtilities.createNumberArray(doubleArray);
		Number [] expectedResult = {1.5,2.5,3.5};
		String message = "Passing 1D array {1.5, 2.5, 3.5} in method createNumberArray, should return a Number array with the same values.";
		boolean result = Arrays.equals(actualResult,expectedResult);
		assertTrue(message, result);
	}
	
	/**
	 *  test createNumberArray function by passing null argument
	 *  whitebox testing
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_createNumberArray1D_passing_null() {
		Number [] actualResult = DataUtilities.createNumberArray(null);

	}
	/**
	 *  test createNumberArray2D function by passing double [] object
	 *  Equivalent class test
	 */
	@Test
	public void test_createNumberArray2D_passing_doubleArray() {

		double [][] double2DArray = {{1.5,2.5},{3.5,4.5}};
		Number[][] actualResult = DataUtilities.createNumberArray2D(double2DArray);
		Number [][] expectedResult = {{1.5,2.5},{3.5,4.5}};
		String message = "Passing 1D array {{1.5,2.5},{3.5,4.5}} in method createNumberArray, should return a Number array with the same values.";

		boolean result = Arrays.deepEquals(actualResult,expectedResult);
		assertTrue(message, result);
	}
	
	/**
	 *  test createNumberArray2D function by passing null argument
	 *  whitebox testing
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_createNumberArray2D_passing_null() {
		Number[][] actualResult = DataUtilities.createNumberArray2D(null);

	}
}


