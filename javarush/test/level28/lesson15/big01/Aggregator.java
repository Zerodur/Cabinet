package com.javarush.test.level28.lesson15.big01;


import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;


/**
 * Created by Zerodur on 24.08.2016.
 */
public class Aggregator
{
    public static void main(String[] args)
    {
        Provider providerMK = new Provider(new MoikrugStrategy());
        Provider providerHH = new Provider(new HHStrategy());
        HtmlView view = new HtmlView();
        Model model = new Model(view, providerHH);
        Controller controller = new Controller(model);

        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}
