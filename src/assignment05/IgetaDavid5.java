package assignment05;

/**
 * Big-O Notation Assignment
 * 
 * @author William McDaniel Albritton
 */
public class IgetaDavid5 {
	
  public static void main(String[] arguments) {
    int n = Integer.MAX_VALUE; // some very large number
    int count = 0;
    // problem 1
    //O(n)
    for (int i = n; i > 0; i--) {
      count++;
    }

    // problem 2
    //O(n)
    for (int i = n; i > 0; i--) {
      //O(1)
      for (int j = 0; j < 1000; j++) {
        count++;
      }
    }

    // problem 3
    //O(log2n)
    for (int i = n; i > 0; i = i / 2) {
      //O(n)
      for (int j = 0; j < n; j++) {
         //O(n)
        for (int k = 0; k < n; k++) {
          count++;
        }
      }
    }

    // problem 4
    //O(1)
    for (int i = 0; i < 100; i++) {
      count++;
    }
    //O(n)
    for (int j = 0; j < n; j++) {
      count++;
    }
    //O(1)
    for (int k = 0; k < 1000; k++) {
      count++;
    }

    // problem 5
    //O(n)
    for (int i = 0; i < n; i++) {
      //O(n)
      for (int j = 0; j < n; j++) {
        //O(n)
        for (int k = 0; k < n; k++) {
          //O(n)
          for (int m = 0; m < n; m++) {
            count++;
          }
        }
      }
    }

    // problem 6
    //O(1)
    for (int i = n; i <= n; i++) {
      count++;
    }

    // problem 7
    for (int i = 0; i < n; i++) {
      for (int j = n; j > 0; j = j / 2) {
        count++;
      }
    }

    // problem 8
    for (int i = n; i > 0; i = i / 2) {
      for (int j = 0; j < n; j++) {
        count++;
      }
    }
    for (int k = 0; k < n; k++) {
      for (int m = 0; m < n; m++) {
        count++;
      }
    }

    // problem 9
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 100; j++) {
        for (int k = 0; k < n; k++) {
          count++;
        }
      }
    }

    // problem 10
    for (int i = n; i > 0; i = i / 2) {
      for (int j = n; j > 0; j = j / 2) {
        for (int k = n; k > 0; k = k / 2) {
          count++;
        }
      }
    }
  }
}