package Language;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/**
 * Main program for Language Manager project
 *
 * @params args command line parameters
 * @throws FileNotFoundException
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File inFile = new File("languages.txt");
        Scanner inScan = new Scanner(inFile);
        // Clears console
        System.out.print('\u000c');

        // Variables to hold customer data
        String   langData;
        Language aLanguage;
        String name;
        String filename;
        Type type = null;
        String typeStr;
        int index = 0;
        // Read the data
        int numLanguages = inScan.nextInt();
        inScan.nextLine();
        inScan.nextLine();
        // create array size of languages
        Language [] arrayLanguages = new Language[numLanguages];
        while (inScan.hasNext()) {
            langData = inScan.nextLine();
            System.out.println(langData);

            // make more dynamic by counting the number of columns instead of hard coding

            String[] arrOfStrLangData = langData.split(",", 3);
            name = arrOfStrLangData[0];
            System.out.println("name: " + name);
            filename = arrOfStrLangData[1];
            System.out.println("filename: " + filename);

            typeStr = arrOfStrLangData[2];
            System.out.println("type: " + typeStr);

            //NOT SURE WHAT TO DO HERE BECAUSE TYPE IS TYPE AND IT IS STRING
            //type = arrOfStrLangData[2];

//            for (String a : arrOfStrLangData)
//                System.out.println(a);
            if (typeStr.equals("Compiled")) {
                type = Type.COMPILED;
            }
            if (typeStr.equals("Interpreted")) {
                type = Type.INTERPRETED;
            }
            if (typeStr.equals("Numerical_Analysis")) {
                type = Type.NUMERICAL_ANALYSIS;
            }
            if (typeStr.equals("Scripting")) {
                type = Type.SCRIPTING;
            }

            aLanguage = new Language(name, filename, type);
            arrayLanguages[index] = aLanguage;
            if (index < numLanguages -1) {
                index += 1;
            }


            System.out.println(aLanguage);
        }
        inScan.close();

    }
}