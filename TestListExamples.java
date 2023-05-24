import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }
}

// import static org.junit.Assert.*;

// import java.beans.Transient;

// import org.junit.*;
// import java.util.List;
// import java.util.Arrays;

// // java -cp $CPATHTESTS org.junit.runner.JUnitCore TestListExamples > output.txt
// public class TestListExamples {
//   @Test
//   public void testList() {
//     ListExamples le = new ListExamples();
//     List<String> original = Arrays.asList("one", "two", "three");
//     StringChecker sc = new StringChecker() {
//       public boolean checkString(String s) {
//         return s.contains("one");
//       }
//     };
//     List<String> result = le.filter(original, sc);
//     List<String> compare = Arrays.asList{"one");
//     assertEquals(result, compare);
//   }

//   @Test
//   public void testMerge() {
//     ListExamples le = new ListExamples();
//     List<String> list1 = Arrays.asList("a", "c", "e");
//     List<String> list2 = Arrays.asList("b", "d", "f");
//     List<String> result = le.merge(list1, list2);
//     List<String> compare = Arrays.asList("a", "b", "c", "d", "e", "f");
//     assertEquals(result, compare);
//   }
// }
