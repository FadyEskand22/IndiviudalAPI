
package com.mycompany.apiindividual;

import java.util.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class APIindividual {
    
    private static HttpURLConnection connect;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Scanner input = new Scanner(System.in);
        System.out.print("Which nintendo game character would you like to search for?: ");
        String game = input.nextLine();
        
        StringBuffer  output = new StringBuffer();
        String line;
        BufferedReader read;
        
        try{
           URL url = new URL("https://www.amiiboapi.com/api/amiibo/?name=" + game); 
           HttpURLConnection connect = (HttpURLConnection) url.openConnection();
           
           connect.setRequestMethod("GET");
           connect.connect();
           
           int connectionStatus = connect.getResponseCode();
           if(connectionStatus < 200){
               System.out.println("Connection unsuccessful ");
               
           }
           else {
              read = new BufferedReader (new InputStreamReader(connect.getInputStream()));
              while((line = read.readLine()) != null){
                  output.append(line);
              }
              connect.disconnect();
           }
            System.out.println(output.toString());
            connect.disconnect();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
    }
    
                
    
}
