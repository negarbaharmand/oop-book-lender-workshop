import com.baharmand.model.Book;
import com.baharmand.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PersonTest {

    Person testPerson;
    Book mockBook;


    @BeforeEach
    public void setup() {
        mockBook = new Book("Big Wishes", "Victor Hugo");
        testPerson = new Person("Erik", "Johansson");
    }

    @Test
    public void testPersonCreation() {
        assertEquals("Erik", testPerson.getFirstName());
        assertEquals("Johansson", testPerson.getLastName());
        assertEquals(0, testPerson.getBorrowedBooks().length);
    }

    @Test
    public void testPersonId() {
        Integer expectedResult = 1001;
        Integer actualResult = testPerson.getPersonId();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testLoanBookAvailability() {
        testPerson.loanBook(mockBook);
        assertFalse(mockBook.isAvailable());
    }

    @Test
    public void testLoanBookBorrowingPerson() {
        testPerson.loanBook(mockBook);
        assertEquals(testPerson, mockBook.getBorrowingPerson());
    }

    @Test
    public void testLoanReturnBorrowedBooks() {
        testPerson.loanBook(mockBook);
        assertEquals(1, testPerson.getBorrowedBooks().length);
        assertEquals(mockBook, testPerson.getBorrowedBooks()[0]);
        testPerson.returnBook(mockBook);
        assertEquals(0, testPerson.getBorrowedBooks().length);

    }

}
