import java.util.*;

// Product Class
class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void reduceQuantity(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
        }
    }
}

// Customer Class
class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}

// Cart Class (Aggregation: Cart has Products)
class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }
}

// Abstract Discount Strategy (Polymorphism)
abstract class DiscountStrategy {
    public abstract double applyDiscount(double amount);
}

class NoDiscount extends DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount; // no discount
    }
}

class SeasonalDiscount extends DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.9; // 10% discount
    }
}

class FestivalDiscount extends DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.8; // 20% discount
    }
}

// Abstract Payment Class (Abstraction + Inheritance)
abstract class Payment {
    public abstract void pay(double amount);
}

// Credit Card Payment (Inheritance)
class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}

// UPI Payment (Inheritance)
class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI ID: " + upiId);
    }
}

// Order Class
class Order {
    private Customer customer;
    private Cart cart;
    private Payment payment;
    private DiscountStrategy discountStrategy;

    public Order(Customer customer, Cart cart, Payment payment, DiscountStrategy discountStrategy) {
        this.customer = customer;
        this.cart = cart;
        this.payment = payment;
        this.discountStrategy = discountStrategy;
    }

    public void placeOrder() {
        double total = cart.calculateTotal();
        double finalAmount = discountStrategy.applyDiscount(total);

        System.out.println("Customer: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Total Amount: " + total);
        System.out.println("After Discount: " + finalAmount);

        payment.pay(finalAmount);
        System.out.println("Order placed successfully!\n");
    }
}

// Main Class to Run the System
public class OnlineShoppingSystem {
    public static void main(String[] args) {
        // Create products
        Product p1 = new Product("Laptop", 59999, 5);
        Product p2 = new Product("Smartphone", 29999, 10);

        // Customer
        Customer c1 = new Customer("Aditya Raj", "aditya8810328@gmail.com");

        // Add products to cart
        Cart cart = new Cart();
        cart.addProduct(p1);
        cart.addProduct(p2);

        // Payment method (Credit Card)
        Payment payment1 = new CreditCardPayment("5419-9687-7592-8946");
        // Payment method (UPI)
        Payment payment2 = new UPIPayment("8810328594@ybl");

        // Discount strategies
        DiscountStrategy noDiscount = new NoDiscount();
        DiscountStrategy seasonal = new SeasonalDiscount();
        DiscountStrategy festival = new FestivalDiscount();

        // Place Orders
        Order order1 = new Order(c1, cart, payment1, noDiscount);
        order1.placeOrder();

        Order order2 = new Order(c1, cart, payment2, seasonal);
        order2.placeOrder();

        Order order3 = new Order(c1, cart, payment1, festival);
        order3.placeOrder();
    }
}
