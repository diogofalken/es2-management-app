package middlewares;

import interfaces.ResourceRestApiMethods;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import types.Resource;
import types.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

public class ResourcesMiddleware implements ResourceRestApiMethods {
    @Override
    public Collection<Resource> getResources() {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/resources");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            // Buffer
            InputStreamReader in = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(in);

            // String Builder
            StringBuilder result = new StringBuilder();

            // Output
            String output;

            while ((output = br.readLine()) != null) {
                result.append(output);
            }

            // Closing the buffer
            br.close();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());
            JSONArray jsonArray = (JSONArray) jsonOutput.get("data");

            Collection<Resource> resourceCollection = new ArrayList<Resource>();

            for(int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonobject = (JSONObject) jsonArray.get(i);
                Integer id = Integer.parseInt(jsonobject.get("id").toString());
                String name = jsonobject.get("name").toString();
                Integer year = Integer.parseInt(jsonobject.get("year").toString());
                String color = jsonobject.get("color").toString();
                String pantoneValue = jsonobject.get("pantone_value").toString();

                Resource resource = new Resource(id, name, year, color, pantoneValue);

                resourceCollection.add(resource);
            }

            connection.disconnect();
            return resourceCollection;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Resource getResource(Integer id) {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/resources/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            // Buffer
            InputStreamReader in = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(in);

            // String Builder
            StringBuilder result = new StringBuilder();

            // Output
            String output;

            while ((output = br.readLine()) != null) {
                result.append(output);
            }

            // Closing the buffer
            br.close();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());
            JSONObject jsonData = (JSONObject) jsonOutput.get("data");

            // fields
            String name = jsonData.get("name").toString();
            Integer year = Integer.parseInt(jsonData.get("year").toString());
            String color = jsonData.get("color").toString();
            String pantoneValue = jsonData.get("pantone_value").toString();

            Resource resource = new Resource(id, name, year, color, pantoneValue);

            connection.disconnect();

            return resource;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
