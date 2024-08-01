package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveData {

    public static class SaveDataBefore{
        public static void saveData(ArrayList<Crypto> arrayList){
            try {
                FileWriter fileWriter=new FileWriter("BeforeData.json");
               JSONArray jsonArray=new JSONArray();
                for (Crypto obj:arrayList) {
                    JSONObject jsonObject=new JSONObject();
                    jsonObject.put("price",obj.price);
                    jsonObject.put("CoinsName",obj.symbol);
                    jsonArray.put(jsonObject);
                }
                fileWriter.append(jsonArray.toString());
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Recording problem beforeData");
            }

        }
    }
    public static class SaveDataAfter{
        public static void saveData(ArrayList<Crypto> arrayList){
            try {
                FileWriter fileWriter=new FileWriter("AfterData.json");
                JSONArray jsonArray=new JSONArray();
                for (Crypto obj:arrayList) {
                    JSONObject jsonObject=new JSONObject();
                    jsonObject.put("price",obj.price);
                    jsonObject.put("CoinsName",obj.symbol);
                    jsonArray.put(jsonObject);
                }
                fileWriter.append(jsonArray.toString());
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Recording problem afterData");
            }
        }
    }
}
