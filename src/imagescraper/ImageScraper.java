/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagescraper;

import imagescraper.grab.ImageGrabber;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pavilion G4
 */
public class ImageScraper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
      
       
       
         ImageGrabber grabber = new ImageGrabber();       
         String content = grabber.grab("http://www.fanpop.com/clubs/disneyland/images");
         System.out.println("Getting images...........");
        // String content=
                
       String regex="<img class=\"border\" src=\"(.*?)\"\\s width=\"(.*?) alt=(.*?)/></a><br />";
        Pattern pattern= Pattern.compile(regex);
      
        Matcher matcher=pattern.matcher(content);
       
        while(matcher.find())
        {
           
            String imgLink= matcher.group(1);
            URL imgUrl=new URL(imgLink);
            URLConnection conn1=imgUrl.openConnection();
            InputStream is = conn1.getInputStream();
         
           String[] tokens=imgLink.split("/");
           String path="C:\\Users\\Pavilion G4\\Desktop\\output\\disney\\";
           FileOutputStream os = new FileOutputStream(path+tokens[tokens.length-1]);
            byte[] data=new byte[1024];
                int i=0;
                while((i=is.read(data))!=-1)
                {
                    os.write(data, 0, i);
                }
                os.close();
                is.close();
        }
       

    }
    
}
