package practiceseleniumsessions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CompareTextFiles {

    public static void main(String[] args) throws IOException {
        FileReader fr1 = new FileReader("C:\\Users\\akash mani\\Desktop\\compare.csv");
        FileReader fr2 = new FileReader("F:\\paisawale\\automation_project\\src\\test\\resources\\bhavCopy\\cm15JUN2018bhav.csv.zip");
        BufferedReader br1 = new BufferedReader(fr1);
        BufferedReader br2 = new BufferedReader(fr2);
        String line1 = br1.readLine();
        String line2 = br2.readLine();
        boolean areEqual = true;
        int linenum=1;
        while(line1 != null || line2 != null) {

            if(line1 == null || line2 == null) {
                areEqual = false;
                break;

            }

            else if (!line1.equalsIgnoreCase(line2)){
                areEqual = false;
                break;
            }

            line1 = br1.readLine();
            line2 = br2.readLine();
            linenum++;

        }

        if(areEqual == true) {
            System.out.println("Both file's contents matches");
        }

        else {
            System.out.println("Files content are diffrent at line number "+linenum);
        }

        br1.close();
        br2.close();




    }
}
