package org.sourin;

import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        URL url = null;
        HttpURLConnection connection = null;
        int responseCode = 0;
        String urlString = "https://api.chucknorris.io/jokes/random";


        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            System.out.println("URL Problem");
        }

        //connection

        try {
            connection = (HttpURLConnection) url.openConnection();
            responseCode = connection.getResponseCode();
        } catch (Exception e) {
            System.out.println("connection problem");
        }

        if(responseCode==200){
            StringBuilder apidata = new StringBuilder();

            try{

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));


                String readLine = null;

                while ((readLine = in.readLine()) != null) {
                    apidata.append(readLine);
                }

                in.close();
            }catch (Exception e){
                System.out.println("ResponseCode Problem");
            }

            JSONObject jsonObject=new JSONObject(apidata.toString());
            System.out.println(jsonObject.get("categories"));
            System.out.println(jsonObject.get("created_at"));
            System.out.println(jsonObject.get("icon_url"));
            System.out.println(jsonObject.get("id"));
            System.out.println(jsonObject.get("updated_at"));
            System.out.println(jsonObject.get("url"));
            System.out.println(jsonObject.get("value"));

            //or

            System.out.println(jsonObject.toString());

        }else{
            System.out.println("Api not called");
        }


    }
}