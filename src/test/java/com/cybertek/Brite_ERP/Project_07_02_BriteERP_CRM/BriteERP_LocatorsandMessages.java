package com.cybertek.Brite_ERP.Project_07_02_BriteERP_CRM;

public class BriteERP_LocatorsandMessages {

    static String successfulLoginLocator = "o_thread_title";   //classname
    static String crmLocator = "//a//span[contains(text(),'CRM')]"; // xpath
    static String crmPageTextLocator = "//li[.='Pipeline']";  //xpath
    static String crmListButtonLocator = "button[accesskey='l']";   //css locator
    static String numberOfOpportunitiesLocator = "span.o_pager_limit"; // css locator
    //static String numberOfOpportunitiesLocator = "div.o_cp_pager div"; // css locator
    static String kanbanViewButtonLocator = "button[accesskey='k']"; //css locator
    static String createButtonLocator = "button[accesskey='c']";   //css locator
    static String inputOpportunityTitleLocator = "input[name='name']";   // css locator
   // static String inputCustomerLocator = "(//span[@class='o_dropdown_button'])[1]"; //xpath
    static String inputCustomerLocator = "//div[@class='o_input_dropdown']//input"; //xpath
    //static String listOfOpportunitiesLocator = "//div[starts-with(@class,'oe_kanban_color')]";   //xpath

    static String listOfOpportunitiesLocator = "//div[contains(@class,'oe_kanban_color')]";   //xpath
    static String listOfCustomerOptionsLocator = "//li[starts-with(@id,'ui-id')]"; //xpath

    static String expectedRevenueLocator = "//input[@name='planned_revenue']";   //xpath
    static String createOpportunityButtonLocator = "close_dialog";  //name
    static String deleteButtonLocator = "(//a[@data-type='delete'])";   // xpath
    static String deleteOkButtonLocator = "//span[contains(text(),'Ok')]";  //xpath
    static String listOfThreeDotsLocator = "//a[@class='dropdown-toggle btn']"; // xpath
   // static String threeDotLocator = "(//a[@class='dropdown-toggle btn'])[" + "]"; // xpath




    static String loginExpectedMessage = "Congratulations, your inbox is empty";
    static String CRMExpectedMessage = "Pipeline";

    static int numberOfOpportunities;
    static int numberOfOpportunities_after;
}
