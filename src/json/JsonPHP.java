/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 *
 * @author ARQ
 */
public class JsonPHP {
    String json ;
        
    public JsonPHP(){
        json = getJSONPHP();        
    }
    
    public static String getJSONPHP(){                
      
      StringBuffer response = null; 
      String res = null;           
      try {                                      
          String urldir ="http://www.midominio.com/getJson.php";                                                                         
          URL oracle = new URL(urldir);
          URLConnection obj = oracle.openConnection();
          HttpURLConnection con = (HttpURLConnection) obj;
          BufferedReader in;          
          in = new BufferedReader(new InputStreamReader(obj.getInputStream()));
          response = new StringBuffer();

          while ((res = in.readLine()) != null) {
            response.append(res);
          }                                  
          in.close();                                                                                                                         
        } catch (Exception e) {
             e.printStackTrace();               
        }   
        return response.toString();                        
    }
    
    public  JSONArray objJSON(String json){         
        Object jsonObject =JSONValue.parse(json.toString()); 
        JSONArray array=(JSONArray)jsonObject;
        return array;
    }
}
