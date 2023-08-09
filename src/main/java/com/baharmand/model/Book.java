package com.baharmand.model;

public class Book {
    private final String title;
    private final String author;
    private boolean available;
    private Person borrowingPerson;

    public Person getBorrowingPerson() {
        return borrowingPerson;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
        this.borrowingPerson = null;
    }

    public void showPerson() {
        if (borrowingPerson != null) {
            System.out.println("The book is borrowed by user number " + this.borrowingPerson.getPersonId());
        } else {
            System.out.println(this.title + " is available for borrowing.");
        }
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void bookInfo() {
        System.out.println(this.title + " by " + this.author + " is " + (this.available ? "available." : "not available."));
    }

    public void setCurrentPerson(Person person) {
        borrowingPerson = person;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

}


