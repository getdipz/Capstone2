package com.xyz.abc;

import java.util.Scanner;

public class InvoiceItem_Demo {

	int InvoiceId, InvoiceQty, InvoiceItemPrice;
	String InvoiceDesc;

	public int getInvoiceId() {
		return InvoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		InvoiceId = invoiceId;
	}

	public int getInvoiceQty() {
		return InvoiceQty;
	}

	public void setInvoiceQty(int invoiceQty) {
		InvoiceQty = invoiceQty;
	}

	public int getInvoiceItemPrice() {
		return InvoiceItemPrice;
	}

	public void setInvoiceItemPrice(int invoiceItemPrice) {
		InvoiceItemPrice = invoiceItemPrice;
	}

	public String getInvoiceDesc() {
		return InvoiceDesc;
	}

	public void setInvoiceDesc(String invoiceDesc) {
		InvoiceDesc = invoiceDesc;
	}

	public InvoiceItem_Demo(int invoiceId, int invoiceQty, int invoiceItemPrice, String invoiceDesc) {
		super();
		InvoiceId = invoiceId;
		InvoiceQty = invoiceQty;
		InvoiceItemPrice = invoiceItemPrice;
		InvoiceDesc = invoiceDesc;
	}

	public static void main(String[] args) {
		System.out.println("Enter the invoice quantity: ");
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		System.out.println("Entered integer is: " + num);
		InvoiceItem_Demo var = new InvoiceItem_Demo(1, num, 30, "this is description of invoice");
		System.out.println("Enter imvoice quantity" + var.InvoiceQty);
		if (var.InvoiceQty == 1) {
			System.out.println("Item quantity entered is" + var.InvoiceQty);
		}
		if (var.InvoiceQty > 1) {

			System.out.println("Item quantity entered is larger than one:" + " " + var.InvoiceQty);
			System.out.println("Invoice item price: " + var.InvoiceQty * var.InvoiceItemPrice);
		}

	}
}
