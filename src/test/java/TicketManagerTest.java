import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    @Test
    public void FindAllTest() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1, "SPB", "MSK", 3_000);
        Ticket ticket2 = new Ticket(2, "SPB", "MSK", 2_500);
        Ticket ticket3 = new Ticket(3, "SPB", "MSK", 3_500);
        Ticket ticket4 = new Ticket(4, "SPB", "MSK", 2_700);
        Ticket ticket5 = new Ticket(5, "SPB", "MSK", 3_700);
        Ticket ticket6 = new Ticket(6, "MSK", "KLD", 3_800);
        Ticket ticket7 = new Ticket(7, "MSK", "UFA", 5_000);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.findAll("SPB", "MSK");
        Ticket[] expected = { ticket2, ticket4,ticket1, ticket3, ticket5 };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void AddIdTest() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket2 = new Ticket(2, "SPB", "MSK", 2_500);
        Ticket ticket3 = new Ticket(3, "SPB", "MSK", 3_500);

        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] actual = manager.findAll();
        Ticket[] expected = {  };

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void AddTicketsTest() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, "SPB", "MSK", 3_000);
        Ticket ticket11 = new Ticket(11, "SPB", "KRD", 6_500);
        Ticket ticket12 = new Ticket(12, "SPB", "TUL", 4_000);
        Ticket ticket13 = new Ticket(13, "MSK", "NSK", 8_500);
        Ticket ticket14 = new Ticket(14, "PSK", "KRD", 7_900);

        manager.add(ticket1);
        manager.add(ticket11);
        manager.add(ticket12);
        manager.add(ticket13);
        manager.add(ticket14);

        Ticket[] actual = manager.findAll();
        Ticket[] expected = {  };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void FindOneTicketTest() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket6 = new Ticket(6, "MSK", "KLD", 3_800);

        manager.add(ticket6);

        Ticket[] actual = manager.findAll("MSK", "KLD");
        Ticket[] expected = { ticket6 };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void NotFindTicketTest() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket2 = new Ticket(11, "KLD", "MSK", 8_000);

        manager.add(ticket2);

        Ticket[] actual = manager.findAll();
        Ticket[] expected = {  };

        Assertions.assertArrayEquals(expected, actual);
    }

}