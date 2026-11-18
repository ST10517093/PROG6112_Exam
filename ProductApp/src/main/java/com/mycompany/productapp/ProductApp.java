/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productapp;

/**
 *
 * @author Student
 */

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class ProductApp extends JFrame {
// Form components
    private JTextField txtCustomer;
    private JTextField txtPrice;
    private JComboBox<String> cmbProduct;
    private JButton btnProcess;
    
    public ProductApp() {
        setTitle("Product App");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

// Create menu bar
JMenuBar menuBar = new JMenuBar();

JMenu fileMenu = new JMenu("File");
JMenu toolsMenu = new JMenu("Tools");

JMenuItem exitItem = new JMenuItem("Exit");
JMenuItem processItem = new JMenuItem("Process");
JMenuItem clearItem = new JMenuItem("Clear");

fileMenu.add(exitItem);
toolsMenu.add(processItem);
toolsMenu.add(clearItem);
menuBar.add(fileMenu);
menuBar.add(toolsMenu);

setJMenuBar(menuBar);
// Create form
JPanel panel = new JPanel(new GridLayout(4, 2, 10, 15));

JLabel lblCustomer = new JLabel("Customer Name:");
txtCustomer = new JTextField();

JLabel lblProduct = new JLabel("Select Product:");

String[] products = {
    "Cozy Nights Monarch",
    "Restonic Barbados",
    "Sealy Phuket"
};

cmbProduct = new JComboBox<>(products);

JLabel lblPrice = new JLabel("Enter Price:");
txtPrice = new JTextField();

btnProcess = new JButton("PROCESS");

panel.setBorder(BorderFactory.createEmptyBorder(
20, 20, 20, 20));

panel.add(lblCustomer);
panel.add(txtCustomer);

panel.add(lblProduct);
panel.add(cmbProduct);

panel.add(lblPrice);
panel.add(txtPrice);

panel.add(new JLabel(""));
panel.add(btnProcess);

add(panel);

// Button actions
btnProcess.addActionListener(e -> processSale());
processItem.addActionListener(e -> processSale());
clearItem.addActionListener(e -> clearForm());
exitItem.addActionListener(e -> System.exit(0));
}
    
// Process the sale
private void processSale() {
    
try {
    
String customer = txtCustomer.getText();
String product = cmbProduct.getSelectedItem().toString();
if (customer.trim().isEmpty()) {
JOptionPane.showMessageDialog(this,
"Please enter customer name.");
return;
}

double price = Double.parseDouble(txtPrice.getText());
if (price <= 0) {
JOptionPane.showMessageDialog(this,
"Please enter a valid price.");
return;
}

// Create calculation object

ProductCalculations calc = new ProductCalculations(price);

double vat = calc.GetVat();
double commission = calc.GetCommission();
double total = calc.GetTotal();

// Display results
String result = "Customer Name: " + customer
+"n/Product: " + product
+ "\nVAT: R " + String.format("%.2f", vat)
+ "\nCOMMISSION: R " + String.format("%.2f", commission)
+ "\nTOTAL: R " + String.format("%.2f", total);
        
JOptionPane.showMessageDialog(this, result);

// Save information to file
FileWriter writer = new FileWriter("data.txt", true);

writer.write("DATA LOG\n");
writer.write("*************************************");
writer.write("Customer Name: " + customer + "\n");
writer.write("Product: " + product + "\n");
writer.write("VAT: R " + String.format("%.2f", vat) + "\n");
writer.write("COMMISSION: R " + String.format("%.2f", commission) + "\n");
writer.write("TOTAL: R " + String.format("%.2f", total) + "\n");
writer.write("**************************************\n\n");
writer.close();

} catch (NumberFormatException e) {
    
    JOptionPane.showMessageDialog(this,
    "Please enter a valid price.");
    
} catch (IOException e) {
    
    JOptionPane.showMessageDialog(this,
    "Error saving information to file.");
}
}

// Clear the form

private void clearForm() {
    
txtCustomer.setText("");
txtPrice.setText("");
cmbProduct.setSelectedIndex(0);
}
public static void main(String[] args) {
    
ProductApp app = new ProductApp();

app.setVisible(true);
}
}
    