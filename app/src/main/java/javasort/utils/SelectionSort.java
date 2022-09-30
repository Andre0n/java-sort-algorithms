package javasort.utils;

/**
 * Operations on arrays, wrapper arrays (like {@code Object[]}).
 * <p>
 * Perform <a href="https://en.wikipedia.org/wiki/Selection_sort">Selection
 * sort</a> algorithm.
 * Works in O(n²) time complexity, but has performance advantages over more
 * complicated algorithms in certain situations, particularly where
 * auxiliary memory is limited.
 * </p>
 *
 * @author André Gabriel <a href="https://github.com/Andre0n">GitHub</a>
 */
public class SelectionSort {

  /**
   * Prevents instantiation.
   */
  private SelectionSort() {
  }

  /**
   * Swaps the two specified elements in the specified array.
   *
   * @param A      the array in which to swap elements
   * @param first  the index of first element to be swapped
   * @param second the index of second element to be swapped
   * @param <T>    the class of the objects in the list
   */
  private static <T> void swap(T[] A, int first, int second) {
    T temp = A[first];
    A[first] = A[second];
    A[second] = temp;
  }

  /**
   * Sorts the specified list into ascending order, according to the
   * {@linkplain Comparable natural ordering} of its elements.
   * All elements in the list must implement the {@link Comparable}
   * interface.
   * <p>
   * This implementation iterates over the array and compare each element
   * with the smallest element in the unsorted sublist and swap the elements.
   * </p>
   *
   * @param A   the array to be sorted
   * @param <T> the class of the objects in the list
   */
  public static <T extends Comparable<T>> void sort(T[] A) {
    sort(A, true);
  }

  /**
   * Sorts the specified list into ascending or descending order,
   * according to the {@code ascending} parameter value that is passed.
   * All elements in the list must implement the {@link Comparable}
   * interface.
   * <p>
   * This implementation iterates over the array and compare each element
   * with the smallest element in the unsorted sublist and swap the elements.
   * </p>
   *
   * @param A         the array to be sorted
   * @param ascending the order that array to be sorted
   * @param <T>       the class of the objects in the list
   */
  public static <T extends Comparable<T>> void sort(T[] A, boolean ascending) {
    for (int i = 0; i < A.length - 1; ++i) {
      int min = i;
      for (int j = i + 1; j < A.length; ++j) {
        if (ascending) {
          min = A[j].compareTo(A[min]) < 0 ? j : min;
        } else {
          min = A[j].compareTo(A[min]) > 0 ? j : min;
        }
      }
      swap(A, i, min);
    }
  }
}
