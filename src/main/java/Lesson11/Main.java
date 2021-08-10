
/*
 * 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
 *  Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 *  Посчитать, сколько раз встречается каждое слово.
 * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 *  В этот телефонный справочник с помощью метода add() можно добавлять записи.
 *  С помощью метода get() искать номер телефона по фамилии.
 *  Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 *  тогда при запросе такой фамилии должны выводиться все телефоны.
 * * * Желательно как можно меньше добавлять своего, чего нет в задании
 *     (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
 *     делать взаимодействие с пользователем через консоль и т.д.). Консоль желательно не использовать (в том числе Scanner),
 *     тестировать просто из метода main(), прописывая add() и get().
 */

package Lesson11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Задача 1
        Collection<String>words = new ArrayList<>();
        Collections.addAll(words,"Дуб","Липа","Ольха","Ясень","Береза",
                "Бук","Тополь","Дуб","Бук","Бук",
                "Сосна","Ель","Тополь","Тополь","Тополь",
                "Береза","Ясень","Липа","Дуб","Сосна");

        System.out.println("Первоначальный массив");
        System.out.println(words);

        System.out.println("Уникальные слова");
        Set<String> uniqueWords = new HashSet<String>(words);
        System.out.println(uniqueWords);

        System.out.println("Частота встречаемости слов");
        for (var word : uniqueWords) {
            System.out.println(word + ": " + Collections.frequency(words, word));
        }

        //Задача  2
//        Phonebook phonebook = new Phonebook();
//        phonebook.add("+7000000000111","Иванов");
//        phonebook.add("+7000000000745", "Прилепина");
//        phonebook.add("+7000000000234","Иванов");
//        phonebook.add("+7000000000456","Ковалев");
//        phonebook.add("+7000000000333","Войтов");
//        phonebook.add("+7000000000876", "Иванов");
//        phonebook.add("+7000000000721", "Ковалев");
//
//        phonebook.showNumbersBySurname("Иванов");
//        phonebook.showNumbersBySurname("Петров");
//
//        System.out.print("\n Телефонный справочник");
//        phonebook.showPhoneBook();


        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", "000000000001");
        phonebook.add("Иванов", "000000000002");
        phonebook.add("Ковалев", "312455996679");
        phonebook.add("Ковалев", "798787656679");
        phonebook.add("Ковалев", "863467546654");
        phonebook.add("Войтов", "098706698333");
        phonebook.add("Прилепина", "078961198098");

        //номер телефона по фамилии
        phonebook.showNumbersBySurname("Ковалев");
        phonebook.showNumbersBySurname("Асеев");

        System.out.print("\n Телефонный справочник");
        phonebook.showPhoneBook();

    }
}