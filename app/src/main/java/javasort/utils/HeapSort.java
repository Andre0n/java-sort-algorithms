package javasort.utils;

/**
 * Operations on arrays, wrapper arrays (like {@code Object[]}).
 * <p>
 * Perform <a href="https://en.wikipedia.org/wiki/Heapsort">Heap
 * sort</a> algorithm.
 * Works in O(nlogn) time complexity, but somewhat slower in practice on most
 * machines than a well-implemented quicksort and is not a stable sort.
 * </p>
 *
 * @author André Gabriel <a href="https://github.com/Andre0n">GitHub</a>
 */
public class HeapSort {

  /**
   * Stores the sort order
   */
  private static boolean is_ascending = true;

  /**
   * Prevents instantiation.
   */
  private HeapSort() {
  }

  /**
   * Sorts the specified array into ascending order, according to the
   * {@linkplain Comparable natural ordering} of its elements.
   * All elements in the array must implement the {@link Comparable}
   * interface.
   * 
   * @param A   the array to be sorted
   * @param <T> the class of the objects in the array
   */
  public static <T extends Comparable<T>> void sort(final T[] A) {
    sort(A, true);
  }

  /**
   * Sorts the specified array into ascending or descending order,
   * according to the {@code ascending} parameter value that is passed.
   * All elements in the array must implement the {@link Comparable}
   * interface.
   * 
   * @param A         the array to be sorted
   * @param ascending the order that array to be sorted
   * @param <T>       the class of the objects in the array
   */
  public static <T extends Comparable<T>> void sort(final T[] A, final boolean ascending) {
    is_ascending = ascending;
    heap(A);
  }

  /**
   * Builds a heap from a array in O(n) operations.
   * 
   * <p>
   * This implementation iterates over the array and call {@code heapify} method
   * for each element until half of the array.
   * </p>
   *
   * @param A         the array to be sorted
   * @param ascending the order that array to be sorted
   * @param <T>       the class of the objects in the array
   */
  private static <T extends Comparable<T>> void buildHeap(final T[] A) {
    for (int i = A.length / 2 - 1; i >= 0; i--) {
      heapify(A, A.length, i);
    }
  }

  /**
   * Build a heap from the bottom up by successively sifting downward to establish
   * the heap property. Start from the first index of non-leaf node whose index is
   * given by n/2 - 1 .
   * <p>
   * This implementation create a Min-Heap or a Max-Heap according to the value of
   * ascending variable.
   * </p>
   * 
   * @param <T> the class of the objects in the array
   * @param A   the array to be sorted
   * @param n   the length of the array
   * @param i   the element index
   */
  private static <T extends Comparable<T>> void heapify(final T[] A, final int n, final int i) {
    final int child = 2 * i + 1;
    int max = i;
    if (child < n) {
      final boolean order = is_ascending ? A[child].compareTo(A[max]) > 0 : A[child].compareTo(A[max]) < 0;
      if (order) {
        max = child;
      }
    }

    if (child + 1 < n) {
      final boolean order = is_ascending ? A[child + 1].compareTo(A[max]) > 0 : A[child + 1].compareTo(A[max]) < 0;
      if (order) {
        max = child + 1;
      }
    }

    if (max != i) {
      final T temp = A[i];
      A[i] = A[max];
      A[max] = temp;
      heapify(A, n, max);
    }
  }

  /**
   * Performs a heapsort in the given array
   * 
   * <p>
   * Remove the top element in each step and then consider the remaining elements
   * and transform it into a heap calling {@code heapify} method.
   * </p>
   * 
   * @param <T> the class of the objects in the array
   * @param A   the array to be sorted
   */
  private static <T extends Comparable<T>> void heap(final T[] A) {
    buildHeap(A);
    for (int i = A.length - 1; i >= 1; i--) {
      final T temp = A[0];
      A[0] = A[i];
      A[i] = temp;
      heapify(A, i, 0);
    }
  }
}
