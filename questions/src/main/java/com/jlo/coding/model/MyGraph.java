package com.jlo.coding.model;

import java.util.ArrayList;
import java.util.HashMap;

public class MyGraph {
	
	
	
	private char[][] matrix;
	private Node[][] graph;
	private int maxRows;
	private int maxColumns;
	
	private int complexity =0;
	
	HashMap<Position, Node> vertexs ;
	
	public  MyGraph(char[][] matrix) {
		
		this.matrix = matrix;
		this.maxRows = matrix.length;
		this. maxColumns = matrix[0].length;
		this.graph  = new Node[maxRows][maxColumns];
		this.vertexs = new HashMap<Position, Node>();
		Position p = new Position(0,0);
		Node start = new Node(matrix[0][0], p , maxRows, maxColumns);
		this.vertexs.put(p, start);
		buildGraph(start);
	}
	
	public char[][] getMatrix() {
		return matrix;
	}

	public Node[][] getGraph() {
		return graph;
	}

	public int getMaxRows() {
		return maxRows;
	}

	public int getMaxColumns() {
		return maxColumns;
	}

	public HashMap<Position, Node> getVertexs() {
		return vertexs;
	}

	public void printGraph() {
		
		for(int i = 0; i < maxRows; i++)
		{
			
			System.out.print("[");
			for(int j = 0 ; j< maxColumns; j++){
				System.out.print(this.graph[i][j].getValue());
				if (j == maxColumns -1)
					System.out.println("]");
			}
		}
		System.out.println("Complexity["+complexity+"]");
	}
	
	public void printNodes() {
		vertexs.entrySet().forEach(entry -> {
		    System.out.println(" Node : " + entry.getValue().toString() );
		}); 
	}
	
	
	private void buildGraph( Node start) {
		
		Position p = start.getPosition();
		graph[p.getRow()][p.getColumn()] = start;
		//DOWN
		if(p.hasDown(maxRows)){
			Position down = p.getDown();
			char value = matrix[down.getRow()][down.getColumn()];
			if(vertexs.get(down)!=null){
				
				Node downNode = vertexs.get(down);
				if(downNode.getUp() ==null){
					downNode.setUp(start);
					start.setDown(downNode);
				}
			}
			else {
				Node newNode = new Node(value, down, maxRows, maxColumns);
				newNode.setUp(start);
				start.setDown(newNode);
				vertexs.put(down, newNode);
				complexity++;
				buildGraph(newNode);
			}
		}
	
		//UP
		if(p.hasUp()){
			Position up = p.getUp();
			char value = matrix[up.getRow()][p.getColumn()];
			if(vertexs.get(up)!=null){
				
				Node upNode = vertexs.get(up);
				if(upNode.getDown() ==null)
					upNode.setDown(start);
			}
			else {
				Node newNode = new Node(value, up, maxRows, maxColumns);
				newNode.setDown(start);
				start.setUp(newNode);
				vertexs.put(up, newNode);
				complexity++;
				buildGraph(newNode);
			}
		}
		
		
		//Right
		if(p.hasRight(maxColumns)){
			Position right = p.getRight();
			char value = matrix[right.getRow()][right.getColumn()];
			if(vertexs.get(right)!=null){
				
				Node rightNode = vertexs.get(right);
				if(rightNode.getLeft() ==null)
					rightNode.setLeft(start);
			}
			else {
				Node newNode = new Node(value, right,  maxRows, maxColumns);
				newNode.setLeft(start);
				start.setRight(newNode);
				vertexs.put(right, newNode);
				complexity++;
				buildGraph(newNode);
			}
		}
		else start.setRight(null);
		//LEFT
		if(p.hasLeft()){
			Position left = p.getLeft();
			char value = matrix[left.getRow()][left.getColumn()];
			if(vertexs.get(left)!=null){
				
				Node leftNode = vertexs.get(left);
				if(leftNode.getRight() ==null){
					leftNode.setRight(start);
					
				}
			}
			else {
				Node newNode = new Node(value, left,  maxRows, maxColumns);
				newNode.setRight(start);
				start.setLeft(newNode);
				vertexs.put(left, newNode);
				complexity++;
				buildGraph(newNode);
			}
		}
		else start.setLeft(null);;
		
	}

	public void reset() {
		vertexs.forEach( (k,n) -> n.setVisited(false));
		
	}

}
