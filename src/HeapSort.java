/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2023/9/10
 */
public class HeapSort {


  /**
   * 1.和父节点比大小，大则交换，周而复始，直到最顶点或者没有比父大
   * @param arr
   * @param index
   */
  public static void heapInsert(int[] arr ,int index){
    while (arr[index] > arr[(index - 1)/2]){
      swap(arr , index , (index - 1)/2);
      index = (index - 1)/2;
    }
  }

  /**
   * 拿到左孩子的下标，与（左孩子和右孩子）比较谁大，PK失败就交换位置
   * 直到PK成功，或者已经没有左孩子了
   * @param arr
   * @param index
   * @param heapSize
   */
  private static void heapify(int[] arr ,int index , int heapSize){
    int leafNode = 2 * index + 1;
    while (leafNode < heapSize){
      //两个儿子谁最大
      int largest = leafNode + 1 < heapSize
          && arr[leafNode] < arr[leafNode + 1] ? leafNode + 1 : leafNode;
      //父亲和儿子比
      largest = arr[largest] > arr[index] ? largest : index;
      if (largest == index){
        break;
      }
      swap(arr , index , largest);
      index = largest;
      leafNode = 2 * index + 1;
    }
  }

  /**
   * 1.先构建为大根堆 ，得到堆最大值
   * 2.最后下标的数和最大数做交换，最后一位就是最大值，heapSize减一
   * @param arr
   */
  public static void heapSort(int[] arr){
    if (arr == null || arr.length < 2)
      return;
    for (int i = 0; i < arr.length; i++) {
      heapInsert(arr ,i);
    }
    int heapSize = arr.length;
    swap(arr ,0 ,--heapSize);
    while (heapSize > 0){
      heapify(arr,0,heapSize);
      swap(arr ,0 ,--heapSize);
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1,5,4,3,2,1};
    heapSort(arr);

//    heapInsert(arr,4);


    for (int i : arr) {
      System.out.println(i);
    }
  }

  private static void swap(int[] arr, int index, int parentIndex) {
    if (index == parentIndex){
      return;
    }
    arr[index] = arr[index] ^ arr[parentIndex];
    arr[parentIndex] = arr[index] ^ arr[parentIndex];
    arr[index] = arr[index] ^ arr[parentIndex];
  }

}
