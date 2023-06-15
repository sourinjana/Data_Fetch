package org.sourin;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        URL url=null;
        String urlString="https://api.zippopotam.us/us/33162";

        try {
            url=new URL(urlString);
        } catch (MalformedURLException e) {
            System.out.println("Url Problem");
        }

        HttpURLConnection connection=null;
        int resPonse=0;
        try {
            connection = (HttpURLConnection) url.openConnection();
            resPonse = connection.getResponseCode();
        }catch (Exception e){
            System.out.println("Connection Problem");
        }

        if(resPonse==200){
            StringBuilder apidata=new StringBuilder();

            try {
                BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String readLine=null;
                while ((readLine=in.readLine())!=null){
                    apidata.append(readLine);
                }
                in.close();
            }catch (Exception e){
                System.out.println("Buffer problem");
            }
            JSONObject jsonObject=new JSONObject(apidata.toString());
            System.out.println(jsonObject.get("post code"));
            System.out.println(jsonObject.get("country"));
            System.out.println(jsonObject.get("country abbreviation"));
            System.out.println(jsonObject.get("places"));
            //or
            System.out.println(jsonObject.toString());
        }else{
            System.out.println("Api Problem");
        }

    }
}