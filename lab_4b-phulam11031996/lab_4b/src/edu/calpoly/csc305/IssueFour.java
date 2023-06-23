package edu.calpoly.csc305;

import java.util.List;

public class IssueFour {
  /*
    You will need to update these methods to accomplish the intended task (there
    are a few ways to do this) and update the tests based on your solution.
   */
//  public String buildString(List<String> strings) {
//    StringBuilder builder = new StringBuilder();
//
//    for (String string : strings) {
//      builder.append(String.format("string: %s\n", string));
//    }
//
//    return builder.toString();
//  }
//
//  public String buildString(List<Integer> integers) {
//    StringBuilder builder = new StringBuilder();
//
//    for (Integer integer : integers) {
//      builder.append(String.format("integer: %d\n", integer));
//    }
//
//    return builder.toString();
//  }
//
  public <T> String buildString(List<T> eles) {
    StringBuilder builder = new StringBuilder();

    for (T ele : eles) {
      builder.append(String.format("element: %s\n", String.valueOf(ele)));
    }

    return builder.toString();
  }

}
