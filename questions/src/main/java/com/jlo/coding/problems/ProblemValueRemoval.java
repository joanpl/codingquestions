package com.jlo.coding.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.jlo.coding.exception.ProblemInputException;

/**
 *  No. 32 - Remove Numbers in Array

Question: Given an array and a value, how to implement a function to remove all instances of that value in place and return the new length? The order of elements can be changed. It doesn't matter what you leave beyond the new length.

For example, if the input array is {4, 3, 2, 1, 2, 3, 6}, the result array after removing value 2 contains numbers {4, 3, 1, 3, 6}, and the new length of the remaining array is 5.
 * @author jlo
 *
 */

public class ProblemValueRemoval extends AbstractProblem<Integer>{
	
	public static final Integer defaultValueRemoval = 2;

	private ArrayList<Integer> values = new ArrayList<Integer>();
	
	private Integer toBeRemoved;

	@Override
	public void solveProblem() {
	
		
		ArrayList<Integer> newValues = new ArrayList<Integer>();
	
		for (Integer item: values) {
			if(item.compareTo(toBeRemoved)== 0)
				continue;
			else
				newValues.add(item);
		}
		
		
		ProblemValueRemovalSolution<Integer> solved = (ProblemValueRemovalSolution<Integer>)this.getSolution();
		solved.setSolution(newValues);
		
	}



	@Override
	public void initializeProblem(List<Integer> input, Optional<Integer> result) {
		
		
		
		try {
			if (input instanceof ArrayList<?>)
				this.setValues(((ArrayList<Integer>) input));
			if (result.isPresent()) {
				this.setToBeRemoved(((Integer) result.get()));
			}
			else
				this.setToBeRemoved(defaultValueRemoval);
			
			this.setSolution(new ProblemValueRemovalSolution<Integer> (this.getToBeRemoved()));
			
		}catch (Exception e) { 
			throw new ProblemInputException(e.getMessage());
		}
		
	}

	public Integer getToBeRemoved() {
		return toBeRemoved;
	}

	public void setToBeRemoved(Integer toBeRemoved) {
		this.toBeRemoved = toBeRemoved;
	}

	public ArrayList<Integer> getValues() {
		return values;
	}

	public void setValues(ArrayList<Integer> values) {
		this.values = values;
	}

}
