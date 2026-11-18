/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.salesreport;

/**
 *
 * @author Student
 */

import java.util.Scanner;

public class SalesReport {
    
public static void main(String[] args) {
    
Scanner input = new Scanner(System.in);
// Single-dimensional array
String[] products = {
"Cozy Nights Monarch",
"Restonic Barbados",
"Sealy Phuket"
};
// Two-dimensional array
int[][] sales = new int[3][3];
// Get sales information
for (int i = 0; i < products.length; i++) {
for (int j = 0; j < 3; j++) {
System.out.print("Enter number of sales for month " +
(j + 1) + " for " + products[i] + ": ");
sales[i][j] = input.nextInt();
}
}
// Create Product object
Product product = new Product(products, sales) {
    @Override
    public int getTotalProductsSold() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double getAverageProductsSold() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getMostPopularProduct() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
};
// Create PrintProduct object
PrintProduct report = new PrintProduct();
// Display report
report.printReport(product);
input.close();
}
}

