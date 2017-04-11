package com.jlo.coding;

import java.util.ArrayList;
import java.util.StringJoiner;

public class ProblemValueRemovalSolution<T> implements ISolution {
	
	private Integer solvedRemoval ;
	
	private boolean isSolved = false;


	private ArrayList<Integer> solution  = new ArrayList<Integer>();
	
	
	public ProblemValueRemovalSolution(Integer toBeRemoved) {
	this.setSolvedRemoval(toBeRemoved);
	}
	
	
	public void setSolution(ArrayList<Integer> solution)
	{
		this.solution = solution;
	}


	@Override
	public boolean getSolved() {
		
		return this.isSolved;
	}


	@Override
	public boolean isSolved() {
		// TODO Auto-generated method stub
		return this.isSolved;
	}


	@Override
	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
		
	}


	public Integer getSolvedRemoval() {
		return solvedRemoval;
	}


	public void setSolvedRemoval(Integer solvedRemoval) {
		this.solvedRemoval = solvedRemoval;
	}
	
	
	public String toString() {
		StringJoiner joiner = new StringJoiner(";");
		solution.forEach(e ->joiner.add(e.toString()));
		return joiner.toString();
	}
}
