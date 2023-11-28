package com.veltopia.library.services;

import com.veltopia.library.entities.Book;
import com.veltopia.library.entities.User;
import com.veltopia.library.kafka.UserProducer;
import com.veltopia.library.repositories.BookRepository;
import com.veltopia.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducer userProducer;

    public void findUsersByBook(String bookTitle) {

        Book book = bookRepository.findByTitle(bookTitle);

        if(book == null) {return;}

        List<User> user = userRepository.findByBooks(book);

        if (user == null || user.isEmpty()) {return;}

        userProducer.sendMessage(null);

    }
}
