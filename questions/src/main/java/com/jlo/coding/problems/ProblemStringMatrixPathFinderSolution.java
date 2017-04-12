package com.jlo.coding.problems;

import java.util.ArrayList;

import com.jlo.coding.model.Node;
import com.jlo.coding.model.Position;

public class ProblemStringMatrixPathFinderSolution implements ISolution {

	private String match;
	private ArrayList<Node> solution = new ArrayList<Node>();
	
	private boolean isSolved;
	
	
	public void printSolution() {
		solution.forEach(n -> System.out.println(n.toString()));
	}
	
	@Override
	public boolean getSolved() {
		// TODO Auto-generated method stub
		return this.isSolved;
	}

	@Override
	public boolean isSolved() {
		//change to jaa 8 too tired to do it now
		if(solution.size() != match.length())
		{
			setSolved(false);
		
		}
		else {
			boolean match = true;
		
			for(int i = 0; i<  solution.size() && match; i++)
			{
				match = solution.get(i).getValue() == this.match.charAt(i);
			}
			setSolved(match);
		}
		
		
		return this.getSolved();
	}

	@Override
	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;

	}

	public ArrayList<Node> getSolution() {
		return solution;
	}

	public void setSolution(ArrayList<Node> solution) {
		this.solution = solution;
	}

	public String getMatch() {
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}

	public void reset() {
		this.solution = new ArrayList<Node> ();
		this.isSolved = false;
	}

}
