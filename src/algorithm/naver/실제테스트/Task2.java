package algorithm.naver.실제테스트;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
//		int[] A = {3, 4, 5, 3, 7};
//		int[] A = {1, 2, 3, 4};
        int[] A = {1, 3, 1, 2};

        int point = -1;

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < A.length; i++) arr.add(A[i]);

        if (check(arr)) {
            point = 0;
        } else {
            int cnt = 0;
            for (int i = 0; i < A.length; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < A.length; j++) {
                    if (i == j) continue;
                    list.add(A[j]);
                }

                if (check(list)) {
                    System.out.println(list.toString());
                    cnt += 1;
                }
            }
            if (cnt != 0) point = cnt;
        }

        System.out.println(point);
    }

    public static boolean check(List<Integer> list) {
        boolean check = true;

        for (int j = 1; j < list.size(); j++) {
            if ((j + 1) % 2 == 0) {
                if (list.get(j - 1) > list.get(j)) check = false;
            } else {
                if (list.get(j - 1) < list.get(j)) check = false;
            }
        }

        return check;
    }
}
