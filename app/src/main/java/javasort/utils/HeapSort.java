package javasort.utils;


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

  public  static <T extends Comparable <T>> void sort(T[] A){
    sort(A, true);
  }

  public  static <T extends Comparable <T>> void sort(T[] A, boolean ascending){
    is_ascending = ascending;
    heap(A);
  }

  private static <T extends Comparable<T>> void buildHeap(T[] A) {
    for (int i = A.length / 2 - 1; i >= 0; i--) {
      heapify(A, A.length, i);
    }
  }

  private static <T extends Comparable<T>> void heapify(T[] A, int n, int i) {
    int child = 2 * i + 1;
    int max = i;
    if (child < n) {
      boolean order =   is_ascending ? A[child].compareTo(A[max]) > 0 : A[child].compareTo(A[max]) < 0;
      if (order) {
        max = child;
      }
    }

    if (child + 1 < n) {
        boolean order =   is_ascending ? A[child + 1].compareTo(A[max]) > 0 : A[child + 1].compareTo(A[max]) < 0;
        if (order) {
          max = child + 1;
        }
    }

    if (max != i) {
      T temp = A[i];
      A[i] = A[max];
      A[max] = temp;
      heapify(A, n, max);
    }
  }


  private static <T extends Comparable<T>> void heap(T[] A) {
    buildHeap(A);
    for (int i = A.length - 1; i >= 1; i--) {
      T temp = A[0];
      A[0] = A[i];
      A[i] = temp;
      heapify(A, i, 0);
    }
  }

}
