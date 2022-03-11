import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
try{
    URL weatherURL = new URL("http://dataservice.accuweather.com/forecasts/v1/daily/5day/294021?apikey=lMmY2qLZX7Nl8xuPDSvbssFf0qWwPfUY");
    HttpURLConnection urlConnection = (HttpURLConnection)weatherURL.openConnection();
//    Map<String, List<String>> headers= urlConnection.getHeaderFields();
//    for (String k : headers.keySet()){
//        System.out.println("Ключ: "+ k + " Значение: " +headers.get(k));
//    }

    if(urlConnection.getResponseCode() == 200){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))){
            StringBuilder responseContent = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {responseContent.append(line); }
            System.out.println(responseContent);
        }catch (IOException exception) {
             System.out.println(exception.getMessage());
            }
    }
    } catch (Exception ex){
    ex.getMessage();
        }
    }

}
