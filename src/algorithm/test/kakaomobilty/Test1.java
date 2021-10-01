package algorithm.test.kakaomobilty;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
//        String s = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String s = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String[] str = s.split(", ");

        List<String> emailList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();

        for (int i = 0; i < str.length; i++) {
            String name = str[i];

            String[] detailName = name.split(" ");
            String nicName = "";

            for (int j = 0; j < detailName.length; j++) {
                String detail = detailName[j];
                if(detail.contains("-")) {
                    String[] lastName = detail.split("-");
                    for(int k = 0; k < lastName.length; k++) {
                        nicName += (k == lastName.length-1) ? lastName[k].substring(0, 2).toLowerCase() : lastName[k].toLowerCase();
                    }
                }else {

                    nicName += (j == detailName.length-1) ? detail.toLowerCase() : String.valueOf(detail.charAt(0)).toLowerCase();
                }
            }

            nameList.add(nicName.toString());

            String finalNicName = nicName;

            List<String> findNames = nameList.stream().filter(n -> n.equals(finalNicName)).collect(Collectors.toList());

            String nicNameNumber = (findNames.size() == 1) ? "" : String.valueOf(findNames.size());
            emailList.add(name +  " <" + nicName.toString() + nicNameNumber + "@example.com>");
        }

        StringBuilder emailBuilder = new StringBuilder();

        for(String email : emailList){
            emailBuilder.append(email).append("\n");
        };

        System.out.println(emailBuilder.toString());
    }
}
