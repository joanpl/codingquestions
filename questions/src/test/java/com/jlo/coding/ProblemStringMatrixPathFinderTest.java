package com.jlo.coding;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.jlo.coding.problems.ProblemStringMatrixPathFinder;

public class ProblemStringMatrixPathFinderTest {

	char matrix[][] = {{'F', 'B', 'B'}, {'F', 'A', 'A'}, {'D','B','F'}};
	ProblemStringMatrixPathFinder finder = new ProblemStringMatrixPathFinder();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		//THIS IS CERTAINLY NOT OPTIMIZE // NEED TO SLEEP -> ZzzzZzzz
		finder.initializeProblem(matrix, Optional.of("FAB"));
		finder.getGraph().printGraph();
		//finder.getGraph().printNodes();
		
		System.out.println("FIND: FAB" );
		finder.solveProblem();
		System.out.println("Is it Solved?" );
		System.out.println(finder.getSolution().isSolved());
		System.out.println("Solution" );
		finder.getSolution().printSolution();
		System.out.println("Resursion executions:" );
		System.out.println(finder.getComplexity());
		
	}

}
