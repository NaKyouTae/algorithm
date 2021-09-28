package algorithm.programmers.level2;

import java.util.Stack;

/** 
 * 올바른 괄호
 * */
public class Study13 {
    public static void main(String[] args) {
//        "()()"	true
//        "(())()"	true
//        ")()("	false
//        "(()("	false
//        String s = "()()";
//        String s = "(())()";
//        String s = ")()(";
        String s = "(()(";
        problem1(s);
        problem2(s);
    }

    public static void problem1(String s) {
        char firstChar = s.charAt(0);
        char lastChar = s.charAt(s.length()-1);

        if(firstChar == ')' || lastChar == '(') System.out.println(false);

        Stack<Character> stc = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stc.push(c);
            }else {
                if(stc.isEmpty()) System.out.println(false);

                stc.pop();
            }
        }

        System.out.println((!stc.isEmpty()) ? false : true);
    }

    public static void problem2 (String s) {
        if(s.charAt(0) == ')') System.out.println(false);

        int basketCount = 0;

        for(int i = 0; i < s.length(); i++) {
            char b = s.charAt(i);

            if(b == '(') {
                basketCount++;
            }else {
                if(basketCount <= 0) System.out.println(false);
                basketCount--;
            }
        }

        System.out.println((basketCount > 0) ? false : true);
    }
}
