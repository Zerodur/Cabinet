package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode()
        {
            for (Map.Entry<String, String> pair : countries.entrySet()){
                if (pair.getValue().equals(customer.getCountryName())){
                    return pair.getKey();
                }
            }
            return null;
        }

        @Override
        public String getCompany()
        {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            String str = contact.getName();
            return str.substring(str.indexOf(',') + 2);
        }

        @Override
        public String getContactLastName()
        {
            String str = contact.getName();
            return str.substring(0, str.indexOf(','));
        }

        @Override
        public String getDialString()
        {
            String str = contact.getPhoneNumber();
            return "callto://" + str.replaceAll("[()-]", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }

    public static void main(String[] args)
    {
        Customer customer = new Customer()
        {
            @Override
            public String getCompanyName()
            {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName()
            {
                return "Ukraine";
            }
        };

        Contact contact = new Contact()
        {
            @Override
            public String getName()
            {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber()
            {
                return "+38(050)123-45-67";
            }
        };
        DataAdapter dataAdapter = new DataAdapter(customer, contact);
        System.out.println(dataAdapter.getCompany());
        System.out.println(dataAdapter.getContactFirstName());
        System.out.println(dataAdapter.getCountryCode());
        System.out.println(dataAdapter.getContactLastName());
        System.out.println(dataAdapter.getDialString());

    }
}