package com.sumanshekhar.java.advance.filehandling.gson;

import java.util.List;
//Contract
public interface KeywordAnalyzerInterface {

    void recordKeyword(String keyword);

    List<String> getAllKeyword();

    List<KeywordAndFrequency> getAllKeywordWithFreq();
}
