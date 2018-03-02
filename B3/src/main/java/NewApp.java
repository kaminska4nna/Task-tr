
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NewApp {
        public static void main(String[] args) throws FileNotFoundException,
                IOException, ParseException {

                JSONParser parser = new JSONParser();
                JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(
                        "B3/task_B3.json"));

                for (Object o : jsonArray) {
                        JSONObject name = (JSONObject) o;

                        String strId = (String) name.get("id");
                        System.out.print(strId + ": ");

                        String priceUSD = (String) name.get("price_usd");
                        System.out.print(priceUSD);
                        System.out.println();


                }

        }
}