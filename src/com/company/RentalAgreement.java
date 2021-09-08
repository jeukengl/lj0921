package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class RentalAgreement {
    String toolCode;
    String date;
    int rentalDays;
    int discount;

    String toolType;
    String toolBrand;
    String dueDate;
    double rentalCharge;
    int chargeDays;
    double preDiscountCharge;
    double discountAmount;
    double finalCharge;

    // Initializing new lists for tool info
    private HashMap<String, ArrayList<String>> ToolInfo = new HashMap<String, ArrayList<String>>();
    private ArrayList<String> LADWList = new ArrayList<String>();
    private ArrayList<String> CHNSList = new ArrayList<String>();
    private ArrayList<String> JAKRList = new ArrayList<String>();
    private ArrayList<String> JAKDList = new ArrayList<String>();

    // Initializing new lists for charge info
    private HashMap<String, ArrayList<String>> ChargeInfo = new HashMap<String, ArrayList<String>>();
    private ArrayList<String> LadderList = new ArrayList<String>();
    private ArrayList<String> ChainsawList = new ArrayList<String>();
    private ArrayList<String> JackHammerList = new ArrayList<String>();

    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");

    public RentalAgreement(String toolCode, String date, int rentalDays, int discount){
        this.toolCode = toolCode;
        this.date = date;
        this.rentalDays = rentalDays;
        this.discount = discount;

        // Setting tool info lists and hashmap
        LADWList.add(0,"Werner");
        LADWList.add(1,"Ladder");
        CHNSList.add(0,"Stihl");
        CHNSList.add(1, "Chainsaw");
        JAKRList.add(0, "Ridgid");
        JAKRList.add(1, "Jackhammer");
        JAKDList.add(0, "DeWalt");
        JAKDList.add(1,"Jackhammer");

        ToolInfo.put("LADW", LADWList);
        ToolInfo.put("CHNS", CHNSList);
        ToolInfo.put("JAKR", JAKRList);
        ToolInfo.put("JAKD", JAKDList);

        // Setting charge info lists and hashmap
        // 0 - Daily charge
        // 1 - Weekday charge
        // 2 - Weekend charge
        // 3 - Holiday charge
        LadderList.add(0, "1.99");
        LadderList.add(1, "Yes");
        LadderList.add(2, "Yes");
        LadderList.add(3, "No");

        ChainsawList.add(0, "1.49");
        ChainsawList.add(1, "Yes");
        ChainsawList.add(2, "No");
        ChainsawList.add(3, "Yes");

        JackHammerList.add(0, "2.99");
        JackHammerList.add(1, "Yes");
        JackHammerList.add(2, "No");
        JackHammerList.add(3, "No");

        ChargeInfo.put("Ladder", LadderList);
        ChargeInfo.put("Chainsaw", ChainsawList);
        ChargeInfo.put("Jackhammer", JackHammerList);

    }

    public String getToolType(){
        // Reads in the toolCode and toolType
        this.toolType = ToolInfo.get(this.toolCode.toUpperCase()).get(1);
        return this.toolType;
    }

    public String getToolBrand(){
        // Reads in the toolCode and toolCode
        this.toolBrand = ToolInfo.get(this.toolCode.toUpperCase()).get(0);
        return toolBrand;
    }

    public int getRentalDays(){
        // Specified at checkout
        return rentalDays;
    }

    public String getCheckoutDate(){
        // Specified at checkout
        return date;
    }

    public String getDueDate() throws ParseException {
        // Calculates due date from checkout date and rental days

        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(this.date));
        c.add(Calendar.DATE, this.rentalDays);
        this.dueDate = sdf.format(c.getTime());

        return dueDate;
    }

    public double getRentalCharge(){
        // Amount per day, specified by the tool type

        this.rentalCharge = Double.parseDouble(ChargeInfo.get(this.getToolType()).get(0));
        return rentalCharge;
    }

    public int getChargeDays() throws ParseException {
        // Count of chargeable days from day after checkout through and including due date excluding no charge days
        int totalChargeDays = this.rentalDays;
        for(int i =1; i<=this.rentalDays; i++){
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(this.date));
            c.add(Calendar.DATE, i);

            if((c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
                    && !this.toolType.equals("Ladder")){
                totalChargeDays = totalChargeDays-1;
            }
            if (c.get(Calendar.MONTH)== Calendar.JULY && c.get(Calendar.DAY_OF_MONTH) == 4
                    && !this.toolType.equals("Chainsaw")){
                totalChargeDays = totalChargeDays-1;
            }
            if(c.get(Calendar.MONTH) == Calendar.SEPTEMBER && c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY &&
                            c.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 1 && !this.toolType.equals("Chainsaw")){
                totalChargeDays = totalChargeDays-1;
            }

        }
        this.chargeDays = totalChargeDays;

        return chargeDays;
    }

    public double getPreDiscountCharge() throws ParseException {
        // Calculated as charge days X daily charge. Resulting total rounded half up to cents.
        this.preDiscountCharge = Math.round((getChargeDays() * getRentalCharge()*100.0))/100.0;

        return preDiscountCharge;
    }

    public int getDiscountPercent(){
        // Specified at checkout
        return discount;
    }
    public double getDiscountAmount() throws ParseException {
        // Calculated from discount % and pre-discount charge.
        this.discountAmount = Math.round((this.discount/100.0 * this.getPreDiscountCharge()*100.0))/100.0;
        return discountAmount;
    }
    public double getFinalCharge() throws ParseException {
        // Calculated as pre-discount charge- discount amount
        this.finalCharge = Math.round((this.getPreDiscountCharge() - this.getDiscountAmount())*100.0)/100.0;
        return finalCharge;
    }

    public void printAll() throws ParseException {
        System.out.println("Tool Type: " + getToolType());
        System.out.println("Tool Brand: " + getToolBrand());
        System.out.println("Rental Days: " + getRentalDays());
        System.out.println("Checkout Date: " + getCheckoutDate());
        System.out.println("Due Date: " + getDueDate());
        System.out.println("Daily Rental Charge: " + "$" + getRentalCharge());
        System.out.println("Charge days: " + getChargeDays());
        System.out.println("Pre-discount charge: " + "$" + getPreDiscountCharge());
        System.out.println("Discount percent: " + getDiscountPercent() + "%");
        System.out.println("Discount amount: " + "$" + getDiscountAmount());
        System.out.println("Final Charge: " + "$" + getFinalCharge());

    }




}
