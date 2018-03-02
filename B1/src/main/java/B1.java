import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class B1 {
    public static void main(String[] args) {
        String html = "http://www.ote-cr.cz/statistics/imbalances-electricity/";

        try {
            Document doc = Jsoup.connect(html).get();
            Elements tableElements = doc.select("table");
            Elements tableHeaderEles = tableElements.select("thead tr th");
            System.out.println("headers");

            for (int i = 0; i < tableHeaderEles.size(); ++i) {
                System.out.println(((Element) tableHeaderEles.get(i)).text());
            }

            System.out.println();
            Elements tableRowElements = tableElements.select(":not(thead) tr");

            for (int i = 0; i < tableRowElements.size(); ++i) {
                Element row = (Element) tableRowElements.get(i);
                System.out.println("row");
                Elements rowItems = row.select("td");

                for (int j = 0; j < rowItems.size(); ++j) {
                    System.out.println(((Element) rowItems.get(j)).text());
                }

                System.out.println();
            }
        } catch (IOException var10) {
            var10.printStackTrace();
        }
    }
}