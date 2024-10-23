package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		if (n == 0) {
			return 0;
		}
		double sum = 1/ (Math.pow(2, n)) + geometricSum (n-1);
		
			// FIXME compute the geometric sum for the first n terms recursively
			return sum;
		
	}
	
	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		double bound = 5.0;
		StdDraw.setXscale(-bound, bound);
		StdDraw.setYscale(-bound, bound);
		// base case
		if (radius < radiusMinimumDrawingThreshold) {
			return;
		}
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.circle (xCenter, yCenter, radius);
		//top circle
		circlesUponCircles (xCenter, yCenter + radius, radius/3, radiusMinimumDrawingThreshold);
		//right circle
		circlesUponCircles (xCenter + radius, yCenter, radius/3, radiusMinimumDrawingThreshold);
		//bottom circle
		circlesUponCircles (xCenter, yCenter - radius, radius/3, radiusMinimumDrawingThreshold);
		//left circle
		circlesUponCircles (xCenter - radius, yCenter, radius/3, radiusMinimumDrawingThreshold);

	}

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		//create a new array
		int [] reversedArray = new int[array.length];
		//call helper method
		reversedHelper(array, reversedArray, 0);
			return reversedArray;
		
	}
	
	public static void reversedHelper (int[] original, int[] reversed, int index) {
		//base case
		if (index >= original.length) {
			return;
		}
		//set the current index in the reversed array
		reversed[index] = original[original.length - 1 - index];
		//next index
		reversedHelper (original, reversed, index+1);
	}
	
	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		if (q == 0) {
			return p;
		}
		return gcd(q, p % q );

		
	}

}
