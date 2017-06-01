//Imported Items Jsoup tools for scraping
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

//Exception import

public class Scraper {

    public static void main(String[] args) throws IOException {

        //create a connection to the website that scraper reads from
        final Document document = Jsoup.connect("http://www.imdb.com/chart/top").get();
        final Document document1 = Jsoup.connect("http://www.billboard.com/charts/hot-100").get();

        //from the web page pick the part we want to scan (for each loop does them all)
        for (Element row: document.select("table.chart.full-width tr"))
        {
            //store values picked from certain columns
            final String title = row.select(".titleColumn a").text();
            final String rating = row.select(".imdbRating").text();

            //print them all out
            //System.out.println(title + " -> Rating: " + rating);
            
        }

        for (Element row: document1.select("div.chart-row__container"))
             {
                 final String song = row.select("h2.chart-row__song").text();
                 final String artists = row.select("a.chart-row__artist").text();
                System.out.println(song + " Artist: " + artists);
        }


    }

}
