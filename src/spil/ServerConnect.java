package spil;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by sverreostgaard on 25.11.15.
 */
public class ServerConnect {

    String host;
    int port;

    /**
     * Initializing the objects.
     */
    public ServerConnect() {
        this.host = "http://localhost";
        this.port = 8888;
    }

    /**
     *This method gets the host address.
     */
    public String getHost() {
        return host;
    }

    /**
     * This method gets the port number
     */
    public int getPort() {
        return port;
    }

    /**
     * This method is being used when we need to get at object from the server.
     */
    public String get(String path) {

        Client client = Client.create();

        WebResource webResource = client.resource(getHost() + ":" + getPort() + "/api/" + path);

        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        String message = response.getEntity(String.class);
        if (response != null) {
            return message;
        }
        return "";
    }


    /**
     *This is used when we are setting/posting to the server.
     */
    public String post(String json, String path) {
        Client client = Client.create();

        WebResource webResource = client.resource(getHost() + ":" + getPort() + "/api/" + path);

        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

        if (response != null) {
            return response.getEntity(String.class);
        }
        return "";
    }


    /**
     * the Method is used when we putting something in to the server or adding
     */
    public  String put(String path, String json){
        Client client = Client.create();
        WebResource webResource = client.resource(getHost()+ ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);

        String output = response.getEntity(String.class);
        return output;
    }


    /**
     *This method is  for converting the message received from the server into a String that can be shown in a client
     */
    public String messageParser(String json) {
        JSONParser jsonParser = new JSONParser();

        String message = "";
        try {
            Object obj = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;

            message = ((String) jsonObject.get("message"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return message;
    }


    /**
     *This method is used when there is a need to delete an object from the server.
     */
    public String delete(String path) {
        Client client = Client.create();
        System.out.println(getHost() + ":" + getPort() + "/api/" + path);
        WebResource webResource = client.resource(getHost() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);

        return response.getEntity(String.class);

    }
}



