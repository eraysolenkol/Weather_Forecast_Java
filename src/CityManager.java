import org.json.JSONObject;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;

public class CityManager {
    JsonReader jR = new JsonReader();

    public City getCityByName(String cityName) throws IOException, JSONException {
        JSONObject json = jR.readJsonFromUrl(String.format("https://weatherdbi.herokuapp.com/data/weather/%s", cityName));
        City city = new City(json.getString("region"));
        city.setCurrentCTemp(json.getJSONObject("currentConditions").getJSONObject("temp").getInt("c"));
        JSONArray days = json.getJSONArray("next_days");
        
        for (int i = 0; i < days.length()-1; i++) {
            JSONObject day = (JSONObject)days.get(i);
            city.getcTempsByDays().put(day.getString("day"), day.getJSONObject("max_temp").getInt("c"));
        }
        return city;
    }

    public void printTempsThisWeek(City city) {
        System.out.println("City: " + city.getName());
        System.out.println("(Current temp: " + city.getCurrentCTemp() + "°C)");
        for (String day : city.getcTempsByDays().keySet()) {
            System.out.println(day + ": " + city.getcTempsByDays().get(day) + " °C");
        }
    }


}
