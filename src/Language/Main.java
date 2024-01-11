package File142;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("/Users/gloriavilla/IdeaProjects/Project5/src/File142/languages.txt");
        Scanner inScan = new Scanner(inFile);
        // Clears console
        System.out.print('\u000c');

        // Variables to hold customer data
        String   langData;
        Language aLanguage;
        String name;
        String filename;
        Type type;

        // Read the data
        while (inScan.hasNext()) {
            inScan.nextLine();
            inScan.nextLine();
            langData = inScan.nextLine();
            System.out.println(langData);
            String[] arrOfStrLangData = langData.split(",", 3);
            name = arrOfStrLangData[0];
            System.out.println("name: " + name);
            filename = arrOfStrLangData[1];
            System.out.println("filename: " + filename);
            type = Type.valueOf(arrOfStrLangData[2]);
            System.out.println("type: " + type);

            //NOT SURE WHAT TO DO HERE BECAUSE TYPE IS TYPE AND IT IS STRING
            //type = arrOfStrLangData[2];

//            for (String a : arrOfStrLangData)
//                System.out.println(a);

            aLanguage = new Language(name, filename, type);
            System.out.println(aLanguage);
        }
        inScan.close();

    }
}