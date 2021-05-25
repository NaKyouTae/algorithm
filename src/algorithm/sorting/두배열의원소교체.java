package algorithm.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//5 3
//1 2 5 4 3
//5 5 6 6 5
public class 두배열의원소교체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        List<Integer> list_a = new ArrayList<>();
        List<Integer> list_b = new ArrayList<>();


        String[] a = br.readLine().split(" ");
        for (int i = 0; i < n; i++) list_a.add(Integer.parseInt(a[i]));

        String[] b = br.readLine().split(" ");
        for (int i = 0; i < n; i++) list_b.add(Integer.parseInt(b[i]));


        Collections.sort(list_a);
        Collections.reverse(list_b);

        for (int i = 0; i < k; i++) {
            int temp = list_a.get(i);
            list_a.set(i, list_b.get(i));
            list_b.set(i, temp);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += list_a.get(i);
        }

        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
    }
}
