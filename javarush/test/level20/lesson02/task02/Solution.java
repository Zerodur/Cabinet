package com.javarush.test.level20.lesson02.task02;

import com.javarush.test.level14.lesson08.home03.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("e:\\test2.txt");
            InputStream inputStream = new FileInputStream("e:\\test2.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User());
            //javaRush.users.get(0).setFirstName("Alex");
            javaRush.users.get(0).setLastName("Zeiss");
            javaRush.users.get(0).setBirthDate(new Date());
            javaRush.users.get(0).setMale(true);
            javaRush.users.get(0).setCountry(User.Country.OTHER);

            javaRush.users.add(new User());
            javaRush.users.get(1).setFirstName("Elee");
            javaRush.users.get(1).setLastName("Zeiss");
            javaRush.users.get(1).setBirthDate(new Date());
            javaRush.users.get(1).setMale(false);
            javaRush.users.get(1).setCountry(User.Country.OTHER);

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User());
            javaRush.users.get(2).setFirstName("Leonid");
            javaRush.users.get(2).setLastName("Zeiss");
            javaRush.users.get(2).setBirthDate(new Date());
            javaRush.users.get(2).setMale(true);
            javaRush.users.get(2).setCountry(User.Country.OTHER);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {

        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);

            printWriter.println(users.size());
            for (int i = 0; i < users.size(); i++){
                printWriter.println(users.get(i).getFirstName());
                printWriter.println(users.get(i).getLastName());
                printWriter.println(users.get(i).getBirthDate().getTime());
                printWriter.println(users.get(i).isMale());
                printWriter.println(users.get(i).getCountry().getDisplayedName());
            }
            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (reader.ready()){
                int usersSize = Integer.parseInt(reader.readLine());

                for (int i = 0; i < usersSize; i++){
                    User user = new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    user.setMale(Boolean.parseBoolean(reader.readLine()));
                    String country = reader.readLine();
                    if (country.equals(User.Country.OTHER.getDisplayedName())){
                        user.setCountry(User.Country.OTHER);
                    }else if (country.equals(User.Country.RUSSIA.getDisplayedName())){
                        user.setCountry(User.Country.RUSSIA);
                    }else user.setCountry(User.Country.UKRAINE);

                    users.add(user);
                }
            }
            reader.close();
        }

        public boolean equals(Object obj) {
            if ((obj == null) || (getClass() != obj.getClass())) {
                return false;
            }
            JavaRush javaRush = (JavaRush) obj;
            for (int i = 0; i < users.size(); i++) {
                User thisUser = users.get(i);
                User otherUser = javaRush.users.get(i);
                if (thisUser != null && otherUser != null) {
                    if (thisUser.getFirstName() != null && otherUser.getFirstName() != null) {
                        if (!thisUser.getFirstName().equals(otherUser.getFirstName())) {
                            return false;
                        }
                    }
                    else
                    {
                        if ((thisUser.getFirstName() != null && otherUser.getFirstName() == null) || (thisUser.getFirstName() == null && otherUser.getFirstName() != null))
                            return false;
                    }
                    if (thisUser.getLastName() != null && otherUser.getLastName() != null) {
                        if (!thisUser.getLastName().equals(otherUser.getLastName())) {
                            return false;
                        }
                    }
                    else
                    {
                        if ((thisUser.getLastName() != null && otherUser.getLastName() == null) || (thisUser.getLastName() == null && otherUser.getLastName() != null))
                            return false;
                    }
                    if (thisUser.getBirthDate() != null && otherUser.getBirthDate() != null) {
                        if (!thisUser.getBirthDate().equals(otherUser.getBirthDate())) {
                            return false;
                        }
                    }
                    else
                    {
                        if ((thisUser.getBirthDate() != null && otherUser.getBirthDate() == null) || (thisUser.getBirthDate() == null && otherUser.getBirthDate() != null))
                            return false;
                    }
                    if (!thisUser.isMale() == otherUser.isMale()) {
                        return false;
                    }
                    if (thisUser.getCountry() != null && otherUser.getCountry() != null) {
                        if (!thisUser.getCountry().equals(otherUser.getCountry())) {
                            return false;
                        }
                    }
                    else
                    {
                        if ((thisUser.getCountry() != null && otherUser.getCountry() == null) || (thisUser.getCountry() == null && otherUser.getCountry() != null))
                            return false;
                    }
                }
                else
                {
                    if (thisUser == null && otherUser == null)
                        continue;
                    else
                        return false;
                }
            }
            return true;
        }
    }
}

