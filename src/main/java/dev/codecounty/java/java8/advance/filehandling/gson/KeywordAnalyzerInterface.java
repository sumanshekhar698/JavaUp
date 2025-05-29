package dev.codecounty.java.java8.advance.filehandling.gson;

import java.util.List;
//Contract
public interface KeywordAnalyzerInterface {

    void recordKeyword(String keyword);

    List<String> getAllKeyword();

    List<KeywordAndFrequency> getAllKeywordWithFreq();
}
