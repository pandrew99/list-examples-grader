import static org.junit.Assert.*;

import java.beans.Transient;

import org.junit.*;
import java.util.List;
import java.util.Arrays;

public class TestListExamples {
  @Test
  public void testList() {
    ListExamples le = new ListExamples();
    List<String> original = Arrays.asList("one", "two", "three");
    StringChecker sc = new StringChecker() {
      public boolean checkString(String s) {
        return s.contains("one");
      }
    };
    List<String> result = le.filter(original, sc);
    List<String> compare = Arrays.asList("one");
    assertEquals(result, compare);
  }

  @Test
  public void testMerge() {
    ListExamples le = new ListExamples();
    List<String> list1 = Arrays.asList("a", "c", "e");
    List<String> list2 = Arrays.asList("b", "d", "f");
    List<String> result = le.merge(list1, list2);
    List<String> compare = Arrays.asList("a", "b", "c", "d", "e", "f");
    assertEquals(result, compare);
  }
}
