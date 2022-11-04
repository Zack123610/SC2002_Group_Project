package movie.ticket;

import cineplex.cinema.Seat;
import customer.Age;
import movie.showtime.Showtime;

public interface ITicketController {
    public Ticket issueTicket(Age age, Seat seat, Showtime showtime);
}
