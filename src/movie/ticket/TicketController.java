package movie.ticket;
import java.util.Scanner;

import cineplex.cinema.Seat;
import customer.Age;
import movie.showtime.Showtime;

public class TicketController  {	

    // public void changeBasePrice(int P)
    // {
    //     Ticket.setBasePrice(P);
    //     double p = this.calculateFinalPrice();
    //     System.out.println("Final price = " + p +" for base price = " + P);
    // }
    // public void changeSeat(Seat target)
    // {
    //     if(target.isOccupied())
    //     {
    //         System.out.println("Error! target seat is already occupied !!");
    //         return;
    //     }
    //     else
    //     {
    //         this.getSeat().setOccupied(false);
    //         this.setSeat(target);
    //         target.setOccupied(true);
    //         System.out.println("Seat change successful!");
    //     }
    // }
    
    // public void changeShowtime(Showtime target)
    // {
        
    // }
    public Age getAge(){
        System.out.println("Select Age \n1)Senior \n2)Adult \n3)Children");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch(choice){
            case 1: return Age.SENIOR;
            case 2: return Age.ADULT;
            case 3: return Age.CHILDREN;
        }
        return Age.ADULT;
    }
    public Ticket issueTicket(Age age, Seat seat, Showtime showtime){
        Ticket ticket = new Ticket(age, seat, showtime);
        ticket.displayTicketInfo();
        return ticket;
    }
}