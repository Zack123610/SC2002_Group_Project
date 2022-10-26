package movie.ticket;
import cineplex.cinema.Seat;
import movie.showtime.Showtime;

public class TicketController extends Ticket {	
    public void changeBasePrice(int P)
    {
        Ticket.setBasePrice(P);
        double p = this.calculateFinalPrice();
        System.out.println("Final price = " + p +" for base price = " + P);
    }
    public void changeSeat(Seat target)
    {
        if(target.isOccupied())
        {
            System.out.println("Error! target seat is already occupied !!");
            return;
        }
        else
        {
            this.getSeat().setOccupied(false);
            this.setSeat(target);
            target.setOccupied(true);
            System.out.println("Seat change successful!");
        }
    }
    
    public void changeShowtime(Showtime target)
    {
        
    }
}