package com.company;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public class RentalAgreementTest {
    @Test
    public void TestCases() throws ParseException {
        // Note: I have the application catching if the percentage is between 0 and 100 based on user input.
        // That way no calculations are done on incorrect information.
        RentalAgreement rentalAgreementCase1 = new RentalAgreement("jakr", "9/3/15", 5, 101);
        assertEquals("Jackhammer", rentalAgreementCase1.getToolType());
        assertEquals("Ridgid", rentalAgreementCase1.getToolBrand());
        assertEquals(5, rentalAgreementCase1.getRentalDays());
        assertEquals("9/3/15", rentalAgreementCase1.getCheckoutDate());
        assertEquals("09/08/15", rentalAgreementCase1.getDueDate());
        assertEquals(2, rentalAgreementCase1.getChargeDays());
        assertEquals(101, rentalAgreementCase1.getDiscountPercent());

        // Test case 2
        RentalAgreement rentalAgreementCase2 = new RentalAgreement("ladw", "7/2/20", 3, 10);
        assertEquals("Ladder", rentalAgreementCase2.getToolType());
        assertEquals("Werner", rentalAgreementCase2.getToolBrand());
        assertEquals(3, rentalAgreementCase2.getRentalDays());
        assertEquals("7/2/20", rentalAgreementCase2.getCheckoutDate());
        assertEquals("07/05/20", rentalAgreementCase2.getDueDate());
        assertEquals(2, rentalAgreementCase2.getChargeDays());
        assertEquals(3.98, rentalAgreementCase2.getPreDiscountCharge(), 0.0);
        assertEquals(10, rentalAgreementCase2.getDiscountPercent(), 0.0);
        assertEquals(0.4, rentalAgreementCase2.getDiscountAmount(), 0.0);
        assertEquals(3.58, rentalAgreementCase2.getFinalCharge(), 0.0);

        // Test case 3
        RentalAgreement rentalAgreementCase3 = new RentalAgreement("chns", "7/2/15", 5, 25);
        assertEquals("Chainsaw", rentalAgreementCase3.getToolType());
        assertEquals("Stihl", rentalAgreementCase3.getToolBrand());
        assertEquals(5, rentalAgreementCase3.getRentalDays());
        assertEquals("7/2/15", rentalAgreementCase3.getCheckoutDate());
        assertEquals("07/07/15", rentalAgreementCase3.getDueDate());
        assertEquals(3, rentalAgreementCase3.getChargeDays());
        assertEquals(4.47, rentalAgreementCase3.getPreDiscountCharge(), 0.0);
        assertEquals(25, rentalAgreementCase3.getDiscountPercent(), 0.0);
        assertEquals(1.12, rentalAgreementCase3.getDiscountAmount(), 0.0);
        assertEquals(3.35, rentalAgreementCase3.getFinalCharge(), 0.0);

        // Test case 4
        RentalAgreement rentalAgreementCase4 = new RentalAgreement("jakd", "9/3/15", 6, 0);
        assertEquals("Jackhammer", rentalAgreementCase4.getToolType());
        assertEquals("DeWalt", rentalAgreementCase4.getToolBrand());
        assertEquals(6, rentalAgreementCase4.getRentalDays());
        assertEquals("9/3/15", rentalAgreementCase4.getCheckoutDate());
        assertEquals("09/09/15", rentalAgreementCase4.getDueDate());
        assertEquals(3, rentalAgreementCase4.getChargeDays());
        assertEquals(8.97, rentalAgreementCase4.getPreDiscountCharge(), 0.0);
        assertEquals(0, rentalAgreementCase4.getDiscountPercent(), 0.0);
        assertEquals(0.0, rentalAgreementCase4.getDiscountAmount(), 0.0);
        assertEquals(8.97, rentalAgreementCase4.getFinalCharge(), 0.0);

        // Test case 5
        RentalAgreement rentalAgreementCase5 = new RentalAgreement("jakr", "7/2/15", 9, 0);
        assertEquals("Jackhammer", rentalAgreementCase5.getToolType());
        assertEquals("Ridgid", rentalAgreementCase5.getToolBrand());
        assertEquals(9, rentalAgreementCase5.getRentalDays());
        assertEquals("7/2/15", rentalAgreementCase5.getCheckoutDate());
        assertEquals("07/11/15", rentalAgreementCase5.getDueDate());
        assertEquals(5, rentalAgreementCase5.getChargeDays());
        assertEquals(14.95, rentalAgreementCase5.getPreDiscountCharge(), 0.0);
        assertEquals(0.0, rentalAgreementCase5.getDiscountPercent(), 0.0);
        assertEquals(0.0, rentalAgreementCase5.getDiscountAmount(), 0.0);
        assertEquals(14.95, rentalAgreementCase5.getFinalCharge(), 0.0);

        // Test case 6
        RentalAgreement rentalAgreementCase6 = new RentalAgreement("jakr", "7/2/20", 4, 50);
        assertEquals("Jackhammer", rentalAgreementCase6.getToolType());
        assertEquals("Ridgid", rentalAgreementCase6.getToolBrand());
        assertEquals(4, rentalAgreementCase6.getRentalDays());
        assertEquals("7/2/20", rentalAgreementCase6.getCheckoutDate());
        assertEquals("07/06/20", rentalAgreementCase6.getDueDate());
        assertEquals(1, rentalAgreementCase6.getChargeDays());
        assertEquals(2.99, rentalAgreementCase6.getPreDiscountCharge(), 0.0);
        assertEquals(50, rentalAgreementCase6.getDiscountPercent(), 0.0);
        assertEquals(1.5, rentalAgreementCase6.getDiscountAmount(), 0.0);
        assertEquals(1.49, rentalAgreementCase6.getFinalCharge(), 0.0);
    }

}