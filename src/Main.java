import java.util.Scanner;
import org.json.JSONException;

public class Main {
    public static void main(String[] args) {
        City city;
        CityManager cityManager = new CityManager();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the city name: ");
        String cityName = scan.nextLine();
        scan.close();
        System.out.println("Loading...");

        try {
            city = cityManager.getCityByName(cityName);
            cityManager.printTempsThisWeek(city);
        } catch (JSONException e) {
            System.out.println(String.format("%s couldn't found!",cityName));
        } catch (Exception e) {
            System.out.println("Unknown Error");
        }

    }
}

