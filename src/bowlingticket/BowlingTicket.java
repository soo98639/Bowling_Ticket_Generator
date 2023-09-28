package bowlingticket;

public class BowlingTicket {
    private String ticketNo, custName;
    private int playTime, playerType, noOfPlayer;
    private double totalPayment;
    
    public BowlingTicket(String ticketNo, String custName, int playTime, int playerType, int noOfPlayer)
    {
        this.ticketNo = ticketNo;
        this.custName = custName;
        this.playTime = playTime;
        this.playerType = playerType;
        this.noOfPlayer = noOfPlayer;
    }
    
    public void calculateCharge()
    {
        switch (playTime) 
        {
            case 1:
                switch(playerType)
                {
                    case 1: 
                        totalPayment = 8.80 * noOfPlayer;
                        break;
                    case 2: 
                        totalPayment = 6.80 * noOfPlayer;
                        break;
                    case 3: 
                        totalPayment = 14.00 * noOfPlayer;
                        break;
                    default: 
                        System.out.println("Input is invalid. Program is terminated.");
                        System.exit(0);
                }   
                break;
            case 2:
                switch(playerType)
                {
                    case 1: 
                        totalPayment = 7.50 * noOfPlayer;
                        break;
                    case 2: 
                        totalPayment = 5.80 * noOfPlayer;
                        break;
                    case 3: 
                        totalPayment = 12.50 * noOfPlayer;
                        break;
                    default: 
                        System.out.println("Input is invalid. Program is terminated.");
                        System.exit(0);      
                }   
                break;
            default:
                System.out.println("Input is invalid. Program is terminated.");
                System.exit(0);
        }
    }
    
    public void calculateRebate()
    {
        double totalRebate;
        
        if (noOfPlayer >= 1 && noOfPlayer <=10)
        {
            totalRebate = 0;
        }
        else if (noOfPlayer >= 11 && noOfPlayer <=20)
        {
            totalRebate = totalPayment * 0.05;
        }
        else 
        {
            totalRebate = totalPayment * 0.1;
        }
        
        totalPayment = totalPayment - totalRebate;
    }
    
    public double getTotalPayment()
    {
        return totalPayment;
    }
    
    public String toString()
    {
        String playTimeS = null, playerTypeS = null;
        
        switch(playTime)
        {
            case 1: 
                playTimeS = "Public Holiday";
                break;
            default:
                playTimeS = "Ordinary Day";
        }
        
        switch(playerType)
        {
            case 1:
                playerTypeS = "Company Tournament";
                break;
            case 2:
                playerTypeS = "Member";
                break;
            default:
                playerTypeS = "Non-Member";     
        }
        return  String.format("%-12s %-14s %-18s %-26s %-8s %10s %.2f", 
                ticketNo, custName, playTimeS, playerTypeS, noOfPlayer,"RM ", totalPayment); 
    }   
}