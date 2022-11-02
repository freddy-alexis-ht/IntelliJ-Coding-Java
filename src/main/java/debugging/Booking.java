package debugging;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Booking {

    private final String hotel;
    private final LocalDate checkinDate;
    private final LocalDate checkoutDate;
    private final Collection<Guest> guests = new ArrayList<>();
    private boolean confirmed;

    public Booking(String hotel, LocalDate checkinDate, LocalDate checkoutDate) {
        this.hotel = hotel;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }

    public void addGuest(String guestName) {
        this.guests.add(new Guest(guestName));
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public String getHotel() {
        return hotel;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public int getNumGuests() {
        return this.guests.size();
    }


    public static void main(String[] args) {
        Booking booking = new Booking("The Prancing Pony", LocalDate.now(), LocalDate.now().plusDays(2));
        booking.addGuest("Pippin");
        booking.addGuest("Frodo");
        booking.addGuest("Sam");
        booking.addGuest("Merry");
        booking.confirm();
    }

    private void confirm() {
        this.confirmed = true;
    }
}
