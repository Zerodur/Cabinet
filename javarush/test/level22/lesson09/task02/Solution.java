package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
    public static void main(String[] args)
    {
        Map<String, String> selectMap = new HashMap<String, String>();
       /* selectMap.put("name", "Ivanov");
        selectMap.put("country", null);
        selectMap.put("city", "Kiev");
        selectMap.put("age", null);
        selectMap.put("height", "185");*/
        System.out.println(getCondition(selectMap));
    }
    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder stringBuilder = null;
        if (!params.isEmpty())
        {
            stringBuilder = new StringBuilder();
            for (Map.Entry<String, String> pair : params.entrySet())
            {
                if (pair.getValue() != null & pair.getKey() != null)
                    if (stringBuilder.length() == 0)
                        stringBuilder.append(String.format("%s = '%s'", pair.getKey(), pair.getValue()));
                    else stringBuilder.append(String.format(" and %s = '%s'", pair.getKey(), pair.getValue()));
            }

        }
        return stringBuilder;
    }
}
