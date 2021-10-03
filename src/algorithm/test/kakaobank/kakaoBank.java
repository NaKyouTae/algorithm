package algorithm.test.kakaobank;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class kakaoBank {
    private static final String COMMENTS_FILE_PATH = "..\\comments.csv";
    private static final String HIGH_SCHOOL = "고등학교";
    private static final String MIDDLE_SCHOOL = "중학교";

    public static void main(String[] args) {
        File csv = new File(COMMENTS_FILE_PATH);

        BufferedReader br = null;

        try{
            br = Files.newBufferedReader(Paths.get(COMMENTS_FILE_PATH));

            String line = "";

            while((line = br.readLine()) != null) {
                if(!line.contains(HIGH_SCHOOL) || !line.contains(MIDDLE_SCHOOL)) continue;

                System.out.println(line);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
