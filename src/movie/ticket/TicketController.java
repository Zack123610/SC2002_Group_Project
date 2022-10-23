package movie.ticket;
import booking.Booking;
import cineplex.cinema.Seat;
import customer.Customer;
import globals.Writable;
import showtime.Showtime;

public class TicketController extends Ticket{
    public void changeBasePrice(int P)
    {
        this.setBasePrice(P);
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
            this.seat.occupied =false;
            this.setSeat(target);
            target.occupied = true;
            System.out.println("Seat change successful!");
        }
    }
    public void changeShowtime(Showtime target)
    {
        
    }
}
