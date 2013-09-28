package utiles;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import com.google.gson.Gson;

public class MessageUtil {
    
    private final static StringBuilder URLGOOGLE = new StringBuilder("https://android.googleapis.com/gcm/send");
   // QUALITAS
    // private final static StringBuilder GOOGLEKEY = new StringBuilder("AIzaSyDXGcULzW0I5TNF1VzgicT7tlng6N0T7Vw");
   // SAMBORNS
    private final static StringBuilder GOOGLEKEY = new StringBuilder("AIzaSyA0EGE_tRowpirxKhKuS2trQ8QR-RzqzIc");
    
    
    
    public static String sendMsj(ArrayList<String> registrationIDs, String mensaje)
      {
    	
    	HashMap<String,Object> sourceMap = new HashMap<String,Object>();
        sourceMap.put("message", mensaje);
        sourceMap.put("registration_ids",registrationIDs);

        URL url;
        HttpURLConnection connection = null;  
        try {
          //Create connection
          url = new URL(URLGOOGLE.toString());
          connection = (HttpURLConnection)url.openConnection();
          connection.setRequestMethod("POST");
          connection.setRequestProperty("Authorization", GOOGLEKEY.toString());
          connection.set("Content-Type","application/json");

          connection.setRequestProperty("Content-Language", "en-US");  
                
          connection.setUseCaches (false);
          connection.setDoInput(true);
          connection.setDoOutput(true);

          String regIDJson= new Gson().toJson(sourceMap);
          
          System.out.println("DATOS JSON::::"+ regIDJson);
          System.out.println("::::HEADERS:::"+connection.getHeaderFields().toString());
        
          //
          
          //Envio de request
          DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
          wr.writeBytes (regIDJson);
          wr.flush ();
          wr.close ();

          //Get Response    
          InputStream is = connection.getInputStream();
          BufferedReader rd = new BufferedReader(new InputStreamReader(is));
          String line;
          StringBuffer response = new StringBuffer(); 
          while((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
          }
          rd.close();
          return response.toString();

        } catch (Exception e) {

          e.printStackTrace();
          return null;

        } finally {

          if(connection != null) {
            connection.disconnect(); 
          }
        }
      }
    
    
    
    
 
}