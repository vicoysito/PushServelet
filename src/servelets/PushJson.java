package servelets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import utiles.DAOPush;
import utiles.MessageUtil;


/*
 * 
 * $headers = array(
            'Authorization: key=' . GOOGLE_API_KEY,
            'Content-Type: application/json'
        );
        
                curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        
           $fields = array(
            'registration_ids' => $registatoin_ids,
            'data' => $message
        );
        
       curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($fields));
       
API Project: 699404857819

API key:



////////
 * 
 
 
URLConnection connection = new URL(url).openConnection();
connection.setDoOutput(true); // Triggers POST.
connection.setRequestProperty("Accept-Charset", charset);
connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
OutputStream output = connection.getOutputStream();
try {
     output.write(query.getBytes(charset));
} finally {
     try { output.close(); } catch (IOException logOrIgnore) {}
}
InputStream response = connection.getInputStream();
// ...


 * 
 */




/**
 * Servlet implementation class PushJson
 */
@WebServlet(description = "Parsea el formulario a Json y manda una petición http por post", urlPatterns = { "/PushJson" })
public class PushJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private StringBuilder url = new StringBuilder();
       

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     try {
	    	 
	        String msj = request.getParameter("mensaje");
	    	url.append("https://android.googleapis.com/gcm/send");
	    	
	    	
	    	
	        DAOPush keyValues = new DAOPush();
	        
	        //ArrayList<String> disRegID = keyValues.ObtieneDatos();
	        ArrayList<String> disRegID = new ArrayList<String>();
	        
	        disRegID.add("APA91bHoBE3U-N-TGpbUYaSqyHVcVQIfawB3ktjIW8qDmaEo1s-vq33eA6b3Hx71nWQP5i9qRSoMY8wFYQShI7ELz3hR6P14y195i8sXWmYZ08FocX_MJUSbjVdvUgSbZd21e7iCyn7j2DRyDnK9WmaR0kUApWHOv7eFmQ8NdIhriVMLqWFu84I");
	        
	        String resp = MessageUtil.sendMsj(disRegID, "que show");
	        
	        System.out.println("respuesta:::"+resp);
	        
	        
	        
	        
	        
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String getServletInfo() {
        return "Manejador de segmentos";
    }
	
   

}
