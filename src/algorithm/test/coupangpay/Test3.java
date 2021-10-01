package algorithm.test.coupangpay;

public class Test3 {
//    잠겨 있는 다이얼 자물쇠가 있습니다. 이 자물쇠를 풀기 위해서는 비밀번호를 눈금선에 맞추어야 합니다. 현재 눈금선에 맞추어져 있는 수의 각 자리를 정방향, 또는 역방향으로 회전하여 비밀번호의 수와 맞출 수 있습니다. 이 때, 자물쇠를 풀기 위해 회전시키는 횟수의 최솟값을 구하려고 합니다. 예를 들어, 현재 눈금선의 숫자는 "82195" 이고, 비밀번호가 "64723" 이라면 다음과 같은 연산을 거쳐 자물쇠를 풀 수 있습니다.
//
//1번째 비밀번호 : 8→ 7→ 6 (역방향 2회)
//            2번째 비밀번호 : 2→ 3→ 4 (정방향 2회)
//            3번째 비밀번호 : 1→ 0→ 9→ 8→ 7 (역방향 4회)
//            4번째 비밀번호 : 9→ 0→ 1→ 2 (정방향 3회)
//            5번째 비밀번호 : 5→ 4→ 3 (역방향 2회)
//    총 횟수 : 13회
//    물론 이 방법 이외에도 다른 방법으로 회전시켜 자물쇠를 풀 수 있지만, 해당 방법보다 더 작은 횟수로 자물쇠를 푸는 방법은 없습니다. 따라서 최솟값은 13이 됩니다. 현재 눈금선에 있는 숫자 P와, 비밀번호 S가 매개변수로 주어질 때, 자물쇠를 풀기 위한 최소 회전 횟수를 return 하는 solution 함수를 완성해 주세요.
//
//            제한사항
//    비밀번호의 길이 : 1000 자리 이하의 자연수
    public static void main(String[] args) {
//        "82195"	"64723"	13
//        "00000000000000000000"	"91919191919191919191"	20

//        String p = "82195";
//        String s = "64723"; //        13
        String p  ="00000000000000000000";
        String s = "91919191919191919191"; //	20

        int sum = 0;

        // 문자 타입을 이용한 현재 자리의 수와 비밀번호의 수를 차례대로 비교한다.
        for (int i = 0; i < p.length(); i++) {
            int pChar = p.charAt(i);
            int sChar = s.charAt(i);

            // 증가하였을때 이동 횟수
            int upDif = Math.abs(pChar - sChar);

            int big = Math.max(pChar, sChar);
            int small = Math.min(pChar, sChar) + 10;

            // 감소하였을때 이동 횟수
            int downDif = Math.abs(big - small);

            // 증가 횟수와 감소 횟수중 작은 값을 이동 횟수로 더함
            int min = Math.min(upDif, downDif);
            System.out.println(min);
            sum += min;
        }

        System.out.println(sum);
    }
}
