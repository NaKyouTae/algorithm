package algorithm.codefestival;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//4.0 3.0 2.1 4.3 5.0
//2 3
//WYO
//YYO
//ABC
//DCE

//D 4.3 1 0
//B 3.0 0 1
//C 2.1 1 1
//E 5.0 1 2
//C 2.1 0 2

public class 문3_안본콘텐츠없게해주세요_정답 {
    public static class Node {
        String view;
        String type;
        double point;
        int x;
        int y;

        Node(String v) {
            this.view = v;
        }

        Node(String v, String t) {
            this.view = v;
            this.type = t;
        }

        Node(String v, String t, double p, int x, int y) {
            this.view = v;
            this.type = t;
            this.point = p;
            this.x = x;
            this.y = y;
        }
    }

    public static Comparator<Node> compare = new Comparator<Node>() {

        @Override
        public int compare(Node o1, Node o2) {
            return (o1.point == o2.point) ? 0 : (o1.point > o2.point) ? -1 : 1;
        }

    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] s = br.readLine().split(" ");

        double[] point = new double[s.length];
        for (int i = 0; i < s.length; i++) {
            point[i] = Double.parseDouble(s[i]);
        }

        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);

        String[][] view = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                view[i][j] = str[j];
            }
        }

        String[][] type = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                type[i][j] = str[j];
            }
        }

        List<Node> viewY = new ArrayList<>();
        List<Node> viewO = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (view[i][j].equals("Y"))
                    viewY.add(new Node(view[i][j], type[i][j], point[type[i][j].charAt(0) - 'A'], i, j));
                if (view[i][j].equals("O"))
                    viewO.add(new Node(view[i][j], type[i][j], point[type[i][j].charAt(0) - 'A'], i, j));
            }
        }

        Collections.sort(viewY, compare);
        Collections.sort(viewO, compare);

        List<Node> list = new ArrayList<>();
        list.addAll(viewY);
        list.addAll(viewO);

        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            sb.append(node.type).append(" ").append(node.point).append(" ").append(node.x).append(" ").append(node.y).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
