package Language;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Language {
    private String name;
    private String filename;
    private Type type;
    private String [] keywords;

public Language(String name, String filename, Type type) {
    int index = 0;

    // always check for nulls first then empty so it does not throw exception
    if ( name != null && !name.isEmpty()) {
        this.name = name;  // C
    }
    if (filename != null && filename != "") {
        this.filename = filename;  // c.txt
        File inFile = new File(this.filename);
        // numKeywords needs to be in right scope to use later to create array
        int numKeywords;
        try {
            Scanner inScan = new Scanner(inFile);
            // Clears console
            System.out.print('\u000c');
            numKeywords = inScan.nextInt();
            inScan.nextLine();
            // set array to size of numKeywords
            keywords = new String[numKeywords];
            while (inScan.hasNext()){
                keywords[index] = inScan.nextLine();
                //System.out.println(keyword[index]);
                if (index < numKeywords -1) {
                    index += 1;
                }
            }
            inScan.close();
            sortKwds();

        } catch (FileNotFoundException e) {
            // Display exception
            System.out.println("Exception Found " + e.getMessage());
        }


        // fill in sort keyword method
        // complete the to string
        // complete Language manager methods

    }
    if(type != null) {
        this.type = type; // Compiled
    }

}

public String getName() {
    return name;
}

public String getFilename() {
    return filename;
}

public Type getType() {
    return type;
}

public Integer getKwdCount() {
    return keywords.length;

}

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }
    public String[] getKeywords() {
        return keywords;
    }

    public String getKwd(Integer index) {
    return keywords[index];
}

public Integer findKwd(String keyword) {
    // indexOf
    //return keywords.indexOf(keyword);
    return null;
}
public Integer findShortestKwdLength() {
    if (keywords.length ==0){
        return -1;
    }
    int min = Integer.MAX_VALUE;
    for(int i=0; i< keywords.length; i++) {
        if (keywords[i].length()<min){
            min = keywords[i].length();
        };
    }
    return min;
}
public Integer findLongestKwdLength() {
    if (keywords.length == 0){
        return -1;
    }
    int max = Integer.MIN_VALUE;
    for(int i=0; i< keywords.length; i++) {
        if (keywords[i].length()>max){
            max = keywords[i].length();
        };
    }
    return max;
}

public void sortKwds(){
    // array has a method to sort its elements
    //Arrays.sort(keywords);
    int length = keywords.length;
    for (int index1=1; index1<length; index1++) {
        String value = keywords[index1];
        int index2 = index1-1;
        while( (index2>-1) && keywords[index2].compareTo(value)>0) {
            keywords[index2 +1] = keywords[index2];
            index2--;
        }
        keywords[index2+1] = value;

    }



}

public String toString() {
    return "name: " + name + " type: " + type + " keyword count: " + (keywords==null ? 0 : keywords.length) ;
}





}
