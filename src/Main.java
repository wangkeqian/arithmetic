public class Main {

  public static void main(String[] args) {
    int[] chars = new int[]{1,1,2,2,3,3,3,4,4,4,4,5,5,5};

//    swap(chars, 0,2);
//    for (int aChar : chars) {
//      System.out.println(aChar);
//    }
    find2(chars);
  }

  private static void swap(int[] arr, int i, int j) {

    arr[i] = arr[i] ^ arr[j];
    arr[j] = arr[i] ^ arr[j];
    arr[i] = arr[i] ^ arr[j];
  }


  /**
   * 一个数组中 找到两个出现次数为奇数的数
   * @param arr
   */
  private static void find2(int[] arr){
    if (arr == null || arr.length == 0){
      return;
    }
    int eor = 0;
    for (int i : arr) {
      eor ^= i;
    }
    // eor = a ^ b
    //取出eor最右侧的1
    int rightOne = eor & (~eor + 1);
    int onlyOne = 0;
    for (int cur : arr) {
      if ((cur & rightOne) == 0){
        onlyOne ^= cur;
      }
    }
    //right = a | b
    System.out.println(onlyOne + " - " + (onlyOne ^ eor));
  }
}