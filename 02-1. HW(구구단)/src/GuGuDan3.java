
public class GuGuDan3 {
	public static void main(String[] args) {
		for (int k = 2; k <= 9; k++) {
			System.out.print(k + "단");
		    System.out.print("\t"+"\t");
		  }
	    System.out.println();
	    
	    int i = 1;
	    do {
	    	int j = 2;
	    	do {
	    		System.out.print(j + " * " + i + " = " + i * j);
	    		System.out.print("\t");
	    		} while (j++ < 9);
	    	System.out.println();
	    } while (i++ < 9);
	}
}