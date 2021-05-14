package algorithm.bfs;

import java.io.*;
import java.util.*;

public class DFS와BFS1 {
    
    public static int N, M, S;
    public static boolean[] bfsVisit, dfsVisit;
    public static StringBuilder sb = new StringBuilder();
    public static Queue<Integer> que = new LinkedList<>();
    public static List<List<Integer>> list = new ArrayList<>();    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] str = br.readLine().split(" ");
        
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        S = Integer.parseInt(str[2]);
        
        bfsVisit = new boolean[N];
        dfsVisit = new boolean[N];
        
        for(int i = 0; i < N; i++) list.add(new ArrayList<>());
        for(int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0])-1;
            int y = Integer.parseInt(s[1])-1;
            list.get(x).add(y);
            list.get(y).add(x);
        }
        
    	for(int i = S-1; i < N; i++){
    		if(!dfsVisit[i]) {
    			dfsVisit[i] = true;
    			if(list.get(i).size() == 0) {
    	        	sb.append(S);
    	        	break;
    	        }else {
    	        	dfs(i);
    	        }
    		}
    	}
    	sb.append("\n");
    	for(int i = S-1; i < N; i++){
    		if(!bfsVisit[i]) {
    			bfsVisit[i] = true;
    			if(list.get(i).size() == 0) {
    	        	sb.append(S);
    	        	break;
    	        }else {
    	        	bfs(i);
    	        }
    		}
    	}
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    public static void dfs(int x) {
        List<Integer> temp = new ArrayList<>();
        sb.append(x+1).append(" ");
        
        for(int i = 0; i < list.get(x).size(); i++) {    
            int n = list.get(x).get(i);
            if(!dfsVisit[n]) {
                temp.add(n);
            }
        }
        
        Collections.sort(temp);
        for(Integer t : temp) {
            if(!dfsVisit[t]) {
                dfsVisit[t] = true;
                dfs(t); 
            }
        }
        temp = new ArrayList<>();
    }
    
    public static void bfs(int s) {
        List<Integer> temp = new ArrayList<>();
        que.add(s);
        
        while(!que.isEmpty()) {
            int x = que.poll();
            sb.append(x+1).append(" ");
            for(int i = 0; i < list.get(x).size(); i++) {
                int n = list.get(x).get(i);
                if(!bfsVisit[n]) {
                    bfsVisit[n] = true;
                    temp.add(n);
                }
            }
            
            Collections.sort(temp);
            for(Integer t : temp) que.add(t);
            temp = new ArrayList<>();
        }
    }
}