package com.jlo.coding.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.jlo.coding.exception.ProblemInputException;

public abstract class AbstractProblem<T> implements IProblem<T> {

	private ISolution solution;

	public ISolution getSolution() {
		return solution;
	}

	public void setSolution(ISolution solution) {
		this.solution = solution;
	}
	
	public void resetProblem() {
		this.solution = null;
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> generateRandomInput(Optional<Integer> maxSize) {
		Random number = new Random();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int size = maxSize!=null && maxSize.isPresent()? maxSize.get() : 10;
		if (size < 0)
			throw new ProblemInputException("array size needs to be >=0");
		if(size == 0)
			return (List<T>)result;
		Integer[] randomArray = new Integer[size];
		int count = 0;
		while(count < size) {
			randomArray[count] = number.nextInt(size);
			count++;
		}
		Arrays.sort(randomArray);
		Collections.addAll(result, randomArray);
		
		return (List<T>) result;
		
		
	}
	
	/**
	 * Returns a psuedo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimim value
	 * @param max Maximim value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	

}
