

public class Driver {
	
	  public static void main(String[] args)
	  {
	    Example ex = new Example();
	    int total = 0;

	    for (int i : ex.getNums()) {
	    	total += i;
	    }

	    System.out.println(total);
	  }
}
