package com.jlo.coding;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Before;
import org.junit.Test;

import com.jlo.coding.exception.ProblemInputException;
import com.jlo.coding.exception.UnsolvableProblemException;

public class ProblemValueRemovalTest {
	ProblemValueRemoval problem;

	@Before
	public void setUp() throws Exception {

	problem = new ProblemValueRemoval();
	}
	
	@Test(expected = ProblemInputException.class)
	public void testInitializeProblemNull(){
		problem.initializeProblem(null, null);		
		
	}
	
	@Test
	public void testRunProblem() {
		
		int count = 1;
		while(count>0){
			
			int listSize = 10; //ProblemValueRemoval.randInt(0, 20);
			
			int result = 2;//ProblemValueRemoval.randInt(0, 5);
			try{
			problem.initializeProblem(problem.generateRandomInput(Optional.of(listSize)), Optional.ofNullable(result));	
			problem.solveProblem();
			} catch (ProblemInputException e) {
				System.out.println(e.getMessage());
			}catch (UnsolvableProblemException e) {
				System.out.println(e.getMessage());
			}
			problem.getValues().forEach(item->System.out.print("["+item+"]"));
			System.out.println("Value to be found:");
			System.out.println(problem.getToBeRemoved());;
			System.out.println("SOLUTION");
			System.out.println(problem.getSolution().toString());
			
			count--;
		}
	}

	
	
	
	@Test
	public void testInitializeProblemDefault(){
		problem.initializeProblem(problem.generateRandomInput(Optional.of(20)),Optional.ofNullable( null));	
		 assertThat(problem.getValues().size(), is(20));
		 assertThat(problem.getToBeRemoved(), is(ProblemValueRemoval.defaultValueRemoval));
		
	}
//	
	@Test
	public void testInitializeProblemWithSum(){
		problem.initializeProblem(problem.generateRandomInput(Optional.of(30)), Optional.ofNullable(8));	
		 assertThat(problem.getValues().size(), is(30));
		 assertThat(problem.getToBeRemoved(), is(8));
	}

}
