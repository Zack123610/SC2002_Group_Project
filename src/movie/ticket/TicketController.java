package movie.ticket;
import cineplex.cinema.Seat;
import movie.showtime.Showtime;
import customer.Age;
public class TicketController extends Ticket {
    private Ticket[] tickets;
    private int currentSize;
    public TicketController() 
    {
        this.tickets = new Ticket[100];
        this.currentSize = -1;
    }
    public int searchTicket(Seat seat, Showtime showtime)
    {
        for(int i = 0;i <= currentSize;i++)
        {
            if(tickets[i].getShowtime() == showtime && tickets[i].getSeat() == seat)
                return i;
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
        tickets[currentSize].setAge(age);
        tickets[currentSize].setShowtime(showtime);
        tickets[currentSize].setSeat(seat);
        return tickets[currentSize];
    }
    public Ticket getTicket(Seat seat,Showtime showtime)
    {
        Ticket temp = new Ticket();
        int pos = searchTicket(seat, showtime);
        if(pos != -1) return tickets[pos];
        return temp;
    }
    public void deleteTicket(Seat seat,Showtime showtime)
    {
        int pos = searchTicket(seat, showtime);
        for(int i = pos;i< currentSize;i++)
        {
            tickets[i].setAge(tickets[i+1].getAge());
            tickets[i].setSeat(tickets[i+1].getSeat());
            tickets[i].setShowtime(tickets[i+1].getShowtime());
        }
        tickets[currentSize] = new Ticket();
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
        tickets[pos].setSeat(newSeat);
        tickets[pos].setShowtime(newShowtime);
        System.out.println("Seat change successful!");
    }
}