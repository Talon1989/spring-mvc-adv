package com.fabio.springmvc.services.reposervices;

import com.fabio.springmvc.domain.Order;
import com.fabio.springmvc.repositories.OrderRepository;
import com.fabio.springmvc.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("springdatajpa")
public class OrderServiceRepoImpl implements OrderService{

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceRepoImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<?> listAll() {
        return (List<Order>)orderRepository.findAll();
    }

    @Override
    public Order getById(Integer id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order saveOrUpdate(Order domainObject) {
        return orderRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        orderRepository.delete(id);
    }
}
