package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ReplaceArray {
    public static ArrayList<Crypto>replaceData(JSONArray jsonArray){
    ArrayList<Crypto> cryptos=new ArrayList<>();
        for (Object elem:jsonArray) {
            JSONObject jsonObject=(JSONObject) elem;
            Crypto crypto= Crypto.builder().
                    symbol(jsonObject.get("symbol").toString())
                    .price(jsonObject.get("price").toString()).build();
                    cryptos.add(crypto);
        }

        return cryptos;
    }
}
