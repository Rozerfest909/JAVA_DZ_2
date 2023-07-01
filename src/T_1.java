import java.util.LinkedHashMap;
import java.util.Map;


//        1) Дана строка sql-запроса "select * from students where ".
//        Сформируйте часть WHERE этого запроса, используя StringBuilder.
//        Данные для фильтрации приведены ниже в виде json-строки.
//        Если значение null, то параметр не должен попадать в запрос.
//        Параметры для фильтрации:
//        {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} select * from students where 'name=Ivanov' and 'country=Russia' and...
//
public class T_1 {
    public static void main(String[] args) {
        T_01();
    }

    static void T_01() {



        StringBuilder task = new StringBuilder("select * from students where ");
        Map<String, String> Part = new LinkedHashMap<>();
        Part.put("name", "Ivanov");
        Part.put("country", "Russia");
        Part.put("city", "Moscow");
        Part.put("age", null);

        System.out.println(task + getQuery(Part));
    }

    static String getQuery(Map<String, String> params) {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null) {
                s.append(pair.getKey() + " = '" + pair.getValue() + "' and ");
            }
        }
        s.delete(s.toString().length() - 5, s.toString().length());
        return s.toString();
    }
}


