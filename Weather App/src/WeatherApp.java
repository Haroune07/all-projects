import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class WeatherApp {

    public static JSONObject getWeatherData(String locationName) {
        JSONArray locationData = getLocationData(locationName);

        if (locationData == null || locationData.isEmpty()) {
            System.out.println("Error: No location data found.");
            return null;
        }

        JSONObject location = (JSONObject) locationData.get(0);
        double latitude = (double) location.get("latitude");
        double longitude = (double) location.get("longitude");

        String urlString = "https://api.open-meteo.com/v1/forecast?" + 
        "latitude=" + latitude +
        "&longitude=" + longitude +
        "&hourly=temperature_2m,relative_humidity_2m,weather_code,wind_speed_10m&timezone=America%2FNew_York";

        try {
            HttpURLConnection connection = fetchApiResponse(urlString);

            if (connection == null || connection.getResponseCode() != 200) {
                System.out.println("Error: Could not connect to API");
                return null;
            }

            StringBuilder resultJSON = new StringBuilder();
            Scanner scanner = new Scanner(connection.getInputStream());

            while (scanner.hasNext()) {
                resultJSON.append(scanner.nextLine());
            }

            scanner.close();
            connection.disconnect();

            JSONParser parser = new JSONParser();
            JSONObject resultJsonObj = (JSONObject) parser.parse(String.valueOf(resultJSON));

            JSONObject hourly = (JSONObject) resultJsonObj.get("hourly");

            // Find the time
            JSONArray time = (JSONArray) hourly.get("time");
            int index = findIndexOfCurrentTime(time);

            if (index == -1) {
                System.out.println("Error: No matching time found.");
                return null;
            }

            // Find weather data
            JSONArray temperatureData = (JSONArray) hourly.get("temperature_2m");
            double temperature = (double) temperatureData.get(index);

            // Find weather condition
            JSONArray weatherCode = (JSONArray) hourly.get("weather_code");
            String weatherCondition = convertWeatherCode((long) weatherCode.get(index));

            // Find humidity
            JSONArray relativeHumidity = (JSONArray) hourly.get("relative_humidity_2m");
            long humidity = (long) relativeHumidity.get(index);

            // Find windspeed
            JSONArray windspeedData = (JSONArray) hourly.get("wind_speed_10m");
            double windspeed = (double) windspeedData.get(index);

            JSONObject weatherData = new JSONObject();
            weatherData.put("temperature", temperature);
            weatherData.put("weather_condition", weatherCondition);
            weatherData.put("humidity", humidity);
            weatherData.put("windspeed", windspeed);

            return weatherData;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static JSONArray getLocationData(String locationName) {
        locationName = locationName.replaceAll(" ", "+");

        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" +
                locationName + "&count=10&language=en&format=json";

        try {
            HttpURLConnection connection = fetchApiResponse(urlString);

            if (connection == null || connection.getResponseCode() != 200) {
                System.out.println("Error: Could not connect to API");
                return null;
            }

            StringBuilder resultJSON = new StringBuilder();
            Scanner scanner = new Scanner(connection.getInputStream());

            while (scanner.hasNext()) {
                resultJSON.append(scanner.nextLine());
            }

            scanner.close();
            connection.disconnect();

            JSONParser parser = new JSONParser();
            JSONObject resultJSJsonObj = (JSONObject) parser.parse(String.valueOf(resultJSON));

            return (JSONArray) resultJSJsonObj.get("results");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static HttpURLConnection fetchApiResponse(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int findIndexOfCurrentTime(JSONArray timeList) {
        String currentTime = getCurrentTime();

        for (int i = 0; i < timeList.size(); i++) {
            String time = (String) timeList.get(i);
            if (time.equalsIgnoreCase(currentTime)) {
                return i;
            }
        }
        return -1;
    }

    public static String getCurrentTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH':00'");
        return currentDateTime.format(formatter);
    }

    private static String convertWeatherCode(long weatherCode) {
        if (weatherCode == 0L) return "Clear";
        if (weatherCode > 0L && weatherCode <= 3L) return "Cloudy";
        if ((weatherCode >= 51L && weatherCode <= 67L) || (weatherCode >= 80L && weatherCode <= 99L)) return "Rain";
        if (weatherCode >= 71L && weatherCode <= 77L) return "Snow";
        return "Unknown";
    }

}

