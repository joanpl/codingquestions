package com.jlo.coding.model;

public class Position {
	
	private int column;
	private int row;
	
	
	
	public Position(int row, int column){
		this.column = column;
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	//CHECK Edges.
	public Position getLeft() {
		Position p =new Position(this.row, this.column-1); 
		return p;
	}
	
	public boolean hasLeft() {
		return this.column -1 >=0;
	}
	//CHECK Edges.
	public Position getRight() {
		Position p =new Position(this.row, this.column+1); 
		return p;
	}
	
	public boolean hasRight(int max) {
		return this.column+1 <max;
	}

	//CHECK Edges.
	public Position getDown() {
		Position p =new Position(this.row+1, this.column); 
		return p;
	}
	
	public boolean hasDown(int max) {
		return this.row +1 < max;
	}
	//CHECK Edges.
	public Position getUp() {
		Position p =new Position(this.row-1, this.column); 
		return p;
	}
	
	public boolean hasUp() {
		return this.row-1 >=0;
	}
	
	  @Override
	    public boolean equals(Object o) {

	        if (o == this) return true;
	        if (!(o instanceof Position)) {
	            return false;
	        }

	        Position p = (Position) o;

	      return this.row == p.getRow() && this.column == p.getColumn();
	    }

	    @Override
	    public int hashCode() {
	    	 return (Integer.toString(this.row) + "," + Integer.toString(this.column)).hashCode();
	        
	    }
	
	
}
