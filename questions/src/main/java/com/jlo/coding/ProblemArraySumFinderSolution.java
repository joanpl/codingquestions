package com.jlo.coding;

public class ProblemArraySumFinderSolution<Integer> implements ISolution {
	
	private boolean isSolved ;
	public Integer getFirst() {
		return first;
	}

	public void setFirst(Integer first) {
		this.first = first;
	}

	public Integer getSecond() {
		return second;
	}

	public void setSecond(Integer second) {
		this.second = second;
	}

	private Integer first;
	private Integer second;
	
	private Integer solution;

	public ProblemArraySumFinderSolution(Integer solution) {
		this.isSolved = first !=null && second != null;
		this.solution = solution;
	}

	public boolean getSolved() {
		return isSolved;
	}
	
	public boolean isSolved() {
		
		
		if (!(this.isSolved = first !=null && second != null))
			return false;
		
		int result = (int)this.first + (int)this.second;
		return (int)solution == result;
		
			
	}

	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}

	public String toString() {
		return "solution value["+this.solution+"] is solved ["+ this.getSolved()+"] \n First["+this.first+"]" + "Second["+this.second+"]";
	}
}