public class GuGuDan2 {
	public static void main(String[] args) {
		for (int k = 2; k <= 9; k++) {
			System.out.print(k + "단");
		    System.out.print("\t"+"\t");
		  }
	    System.out.println();
	      
		int i = 0;
		while (i++ < 9) {
			int j = 1;
			while (j++ <9) {
				System.out.print(j + " * " + i + " = " + i * j);
				System.out.print("\t");
			}
			System.out.println();
		}
	} 
}