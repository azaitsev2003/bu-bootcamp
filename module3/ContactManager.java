import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Ada Wong", new Contact("Ada Wong", "+1 770 671 6969"));
        contacts.put("Leon Kennedy", new Contact("Leon Kennedy", "+1 703 210 1738"));
        contacts.put("Ethan Winters", new Contact("Ethan Winters", "+1 703 815 2694"));
        contacts.put("Mia Winters", new Contact("Mia Winters", "+1 703 666 6666"));
        contacts.put("Grace Ashcroft", new Contact("Grace Ashcroft", "+1 703 777 8899"));

        // Step 5: look up a contact 
        Contact lookUp = contacts.get("Leon Kennedy");
        if (lookUp == null) {
            System.out.println("Contact not found.");
        }
        else {
            System.out.println(lookUp);
        }
        lookUp = contacts.get("The Duke");
        if (lookUp == null) {
            System.out.println("Contact not found.");
        }
        else {
            System.out.println(lookUp);
        }
 
        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));
        System.out.println("=== All Contacts ===");
        for (int i = 0; i < sorted.size(); i++) {
            System.out.println("Name: " + sorted.get(i).getName() + " | Phone: " + sorted.get(i).getPhone());
        }
        
    } 
}