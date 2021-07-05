package coding.game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetClientPost {
    public static void main(String[] args) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();

            URL url = new URL("http://127.0.0.1:5000/item/test1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\n" +
                    "\t\"price\": 12.99,\n" +
                    "\t\"store_id\": 1,\n" +
                    "\t\"in_data\": [\n" +
                    "\t\t{\n" +
                    "\t\t\t\"ric\": \"0005.HK\",\n" +
                    "\t\t\t\"qty\": 7000,\n" +
                    "\t\t\t\"side\": \"Buy\",\n" +
                    "\t\t\t\"suspended\": \"false\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"ric\": \"0019.HK\",\n" +
                    "\t\t\t\"qty\": 2500,\n" +
                    "\t\t\t\"side\": \"Sell\",\n" +
                    "\t\t\t\"suspended\": \"\"\n" +
                    "\t\t}\n" +
                    "\t]\n" +
                    "}";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed : HTTP Error code: " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            StringBuilder outBuffer = new StringBuilder();
            JsonElement je;
            System.out.println("Output from server.....\n");
            while ((output = br.readLine()) != null) {
                outBuffer.append(output);
                // System.out.println(output);
            }

            je = jp.parse(outBuffer.toString());
            String prettyJsonString = gson.toJson(je);
            System.out.println(prettyJsonString);

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
