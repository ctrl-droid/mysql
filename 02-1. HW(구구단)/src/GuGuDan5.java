public class GuGuDan5 {

  public static void main(String[] args) {
	  for (int k = 2; k <= 9 ; k ++ ) {
		  System.out.print(k + "단");
	      System.out.print("\t"+"\t");
	  }
      System.out.println();
      
	  for (int i = 1; i <= 9; i+=2) {
		  for (int j = 2; j <= 9; j++) {
			  System.out.print(j + " * " + i + " = " + i * j);
			  System.out.print("\t");
      }
      System.out.println();
	  }
  }
}
