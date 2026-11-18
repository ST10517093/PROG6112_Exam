/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salesreport;

/**
 *
 * @author Student
 */

    public class PrintProduct {
// Print total products sold
public void printTotalProductsSold(Product product) {
    
System.out.println("TOTAL PRODUCT SALES: " +
product.GetTotalProductsSold());
}
// Print average products sold
public void printAverageProductsSold(Product product) {
System.out.println("AVERAGE PRODUCT SALES: " +
product.GetAverageProductSold());
}
// Print most popular product
public void printMostPopularProduct(Product product) {
System.out.println("MOST POPULAR PRODUCT: " +
product.GetMostPopularProduct());
}
// Print complete report
public void printReport(Product product) {

        System.out.println("\nPRODUCT SALES REPORT - 2026");

        System.out.println("********************************");

        printTotalProductsSold(product);

        printAverageProductsSold(product);

        printMostPopularProduct(product);

    }

}

