package movie.ticket;
import cineplex.cinema.Seat;
import customer.Age;
import input.IntegerHandler;
import movie.showtime.Showtime;

public class TicketController implements ITicketController {	
	
	public TicketController() { }
	
	public Age getAge(){
        System.out.println("Select Age: \n1)Senior \n2)Adult \n3)Children");
        System.out.print("Please select an option: ");
        return switch(IntegerHandler.readInt(1, 3)) {
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