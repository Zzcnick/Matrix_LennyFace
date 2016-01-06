/* Zicheng Zhen
   APCS1 - pd10
   HW54 - Red vs. Blue / Matrices
   2015-01-05 */

/*====================================
  class Matrix -- models a square matrix

  TASK: Implement methods below.
        Categorize runtime of each. 
        Test in your main method.
  ====================================*/ 

public class Matrix {

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

    //return the item at the specified row & column   
    private Object get( int r, int c ) {
	return matrix[r][c];
    }


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[i].length; j++) {
		if (get(i,j) != null) 
		    return false;
	    }
	}
	return true;
    }


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	Object old = get(r,c);
	matrix[r][c] = newVal;
	return old;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	String ret = "|";
	for (int r = 0; r < matrix.length; r++) {
	    for (int c = 0; c < matrix[r].length; c++) {
		ret += get(r,c) + "\t";
	    }
	    ret += "\n";
	}
	return ret;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) {
	// Check alises
	boolean ret = rightSide == this;
	if (!(ret)) {
	    if (rightSide instanceof Matrix) {
		int size = this.size();
		if (size == (Matrix)rightSide.size()) {
		    for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
			    if (!(this.get(r,c).equals((Matrix)rightSide.get(r,c))))
				return false;
			}
		    }
		    return true;
		}
	    }
	    ret = false;
	}
	return ret;
    }


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
	
    }


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {

    }


    //main method for testing
    public static void main( String[] args ) {

    }

}//end class Matrix
