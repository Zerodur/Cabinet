package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zerodur on 01.09.2016.
 */
public class MoikrugStrategy implements Strategy
{
    private final String URL_FORMAT = "http://moikrug.ru/vacancies?currency=rur&page=%d&q=java+%s";

    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            int pageNumber = 1;
            Document doc;
            while (true) {
                doc = getDocument(searchString, pageNumber++);
                if (doc == null) break;

                Elements elements = doc.getElementsByClass("job");
                if (elements.size() == 0) break;

                for (Element element : elements) {
                    // title
                    Element titleElement = element.getElementsByClass("title").first();
                    String title = titleElement.text();
                    // url
                    String url = titleElement.attr("href");
                    // company
                    String companyName = element.getElementsByClass("company_name").first().text();
                    // salary
                    Element salaryElement = element.getElementsByClass("count").first();
                    String salary = "";
                    if (salaryElement != null) {
                        salary = salaryElement.text();
                    }
                    // city
                    String city = "";
                    Element cityElement = element.getElementsByClass("location").first();
                    if (cityElement != null)
                    {
                        city = cityElement.text();
                    }

                    // site
                    String siteName = "http://moikrug.ru/";

                    // add vacancy to the list
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(url);
                    vacancies.add(vacancy);
                }
            }
        }
        catch (Exception e) {
            //e.printStackTrace();
        }

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {

        String url = String.format(URL_FORMAT, page, searchString);
        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                .referrer("none")
                .get();

        return document;
    }
}
