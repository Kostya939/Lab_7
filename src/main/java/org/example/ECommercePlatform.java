package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ECommercePlatform {
    private final Map<Integer, User> users;
    private final Map<Integer, Product> products;
    private final Map<Integer, Order> orders;

    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void createOrder(Order order) {
        orders.put(order.getId(), order);
    }

    public List<Product> getAvailableProducts() {
        return products.values().stream()
                .filter(product -> product.getStock() > 0)
                .collect(Collectors.toList());
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }

    public void updateProductStock(Integer productId, int newStock) {
        if (products.containsKey(productId)) {
            Product product = products.get(productId);
            product.setStock(newStock);
        }
    }
}
