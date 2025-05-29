package dev.codecounty.java.java8.advance.filehandling.gson;

import com.google.gson.Gson;

import java.util.List;

//Dev-1
public class KeywordDriver {
    public static void main(String[] args) {

        KeywordAndFrequency keywordAndFrequency = new KeywordAndFrequency("Mobile", 3);
        System.out.println(keywordAndFrequency);// to String Format
        Gson gson = new Gson();
        System.out.println(gson.toJson(keywordAndFrequency));// Json Format

        KeywordAnalyzerInterface keywordAnalyzerInterface = new KeywordAnalyserImplementation();
        keywordAnalyzerInterface.recordKeyword("Laptop");
        keywordAnalyzerInterface.recordKeyword("Mobile");
        keywordAnalyzerInterface.recordKeyword("Ear Phone");
        keywordAnalyzerInterface.recordKeyword("Ear Phone");
        keywordAnalyzerInterface.recordKeyword("Ear Phone");
        keywordAnalyzerInterface.recordKeyword("Mobile");
        keywordAnalyzerInterface.recordKeyword("Pen");
        keywordAnalyzerInterface.recordKeyword("Macbook");
        keywordAnalyzerInterface.recordKeyword("Pen");


//		Printing all the Keywords
        for (String keyword : keywordAnalyzerInterface.getAllKeyword()) {
            System.out.print(keyword + " ");
        }
        System.out.println("\n");

        List<KeywordAndFrequency> list = keywordAnalyzerInterface.getAllKeywordWithFreq();
        String response = gson.toJson(list);
        System.out.println(response);

//        for(KeywordAndFrequency keywordAndFrequency: keywordAnalyzerInterface.getAllKeywordWithFreq()){
//            System.out.println(keywordAndFrequency);
//        }

    }
}
