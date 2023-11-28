package com.veltopia.library.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veltopia.library.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID>{

    Book findByTitle(String title);

}
