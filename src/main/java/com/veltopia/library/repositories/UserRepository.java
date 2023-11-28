package com.veltopia.library.repositories;

import java.util.List;
import java.util.Optional;

import com.veltopia.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veltopia.library.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findByBooks(Book book);

    Optional<User> findById(Long id);
}
