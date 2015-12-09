package spil;

/**
 * Created by johanandersen on 01/12/2015.
 */


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;


/**
 * The Constructor for the class
 */

public class Api {

    ServerConnect serverConnect = new ServerConnect();


    /**
     *This method is used to login on the server and are posting an object of User in Gson to Json format
     */

    public String login(User user) {

        String message;

        String data = serverConnect.post(new Gson().toJson(user), "login");
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(data);
            JSONObject jsonobject = (JSONObject) object;

            message = (String) jsonobject.get("message");

            if (jsonobject.get("userid") != null) {
                user.setId((int) (long) jsonobject.get("userid")); //Long tvinger JSON til int
            }

        } catch (ParseException e) {
            message = "You didn't type anything";
        }
        return message;
    }

    /**
     * This method makes an ArrayList of the users,
     * by getting all the users from the server using a get-request on the path "users/"
     * and get all the users from the server and make an ArrayList of User
     */
    public ArrayList<User> getUsers() {

        String jsonOfUsers = serverConnect.get("users");

        return new Gson().fromJson(jsonOfUsers, new TypeToken<ArrayList<User>>() {
        }.getType());

    }

    public String createGame(Game game) {

        String jsonData = serverConnect.post(new Gson().toJson(game), "games/");

        return serverConnect.messageParser(jsonData);
    }

    /**
     * This method makes an ArrayList of the games that are open,
     * by getting all the users from the server using a get-request on the path "games/open/"
     * and get all the games from the server and make an ArrayList of games
     */
    public ArrayList<Game> getOpenGames() {
        String jsonData = serverConnect.get("games/open");

        return new Gson().fromJson(jsonData, new TypeToken<ArrayList<Game>>() {
        }.getType());
    }


    public String joinGame(Game game) {
        String jsonData = serverConnect.put("games/join", new Gson().toJson(game));
        return serverConnect.messageParser(jsonData);
    }

    public String startGame(Game game) {
        String jsondata = serverConnect.put("games/start", new Gson().toJson(game));
        return serverConnect.messageParser(jsondata);
    }

    public String deleteGame(int gameID) {
        String jsonData = serverConnect.delete("games/" + gameID);

        return serverConnect.messageParser(jsonData);
    }

    public ArrayList<Score> getHighScore(){
        String jsonData = serverConnect.get("scores/{userid}");

        return  new Gson().fromJson(jsonData, new TypeToken<ArrayList<Score>>(){}.getType());
    }
}

