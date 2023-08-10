package com.baharmand.model;

import com.baharmand.model.sequencer.PersonIdGenerator;

import java.util.Arrays;

public class Person {
    private final Integer personId;
    private final String firstName;
    private final String lastName;
    private Book[] borrowedBooks;
    //private Integer numBorrowedBooks;

    public Person(String firstName, String lastName) {
        this.personId = PersonIdGenerator.generateNextPersonId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.borrowedBooks = new Book[0];
        // this.numBorrowedBooks = 0;
    }

    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public void loanBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");
        if (book.isAvailable()) {
           /* if (numBorrowedBooks < borrowedBooks.length) {
                borrowedBooks[numBorrowedBooks] = book;
                numBorrowedBooks++;
                book.setAvailable(false);
                book.setCurrentPerson(this);
                System.out.println(firstName + " " + lastName + " has borrowed the book: " + book.getTitle());
            } else {
                System.out.println("Sorry, you have borrowed the maximum number of books.");
            }*/
            //Class solution:

            book.setCurrentPerson(this);
            book.setAvailable(false);
            Book[] newArray = Arrays.copyOf(borrowedBooks, borrowedBooks.length + 1);
            newArray[newArray.length - 1] = book;
            borrowedBooks = newArray;
        } else {
            throw new IllegalArgumentException("Book is not available");
        }
    }

    public void returnBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");
        int counter = 0;
        Book[] newArray = Arrays.copyOf(borrowedBooks, borrowedBooks.length - 1);
        for (Book elementArray : borrowedBooks) {
            if (elementArray.getTitle().equalsIgnoreCase(book.getTitle())) {
                book.setCurrentPerson(null);
                book.setAvailable(true);
                continue;
            }
            newArray[counter++] = elementArray;
        }
        borrowedBooks = newArray;
    }

    public void displayBooks() {
        System.out.println(firstName + " " + lastName + " has borrowed the following books:");
        for (Book borrowedBook : borrowedBooks) {
            System.out.println("- " + borrowedBook.getTitle() + " by " + borrowedBook.getAuthor());
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPersonId() {
        return personId;
    }


}
