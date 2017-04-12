package com.jlo.coding.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import com.jlo.coding.exception.UnsolvableProblemException;
import com.jlo.coding.model.MyGraph;
import com.jlo.coding.model.Node;
import com.jlo.coding.model.Position;


/**Question: How to implement a function to check whether there is a path for a string in a matrix of characters? 
 *  It moves to left, right, up and down in a matrix, and a cell for a movement. 
 *  The path can start from any entry in a matrix. If a cell is occupied by a character of a string on the path,
 *   it cannot be occupied by another character again.
 *   For example, the matrix below with three rows and four columns has a path for the string “BCCED” 
 *   (as highlighted in the matrix). It does not have a path for the string “ABCB”, 
 *   because the first “B” in the string occupies the “B” cell in the matrix, and the second “B” 
 *   in the string cannot enter into the same cell again.
 *   
 *    A 'B 'C E
 *    S F 'C S
 *    A 'D 'E E
**/

public class ProblemStringMatrixPathFinder extends AbstractProblem {
	
	
	private MyGraph graph;
	
	private int complexity = 0;
	
	public ProblemStringMatrixPathFinderSolution getSolution() {
		return solution;
	}

	public void setSolution(ProblemStringMatrixPathFinderSolution solution) {
		this.solution = solution;
	}

	public MyGraph getGraph() {
		return graph;
	}

	private ProblemStringMatrixPathFinderSolution solution = new ProblemStringMatrixPathFinderSolution();
	private ArrayList<Node> starting = new ArrayList<Node>();

	
	
	@Override
	public void solveProblem() {
		// TODO Auto-generated method stub
	
		
		HashMap<Position, Node> nodes =graph.getVertexs();
//		ArrayList<Node> startingNodes = nodes.entrySet().stream()
//				.filter(map -> solution.getMatch().charAt(0)==(map.getValue().getValue()))
//				.map(map->map.getValue()).collect(Collector.)
		
		nodes.forEach( (k,v) ->
		{
			if(v.getValue() == this.solution.getMatch().charAt(0))
			{
				v.setStartingPoint(true);
				starting.add(v);						}
			
		});
		
		for ( Node n: starting) {
			solution.getSolution().add(n);
			n.setVisited(true);
			setComplexity(getComplexity() + 1);
			findPath(n, 1);
			if (solution.isSolved())
				break;
			else {
				solution.reset();
				graph.reset();
			}
		}
		
		if(starting.isEmpty())
			throw new UnsolvableProblemException();
		
		
	}
	
	public void findPath(Node start, int i) {
		//Start
		
		if( i == solution.getMatch().length() )
			return;
		if(solution.isSolved())
			return;
			
		if(! (i < solution.getMatch().length())){
			this.solution.getSolution().remove(i-1);
			return;
		}
		if(!solution.isSolved() && start.hasDown() && !start.getDown().isVisited()){
			if(start.getDown().getValue() == solution.getMatch().charAt(i)){
				this.solution.getSolution().add(start.getDown());
				setComplexity(getComplexity() + 1);
				findPath(start.getDown(), i + 1);
			}
		}		
		if(!solution.isSolved() && start.hasRight() && !start.getRight().isVisited()){
			if(start.getRight().getValue() == solution.getMatch().charAt(i)){
				this.solution.getSolution().add(start.getRight());
				setComplexity(getComplexity() + 1);
				findPath(start.getRight(), ++i);
			}
		}	
		
		if(!solution.isSolved() && start.hasUp() && !start.getUp().isVisited()){
			if(start.getUp().getValue() == solution.getMatch().charAt(i)){
				this.solution.getSolution().add(start.getUp());
				setComplexity(getComplexity() + 1);
				findPath(start.getUp(), ++i);
			}
		}
		if(!solution.isSolved() && start.hasLeft() && !start.getLeft().isVisited()){
			if(start.getLeft().getValue() == solution.getMatch().charAt(i)){
				this.solution.getSolution().add(start.getLeft());
				setComplexity(getComplexity() + 1);
				findPath(start.getLeft(), ++i);
			}
		}
		
	
		
	}
	

	@Override
	public void initializeProblem(List input, Optional result) {
		if(result.isPresent())
		{
			solution.setMatch(result.get().toString());
		}
		else
			solution.setMatch("BA");
		
		graph = new MyGraph((char[][]) input.toArray());

	}
	
	public void initializeProblem(char[][] input, Optional result) {
		if(result.isPresent())
		{
			solution.setMatch(result.get().toString());
		}
		else
			solution.setMatch("BA");
		graph = new MyGraph(input);
		

	}

	public int getComplexity() {
		return complexity;
	}

	public void setComplexity(int complexity) {
		this.complexity = complexity;
	}

}
