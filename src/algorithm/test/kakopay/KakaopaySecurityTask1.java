package algorithm.test.kakopay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Create By na kyutae 2021-10-31
 */

// 1. 편의점 알바를 하던 죠르디는 알파벳 문자로 이루어진 상품코드가 너무 길어 별도의 규칙을 만들어 인코딩하려고 합니다.
// 죠르디는 문자열 안에 연속적으로 반복되는 문자를 "반복되는횟수 [문자]"형태로 인코딩할 계획입니다.
// 예를들어 aaaz는 3[a]z로 인코딩되고 accccaccccacccc는 a4[c]a4[c]a4[c]로 1회 인코딩 되고 다시3[a4[c]]로 인코딩 됩니다.
// 인코딩에 너무 집중한 죠르디는 인코딩한 문자열을 다시 원래 문자열로 만드는 디코딩 프로그램 작성을 깜빡했습니다.
// 죠르디 대신 인코딩된 문자열이 들어왔을 때, 디코딩된 문자열을 반환하는 프로그램을 작성해 주세요.
//
// 규칙
// - 입력되는 문자열은 숫자, 문자, 괄호로만 이루어져 있습니다.
// - 숫자는 양의 정수이며, 문자에는 숫자가 포함되지 않습니다. 예를 들어 3a, 2[4]와 같은 입력은 존재하지 않습니다.
// - 입력되는 문자열의 길이는 L은 0 < L < 128 입니다.
//
// 예제 입출력
// 입력 : 3[a]z
// 출력 : aaaz
//
// 입력 : 3[a4[c]]
// 출력 : acccc acccc acccc


public class KakaopaySecurityTask1 {

    public static void main(String[] args) throws IOException {
//        List<String> inputs = new ArrayList<>();
//
//        inputs.add("3[a]z");
//        inputs.add("3[a4[c]]");
//        inputs.add("3[a4[c]4[f]]");
//        inputs.add("127[a]z");
//        inputs.add("abc10[j]z");
//
//        inputs.forEach(input -> {
//            System.out.println(decoding(input));
//        });

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(decoding(str));
    }

    public static String decoding(String str) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> que = new LinkedList<>();

        for(int i = str.length()-1; i >= 0; i--) {
            char c = str.charAt(i);
            que.add(c);
        }

        while(!que.isEmpty()) {
            char peek = que.poll();

            if(peek == ']') {
                String res = "";
                String repeatCount = "";

                while(!que.isEmpty()) {
                    char strAt = que.poll();

                    if(!Character.isAlphabetic(strAt) && !Character.isDigit(strAt)) continue;

                    if(Character.isDigit(strAt)) {
                        repeatCount = strAt + repeatCount;

                        repeatCount = getNumber(que) + repeatCount;

                        break;
                    }else {
                        res = strAt + res;
                    }
                }

                sb.append(res.repeat(Integer.parseInt(repeatCount)));
            }else if(Character.isAlphabetic(peek)) {
                sb.append(peek);
            }else if(Character.isDigit(peek)){
                String repeatCount = String.valueOf(peek);

                repeatCount = getNumber(que) + repeatCount;

                return sb.reverse().toString().repeat(Integer.parseInt(repeatCount));
            }
        }

        return sb.reverse().toString();
    }

    /**
     * 숫자를 추출하는 메서드
     * @param que 문자 리스트
     * @return String 형 숫자
     */
    public static String getNumber(Queue<Character> que) {
        String num = "";

        while(!que.isEmpty()) {
            char numAt = que.peek();

            if(Character.isDigit(numAt)) {
                que.poll();
                num = numAt + num;
            }else {
                break;
            }
        }

        return num;
    }
}
