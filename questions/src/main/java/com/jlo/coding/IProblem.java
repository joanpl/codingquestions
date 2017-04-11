package com.jlo.coding;

import java.util.List;
import java.util.Optional;

public interface IProblem<T> {
	
	
	void solveProblem();
	
	List<T> generateRandomInput(Optional<Integer> maxSize);

	void initializeProblem(List<T> input, Optional<T> result);



}
