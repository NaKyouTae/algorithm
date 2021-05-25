package algorithm.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

//12
//Junkyu 50 60 100
//Sangkeun 80 60 50
//Sunyoung 80 70 100
//Soong 50 60 90
//Haebin 50 60 100
//Kangsoo 60 80 100
//Donghyuk 80 60 100
//Sei 70 70 70
//Wonseob 70 70 90
//Sanghyun 70 70 80
//nsj 80 80 80
//Taewhan 50 60 90

public class 국영수 {
    public static class Node {
        String name;
        int korean;
        int english;
        int math;

        Node(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    public static Comparator<Node> compare = new Comparator<Node>() {

        @Override
        public int compare(Node o1, Node o2) {
            int result = 0;
            if (o1.korean == o2.korean) {
                if (o1.english == o2.english) {
                    if (o1.math == o2.math) {
                        int min = Math.min(o1.name.length(), o2.name.length());
                        for (int i = 0; i < min; i++) {
                            result = compareEnglish(o1.name.charAt(i), o2.name.charAt(i));

                            if (result == 0) continue;
                            else if (result == 1 || result == -1) break;
                        }

                    } else if (o1.math > o2.math) {
                        result = -1;
                    } else {
                        result = 1;
                    }
                } else if (o1.english > o2.english) {
                    result = 1;
                } else {
                    result = -1;
                }
            } else if (o1.korean > o2.korean) {
                result = -1;
            } else {
                result = 1;
            }

            return result;
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Node(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        list.sort(compare);

        for (Node l : list) {
            sb.append(l.name).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int compareEnglish(char o1, char o2) {
        if (o1 == o2) {
            return 0;
        } else if (o1 > o2) {
            return 1;
        } else {
            return -1;
        }
    }
}
