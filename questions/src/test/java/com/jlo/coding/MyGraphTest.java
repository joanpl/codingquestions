package com.jlo.coding;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jlo.coding.model.MyGraph;

public class MyGraphTest {

	MyGraph graph ;
	
	char matrix[][] = {{'A', 'B', 'C'}, {'D', 'A', 'C'}};
	@Before
	public void setUp() throws Exception {
		
		
	}

	@Test
	public void testInitialize() {
		graph = new MyGraph(matrix);
		graph.printGraph();
		graph.printNodes();
		
	}

}
