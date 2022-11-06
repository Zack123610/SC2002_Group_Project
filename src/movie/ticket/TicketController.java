package movie.ticket;
import cineplex.cinema.Seat;
import customer.Age;
import input.NumberHandler;
import main.ITicketController;
import movie.showtime.Showtime;

/**
 * The TicketController provides the implementation for the {@code ITicketController} interface
 * @author Tan Say Hong
 *
 */
public class TicketController implements ITicketController {	
	
	public Age getAge(){
        System.out.println("Select Age: \n1) Senior \n2) Adult \n3) Children");
        System.out.print("Please select an option: ");
        return switch(NumberHandler.readInt(1, 3)) {
            case 1 -> Age.SENIOR;
            case 2 -> Age.ADULT;
            case 3 -> Age.CHILD;
            default -> Age.ADULT;
        };
    }
	
    public Ticket issueTicket(Age age, Seat seat, Showtime showtime){
        Ticket ticket = new Ticket(age, seat, showtime);
        ticket.displayTicketInfo();
        return ticket;
    }
}