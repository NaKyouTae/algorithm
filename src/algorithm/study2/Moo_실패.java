package algorithm.study2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//11
//m

//https://www.acmicpc.net/problem/5904

public class Moo_실패 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<String> property = new ArrayList<>();
        property.add("moo");
        property.add("mooo");
        property.add("moooo");

        List<String> list = new ArrayList<>();
        list.add("moo");
        list.add("moomooomoo");
        list.add("moomooomoomoooomoomooomoo");

        int len = list.get(list.size() - 1).length();

        while (n > len) {

        }


    }
}
