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
  
  }