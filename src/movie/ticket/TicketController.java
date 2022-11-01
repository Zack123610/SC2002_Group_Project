package movie.ticket;
import java.util.ArrayList;
import java.util.List;
import cineplex.cinema.Seat;
import movie.showtime.Showtime;
import customer.Age;

public class TicketController extends Ticket {
    private List<Ticket> tickets;
    private int currentSize;
    public TicketController() 
    {
        this.tickets  = new ArrayList<Ticket>();
        this.currentSize = -1;
    }
    public int searchTicket(Seat seat, Showtime showtime)
    {
        int ptr = -1;
        for(Ticket t : tickets)
        {
            ptr++;
            if(t.getShowtime() == showtime && t.getSeat() == seat)
                return ptr;
        }
        return -1;
    }
    public Boolean TicketAlreadyExists(Seat seat, Showtime showtime) 
    //call this before assign new ticket, before getting ticket information and deleting ticket to avoid error
    {
        int pos = searchTicket(seat, showtime);
        if(pos != -1) return true;
        return false;
    }
    public Ticket newTicket(Seat seat,Age age,Showtime showtime)
    {
        currentSize++;
        Ticket temp = new Ticket();
        temp.setAge(age);
        temp.setShowtime(showtime);
        temp.setSeat(seat);
        tickets.add(temp);
        return tickets.get(currentSize);
    }
    public Ticket getTicket(Seat seat,Showtime showtime)
    {
        Ticket temp = new Ticket();
        int pos = searchTicket(seat, showtime);
        if(pos != -1) return tickets.get(pos);
        return temp;
    }
    public void deleteTicket(Seat seat,Showtime showtime)
    {
        int pos = searchTicket(seat, showtime);
        tickets.remove(pos);
        currentSize--;
    }
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
    public void changeShowtime(Seat Currentseat , Seat newSeat,Showtime CurrentShowtime,Showtime newShowtime)
    {
        if(TicketAlreadyExists(newSeat,newShowtime))
        {
            System.out.println("Error, Ticket already exist in target position!!");
            return;
        }
        int pos = searchTicket(Currentseat, CurrentShowtime);
        tickets.get(pos).setSeat(newSeat);
        tickets.get(pos).setShowtime(newShowtime);
        System.out.println("Seat change successful!");
    }
}