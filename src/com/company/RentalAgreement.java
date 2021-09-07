package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class RentalAgreement {
    String toolCode;
    String date;
    int rentalDays;
    int discount;

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


    public RentalAgreement(String toolCode, String date, int rentalDays, int discount){
        this.toolCode = toolCode;
        this.date = date;
        this.rentalDays = rentalDays;
        this.discount = discount;

        // Setting lists
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
    }

    public String getToolType(String toolCode){
        // Reads in the toolCode and toolType
        return "Happy";
    }

    public String getToolBrand(String toolCode){
        // Reads in the toolCode and toolCode
        return "Happy";
    }

    public int getRentalDays(){
        // Specified at checkout
        return this.rentalDays;
    }

    public String getCheckoutDate(){
        // Specified at checkout
        return this.date;
    }

    public String getDueDate(String toolCode){
        // Calculates due date from checkout date and rental days
        return "Happy";
    }

    public String getRentalCharge(String toolCode){
        // Amount per day, specified by the tool type
        return "Happy";
    }

    public String getChargeDays(String toolCode){
        // Count of chargeable days from day after checkout through and including due date excluding no charge days
        return "Happy";
    }

    public String getPreDiscountCharge(String toolCode){
        // Calculated as charge days X daily charge. Resulting total rounded half up to cents.
        return "Happy";
    }

    public int getDiscountPercent(){
        // Specified at checkout
        return this.discount;
    }
    public String getDiscountAmount(String toolCode){
        // Calculated from discount % and pre-discount charge. Resulting amount rounded half up to cents
        return "Happy";
    }
    public String getFinalCharge(String toolCode){
        // Calculated as pre-discount charge- discount amount
        return "Happy";
    }




}
