package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ECommerceTest {

    private ECommercePlatform platform;
    private User user1, user2;
    private Product product1, product2;

    @BeforeEach
    void setUp() {
        platform = new ECommercePlatform();

        user1 = new User(1, "john_doe");
        user2 = new User(2, "jane_smith");
        product1 = new Product(1, "Laptop", 1200.0, 15);
        product2 = new Product(2, "Smartphone", 800.0, 10);

        platform.addUser(user1);
        platform.addUser(user2);
        platform.addProduct(product1);
        platform.addProduct(product2);
    }

    @Test
    void testAddUser() {
        assertEquals(2, platform.getUsers().size());
    }

    @Test
    void testAddProduct() {
        assertEquals(2, platform.getAvailableProducts().size());
    }

    @Test
    void testCreateOrder() {
        user1.addToCart(product1, 1);
        Order order1 = new Order(1, user1.getId(), user1.getCart());
        platform.createOrder(order1);

        assertEquals(1, platform.getOrders().size());
    }

    @Test
    void testUpdateProductStock() {
        platform.updateProductStock(product1.getId(), 10);
        assertEquals(10, product1.getStock());
    }

    @Test
    void testAddToCart() {
        user1.addToCart(product1, 1);
        assertEquals(1, user1.getCart().size());
    }

    @Test
    void testRemoveFromCart() {
        user1.addToCart(product1, 1);
        user1.removeFromCart(product1, 1);
        assertTrue(user1.getCart().isEmpty());
    }

    @Test
    void testModifyCart() {
        user1.addToCart(product1, 1);
        user1.modifyCart(product1, 2);
        assertEquals(2, user1.getCart().get(product1));
    }

    @Test
    void testCalculateTotalPrice() {
        user1.addToCart(product1, 1);
        Order order1 = new Order(1, user1.getId(), user1.getCart());
        assertEquals(1200.0, order1.getTotalPrice());
    }

}

