package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

/**
 * Created by Zerodur on 30.08.2016.
 */
public class HtmlView implements View
{
    private final String filePath = "./src/"+ this.getClass().getPackage().getName().replace('.','/') + "/vacancies.html";
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies)
    {
        updateFile(getUpdatedFileContent(vacancies));
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Гомель");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies)
    {
        Document doc = null;
            try
            {
            doc = getDocument();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "Some exception occurred";
        }

        Element original = doc.getElementsByClass("template").first();
        Element template = original.clone();
        template.removeClass("template").addClass("vacancy").removeAttr("style");
        doc.select("tr[class=vacancy]").remove();
        for (Vacancy vacancy : vacancies){
            Element clone = template.clone();
            clone.getElementsByClass("city").first().appendText(vacancy.getCity());
            clone.getElementsByClass("companyName").first().appendText(vacancy.getCompanyName());
            clone.getElementsByClass("salary").first().appendText(vacancy.getSalary());
            clone.getElementsByClass("title").first().child(0).appendText(vacancy.getTitle()).attr("href", vacancy.getUrl());
            original.before(clone);
        }

        return doc.html();
    }

    private void updateFile(String doc){

        FileWriter writer = null;
        try
        {
            writer = new FileWriter(filePath);
            writer.write(doc);
            writer.flush();
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException{
        Document html = Jsoup.parse(new File(filePath), "UTF-8");
        return html;
    }

}
/*
Element template = doc.getElementsByAttributeValueEnding("class","template").first();
        Element copyTemplate = template.clone();
        copyTemplate.removeClass("template").removeAttr("style");
        Element newDoc = doc.removeClass("vacancy");

        for (Vacancy vacancy : vacancies){
            Element clone = copyTemplate.clone();
            clone.getElementsByClass("city").first().appendText(vacancy.getCity());
            clone.getElementsByClass("companyName").first().appendText(vacancy.getCompanyName());
            clone.getElementsByClass("salary").first().appendText(vacancy.getSalary());
            clone.getElementsByClass("title").first().child(0).appendText(vacancy.getTitle()).attr("href", vacancy.getUrl());
            newDoc.select("table").first().appendChild(clone);
        }
 */