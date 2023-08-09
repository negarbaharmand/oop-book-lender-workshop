package com.baharmand.model;

import com.baharmand.model.sequencer.PersonIdGenerator;

public class Person {
    private final Integer personId;
    private final String firstName;
    private final String lastName;
    private Book[] borrowedBooks;
    private Integer numBorrowedBooks;

    public Person(String firstName, String lastName) {
        this.personId = PersonIdGenerator.generateNextPersonId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.borrowedBooks = new Book[5];
        this.numBorrowedBooks = 0;
    }

    public Integer getNumBorrowedBooks() {
        return numBorrowedBooks;
    }

    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public void loanBook(Book book) {
        if (book.isAvailable()) {
            if (numBorrowedBooks < borrowedBooks.length) {
                borrowedBooks[numBorrowedBooks] = book;
                numBorrowedBooks++;
                book.setAvailable(false);
                book.setCurrentPerson(this);
                System.out.println(firstName + " " + lastName + " has borrowed the book: " + book.getTitle());
            } else {
                System.out.println("Sorry, you have borrowed the maximum number of books.");
            }
        } else {
            System.out.println("Sorry, the book is not available for borrowing.");
        }
    }

    public void displayBooks() {
        System.out.println(firstName + " " + lastName + " has borrowed the following books:");
        for (int i = 0; i < numBorrowedBooks; i++) {
            System.out.println("- " + borrowedBooks[i].getTitle() + " by " + borrowedBooks[i].getAuthor());
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
