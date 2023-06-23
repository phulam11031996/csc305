package edu.calpoly.csc305;

import java.util.List;

public class IssueFive {
  public <T extends Number> long sumAsLongs(List<T> numbers) {
    long total = 0;

	// ask about this
    for (T number : numbers) {
//      total += ((Integer) number).longValue();
      total += (number).intValue();
    }

    return total;
  }

  public long sumIntsAsLongs(List<Integer> ints) {
    return sumAsLongs(ints);
  }

  public long sumDoublesAsLongs(List<Double> doubles) {
    return sumAsLongs(doubles);
  }
}
