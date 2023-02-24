package HW_les5;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Пусть дан список сотрудников:Иван Иванов (и остальные)
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.
// Иван Иванов 88001122333
// Иван Курицин 88001662333
// Иван Курицин 88001112333
// Иван Незлобин 88001122432
// Сергей Потапов 88001112453
// Сергей Потапов 8800163214
// Сергей Курицин 8800142421
// Михаил Незлобин 880012343
// OutPut
// Иван - 3
// Сергей - 2
// Потому как если один сотрудник имеет 2 или более номера , его имя считаем 1 раз.

public class HW_les5 {
   public static void main(String[] args) {
      LinkedHashMap<String, String> phoneNumAndNames = new LinkedHashMap<>();

      phoneNumAndNames.put("88001122333", "Иван Иванов");
      phoneNumAndNames.put("88001662333", "Иван Курицын");
      phoneNumAndNames.put("88001112333", "Иван Курицын");
      phoneNumAndNames.put("88001122432", "Иван Незлобин");
      phoneNumAndNames.put("88001112453", "Сергей Потапов");
      phoneNumAndNames.put("8800163214", "Сергей Потапов");
      phoneNumAndNames.put("8800142421", "Сергей Курицин");
      phoneNumAndNames.put("880012343", "Михаил Незлобин");
      for (Entry<String, String> item : phoneNumAndNames.entrySet()) {
         System.out.println(item.getValue() + " " + item.getKey());
      }

      List<String> arr = new ArrayList<>(phoneNumAndNames.values());
      ArrayList<String> arr1 = new ArrayList<>();
      arr1.add(arr.get(0));
      for (int index = 1; index < arr.size(); index++) {
         if (arr.get(index) != arr.get(index - 1)) {
            arr1.add(arr.get(index));
         }
      }
      
      ArrayList<String> arr2 = new ArrayList<>();
      int count = 1;
      for (int index = 0; index < arr1.size(); index++) {
         String[] firstWord = arr1.get(index).split(" ", 2);
         arr2.add(firstWord[0]);
      }
     
      for (int i = 0; i < arr2.size(); i++) {
         for (int j = i+1; j < arr2.size(); j++) {
            if (arr2.get(i).equals(arr2.get(j))) {
               count += 1;
               arr2.remove(j);
            } 
         }
         System.out.println(arr2.get(i) + ": " + count);
         count = 1;
      }
   }
}