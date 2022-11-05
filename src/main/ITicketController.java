package main;

import cineplex.cinema.Seat;
import customer.Age;
import movie.showtime.Showtime;
import movie.ticket.Ticket;

public interface ITicketController {
    public Ticket issueTicket(Age age, Seat seat, Showtime showtime);
    public Age getAge();
<<<<<<< HEAD
}
=======
}
>>>>>>> master
