package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scannerObject = new Scanner(System.in);
        System.out.println("Enter tool code:");
        String toolCode = scannerObject.nextLine();

        System.out.println("Enter checkout date:");
        String checkoutDate = scannerObject.nextLine();

        System.out.println("Enter Rental Days:");
        int rentalDays = scannerObject.nextInt();

        System.out.println("Enter Discount Percent:");
        int discount = scannerObject.nextInt();

        scannerObject.close();
        RentalAgreement rentalAgreement = new RentalAgreement(toolCode, checkoutDate, rentalDays, discount);

        System.out.println(rentalAgreement.getCheckoutDate());
        System.out.println(rentalAgreement.getRentalDays());



    }


}
