package algorithm.binarysearch;

public class 고정점찾기 {
    public static int[] arr;
    public static int answer = -1;

    public static void main(String[] args) {
//		int n = 5;
//		arr = new int[]{-15, -6, 1, 3, 7};

//		int n = 7;
//		arr = new int[] {-15, -4, 2, 8, 9, 13, 15};

        int n = 7;
        arr = new int[]{-15, -4, 3, 8, 9, 13, 15};

        binarySearch(0, n - 1, (n - 1) / 2);

        System.out.println(answer);
    }

    public static void binarySearch(int left, int right, int center) {

        while (right >= left) {
            center = (left + right) / 2;

            if (center > arr[center]) {
                left = center + 1;
            } else if (center < arr[center]) {
                right = center - 1;
            } else {
                answer = center;
                break;
            }
        }
    }
}
