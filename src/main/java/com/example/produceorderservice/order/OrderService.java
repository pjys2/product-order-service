package com.example.produceorderservice.order;

import com.example.produceorderservice.product.Product;
import org.springframework.stereotype.Component;


@Component
class OrderService {
    private final OrderPort orderPort;

    OrderService(final OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public void createOrder(final CreateOrderRequest request) {
        final Product product = orderPort.getProductById(request.productId());
        final Order order = new Order(product, request.quantity());

        orderPort.save(order);

    }
}
