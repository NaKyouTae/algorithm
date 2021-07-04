package algorithm.test.naverWebtoon;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 쿠폰을 사용하여 가장 많이 할인 받아 결제한 금액을 구하시오
 */

public class Test1 {
    public static void main(String[] args) {
        int[] p = {13000, 88000, 10000};
        int[] d = {30, 20};
        System.out.println(solution(p, d));
    }

    public static Comparator<Integer> compare = new Comparator<>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o2, o1);
        }
    };

    public static int solution(int[] prices, int[] discounts) {
        int discount = 0;

        List<Integer> p = Arrays.stream(prices).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        List<Integer> d = Arrays.stream(discounts).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        for (int i = 0; i < p.size(); i++) {
            if(d.size() >= i+1) {
                int dis = p.get(i) * d.get(i) / 100;
                int price = p.get(i) - dis;
                discount += price;
            }else {
                discount += p.get(i);
            }
        }

        return discount;
    }
}
