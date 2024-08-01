package org.example;

import org.json.JSONArray;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ParseDataFromBinance
{
    public static ArrayList<Crypto> getDAta(){
        try {
            URL url = new URL("https://api.binance.com/api/v3/ticker/price");

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(url.openStream()));
            String data= bufferedReader.readLine();

            JSONArray jsonArray=new JSONArray(data);
            return ReplaceArray.replaceData(jsonArray);

        } catch (MalformedURLException e) {
            System.err.println("2");
            throw new RuntimeException(e);
        }catch (IOException e){
            System.err.println("1");
            throw new RuntimeException(e);
        }

    }

}
