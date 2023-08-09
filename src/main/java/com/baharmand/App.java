package com.baharmand;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person person1 = new Person(123, "Negar", "Baharmand");
        Book book1 = new Book("Big wishes", "Victor Hugo");
        Book book2 = new Book("Oliver twist", "Charles Dickens");
        person1.loanBook(book1);
        person1.loanBook(book2);
        person1.displayBorrowedBooks();
        book1.showPerson();
        book1.bookInfo();
    }
}
