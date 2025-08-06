package com.example.springassessmentproject.main;

import com.example.springassessmentproject.q7.Product;
import com.example.springassessmentproject.q7.ProductService;
import com.example.springassessmentproject.q7.BillingException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

public class MainQ7 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("q7-config.xml");
        ProductService service = (ProductService) context.getBean("productService");
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Generate Bill by entering code and quantity");
            System.out.println("2. Exit");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    int code;
                    while (true) {
                        System.out.println("Enter product_code");
                        code = scanner.nextInt();
                        try {
                            if (!service.validateProductCode(code)) {
                                throw new BillingException("Invalid product_code, it should be >0 and 4 digit +ve number");
                            }
                            break;
                        } catch (BillingException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    int qty;
                    while (true) {
                        System.out.println("Enter quantity");
                        qty = scanner.nextInt();
                        try {
                            if (!service.validateQuantity(qty)) {
                                throw new BillingException("Invalid quantity, it should be >0");
                            }
                            break;
                        } catch (BillingException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    Product p = service.getProductDetails(code);
                    System.out.println("Product Name: " + p.getProduct_name());
                    System.out.println("Product Category: " + p.getProduct_category());
                    System.out.println("Product Description: " + p.getProduct_description());
                    System.out.println("Product Price(Rs): " + p.getProduct_price());
                    System.out.println("Quantity: " + qty);
                    System.out.println("Total Bill Amount: Rs." + service.calculatePrice(qty, p.getProduct_price()));
                    break;

                case 2:
                    System.exit(0);

                default:
                    System.out.println("Enter option 1 to 2 only");
            }
        } while (true);
    }
}
/*
 1. Generate Bill by entering code and quantity
2. Exit
1
Enter product_code
1003
Enter quantity
1
Product Name: Tata Harrier
Product Category: Car
Product Description: SUV
Product Price(Rs): 2500000.0
Quantity: 1
Total Bill Amount: Rs.2500000.0
1. Generate Bill by entering code and quantity
2. Exit
 */
