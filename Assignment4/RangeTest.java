
package org.jfree.data;



import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeTest {
	static Range exampleRange;
static Range nullRange;

	@BeforeClass
	public static void setup() throws Exception {
		exampleRange = new Range (-10, 10);
nullRange = null;	
	}
	
	@Before
	public void reset()
	{
		exampleRange = new Range(-10, 10);
	}

	/**
	 * checking lowerbound after shiftRangeByDouble disallowing crossing zero starting with the lower bound at zero
	 * whitebox testing
	 */
	
	@Test
	public void shiftRangeByDoubleAndCompareLowerBoundZeroCrossingFalseatZero() {
		Range testRange = new Range (0,10);
		Range expectedRange = new Range (5, 15);
		Range actualRange = Range.shift(testRange, 5);
		String message = "checking lower bound after shift by +5";
		boolean condition = (expectedRange.getLowerBound() == actualRange.getLowerBound());
		assertTrue(message, condition);
	}
		/**
*  Test constructor where lower is greater than upper to make sure it throws an exception
*/
	@Test(expected = IllegalArgumentException.class)
	public void testCaseWhereLowerIsGreaterThanUpperInConstructor() {
		Range r = new Range(10, 0);
	}
	/**
*  Test hashcode to make sure it runs
*/
	@Test
	public void testHashCode() {
		Range test = new Range(0,1);
		long actual = (long)test.hashCode();
		long expected = 1072693248;
		assertEquals(expected, actual);
	}

	/**
	 * checking lowerbound after shiftRangeByDouble disallowing crossing zero starting with the lower bound below zero
	 * and not trying to shift above zero
	 * whitebox testing
	 */
	@Test
	public void shiftRangeByDoubleAndCompareLowerBoundZeroCrossingFalse() {
		Range testRange = new Range (-10,10);
		Range expectedRange = new Range (-5, 15);
		Range actualRange = Range.shift(testRange, 5);
		String message = "checking lower bound after shift by +5";
		boolean condition = (expectedRange.getLowerBound() == actualRange.getLowerBound());
		assertTrue(message, condition);
	}
	
	/**
	 * checking upperbound after shiftRangeByDouble disallowing crossing zero starting with the lower bound below zero
	 * and not trying to shift above zero
	 * whitebox testing
	 */
	@Test
	public void shiftRangeByDoubleAndCompareUpperBoundZeroCrossingFalse() {
		Range testRange = new Range (-10,10);
		Range expectedRange = new Range (-5, 15);
		Range actualRange = Range.shift(testRange, 5);
		String message = "checking upper bound after shift by +5";
		boolean condition = (expectedRange.getLowerBound() == actualRange.getLowerBound());
		assertTrue(message, condition);
	}
	
	/**
	 * checking lowerbound after shiftRangeByDouble disallowing crossing zero starting with the lower bound below zero
	 * and trying to shift to zero
	 * whitebox testing
	 */
	@Test
	public void shiftRangeByDoubleAndCompareLowerBoundZeroCrossingFalseWithLowerBoundAtZero() {
		Range testRange = new Range (-10,10);
		Range expectedRange = new Range (0, 20);
		Range actualRange = Range.shift(testRange, 10);
		String message = "checking lower bound after shift by +10 with lower bound  at zero and crossing false";
		boolean condition = (expectedRange.getLowerBound() == actualRange.getLowerBound());
		assertTrue(message, condition);
	}
	
	/**
	 * checking upperbound after shiftRangeByDouble disallowing crossing zero starting with the lower bound below zero
	 * and not trying to shift to zero
	 * whitebox testing
	 */
	@Test
	public void shiftRangeByDoubleAndCompareUpperBoundZeroCrossingFalseWithUpperBoundAtZero() {
		Range testRange = new Range (-10,10);
		Range expectedRange = new Range (0, 20);
		Range actualRange = Range.shift(testRange, 10);
		String message = "checking upper bound after shift by +10 with lower bound  at zero and crossing false";
		boolean condition = (expectedRange.getUpperBound() == actualRange.getUpperBound());
		assertTrue(message, condition);
	}
	
	/**
	 * checking lowerbound after shiftRangeByDouble disallowing crossing zero starting with the lower bound below zero
	 * and trying to shift above zero
	 * whitebox testing
	 */
	@Test
	public void shiftRangeByDoubleAndCompareLowerBoundZeroCrossingFalseWithLowerBoundAboveZero() {
		Range testRange = new Range (-10,10);
		Range expectedRange = new Range (0, 25);
		Range actualRange = Range.shift(testRange, 15);
		String message = "checking lower bound after shift by +15 with lower bound  above zero and crossing false";
		boolean condition = (expectedRange.getLowerBound() == actualRange.getLowerBound());
		assertTrue(message, condition);
	}
	
	/**
	 * checking upperbound after shiftRangeByDouble disallowing crossing zero starting with the lower bound below zero
	 * and not trying to shift above zero
	 * whitebox testing
	 */
	@Test
	public void shiftRangeByDoubleAndCompareUpperBoundZeroCrossingFalseWithLowerBoundAboveZero() {
		Range testRange = new Range (-10,10);
		Range expectedRange = new Range (0, 25);
		Range actualRange = Range.shift(testRange, 15);
		String message = "checking upper bound after shift by +15 with lower bound  above zero and crossing false";
		boolean condition = (expectedRange.getLowerBound() == actualRange.getLowerBound());
		assertTrue(message, condition);
	}
	
	/**
	 * checking lowerbound after shiftRangeByDouble allowing crossing zero starting with the lower bound below zero
	 * and trying to shift above zero
	 * whitebox testing
	 */
	@Test
	public void shiftRangeByDoubleAndCompareLowerBoundZeroCrossingTrue() {
		Range testRange = new Range (-10,10);
		Range expectedRange = new Range (5, 25);
		Range actualRange = Range.shift(testRange, 15, true);
		String message = "checking lower bound after shift by +15 zero crossing true";
		boolean condition = (expectedRange.getLowerBound() == actualRange.getLowerBound());
		assertTrue(message, condition);
	}
	
	/**
	 * checking afterbound after shiftRangeByDouble allowing crossing zero starting with the lower bound below zero
	 * and trying to shift above zero
	 * whitebox testing
	 */
	@Test
	public void shiftRangeByDoubleAndCompareUpperBoundZeroCrossingTrue() {
		Range testRange = new Range (-10,10);
		Range expectedRange = new Range (5, 25);
		Range actualRange = Range.shift(testRange, 15, true);
		String message = "checking upper bound after shift by +15 zero crossing true";
		boolean condition = (expectedRange.getLowerBound() == actualRange.getLowerBound());
		assertTrue(message, condition);
	}
	
	/*** Testing "public boolean contains(double value)" Method ***/
	
	/**
	 * The test passingIntegerInContains, tests passing in integer in the variable value for the method contains(double value) - Equivalence Class Testing.
	 */
	@Test
	public void passingIntegerInContains()
	{
		String message = "Integer value, 1,  should be between -10 and 10";
		int valueBeingTested = 1;
		boolean condition = exampleRange.contains(valueBeingTested);
		assertTrue(message, condition);
	}

	/**
	 * The test passingDoubleObjectInContains, tests passing an object Double in the variable value for the method contains(double value) - Equivalence Class Testing.
	 */
	@Test
	public void passingDoubleObjectInContains()
	{
		String message = "Double object, 1.1, should be between -10 and 10";
		Double valueBeingTested = 1.1;
		boolean condition = exampleRange.contains(valueBeingTested);
		assertTrue(message, condition);
	}
	
	/**
	 * The test passingBetweenLowerAndUpper, tests passing a normal double value for method contains(double value) - Equivalence Class Testing.
	 */
	@Test
	public void passingBetweenLowerAndUpper()
	{
		String message = "Passing value 1.1, should be between -10 and 10";
		double valueBeingTested = 1.1;
		boolean condition = exampleRange.contains(valueBeingTested);
		assertTrue(message, condition);
	}
	
	/**
	 * The test passingBelowLowerBound, tests passing a double value below the lower bound for method contains(double value) - Equivalence Class Testing.
	 */
	@Test
	public void passingBelowLowerBound()
	{
		String message = "Passing value -10.1, should not be between -10 and 10";
		double valueBeingTested = -15;
		boolean condition = exampleRange.contains(valueBeingTested);
		assertFalse(message, condition);
	}
	
	/**
	 * The test passingAboveUpperBound, tests passing a double value above the upper bound for method contains(double value) - Equivalence Class Testing.
	 */
	@Test
	public void passingAboveUpperBound()
	{
		String message = "Passing value 10.1, should not be between -10 and 10";
		double valueBeingTested = 15;
		boolean condition = exampleRange.contains(valueBeingTested);
		assertFalse(message, condition);
	}
	
	/**
	 * The test passingJustAboveLowerBound, tests passing a double value barely above the lower bound for method contains(double value) - Boundary Value Testing.
	 */
	@Test
	public void passingJustAboveLowerBound()
	{
		String message = "Passing -9.999, should be between -10 and 10";
		double valueBeingTested = -9.999;
		boolean condition = exampleRange.contains(valueBeingTested);
		assertTrue(message, condition);
	}
	
	/**
	 * The test passingJustBelowUpperBound, tests passing a double value barely below the upper bound for method contains(double value) - Boundary Value Testing.
	 */
	@Test
	public void passingJustBelowUpperBound()
	{
		String message = "Passing 9.999, should be between -10 and 10.";
		double valueBeingTested = 9.999;
		boolean condition = exampleRange.contains(valueBeingTested);
		assertTrue(message, condition);
	}
	
	/**
	 * The test passingJustBelowLowerBound, tests passing a double value barely below the lower bound for method contains(double value) - Boundary Value Testing.
	 */
	@Test
	public void passingJustBelowLowerBound()
	{
		String message = "Passing -10.001, should not be between -10 and 10";
		double valueBeingTested = -10.001;
		boolean condition = exampleRange.contains(valueBeingTested);
		assertFalse(message, condition);
	}
	
	/**
	 * The test passingJustAboveUpperBound, tests passing a double value barely above the upper bound for method contains(double value) - Boundary Value Testing.
	 */
	@Test
	public void passingJustAboveUpperBound() 
	{
		String message = "Passing 10.001, should not be between -10 and 10";
		double valueBeingTested = 10.001;
		boolean condition = exampleRange.contains(valueBeingTested);
		assertFalse(message, condition);
	}
	
	/**
	 * The test passingLowerBound, tests passing a double value that is the same as the lower bound for method contains(double value) - Boundary Value Testing.
	 */
	@Test
	public void passingLowerBound()
	{
		String message = "Passing -10, should be between -10 and 10";
		double valueBeingTested = -10;
		boolean condition = exampleRange.contains(valueBeingTested);
		assertTrue(message, condition);
	}
	
	/**
	 * The test passingUpperBound, tests passing a double value that is the same as the upper bound for method contains(double value) - Boundary Value Testing. 
	 */
	@Test
	public void passingUpperBound()
	{
		String message = "Passing 10, should be between -10 and 10";
		double valueBeingTested = 10;
		boolean condition = exampleRange.contains(valueBeingTested);
		assertTrue(message, condition);
	}
	
	
	/*** Testing "public boolean intersects(double lower, double upper)" Method ***/
	
	/**
	 * The test completelyInside, tests passing the variable lower greater than lower bound and the variable upper less than the upper bound for method intersects(double lower, double upper) - Equivalence Class Testing.
	 */
	@Test
	public void completelyInside()
	{
		String message = "Passing a range of -5 and 5, should intersect between -10 and 10";
		double lower = -5;
		double upper = 5;
		boolean condition = exampleRange.intersects(lower, upper);
		assertTrue(message, condition);
	}
	
	/**
	 * The test completelyBelow, tests passing the variable lower and upper both below the lower bound for method intersects(double lower, double upper) - Equivalence Class Testing.
	 */
	@Test
	public void completelyBelow()
	{
		String message = "Passing a range of -30 and -20, should not intersect between -10 and 10";
		double lower = -30;
		double upper = -20;
		System.out.println("Lower: " + exampleRange.getLowerBound() + " Upper: " + exampleRange.getUpperBound());
		boolean condition = exampleRange.intersects(lower, upper);
		assertFalse(message, condition);
	}
	
	/**
	 * The test completelyAbove, tests passing the variable lower and upper both above the upper bound for method intersects(double lower, double upper) - Equivalence Class Testing.
	 */
	@Test
	public void completelyAbove()
	{
		String message = "Passing a range of 20 and 30, should intersect between -10 and 10";
		double lower = 20;
		double upper = 30;
		boolean condition = exampleRange.intersects(lower, upper);
		assertFalse(message, condition);
	}
	
	/**
	 * The test completelyBiggerThanRange, tests passing the variable lower below the lower bound and the variable upper above the upper bound for method intersects(double lower, double upper) - Equivalence Class Testing.
	 */
	@Test
	public void completelyBiggerThanRange()
	{
		String message = "Passing a range of -20 and 20, should intersect between -10 and 10";
		double lower = -20;
		double upper = 20;
		boolean condition = exampleRange.intersects(lower, upper);
		assertTrue(message, condition);
	}
	
	/**
	 * The test lowerTouchingUpperBound, tests passing the variable lower equal to the upper bound and the variable upper is normal for method intersects(double lower, double upper) - Boundary Value Testing.
	 */
	@Test
	public void lowerTouchingUpperBound()
	{
		String message = "Passing a range of 10 and 15, should not intersect between -10 and 10";
		double lower = 10;
		double upper = 15;
		boolean condition = exampleRange.intersects(lower, upper);
		assertFalse(message, condition);
	}
	
	/**
	 * The test upperTouchingLowerBound, tests passing the variable upper equal to the lower bound and the variable lower is normal for method intersects(double lower, double upper) - Boundary Value Testing.
	 */
	@Test
	public void upperTouchingLowerBound()
	{
		String message = "Passing a range of -15 and -10, should not intersect between -10 and 10";
		double lower = -15;
		double upper = -10;
		boolean condition = exampleRange.intersects(lower, upper);
		assertFalse(message, condition);
	}
	
	/**
	 * The test lowerIsSlightlyBelowUpperBound, tests passing the variable lower slightly below the upper bound and the variable upper is normal for method intersects(double lower, double upper) - Boundary Value Testing.
	 */
	@Test
	public void lowerIsSlightlyBelowUpperBound()
	{
		String message = "Passing a range of 9.999 and 15, should intersect between -10 and 10";
		double lower = 9.999;
		double upper = 15;
		boolean condition = exampleRange.intersects(lower, upper);
		assertFalse(message, condition);
	}
	
	/**
	 * The test upperIsSlightlyAboveLowerBound, tests passing the variable upper slightly above the lower bound and the variable lower is normal for method intersects(double lower, double upper) - Boundary Value Testing.
	 */
	@Test
	public void upperIsSlightlyAboveLowerBound()
	{
		String message = "Passing a range of -15 and -9.999, should intersect between -10 and 10";
		double lower = -15;
		double upper = -9.999;
		boolean condition = exampleRange.intersects(lower, upper);
		assertTrue(message, condition);
	}
	
	/**
	 * The test lowerIsSlightlyAboveUpperBound, tests passing the variable lower slightly above the upper bound and the variable upper is normal for method intersects(double lower, double upper) - Boundary Value Testing.
	 */
	@Test
	public void lowerIsSlightlyAboveUpperBound()
	{
		String message = "Passing a range of 10.001 and 15, should not intersect between -10 and 10";
		double lower = 10.001;
		double upper = 15;
		boolean condition = exampleRange.intersects(lower, upper);
		assertFalse(message, condition);
	}
	
	/**
	 * The test upperIsSlightlyBelowLowerBound, tests passing the variable upper slightly below the lower bound and the variable lower is normal for method intersects(double lower, double upper) - Boundary Value Testing.
	 */
	@Test
	public void upperIsSlightlyBelowLowerBound()
	{
		String message = "Passing a range of -15 and -10.001, should not intersect between -10 and 10";
		double lower = -15;
		double upper = -10.001;
		boolean condition = exampleRange.intersects(lower, upper);
		assertFalse(message, condition);
	}
	
	/**
	 * The test lowerAndUpperAreTheBounds, tests passing the variable lower equal to lower bound and the variable upper equal to upper bound for method intersects(double lower, double upper) - Boundary Value Testing.
	 */
	@Test
	public void lowerAndUpperAreTheBounds()
	{
		String message = "Passing a range of -10 and 10, should intersect between -10 and 10";
		double lower = -10;
		double upper = 10;
		boolean condition = exampleRange.intersects(lower, upper);
		assertTrue(message, condition);
	}
	
	/**
	 * Equivalence Class Test below lower bound for constrain function
	 */
	@Test
	public void constrainValueBelowLowerBound() {
		String message = "Passing a range of -10 and 10, should constrain a value of -15 to -10";
		double actualResult = exampleRange.constrain(-15);
		double expectedResult = -10;
		boolean condition = actualResult == expectedResult;
		assertTrue(message, condition);
	}
	
	/**
	 * Equivalence Class Test at lower bound for constrain function
	 */
	@Test
	public void constrainValueAboveUpperBound() {
		String message = "Passing a range of -10 and 10, should constrain a value of 15 to 10";
		double actualResult = exampleRange.constrain(15);
		double expectedResult = 10;
		boolean condition = actualResult == expectedResult;
		assertTrue(message, condition);
	}
	
	/**
	 * Equivalence Class Test at nominal value for constrain function
	 */
	@Test
	public void constrainValueInRange() {
		String message = "Passing a range of -10 and 10, should constrain a value of 0 to 0";
		double actualResult = exampleRange.constrain(0);
		double expectedResult = 0;
		boolean condition = actualResult == expectedResult;
		assertTrue(message, condition);
	}
	
	/**
	 * Boundary Value Test at just above upper bound for constrain function
	 */
	@Test
	public void constrainValueJustAboveUpperBound() {
		String message = "Passing a range of -10 and 10, should constrain a value of 11 to 10";
		double actualResult = exampleRange.constrain(11);
		double expectedResult = 10;
		boolean condition = actualResult == expectedResult;
		assertTrue(message, condition);
	}
	
	/**
	 * Boundary Value Test at upper bound for constrain function
	 */
	@Test
	public void constrainValueAtUpperBound() {
		String message = "Passing a range of -10 and 10, should constrain a value of 10 to 10";
		double actualResult = exampleRange.constrain(10);
		double expectedResult = 10;
		boolean condition = actualResult == expectedResult;
		assertTrue(message, condition);
	}
	
	/**
	 * Boundary Value Test at just below lower bound for constrain function
	 */
	@Test
	public void constrainValueAtJustBelowLowerBound() {
		String message = "Passing a range of -10 and 10, should constrain a value of -11 to -10";
		double actualResult = exampleRange.constrain(-11);
		double expectedResult = -10;
		boolean condition = actualResult == expectedResult;
		assertTrue(message, condition);
	}
	
	/**
	 * Boundary Value Test at lower bound for constrain function
	 */
	@Test
	public void constrainValueAtLowerBound() {
		String message = "Passing a range of -10 and 10, should constrain a value of -10 to -10";
		double actualResult = exampleRange.constrain(-10);
		double expectedResult = -10;
		boolean condition = actualResult == expectedResult;
		assertTrue(message, condition);
	}
	
	/**
	 * Equivalence Class Test at negative range for getCentralValue function
	 */
	@Test
	public void getCentralValueOfNegativeRange() {
		String message = "Passing a range of -3 and -1, central value should be -2";
		Range r = new Range(-3, -1);
		double actualResult = r.getCentralValue();
		double expectedResult = -2;
		boolean condition = actualResult == expectedResult;
		assertTrue(message, condition);
	}
	
	/**
	 * Equivalence Class Test at positive range for getCentralValue function
	 */
	@Test
	public void getCentralValueOfPositiveRange() {
		String message = "Passing a range of 1 and 3, central value should be 2";
		Range r = new Range(1,3);
		double actualResult = r.getCentralValue();
		double expectedResult = 2;
		boolean condition = actualResult == expectedResult;
		assertTrue(message, condition);
	}

	/**
	 * Equivalence Class Test at negative to positive range for getCentralValue function
	 */
	@Test
	public void getCentralValueOfNegativeToPositiveRange() {
		String message = "Passing a range of -1 and 1, central value should be 0";
		Range r = new Range(-1, 1);
		double actualResult = r.getCentralValue();
		double expectedResult = 0;
		boolean condition = actualResult == expectedResult;
		assertTrue(message, condition);
	}
	
	/**
	 * Equivalence Class Test at same number range for getCentralValue function
	 */
	@Test
	public void getCentralValueOfSameNumberRange() {
		String message = "Passing a range of 1 and 1, central value should be 1";
		Range r = new Range(1, 1);
		double actualResult = r.getCentralValue();
		double expectedResult = 1;
		boolean condition = actualResult == expectedResult;
		assertTrue(message, condition);
	}
	
	/**
	 * Test getUpperBound function 
	 * Equivalent class test
	 */
	
	@Test
	public void test_getUpperBound() {
		String message = "Test the upper bound of range -10 to 10 using the getUpperBound method, should return 10";
		double actualResult = exampleRange.getUpperBound();
		double expectedResult = 10;
		assertEquals(message,expectedResult,actualResult,0.00000001d); 
		
	}
	
	/**
	 * The test passingDoubleObject, tests passing a Double object in the method equals(Object obj) - Whitebox Testing.
	 */
	@Test
	public void passingDoubleObject()
	{
		String message = "Passing a Double object, should not be equal to exampleRange object.";
		Double doubleObject = new Double (5);
		boolean condition = exampleRange.equals(doubleObject);
		assertFalse(message, condition);
	}
	
	/**
	 * The test passingRangeObjectWithDifferentBounds, tests passing a Range object with completely different bounds in method equals(Object obj) - Whitebox Testing.
	 */
	@Test
	public void passingRangeObjectWithDifferentBounds()
	{
		String message = "Passing a Range object with lower = -20 and upper = 20, should not be equal to Range that is -10 to 10.";
		Range testRange = new Range(-20, 20);
		boolean condition = exampleRange.equals(testRange);
		assertFalse(message, condition);
	}
	
	/**
	 * The test passingRangeObjectWithSameLowerButDifferentUpper, tests passing a Range object with same lower but different upper bound in method equals(Object obj) - Whitebox Testing.
	 */
	@Test
	public void passingRangeObjectWithSameLowerButDifferentUpper()
	{
		String message = "Passing a Range object with lower = -10 but upper = 20, should not be equal to Range that is -10 to 10.";
		Range testRange = new Range(-10, 20);
		boolean condition = exampleRange.equals(testRange);
		assertFalse(message, condition);
	}
	
	/**
	 * The test passingRangeObjectWithSameUpperButDifferentLower, tests passing a Range object with same upper but different lower bound in method equals(Object obj) - Whitebox Testing.
	 */
	@Test
	public void passingRangeObjectWithSameUpperButDifferentLower()
	{
		String message = "Passing a range object with upper = 10 but lower = -20, should not be equal to Range that is -10 to 10.";
		Range testRange = new Range(-20, 10);
		boolean condition = exampleRange.equals(testRange);
		assertFalse(message, condition);
	}
	
	/**
	 * The test passingRangeObjectWithSameBounds, tests passing a Range object that has same lower and upper bounds in method equals(Object obj) - Whitebox Testing.
	 */
	@Test
	public void passingRangeObjectWithSameBounds()
	{
		String message = "Passing a range object with lower = -10 and upper = 10, should be equal to Range that is -10 to 10.";
		Range testRange = new Range(-10, 10);
		boolean condition = exampleRange.equals(testRange);
		assertTrue(message, condition);
	}

	/**
	 * The test passingBothNullRangeObjects, tests passing two Range objects that are both null in method combine(Range range1, Range range2) - Whitebox Testing.
	 */
	@Test
	public void passingBothNullRangeObjects()
	{
		String message = "Passing range1 and range2 as both null, will return null.";
		Range combineR1Null = null;
		Range combineR2Null = null;
		Range returnRange = exampleRange.combine(combineR1Null, combineR2Null);
		assertNull(message, returnRange);
	}
	
	
	/**
	 * The test passingRange1AsNullAndRange2AsValid, tests passing two Range objects where range1 is null and range2 is valid in method combine(Range range1, Range range2) - Whitebox Testing.
	 */
	@Test
	public void passingRange1AsNullAndRange2AsValid()
	{
		String message = "Passing range1 as null and range2 as -10 to 10, will return range2.";
		Range combineR1Null = null;
		Range returnRange = exampleRange.combine(combineR1Null, exampleRange);
		boolean condition = true;
		if(returnRange.getLowerBound() != -10)
		{
			condition = false;
		}
		if(returnRange.getUpperBound() != 10)
		{
			condition = false;
		}
		assertTrue(message, condition);
	}
	
	/**
	 * The test passingRange2AsNullAndRange1AsValid, tests passing two Range objects where range2 is null and range1 is valid in method combine(Range range1, Range range2) - Whitebox Testing.
	 */
	@Test
	public void passingRange2AsNullAndRange1AsValid()
	{
		String message = "Passing range2 as null and range1 as -10 to 10, will return range1.";
		Range combineR2Null = null;
		Range returnRange = exampleRange.combine(exampleRange, combineR2Null);
		boolean condition = true;
		if(returnRange.getLowerBound() != -10)
		{
			condition = false;
		}
		if(returnRange.getUpperBound() != 10)
		{
			condition = false;
		}
		assertTrue(message, condition);
	}
	
	/**
	 * The test passingRange1AndRange2TheSame, tests passing two Range objects that are the same in combine(Range range1, Range range2) - Whitebox Testing.
	 */
	@Test
	public void passingRange1AndRange2TheSame()
	{
		String message = "Passing range1 and range2 as -10 to 10, will return a range with the same bounds.";
		Range returnRange = exampleRange.combine(exampleRange, exampleRange);
		boolean condition = true;
		if(returnRange.getLowerBound() != -10)
		{
			condition = false;
		}
		if(returnRange.getUpperBound() != 10)
		{
			condition = false;
		}
		assertTrue(message, condition);
	}
	
	/**
	 * The test passingRange1BiggerThanRange2, tests passing two Range objects where range1 is bigger than range2 in method combine(Range range1, Range range2) - Whitebox Testing.
	 */
	@Test
	public void passingRange1BiggerThanRange2()
	{
		String message = "Passing range1 as -20 to 20 and range2 as -10 to 10, will return a range that is -20 to 20.";
		Range range1Bigger = new Range (-20, 20);
		Range returnRange = exampleRange.combine(range1Bigger, exampleRange);
		boolean condition = true;
		if(returnRange.getLowerBound() != -20)
		{
			condition = false;
		}
		if(returnRange.getUpperBound() != 20)
		{
			condition = false;
		}
		assertTrue(message, condition);
	}
	
	/**
	 * The test passingRange2BiggerThanRange1, tests passing two Range objects where range2 is bigger than range1 in method combine(Range range1, Range range2) - Whitebox Testing.
	 */
	@Test
	public void passingRange2BiggerThanRange1()
	{
		String message = "Passing range1 -10 to 10 and range2 as -20 to 20, will return a range that is -20 to 20.";
		Range range2Bigger = new Range (-20, 20);
		Range returnRange = exampleRange.combine(exampleRange, range2Bigger);
		boolean condition = true;
		if(returnRange.getLowerBound() != -20)
		{
			condition = false;
		}
		if(returnRange.getUpperBound() != 20)
		{
			condition = false;
		}
		assertTrue(message, condition);
	}

	/**
	 * Test getLowerBound function 
	 * Equivalent class test
	 */
	@Test
	public void test_getLowerBound() {
		String message = "Test the lower bound of range -10 to 10 using the getlowerBound method, should return -10";
		double actualResult = exampleRange.getLowerBound();
		double expectedResult = -10;
		assertEquals(message,expectedResult,actualResult,0.00000001d); 
		
	}
	/**
	 * Test getLength function 
	 * Equivalent class test
	 */
	
	@Test
	public void test_getLength() {
		String message = "Test the upper bound of range -10 to 10 using the getUpperBound method, should return 20";
		double actualResult = exampleRange.getLength();
		double expectedResult = 20;
		assertEquals(message,expectedResult,actualResult,0.00000001d); 
		
	}
	
	/**
	 * Test expandToInclude function by passing the value above the upper bound of the range
	 * Equivalent class test
	 *
	 */
	@Test
	public void test_expandToInclude_passing_value_insdie_the_range() {
	
		String message1 = "Test the upper bound of range -10 to 10 after using the expandToInclude function by passing 5.0 to be included";
		String message2 = "Test the lower bound of range -10 to 10 after using the expandToInclude function by passing 5.0 to be included";
		Range.expandToInclude(exampleRange,5.0);
		double actualLower = exampleRange.getLowerBound();
		double actualUpper = exampleRange.getUpperBound();
		double expectedLower = -10;
		double expectedUpper = 10;
		assertEquals(message1,expectedLower,actualLower,0.00000001d); 
		assertEquals(message2,expectedUpper,actualUpper,0.00000001d); 
		
	}
	 

	@Test
	public void test_expandToInclude_passing_value_above_the_upperrange() {
		String message1 = "Test the upper bound of range -10 to 10 after using the expandToInclude function by passing 15.0 to be included";
		String message2 = "Test the lower bound of range -10 to 10 after using the expandToInclude function by passing 15.0 to be included";
		Range test = Range.expandToInclude(exampleRange,15.0);
		double actualLower = test.getLowerBound();
		double actualUpper = test.getUpperBound();
		double expectedLower = -10;
		double expectedUpper = 15;
		assertEquals(message1,expectedLower,actualLower,0.00000001d); 
		assertEquals(message2,expectedUpper,actualUpper,0.00000001d); 
	}
	
	/**
	 * Test expandToInclude function by passing the value below the lower bound of the range
	 * Equivalent class test
	 * 
	 */
	@Test
	public void test_expandToInclude_passing_value_below_the_lowerrange() {
		String message1 = "Test the upper bound of range -10 to 10 after using the expandToInclude function by passing -15.0 to be included";
		String message2 = "Test the lower bound of range -10 to 10 after using the expandToInclude function by passing -15.0 to be included";
		Range test = Range.expandToInclude(exampleRange,-15.0);
		double actualLower = test.getLowerBound();
		double actualUpper = test.getUpperBound();
		double expectedLower = -15;
		double expectedUpper = 10;
		assertEquals(message1,expectedLower,actualLower,0.00000001d); 
		assertEquals(message2,expectedUpper,actualUpper,0.00000001d); 		
	}
	
	/**
	 * Test expandToInclude function by passing int value
	 * Equivalent class test
	 * 
	 */
	
	@Test
	public void test_expandToInclude_passing_integer_value() {
		String message1 = "Test the upper bound of range -10 to 10 after using the expandToInclude function by passing 5 to be included";
		String message2 = "Test the lower bound of range 10 to 10 after using the expandToInclude function by passing 5 to be included";
		Range.expandToInclude(exampleRange,5);
		double actualLower = exampleRange.getLowerBound();
		double actualUpper = exampleRange.getUpperBound();
		double expectedLower = -10;
		double expectedUpper = 10;
		assertEquals(message1,expectedLower,actualLower,0.00000001d); 
		assertEquals(message2,expectedUpper,actualUpper,0.00000001d);
		
	}
	/**
	 * Test expandToInclude function by passing Double value
	 * Equivalent class test
	 * 
	 */
	
	@Test
	public void test_expandToInclude_passing_Double_value() {

		String message1 = "Test the upper bound of range -10 to 10 after using the expandToInclude function by passing Double(5.0) to be included";
		String message2 = "Test the lower bound of range -10 to 10 after using the expandToInclude function by passing Double(5.0) to be included";
		Range.expandToInclude(exampleRange,new Double(5.0));
		double actualLower = exampleRange.getLowerBound();
		double actualUpper = exampleRange.getUpperBound();
		double expectedLower = -10;
		double expectedUpper = 10;
		assertEquals(message1,expectedLower,actualLower,0.00000001d); 
		assertEquals(message2,expectedUpper,actualUpper,0.00000001d);
		
	}
	/**
	 * Test expandToInclude function by passing the value at the upper bound
	 * Boundary value test
	 * 
	 */
	@Test
	public void test_expandToInclude_passing_upper_value() {
		String message1 = "Test the upper bound of range -10 to 10 after using the expandToInclude function by passing 10.0 to be included";
		String message2 = "Test the lower bound of range -10 to 10 after using the expandToInclude function by passing 10.0 to be included";
		Range.expandToInclude(exampleRange,10.0);
		double actualLower = exampleRange.getLowerBound();
		double actualUpper = exampleRange.getUpperBound();
		double expectedLower = -10;
		double expectedUpper = 10;
		assertEquals(message1,expectedLower,actualLower,0.00000001d); 
		assertEquals(message2,expectedUpper,actualUpper,0.00000001d); 
		
	}
	/**
	 * Test expandToInclude function by passing the value just above the upper bound
	 * Boundary value test
	 * 
	 */
	@Test
	public void test_expandToInclude_passing_just_above_upper_value() {
		String message1 = "Test the upper bound of range -10 to 10 after using the expandToInclude function by passing 10.00000001 to be included";
		String message2 = "Test the lower bound of range -10 to 10 after using the expandToInclude function by passing 10.00000001 to be included";
		Range test = Range.expandToInclude(exampleRange, 10.00000001);
		double actualLower = test.getLowerBound();
		double actualUpper = test.getUpperBound();
		double expectedLower = -10;
		double expectedUpper = 10.00000001;
		assertEquals(message1,expectedLower,actualLower,0.00000001d); 
		assertEquals(message2,expectedUpper,actualUpper,0.00000001d); 
		
	}
	/**
	 * Test expandToInclude function by passing the value at the lower bound
	 * Boundary value test
	 * 
	 */
	@Test
	public void test_expandToInclude_passing_lower_value() {
		String message1 = "Test the upper bound of range -10 to 10 after using the expandToInclude function by passing -10.0 to be included";
		String message2 = "Test the lower bound of range -10 to 10 after using the expandToInclude function by passing 10.0 to be included";
		Range.expandToInclude(exampleRange,-10.0);
		double actualLower = exampleRange.getLowerBound();
		double actualUpper = exampleRange.getUpperBound();
		double expectedLower = -10;
		double expectedUpper = 10;
		assertEquals(message1,expectedLower,actualLower,0.00000001d); 
		assertEquals(message2,expectedUpper,actualUpper,0.00000001d); 
		
	}
	/**
	 * Test expandToInclude function by passing the value just below the lower bound
	 * Boundary value test
	 * 
	 */
	@Test
	public void test_expandToInclude_passing_just_below_lower_value() {
		String message1 = "Test the upper bound of range -10 to 10 after using the expandToInclude function by passing -10.00000001 to be included";
		String message2 = "Test the lower bound of range -10 to 10 after using the expandToInclude function by passing -10.00000001 to be included";
		Range test = Range.expandToInclude(exampleRange,-10.00000001);
		double actualLower = test.getLowerBound();
		double actualUpper = test.getUpperBound();
		double expectedLower = -10.00000001;
		double expectedUpper = 10;
		assertEquals(message1,expectedLower,actualLower,0.00000001d); 
		assertEquals(message2,expectedUpper,actualUpper,0.00000001d); 
		
	}
	
	/**
	 * Test expandToInclude function by passing Null Range
	 * Equivalent class test
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void test_expandToInclude_passing_null_Range() {
		String message1 = "Test the upper bound of null Range using the expandToInclude function by passing 5.0 to be included";
		String message2 = "Test the lower bound of null Range using the expandToInclude function by passing 5.0 to be included";
		Range.expandToInclude(nullRange,5.0);
		double actualLower = nullRange.getLowerBound();
		double actualUpper = nullRange.getUpperBound();
		double expectedLower = 5.0;
		double expectedUpper = 5.0;
		assertEquals(message1,expectedLower,actualLower,0.00000001d); 
		assertEquals(message2,expectedUpper,actualUpper,0.00000001d); 
		
	}
	
	/**
	 * Test expand function by passing null Range
	 * Equivalent class test
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_expand_passing_null_range() {
	
	Range.expand(nullRange,0.25,0.5);
		
	}
	
	/**
	 * Test expand function by passing double value
	 * Equivalent class test
	 * 
	 */
	
	@Test
	public void test_expand_passing_integer_value() {
		String message1 = "Test the upper bound of range -10 to 10 after using the expand function by passing upperMargin 0.5 to be expand";
		String message2 = "Test the lower bound of range -10 to 10 after using the expand function by passing lowerMargin 0.25 to be expand";
		Range test = Range.expand(exampleRange,0.25,0.5);
		double actualLower = test.getLowerBound();
		double actualUpper = test.getUpperBound();
		double expectedLower = -15;
		double expectedUpper = 20;
		assertEquals(message1,expectedLower,actualLower,0.00000001d); 
		assertEquals(message2,expectedUpper,actualUpper,0.00000001d);
		
	}
}