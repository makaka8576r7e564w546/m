package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Iterator;

public class CompareJSONData {
    static FileReader afterData, beforeData;
    static FileWriter fileWriter;
    static JSONArray after,before;

    public static void compareJSONData(){
        try {
            afterData = new FileReader("AfterData.json");

            beforeData = new FileReader("BeforeData.json");
            fileWriter=new FileWriter("result.json");
        } catch (FileNotFoundException e) {
            System.out.println("Чтение");
            throw new RuntimeException(e);

        } catch (IOException e) {
            System.out.println("Запись");
            throw new RuntimeException(e);

        }
        JSONParser jsonParser=new JSONParser();
        try {
            after=(JSONArray) jsonParser.parse(afterData);
            before=(JSONArray) jsonParser.parse(beforeData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        JSONArray jsonArray=new JSONArray();

        for (int i = 0; i < after.size()&&i< before.size(); i++) {
            JSONObject jsonObject1=(JSONObject) after.get(i);
            JSONObject jsonObject2=(JSONObject)  before.get(i);
            double delta=  Double.parseDouble(jsonObject1.get("price").toString())/ Double.parseDouble(jsonObject2.get("price").toString())*100;
           double result=Math.abs(100-delta);
           if (result>0.5){
               JSONObject jsonObject=new JSONObject();
               jsonObject.put("Token name", jsonObject1.get("CoinsName"));
               jsonObject.put("Cost change", String.valueOf(result));
            if (delta<100){
                jsonObject.put("Direction change"," UP");


                System.out.println("Цена токена "+jsonObject1.get("CoinsName")+" выросла "+result+ " %");
            }
            else {
                jsonObject.put("Direction change","DOWN");


                System.out.println("Цена токена "+jsonObject1.get("CoinsName")+" упала на "+ result+" %");
            }
            jsonArray.add(jsonObject);

           }



        }
        try {
            fileWriter.append(jsonArray.toJSONString());
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Проблема с записью в файл results.json");
            throw new RuntimeException(e);
        }
        System.out.println(jsonArray);
    }
}
