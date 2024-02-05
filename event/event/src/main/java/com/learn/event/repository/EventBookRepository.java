package com.learn.event.repository;

import com.learn.event.model.EventBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventBookRepository extends JpaRepository<EventBook,Integer> {
}
