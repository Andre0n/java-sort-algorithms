package javasort.utils;

/**
 * Operations on arrays, wrapper arrays (like {@code Object[]}).
 * <p>
 * Perform <a href="https://en.wikipedia.org/wiki/Quicksort">QuickSort</a>
 * algorithm.
 * Quicksort is a divide-and-conquer algorithm and not a stable sort.
 * Works in O(nlogn) time complexity, but hn the worst case, it makes O(n²).
 * </p>
 *
 * @author André Gabriel <a href="https://github.com/Andre0n">GitHub</a>
 */
public class QuickSort {

  /**
   * Stores the sort order
   */
  private static boolean is_ascending = true;

  /**
   * Prevents instantiation.
   */
  private QuickSort() {
  }

  /**
   * Sorts the specified array into ascending order, according to the
   * {@linkplain Comparable natural ordering} of its elements.
   * All elements in the list must implement the {@link Comparable}
   * interface.
   *
   * @param A   the array to be sorted
   * @param <T> the class of the objects in the list
   */
  public static <T extends Comparable<T>> void sort(final T[] A) {
    sort(A, 0, A.length - 1);
  }

  /**
   * Sorts the specified list into ascending or descending order,
   * according to the {@code ascending} parameter value that is passed.
   * All elements in the list must implement the {@link Comparable}
   * interface.
   *
   * @param A         the array to be sorted
   * @param ascending the order that array to be sorted
   * @param <T>       the class of the objects in the list
   */
  public static <T extends Comparable<T>> void sort(final T[] A, final boolean ascending) {
    is_ascending = ascending;
    sort(A, 0, A.length - 1);
  }

  /**
   * Swaps the two specified elements in the specified array.
   *
   * @param A      the array in which to swap elements
   * @param first  the index of first element to be swapped
   * @param second the index of second element to be swapped
   * @param <T>    the class of the objects in the list
   */
  private static <T> void swap(final T[] A, final int first, final int second) {
    final T temp = A[first];
    A[first] = A[second];
    A[second] = temp;
  }

  /**
   * Sorts the specified range of the array by Quicksort
   *
   * @param A     the array to be sorted
   * @param left  the index of the first element, inclusive, to be sorted
   * @param right the index of the last element, inclusive, to be sorted
   * @param <T>   the class of the objects in the list
   */
  private static <T extends Comparable<T>> void sort(final T[] A, final int left, final int right) {
    if (left < right) {
      final int pivot = randomPartition(A, left, right);
      sort(A, left, pivot - 1);
      sort(A, pivot + 1, right);
    }
  }

  /**
   * Partitioning the elements into two sub-arrays.
   * <p>
   * It works by selecting a 'pivot' element from the array and partitioning the
   * other elements into two sub-arrays, according to whether they are less than
   * or greater than the pivot.
   * This function takes the last element as the pivot. Then, checks each element
   * and swaps it before the pivot if its value is smaller or swaps elements after
   * of pivot if its value is greater.
   * </p>
   * 
   * @param A     the array to be partitioned
   * @param left  the index of the first element, inclusive, to be sorted
   * @param right the index of the last element, inclusive, to be sorted
   * @param <T>   the class of the objects in the list
   */
  private static <T extends Comparable<T>> int partition(final T[] A, final int left, final int right) {
    final T pivot = A[right];
    int pIndex = left;
    for (int i = left; i < right; ++i) {
      // Compare based on the given order
      final boolean compare = is_ascending ? A[i].compareTo(pivot) <= 0 : A[i].compareTo(pivot) >= 0;
      if (compare) {
        swap(A, i, pIndex);
        pIndex++;
      }
    }
    swap(A, pIndex, right);
    return pIndex;
  }
}

