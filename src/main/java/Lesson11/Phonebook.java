package Lesson11;

import java.util.*;

public class Phonebook {

//    private Map<String,String> phonebook;
//
//    public Phonebook(){
//        phonebook = new HashMap<>();
//    }
//
//    //добавление в тел.справочник
//    public void add(String number, String surname){
//        phonebook.put(number,surname);
//    }
//
//    //поиск номера(ов) по фамилии
//    public List<String> get(String surname){
//        if(phonebook.containsValue(surname)){
//            List<String> numbersList = new ArrayList<>();
//            for(var number: phonebook.entrySet()){
//                if(number.getValue().equals(surname))
//                    numbersList.add(number.getKey());
//            }
//            return numbersList;
//        }
//        return null;
//    }
//
//    // показать телефонные номера по фамилии
//    public void showNumbersBySurname(String surname){
//        var numberList = get(surname);
//        if(numberList != null) {
//            StringBuilder str = new StringBuilder();
//            str.append(String.format("\n %-10s",surname)) ;
//
//            for(int i = 0; i < numberList.size(); i++){
//                if(i == 0){
//                    str.append(String.format(" телефон: %-14s",numberList.get(i))) ;
//                }else {
//                    str.append(String.format("\n%11s телефон: %-14s","", numberList.get(i))) ;
//                }
//            }
//            str.append("\n");
//            System.out.print(str);
//        } else {
//            System.out.printf(" Фамилии %s нет в справочнике.\n", surname);
//        }
//    }
//
//    // показать телефонную книгу
//    public void showPhoneBook(){
//        Set<String> surnames = new HashSet<>();
//        for(var number: phonebook.entrySet())
//            surnames.add(number.getValue());
//
//        for(var surname: surnames)
//            showNumbersBySurname(surname);
//
//    }

    private Map<String, List<String>> phoneBook;

    public Phonebook(){
        phoneBook = new HashMap<>();
    }

    // поиск телефонных номеров по фамилии
    private List<String> get(String surname){
        return phoneBook.getOrDefault(surname, null);
    }

    // добавление абонента в телефонную книгу
    public void add(String surname, String number){
        if(phoneBook.containsKey(surname)){
            var list = get(surname);
            list.add(number);
        }else {
            ArrayList<String> list = new ArrayList<>();
            list.add(number);
            phoneBook.put(surname, list);
        }
    }

    // показать телефонные номера по фамилии
    public void showNumbersBySurname(String surname){
        var numberList = get(surname);
        if(numberList != null) {
            StringBuilder str = new StringBuilder();
            str.append(String.format("\n %-10s",surname)) ;

            for(int i = 0; i < numberList.size(); i++){
                if(i == 0){
                    str.append(String.format(" телефон: %-14s",numberList.get(i))) ;
                }else {
                    str.append(String.format("\n%11s телефон: %-14s","", numberList.get(i))) ;
                }
            }
            str.append("\n");
            System.out.print(str);
        } else {
            System.out.printf(" Фамилии %s нет в справочнике.\n", surname);
        }
    }

    // показать телефонную книгу
    public void showPhoneBook(){
        for (var surname : phoneBook.keySet()) {
            showNumbersBySurname(surname);
        }
    }

}