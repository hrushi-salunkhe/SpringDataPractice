package com.hrushikesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrushikesh.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{

}
