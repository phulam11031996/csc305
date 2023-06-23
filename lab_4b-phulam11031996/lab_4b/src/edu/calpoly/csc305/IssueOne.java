package edu.calpoly.csc305;

import java.util.ArrayList;
import java.util.List;

public class IssueOne {

  /**
   * Method to illustrate common issue with generics.
 * @param <T>
   *
   * @return default list of items
   */
  public <T> List<T> getItems() {
    ArrayList<T> items = new ArrayList<>();

    items.add((T) "one");
    items.add((T) "two");

    return items;
  }
}
