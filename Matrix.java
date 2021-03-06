/* Team (͡° ͜ʖ ͡°) - Sarah Yoon, Zicheng Zhen
   APCS1 - pd10
   HW55 -- Don't Think You Are, Know You Are / Upgraded Matrices
   2015-01-06 */

/*====================================
  class Matrix -- models a square matrix

  Runtime Classifications:
  Constructors: O(1)
  size():       O(1)
  get():        O(1)
  getRow():     O(1)
  getCol():     O(n)
  set():        O(1)
  setRow():     O(1)
  setCol():     O(n)
  isFull():     O(n^2)
  isEmpty():    O(1)
  toString():   O(n^2)
  equals():     O(n^2)
  swapRows():   O(1)
  swapColumns():O(n)
  transpose():  O(n)
  contains():   O(n^2)
  ====================================*/ 

public class Matrix {
    // INSTANCE VARIABLES ----------------------------------------
    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;
    private Object[][] matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix( ) {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }
    //constructor intializes an a*a matrix
    public Matrix( int a ) {
	this();
	matrix = new Object[a][a];
    }

    //return size of this matrix, where size is 1 dimension
    private int size() {
	return matrix.length;
    }

    // ACCESSORS & MUTATORS ----------------------------------------
    //return the item at the specified row & column   
    private Object get( int r, int c ) {
	return matrix[r][c];
    }
    //return row r
    public Object[] getRow( int r ) {
	return matrix[r];
    }
    //return column c
    public Object[] getCol( int c ) {
	Object[] ret = new Object[size()];
	for (int i = 0; i<size(); i++) {
	    ret[i] = get(i,c);
	}
	return ret;
    }

    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	Object old = get(r,c);
	matrix[r][c] = newVal;
	return old;
    }
    //set row r to newRow, return old row
    public Object[] setRow( int r, Object[] newRow ) {
	Object[] ret = getRow(r);
	matrix[r] = newRow;
	return ret;
    }
    //set column c to newCol, return old column
    public Object[] setCol( int c, Object[] newCol ) {
	Object[] ret = getCol(c);
	int size = this.size();
	for (int i = 0; i < size; i++) {
	    set(i,c,newCol[i]);
	}
	return ret;
    }
    
    // METHODS ----------------------------------------
    //return true if all cells are filled, false otherwise
    private boolean isFull() {
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[i].length; j++) {
		if (get(i,j) == null) 
		    return false;
	    }
	}
	return true;
    }
    
    // return true if a specified cell of the matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
	return get(r,c) == null;
    }

    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	String ret = "";
	for (int r = 0; r < matrix.length; r++) {
	    ret += "|";
	    for (int c = 0; c < matrix[r].length; c++) {
		ret += get(r,c) + "\t";
	    }
	    ret += "|\n";
	}
	return ret;
    }

    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) {	
	if (rightSide == this) 
	    return true;
	if (rightSide instanceof Matrix) {
	    Matrix r = (Matrix)rightSide;
	    if (r.size() == this.size()) {
		for (int i = 0; i < this.size(); i++) {
		    for (int j = 0; j < this.size(); j++) {
			if (!(r.get(i,j) == null && this.get(i,j) == null) &&
			    !(r.get(i,j).equals(this.get(i,j))))
			    return false;
		    }
		}
		return true;
	    }
	} 
	return false;
    }

    //swap two columns of this matrix 
    //(0,0) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
	int size = this.size();
	for (int i = 0; i < size; i++) {
	    Object old_c1 = matrix[i][c1];
	    matrix[i][c1] = matrix[i][c2];
	    matrix[i][c2] = old_c1;
	}
    }

    //swap two rows of this matrix 
    //(0,0) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
	Object[] old_r1 = matrix[r1];
	matrix[r1] = matrix[r2];
	matrix[r2] = old_r1;
    }

    //transposes the matrix (flips matrix across center diagonal)
    public void transpose() {
	int size = this.size();
	Object[][] ret = new Object[size][size];
	for (int i = 0; i < size; i++) {
	    ret[i] = this.getCol(i);
	}
	matrix = ret;
    }

    //returns true if matrix contains o, false otherwise
    public boolean contains( Object o ) {
	for (int r=0; r<size(); r++){
	    for (int c=0; c<size(); c++) {
		if (!isEmpty(c,r) && get(c,r).equals(o)) {
		    return true;
		}
	    }
	}
	return false;
    }

    //main method for testing
    public static void main( String[] args ) {
	// Creating matrices:
	Matrix m1 = new Matrix();
	Matrix m2 = new Matrix(3);
	Matrix m3 = new Matrix();

	// toString and size and isFull:
	System.out.println("Matrix 1: Size " + m1.size() + "\n" + m1);
	System.out.println("Matrix 2: Size " + m2.size() + "\n" + m2);
	System.out.println("Matrix 1 full? " + m1.isFull());
	System.out.println("Matrix 2 full? " + m2.isFull());
	System.out.println("Cell 0,0 of Matrix 1,2 empty? " + m1.isEmpty(0,0)
			   + "\t" + m2.isEmpty(0,0) + "\n");

	// Populate Matrices:
	for (int i = 0; i < 2; i++)
	    for (int j = 0; j < 2; j++)
		m1.set(i,j, (int)((Math.random() * 100)));
	for (int i = 0; i < 3; i++)
	    for (int j = 0; j < 3; j++)
		m2.set(i,j, (int)((Math.random() * 1000)));
	System.out.println("Matrix 1: Populated\n" + m1);
	System.out.println("Matrix 2: Populated\n" + m2);
	
	// Swap columns and rows:
	m1.swapColumns(0,1); m1.swapRows(0,1);
	m2.swapColumns(0,2); m2.swapRows(0,2);
	System.out.println("Matrix 1: Swapped\n" + m1);
	System.out.println("Matrix 2: Swapped\n" + m2);

	// Equals:
	// Populating Matrix 3 so it matches Matrix 1;
	for (int i = 0; i < 2; i++)
	    for (int j = 0; j < 2; j++)
		m3.set(i,j,m1.get(i,j));
	System.out.println("Matrix 3: \n" + m3);
	System.out.println("Matrix 3 equals Matrix 1:\n" + m3.equals(m1));
	System.out.println("Matrix 3 equals Matrix 2:\n" + m3.equals(m2));

	// SetCol, SetRow:
	m1.setRow(0, new Object[]{1,1});
	m1.setRow(1, new Object[]{2,2});
	m3.setCol(0, new Object[]{1,1});
	m3.setCol(1, new Object[]{2,2});
	System.out.println("Matrix 1 After Setting: \n" + m1);
	System.out.println("Matrix 3 After Setting: \n" + m3);

	// Transpose:
	m1.transpose();
	System.out.println("Matrix 1 After Transposing: \n" + m1);
	System.out.println("Matrix 3: \n" + m3);
	System.out.println("Matrix 3 equals Matrix 1:\n" + m3.equals(m1));

	// Contains:
	System.out.println("Matrix 1 Contains 1: \n" + m1.contains(1));
	System.out.println("Matrix 1 Contains 2: \n" + m1.contains(2));
	System.out.println("Matrix 1 Contains 3: \n" + m1.contains(3));
    }

}//end class Matrix
