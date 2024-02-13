package com.sumanshekhar.java.advance.filehandling.gson;

import java.util.*;

//by Dev2
public class KeywordAnalyserImplementation implements KeywordAnalyzerInterface{

//    Set<String> keywordStore;
//    Set<String> keywordStore;

    Map<String,Integer> keywordFreqMap;

    public KeywordAnalyserImplementation() {
//        this.keywordStore = new HashSet<>(); // order is not maintained
//        this.keywordStore = new LinkedHashSet<>(); // insertion order is maintained
        keywordFreqMap = new TreeMap<>(); // natural order
    }

    @Override
    public void recordKeyword(String keyword) {
//        keywordStore.add(keyword);
        if(keywordFreqMap.containsKey(keyword)){
            keywordFreqMap.put(keyword, keywordFreqMap.get(keyword)+1);
        }
        else{
            keywordFreqMap.put(keyword, 1);
        }
    }

    @Override
    public List<String> getAllKeyword() {
        List<String> response = new ArrayList<>(keywordFreqMap.keySet());
//        response.addAll(keywordStore);
        return response;
    }

    @Override
    public List<KeywordAndFrequency> getAllKeywordWithFreq() {
        List<KeywordAndFrequency> keywordAndFrequencyList = new ArrayList<>();
        for(String keyword : keywordFreqMap.keySet()){
            keywordAndFrequencyList.add(new KeywordAndFrequency(keyword,keywordFreqMap.get(keyword)));
        }
      //  Collections.sort(keywordAndFrequencyList);
//        Collections.sort(keywordAndFrequencyList, new Comparator<KeywordAndFrequency>() {
//            @Override
//            public int compare(KeywordAndFrequency o1, KeywordAndFrequency o2) {
//                return o2.freq - o1.freq;
//            }
//        });

        Collections.sort(keywordAndFrequencyList, (o1,o2)->{ return o2.freq - o1.freq;});

        return keywordAndFrequencyList;
    }
}
