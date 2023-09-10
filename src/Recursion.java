/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2023/9/10
 */
public class Recursion {

  public static void main(String[] args) {
    int[] arr = new int[]{5,3,2,11,6,10,3,2,1,55,23};
    test1(arr);
  }

  private static void test1(int[] arr) {
    int length = arr.length;
    int start = 0;
    doProcess(arr,start,length - 1);
    for (int i : arr) {
      System.out.println(i);
    }
  }

  private static void doProcess(int[] arr, int start, int end) {
    if (start == end){
      return;
    }
    int min = start + ((end - start) >> 1);
    doProcess(arr ,start ,min);
    doProcess(arr ,min + 1, end);
    doMerge(arr, start ,min ,end);
  }

  /**
   * 并归排序需要新增一个辅助数组
   */
  private static void doMerge(int[] arr, int start, int min, int end) {
    int[] help = new int[end - start + 1];
    int i = 0;
    int p1 = start;
    int p2 = min + 1;
    while (p1 <= min && p2 <= end ){
      help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
    }
    //如果左边到头了 到头的那个一定大于min 或者大于 end
    while (p1 <= min){
      help[i++] = arr[p1++];
    }
    while (p2 <= end){
      help[i++] = arr[p2++];
    }
    for (int h = 0; h < help.length; h++) {
      arr[start + h] = help[h];
    }
  }
}
