package com.sumanshekhar.java.advance.filehandling.json;

import org.json.JSONObject;

//https://mvnrepository.com/artifact/org.json/json/20210307
public class JSONMessageInJava {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONObject msg = new JSONObject();
        msg.put("Name", "John");
        msg.put("Age", 25);

        JSONObject msgAddress = new JSONObject();
        msgAddress.put("Street", "Las Vegas");
        msgAddress.put("Country", "USA");
        msgAddress.put("PIN", "097876");
        msg.put("Address", msgAddress);
        jsonObject.put("msg", msg);
        System.out.println(jsonObject);

    }

}
