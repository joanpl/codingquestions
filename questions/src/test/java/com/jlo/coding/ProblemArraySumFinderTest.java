package com.jlo.coding;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Before;
import org.junit.Test;

import com.jlo.coding.exception.ProblemInputException;

public class ProblemArraySumFinderTest {
	
	
	ProblemArraySumFinder<Integer> test1;

	@Before
	public void setUp() throws Exception {
		test1 = new ProblemArraySumFinder<Integer>();
	}

	@Test
	public void testRunProblem() {
		
		int count = 10;
		while(count>0){
			
			int listSize = ProblemArraySumFinder.randInt(-1000, 5000);
			
			int result = ProblemArraySumFinder.randInt(-500, 2500);
			
			test1.initializeProblem(test1.generateRandomInput(Optional.of(listSize)), Optional.ofNullable(result));	
			test1.solveProblem();
		
			test1.getRandomInput().forEach(item->System.out.print("["+item+"]"));
			System.out.println("SOLUTION");
			System.out.println(test1.getSolution().toString());
			
			count--;
		}
	}

	
	
	
	@Test(expected = ProblemInputException.class)
	public void testInitializeProblemNull(){
		test1.initializeProblem(null, null);		
		
	}
	
	
	@Test
	public void testInitializeProblemDefault(){
		test1.initializeProblem(test1.generateRandomInput(Optional.of(20)),Optional.ofNullable( null));	
		 assertThat(test1.getRandomInput().size(), is(20));
		 assertThat(test1.getSumResult(), is(ProblemArraySumFinder.defaultSUM));
		
	}
	
	@Test
	public void testInitializeProblemWithSum(){
		test1.initializeProblem(test1.generateRandomInput(Optional.of(30)), Optional.ofNullable(8));	
		 assertThat(test1.getRandomInput().size(), is(30));
		 assertThat(test1.getSumResult(), is(8));
	}
	
	@Test
	public void testGenerateRandomInpuNull() {
		List<Integer> result = test1.generateRandomInput(null);
		System.out.println("testing null");
		assertNotNull(result);
		  //3. Check List Size
        assertThat(result.size(), is(10)); //default size
	}
	
	
	@Test(expected = ProblemInputException.class)
	public void testGenerateRandomInpuNegative() {
		Integer input = new Integer(-1);
		List<Integer> result = test1.generateRandomInput(Optional.ofNullable(input));
		System.out.println("testing negative");
		assertNotNull(result);
		
	}

	@Test
	public void testGenerateRandomInpuEmpty() {
		Integer input = new Integer(0);
		List<Integer> result = test1.generateRandomInput(Optional.ofNullable(input));
		System.out.println("testing empty");
		assertNotNull(result);
		System.out.println(result.size());
        //3. Check List Size
        assertThat(result.size(), is(0));

        //5. check empty list
        assertThat(result, is(IsEmptyCollection.empty()));

       
		
	}
	
	
	@Test
	public void testGenerateRandomInpu1000() {
		Integer input = new Integer(1000);
		List<Integer> result = test1.generateRandomInput(Optional.ofNullable(input));
		System.out.println("testing 1000");
		assertNotNull(result);
		  //3. Check List Size
        assertThat(result.size(), is(1000));
	}
}
