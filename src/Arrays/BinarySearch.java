package Arrays;

public class BinarySearch {

    public static void logic() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        binarySearch(0, a.length - 1, a, 1);
    }

    public static int binarySearch(int start, int end, int[] array, int itemToSearch) {
        int mid = end - start / 2;
        if (array[mid] == itemToSearch) {
            System.out.println("Item Found At Index " + mid);
            return mid;
        } else if (array[mid] < itemToSearch) {
            return binarySearch(mid + 1, end, array, itemToSearch);
        } else {
            return binarySearch(start, mid - 1, array, itemToSearch);
        }
    }
}
