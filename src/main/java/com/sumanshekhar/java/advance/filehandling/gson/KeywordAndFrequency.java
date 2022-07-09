package com.sumanshekhar.java.advance.filehandling.gson;

public class KeywordAndFrequency
        implements Comparable
{
    /*
    {
      "keyword":"mobile",
      "freq":3
    }
     */
    String keyword;
    int freq;

    public KeywordAndFrequency(String keyword, int freq) {
        this.keyword = keyword;
        this.freq = freq;
    }

    @Override
    public String toString() {
        return "KeywordAndFrequency{" +
                "keyword='" + keyword + '\'' +
                ", freq=" + freq +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        KeywordAndFrequency keywordAndFrequency = (KeywordAndFrequency)o;
        return this.freq-((KeywordAndFrequency) o).freq;
    }

}
