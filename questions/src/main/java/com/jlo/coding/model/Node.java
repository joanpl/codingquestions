package com.jlo.coding.model;

public class Node {
	
	public Node( char value, Position position, int maxDown, int maxRight) {
		
		this.value = value;
		this.position = position;
		this.maxDown = maxDown;
		this.maxRight = maxRight;
	}
	private Node right;
	private Node left;
	
	private Node down;
	private Node up;
	
	private char value;
	
	private Position position;
	
	
	private boolean visited = false;
	private boolean startingPoint = false;
	
	private int maxDown =0;
	private int maxRight=0;
	
	
	public boolean isEdge(int maxDown, int maxRight) {
		return !position.hasDown(maxDown) && !position.hasRight(maxRight);
	}
	
	public Node getRight() {
		return this.right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getLeft() {
		return this.left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getDown() {
		return this.down;
	}
	public void setDown(Node down) {
		this.down = down;
	}
	public Node getUp() {
		return up;
	}
	public void setUp(Node up) {
		this.up = up;
	}
	public char getValue() {
		return value;
	}
	public void setValue(char value) {
		this.value = value;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public boolean isStartingPoint() {
		return startingPoint;
	}
	public void setStartingPoint(boolean startingPoint) {
		this.startingPoint = startingPoint;
	}
	
	
	public String toString() {
		String result ="value[" +value+"] position["+position.getRow()+"]["+position.getColumn()+"] ";
		
		
		result +=(right!=null)?	 "Right["+right.getValue() +"]" : "";
		result +=(left!=null)?	 "Left["+left.getValue() +"]" : "";
		result +=(up!=null)?	 "Up["+up.getValue() +"]" : "";
		result +=(down!=null)?	 "Down["+down.getValue() +"]" : "";
		return result;
	
	}

	public boolean hasDown() {
		return position.hasDown(maxDown);
	}
	
	public boolean hasUp() {
		return position.hasUp();
	}
	
	public boolean hasRight() {
		return position.hasRight(maxRight);
	}
	
	public boolean hasLeft() {
		return position.hasLeft();
	}

	public int getMaxDown() {
		return maxDown;
	}

	public void setMaxDown(int maxDown) {
		this.maxDown = maxDown;
	}
	
	

}
