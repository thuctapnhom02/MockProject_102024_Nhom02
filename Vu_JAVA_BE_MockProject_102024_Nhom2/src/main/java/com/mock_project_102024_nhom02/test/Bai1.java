package com.mock_project_102024_nhom02.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        String content = "";

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Product 1", 10000));
        productList.add(new Product("Product 2", 20000));
        productList.add(new Product("Product 3", 30000));

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Input name: ");
            content = sc.nextLine();
            if(content.equalsIgnoreCase("exit"))
                break;
            Product product = search(content, productList);
            System.out.println(Objects.isNull(product) ? "Product not found" : "Product price: " + product.getPrice());
        };
    }

    public static Product search(String productName, List<Product> productList) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }

        return null;
    }
}
