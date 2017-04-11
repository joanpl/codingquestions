package com.jlo.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.jlo.coding.exception.ProblemInputException;
import com.jlo.coding.exception.UnsolvableProblemException;

/**
 * http://codercareer.blogspot.co.uk/2011/10/no-09-numbers-with-given-sum.html
 * Problem 1: Given an increasingly sorted array and a number s, please find two numbers whose sum is s.
 * If there are multiple pairs with sum s, just output any one of them.
 * For example, if the inputs are an array {1, 2, 4, 7, 11, 15} and a number 15,
 * please out two numbers 4 and 11 since 4+11=15.
 * @author jlo
 *
 */
public class ProblemArraySumFinder<T> implements IProblem<T> {
	
	
	public static final Integer defaultSUM = 2;
	
	// is this an integer?
	private Integer sumResult;
	
	private ProblemArraySumFinderSolution<Integer> solution;
	private ArrayList<Integer> randomInput = new ArrayList<Integer>();

	@Override
	public void solveProblem() {
		
		if(randomInput.isEmpty() || randomInput.size() < 2)
		{
			throw new UnsolvableProblemException();
		}
		recursiveSolving(randomInput.toArray(), 0);
			
		
	}
	
	
	public void recursiveSolving(Object[] objects , int cursor) {
		
		if (objects.length <2) return;
		solution.setFirst((int)objects[cursor]);
		if (objects.length == 2 || cursor > objects.length-2) {
			solution.setSecond((int)objects[1]);
				return;
			
		}	
		
		for(int i = cursor ; i < objects.length; i++)
		{
			solution.setSecond((int)objects[i]);
			if(solution.isSolved())
				return;
		}
		cursor++;
		recursiveSolving( objects, cursor);
		
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


	@SuppressWarnings("unchecked")
	@Override
	public void initializeProblem(List<T> input, Optional<T> result) {
		try {
			if (input instanceof ArrayList<?>)
				this.setRandomInput((ArrayList<Integer>) input);
			if (result.isPresent()) {
				this.setSumResult((Integer) result.get());
			}
			else
				this.setSumResult(defaultSUM);
			
			this.setSolution(new ProblemArraySumFinderSolution<Integer> (this.getSumResult()));
			
		}catch (Exception e) { 
			throw new ProblemInputException(e.getMessage());
		}
	}

	
	public void resetProblem() {
		this.randomInput = new ArrayList<Integer>();
		this.sumResult = defaultSUM;
		this.solution.resetSolution(this.sumResult);
	}

	private void setRandomInput(ArrayList<Integer> input) {
		this.randomInput = input;
		
	}


	public ArrayList<Integer> getRandomInput() {
		return randomInput;
	}


	public Integer getSumResult() {
		return sumResult;
	}


	public void setSumResult(Integer sumResult) {
		this.sumResult = sumResult;
	}


	public ProblemArraySumFinderSolution<Integer> getSolution() {
		return solution;
	}


	public void setSolution(ProblemArraySumFinderSolution<Integer> solution) {
		this.solution = solution;
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
