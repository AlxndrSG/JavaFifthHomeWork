import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        addEntry(phoneBook, "Иванов", "+784855901");
        addEntry(phoneBook, "Петров", "+798765488");
        addEntry(phoneBook, "Сидоров", "+745612387");
        addEntry(phoneBook, "Иванов", "+711351182");
        addEntry(phoneBook, "Иванов", "+722228821");
        addEntry(phoneBook, "Сидоров", "+778945604");
        
        printPhoneBook(phoneBook);
    }

    public static void addEntry(HashMap<String, List<String>> phoneBook, String name, String phone) {

        if (phoneBook.containsKey(name)) {
            List<String> phones = phoneBook.get(name);
            phones.add(phone);
        } else {
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            phoneBook.put(name, phones);
        }
    }

    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> phones = entry.getValue();
            System.out.println(name + ": ");
            for (String phone : phones) {
                System.out.println(phone);
            }
            System.out.println();
        }
    }
}
