import java.util.*;

class Reservation {
    private String name;
    private String trainNumber;
    private String trainName;
    private String classType;
    private Date journeyDate;
    private String from;
    private String to;
    private int pnr;

    // Constructor
    public Reservation(String name, String trainNumber, String trainName, String classType, Date journeyDate, String from, String to, int pnr) {
        this.name = name;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.journeyDate = journeyDate;
        this.from = from;
        this.to = to;
        this.pnr = pnr;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getClassType() {
        return classType;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getPNR() {
        return pnr;
    }
}

class ReservationSystem {
    private Map<Integer, Reservation> reservations;
    private int nextPNR;

    public ReservationSystem() {
        reservations = new HashMap<>();
        nextPNR = 1001; // Starting PNR number
    }

    public int reserveTicket(String name, String trainNumber, String trainName, String classType, Date journeyDate, String from, String to) {
        int pnr = nextPNR++;
        Reservation reservation = new Reservation(name, trainNumber, trainName, classType, journeyDate, from, to, pnr);
        reservations.put(pnr, reservation);
        return pnr;
    }

    public Reservation cancelTicket(int pnr) {
        return reservations.remove(pnr);
    }

    public Reservation getReservationDetails(int pnr) {
        return reservations.get(pnr);
    }
}

public class onlineReservationSystem {
    public static void main(String[] args) {
        // Sample usage
        ReservationSystem reservationSystem = new ReservationSystem();

        // User reserves a ticket
        int pnr = reservationSystem.reserveTicket("John Doe", "12345", "Express", "AC", new Date(), "City1", "City2");

        // Display reservation details
        Reservation reservation = reservationSystem.getReservationDetails(pnr);
        if (reservation != null) {
            System.out.println("Reservation Details:");
            System.out.println("PNR: " + reservation.getPNR());
            System.out.println("Name: " + reservation.getName());
            System.out.println("Train Number: " + reservation.getTrainNumber());
            System.out.println("Train Name: " + reservation.getTrainName());
            System.out.println("Class: " + reservation.getClassType());
            System.out.println("Journey Date: " + reservation.getJourneyDate());
            System.out.println("From: " + reservation.getFrom());
            System.out.println("To: " + reservation.getTo());
        } else {
            System.out.println("Reservation not found.");
        }

        // User cancels the ticket
        Reservation cancelledReservation = reservationSystem.cancelTicket(pnr);
        if (cancelledReservation != null) {
            System.out.println("Reservation with PNR " + pnr + " cancelled successfully.");
        } else {
            System.out.println("No reservation found with PNR " + pnr + ".");
        }
    }
}

