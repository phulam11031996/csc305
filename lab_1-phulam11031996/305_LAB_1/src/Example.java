class Example {
	
  private static String name = "";
  private int[] nums = new int[0];

  boolean sameName(String other)
  {
    return other.equals(name);
  }

  public int[] getNums()
  {
    return this.nums;
  }
}  