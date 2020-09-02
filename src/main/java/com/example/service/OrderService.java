package com.example.service;

import com.example.common.Payment;
import com.example.common.TransactionRequest;
import com.example.common.TransactionResponse;
import com.example.entity.Order;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private RestTemplate template;

    public TransactionResponse saveOrder(TransactionRequest request) {
        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call
        Payment paymentResponse = template.postForObject("http://localhost:9191/payment/doPayment", payment, Payment.class); //because controller calling this method is Post
        response = paymentResponse.getPaymentStatus().equals("success") ? "payment processing" : "there is a failure in payment api";
        repository.save(order);
        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response );
    }

}
