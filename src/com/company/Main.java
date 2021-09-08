package com.company;
import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        int rentalDays;
        int discount;
        String toolCode;
        String checkoutDate;
        Scanner scannerObject = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");

        while(true){
            try{
                System.out.println("Enter tool code:");
                toolCode = scannerObject.nextLine().toLowerCase();
                if(toolCode.equals("JAKR".toLowerCase()) || toolCode.equals("JAKD".toLowerCase()) ||
                        toolCode.equals("LADW".toLowerCase()) || toolCode.equals("CHNS".toLowerCase())){
                    break;
                }
                System.out.println("Invalid Tool Code.");
            }catch(InputMismatchException e){
                System.out.println("Please enter a String for Tool Code.");
                scannerObject.nextLine();
            }
        }

        while(true){
            try{
                System.out.println("Enter checkout date (MM/DD/YY):");
                checkoutDate = scannerObject.nextLine();
                sdf.setLenient(false);
                try{
                    sdf.parse(checkoutDate);
                    break;
                } catch (ParseException e) {
                    System.out.println("Date was invalid.");
                }
            }catch(InputMismatchException e){
                System.out.println("Please enter a String for Date.");
                scannerObject.nextLine();
            }
        }




        while(true) {
            try {
                System.out.println("Enter Rental Days:");
                rentalDays = scannerObject.nextInt();
                if (rentalDays >= 1) {
                    break;
                }
                System.out.println("Invalid rental days. Please enter a number of days equal to or greater than 1.");
            } catch (InputMismatchException e) {
                System.out.println("Please enter an Integer");
                scannerObject.nextLine();
            }
        }

        while(true) {
            try {
                System.out.println("Enter Discount Percent:");
                discount = scannerObject.nextInt();
                if (discount >= 0 && discount <= 100) {
                    break;
                }
                System.out.println("Invalid discount. Please enter a percentage between 0 and 100.");
            } catch (InputMismatchException e) {
                System.out.println("Please enter an Integer");
                scannerObject.nextLine();
            }
        }


        scannerObject.close();
        RentalAgreement rentalAgreement = new RentalAgreement(toolCode, checkoutDate, rentalDays, discount);

        rentalAgreement.printAll();



    }


}
