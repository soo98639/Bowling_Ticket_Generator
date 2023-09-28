package bowlingticket;

import java.util.Scanner;

public class BowlingTicketCalculator {
    private static int i=0, choice=0;
    private static BowlingTicket[] arrBowlingTicket = new BowlingTicket[3];
    private static Scanner scan = new Scanner(System.in);
    
    public static void displayMenu()
    {
        System.out.println("MAIN MENU");
        System.out.println("1. CREATE TICKET");
        System.out.println("2. DISPLAY SALES");
        System.out.println("3. DISPLAY TOTAL CURRENT SALES");
        System.out.println("0. EXIT");
        System.out.print("PLEASE CHOOSE ONE OF THE ABOVE OPTIONS: ");
        choice = scan.nextInt();
    }
    
    public static void addTicket(BowlingTicket bowTicket)
    {
        arrBowlingTicket[i] = bowTicket;
        System.out.println("------------------------------------------------");
        System.out.println("INFO:The ticket has been successfully created");
        System.out.println("------------------------------------------------");
    }
    
    public static void printArray()
    {
        System.out.println("========================================================================================================");
        System.out.printf("%-12s %-14s %-18s %-26s %-15s %-15s %n",
                "TICKET NO","CUST. NAME","PLAYTIME","PLAYER TYPE","PLAYER NO.","TOTAL PAYMENT");
        System.out.println("========================================================================================================");
        for(int i=0; i<arrBowlingTicket.length; i++)
        {
            System.out.println(arrBowlingTicket[i].toString());
        }
        System.out.println("========================================================================================================");
    }
    
    public static void calculateTotalSales()
    {
        double totalSales=0;
        for(int i=0; i<arrBowlingTicket.length; i++)
        {
            totalSales += arrBowlingTicket[i].getTotalPayment();
        }
        System.out.println("------------------------------------------");
        System.out.println("\tCurrent total is RM " + String.format("%.2f",totalSales));
        System.out.println("------------------------------------------");
    }

    public static void main(String[] args) 
    {
        String ticketNo, custName;
        int playTime, playerType, noOfPlayer;
        
        do 
        {
            displayMenu();
            switch(choice)
            {
                case 1:
                    System.out.print("Ticket number: ");
                    ticketNo = scan.next();
                    System.out.print("Customer name: ");
                    custName = scan.next();
                    System.out.print("Time [1-Public Holiday 2-Ordinary Day]: ");
                    playTime = scan.nextInt();
                    System.out.print("Player Type [1-Company Tournament 2-Member 3-Non-Member]: ");
                    playerType = scan.nextInt();
                    System.out.print("Number of players: ");
                    noOfPlayer = scan.nextInt();
                    BowlingTicket bowTicket = new BowlingTicket(ticketNo, custName, playTime, playerType, noOfPlayer);
                    addTicket(bowTicket);
                    arrBowlingTicket[i].calculateCharge();
                    arrBowlingTicket[i].calculateRebate();
                    i++;
                    break;     
                case 2: 
                    printArray();
                    break;    
                case 3:
                    calculateTotalSales();
                    break;   
                default:
                    System.exit(0);     
            }
        }
        while(choice > 0);   
    }    
}