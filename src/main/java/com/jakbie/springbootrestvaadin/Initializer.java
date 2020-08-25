package com.jakbie.springbootrestvaadin;

import com.jakbie.springbootrestvaadin.entity.Author;
import com.jakbie.springbootrestvaadin.entity.Book;
import com.jakbie.springbootrestvaadin.entity.Category;
import com.jakbie.springbootrestvaadin.repo.AuthorRepo;
import com.jakbie.springbootrestvaadin.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Initializer {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;

    @Autowired
    public Initializer(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;

        Book book1 = new Book();
        book1.setIsbn("9780132350884");
        book1.setTitle("Clean Code");
        book1.setCategory(Category.ADVENTURE);

        Book book2 = new Book();
        book2.setIsbn("9780070131439");
        book2.setTitle("Introduction to algorithms");
        book2.setCategory(Category.FANTASY);

        Book book3 = new Book();
        book3.setIsbn("9780596004651");
        book3.setTitle("Head First Java");
        book3.setCategory(Category.ADVENTURE);

        Author author = new Author();
        author.setName("Uncle");
        author.setSurname("Jacob");
        author.setBooks(Stream.of(book1, book2, book3).collect(Collectors.toSet()));

        bookRepo.save(book1);
        bookRepo.save(book2);
        bookRepo.save(book3);
        authorRepo.save(author);

    }
}
