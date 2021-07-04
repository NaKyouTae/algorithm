package algorithm.studyGroup.study0;

import java.util.Stack;

public class 프로그래머스2 {
    public static void main(String[] args) {
        String s = "}]()[{";
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1, s.length()) + String.valueOf(s.charAt(0));
            System.out.println(s);
            if (check(s)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean check(String s) {

        Stack<Character> stc = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stc.isEmpty()) {
                if (c == '}') {
                    if (stc.peek() == '{') {
                        stc.pop();
                    }
                } else if (c == ']') {
                    if (stc.peek() == '[') {
                        stc.pop();
                    }
                } else if (c == ')') {
                    if (stc.peek() == '(') {
                        stc.pop();
                    }
                } else {
                    stc.add(c);
                }
            } else {
                stc.add(s.charAt(i));
            }
        }

        return stc.isEmpty();
    }
}
