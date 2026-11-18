/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salesreport;

/**
 *
 * @author Student
 */
    
    public abstract class Product implements IProducts {

    private String[] products;
    private int[][] sales;

    // Constructor
    public Product(String[] products, int[][] sales) {

        this.products = products;
        this.sales = sales;

    }

    // Calculate total products sold
    public int GetTotalProductsSold() {

        int total = 0;

        for (int i = 0; i < sales.length; i++) {

            for (int j = 0; j < sales[i].length; j++) {

                total += sales[i][j];

            }
        }

        return total;
    }

    // Calculate average products sold
    public double GetAverageProductSold() {

        int total = GetTotalProductsSold();

        int count = 0;

        for (int i = 0; i < sales.length; i++) {

            for (int j = 0; j < sales[i].length; j++) {

                count++;

            }
        }

        return (double) total / count;
    }

    // Find most popular product
    public String GetMostPopularProduct() {

        int highest = 0;
        int position = 0;

        for (int i = 0; i < sales.length; i++) {

            int total = 0;

            for (int j = 0; j < sales[i].length; j++) {

                total += sales[i][j];

            }

            if (total > highest) {

                highest = total;
                position = i;

            }
        }

        return products[position] + " (" + highest + ")";
    }
}


