package com.example.platform.repositories;

import com.example.platform.models.Message;
import com.example.platform.models.Customer;
import com.example.platform.models.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
