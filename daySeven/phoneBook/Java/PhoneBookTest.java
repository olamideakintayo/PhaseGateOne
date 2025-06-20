// PhoneBookTest.java

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {

    @BeforeEach
    public void setUp() {
        PhoneBook.numbers = new ArrayList<>();
    }

    @Test
    public void testThatAddsASingleContact() {
        PhoneBook contact = new PhoneBook("Olamide", "Akintayo", "09032592825");
        PhoneBook.numbers.add(contact);
        assertEquals(1, PhoneBook.numbers.size());
    }
    
    @Test
    public void testThatAddsMultipleContacts() {
        PhoneBook contact1 = new PhoneBook("Olamide", "Akintayo", "09032592825");
        PhoneBook contact2 = new PhoneBook("Dominion", "Akintayo", "08033149859");
        PhoneBook.numbers.add(contact1);
        PhoneBook.numbers.add(contact2);
        assertEquals(2, PhoneBook.numbers.size());
    }
    
    @Test
    public void testThatChecksIfFirstNameExists() {
        PhoneBook contact = new PhoneBook("Ella", "Akintayo", "08141511541");
        PhoneBook.numbers.add(contact);
        boolean found = false;
        for (PhoneBook contactItem : PhoneBook.numbers) {
            if (contactItem.firstName.equalsIgnoreCase("Ella")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

	@Test
    public void testThatChecksIfLastNameExists() {
        PhoneBook contact = new PhoneBook("Dominion", "Akintayo", "08033149859");
        PhoneBook.numbers.add(contact);
        boolean found = false;
        for (PhoneBook contactItem : PhoneBook.numbers) {
            if (contactItem.lastName.equalsIgnoreCase("Akintayo")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }
    
     @Test
    public void testThatChecksIfPhoneNumberExists() {
        PhoneBook contact = new PhoneBook("Olamide", "Akintayo", "09032592825");
        PhoneBook.numbers.add(contact);
        boolean found = false;
        for (PhoneBook contactItem : PhoneBook.numbers) {
            if (contactItem.phoneNumber.equals("09032592825")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }
    
    @Test
    public void testThatRemovesContactByPhoneNumber() {
        PhoneBook contact = new PhoneBook("Dominion", "Akintayo", "08033149859");
        PhoneBook.numbers.add(contact);

        for (int i = 0; i < PhoneBook.numbers.size(); i++) {
            if (PhoneBook.numbers.get(i).phoneNumber.equals("08033149859")) {
                PhoneBook.numbers.remove(i);
                break;
            }
        }

        assertEquals(0, PhoneBook.numbers.size());
    }
    
     @Test
    public void testThatRemovesNonExistingContact() {
        PhoneBook contact = new PhoneBook("Ella", "Akintayo", "08141511541");
        PhoneBook.numbers.add(contact);

        for (int i = 0; i < PhoneBook.numbers.size(); i++) {
            if (PhoneBook.numbers.get(i).phoneNumber.equals("00000000000")) {
                PhoneBook.numbers.remove(i);
                break;
            }
        }

        assertEquals(1, PhoneBook.numbers.size());
    }
    
     @Test
    public void testThatFindsAContactByFirstName() {
        PhoneBook contact = new PhoneBook("Ella", "Akintayo", "08141511541");
        PhoneBook.numbers.add(contact);

        PhoneBook foundContact = null;
        for (PhoneBook contactItem : PhoneBook.numbers) {
            if (contactItem.firstName.equalsIgnoreCase("Ella")) {
                foundContact = contactItem;
                break;
            }
        }
        
         assertNotNull(foundContact);
        assertEquals("Akintayo", foundContact.lastName);
    }
    
     @Test
    public void testThatFindsAContactByPhoneNumber() {
        PhoneBook contact = new PhoneBook("Olamide", "Akintayo", "09032592825");
        PhoneBook.numbers.add(contact);

        PhoneBook foundContact = null;
        for (PhoneBook contactItem : PhoneBook.numbers) {
            if (contactItem.phoneNumber.equals("09032592825")) {
                foundContact = contactItem;
                break;
            }
        }

        assertNotNull(foundContact);
        assertEquals("Olamide", foundContact.firstName);
    }
    
     @Test
    public void testThatCheckIfTheListIsEmptyInitially() {
        assertEquals(0, PhoneBook.numbers.size());
    }
  
  }