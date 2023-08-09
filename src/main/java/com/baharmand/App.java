package com.baharmand;

import com.baharmand.model.Book;
import com.baharmand.model.Person;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Person person1 = new Person("Negar", "Baharmand");
        Book book1 = new Book("Big wishes", "Victor Hugo");
        Book book2 = new Book("Oliver twist", "Charles Dickens");
        person1.loanBook(book1);
        person1.loanBook(book2);
        person1.displayBooks();
        book1.showPerson();
        book1.bookInfo();
    }
}
