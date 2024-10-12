package com.ayush.first.project.SpringWithDb.repository;

import com.ayush.first.project.SpringWithDb.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookManagement extends JpaRepository<Book, Long> {
}
