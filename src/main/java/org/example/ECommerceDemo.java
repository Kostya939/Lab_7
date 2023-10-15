package org.example;

public class ECommerceDemo {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        User user1 = new User(1, "john_doe");
        User user2 = new User(2, "jane_smith");
        Product product1 = new Product(1, "Laptop", 1200.0, 15);
        Product product2 = new Product(2, "Smartphone", 800.0, 10);
        platform.addUser(user1);
        platform.addUser(user2);
        platform.addProduct(product1);
        platform.addProduct(product2);

        user1.addToCart(product1, 1);
        user2.addToCart(product2, 2);

        Order order1 = new Order(1, user1.getId(), user1.getCart());
        Order order2 = new Order(2, user2.getId(), user2.getCart());
        platform.createOrder(order1);
        platform.createOrder(order2);

        platform.updateProductStock(product1.getId(), 10);
        platform.updateProductStock(product2.getId(), 5);

        System.out.println("Users:");
        for (User user : platform.getUsers()) {
            System.out.println(user);
        }

        System.out.println("Products:");
        for (Product product : platform.getAvailableProducts()) {
            System.out.println(product);
        }

        System.out.println("Orders:");
        for (Order order : platform.getOrders()) {
            System.out.println(order);
        }
    }
}
