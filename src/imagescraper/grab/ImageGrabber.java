/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagescraper.grab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Pavilion G4
 */
public class ImageGrabber {
     public String grab(String link)throws IOException{
    URL url =new URL(link);
       URLConnection conn=url.openConnection();
       StringBuilder content=new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line="";
                    content = new StringBuilder();
                    while((line=reader.readLine())!=null)
                    {
                        content.append(line).append("\n");
                    }
                reader.close();
                return content.toString();
                
                
    
}
}
