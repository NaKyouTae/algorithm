package algorithm.programmers.level2;

import java.util.*;

/**
 * 오픈채팅방
 * */
public class Study14 {
    public static void main(String[] args) {
        String[] str = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        Map<String, String> userMap = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < str.length; i++) {
            String[] insertInfo = str[i].split(" ");
            String commend = insertInfo[0];
            if(commend.equals("Change") || commend.equals("Enter")) {
                userMap.put(insertInfo[1], insertInfo[2]);
            }
        }

        for (int i = 0; i < str.length; i++) {
            String[] insertInfo = str[i].split(" ");
            String commend = insertInfo[0];
            String uid = insertInfo[1];

            if(commend.equals("Enter")) {
                list.add(userMap.get(uid) + "님이 들어왔습니다.");
            }else if(commend.equals("Leave")) {
                list.add(userMap.get(uid) + "님이 나갔습니다.");
            }

        }

        String[] a = list.toArray(new String[list.size()]);

        for(String s : list) {
            System.out.println(s);
        }


    }
}
