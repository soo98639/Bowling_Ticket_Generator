package bowlingticket;

public class BowlingTicket2 
{
    private String ticketNo;
    private String custName;
    private String playTime;
    private String playerType;
    private int noOfPlayer;
    private double totalPayment;

    BowlingTicket2(String ticketNo, String custName, String playTime, String playerType, int noOfPlayer) 
    {
        this.ticketNo = ticketNo;
        this.custName = custName;
        this.playTime = playTime;
        this.playerType = playerType;
        this.noOfPlayer = noOfPlayer;
    }

    public void calculateCharge() 
    {
        if(playTime.equals("Public Holiday"))
        {
            if(playerType.equals("Company tournament"))
            {
                totalPayment = 8.80 * noOfPlayer;
            }
            else if(playerType.equals("Member"))
            {
                totalPayment = 6.80 * noOfPlayer;
            }
            else
            {
                totalPayment = 14 * noOfPlayer;
            }

        }
        else
        {
            if(playerType.equals("Company tournament"))
            {
              totalPayment = 7.50 * noOfPlayer;
            }
            else if(playerType.equals("Member"))
            {
                totalPayment = 5.80 * noOfPlayer;
            }
            else
            {
                totalPayment = 12.50 * noOfPlayer;
            }
        }
    }//calculateCharge 

    public void calculateRebate()     
    {
        if(noOfPlayer >10 && noOfPlayer<=20)
        {
            totalPayment = totalPayment-(0.05*totalPayment);
        }
        else if(noOfPlayer>20)
        {
            totalPayment = totalPayment-(0.1*totalPayment);
        }
        else
        {
            totalPayment = totalPayment;
        }
    }// calculateRebate
    
    public double getTotalPayment()
    {
        return totalPayment;
    }

    public String toString()
    {
        return "Ticker No: " + ticketNo 
                + "\nCustomer Name: " + custName 
                + "\nPlay Time: " + playTime 
                + "\nPlayer Type: " + playerType 
                + "\nNo. of Player: " + noOfPlayer 
                + "\nTotal Payment: RM " + String.format("%.2f",totalPayment) + "\n\n";
    }
}
