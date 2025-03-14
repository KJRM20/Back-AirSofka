package com.airsofka.admin.application.shared;

import com.airsofka.admin.domain.admin.values.State;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class AdminResponse {
    private final String adminId;
    private final List<Booking> booking;
    private final String email;
    private final Double income;
    private final String state;
    private final Double taxes;

    public AdminResponse(String adminId, List<Booking> booking, String email, Double income, String state, Double taxes) {
        this.adminId = adminId;
        this.booking = booking;
        this.email = email;
        this.income = income;
        this.state = state;
        this.taxes = taxes;
    }

    public String getAdminId() {
        return adminId;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public String getEmail() {
        return email;
    }

    public Double getIncome() {
        return income;
    }

    public String getState() {
        return state;
    }

    public Double getTaxes() {
        return taxes;
    }

    public static class Booking {
        private final String bookingId;
        private final LocalDate arrivalDate;
        private final String bookingCode;
        private final LocalDate creationDate;
        private final LocalDate departureDate;
        private final String destination;
        private final String email;
        private final String flightClass;
        private final String origin;
        private final List<Passenger> passengers;
        private final String paymentMethod;
        private final Double price;
        private final String state;

        public Booking(String bookingId, LocalDate arrivalDate, String bookingCode, LocalDate creationDate, LocalDate departureDate, String destination, String email, String flightClass, String origin, List<Passenger> passengers, String paymentMethod, Double price, String state) {
            this.bookingId = bookingId;
            this.arrivalDate = arrivalDate;
            this.bookingCode = bookingCode;
            this.creationDate = creationDate;
            this.departureDate = departureDate;
            this.destination = destination;
            this.email = email;
            this.flightClass = flightClass;
            this.origin = origin;
            this.passengers = passengers;
            this.paymentMethod = paymentMethod;
            this.price = price;
            this.state = state;
        }

        public String getBookingId() {
            return bookingId;
        }

        public LocalDate getArrivalDate() {
            return arrivalDate;
        }

        public String getBookingCode() {
            return bookingCode;
        }

        public LocalDate getCreationDate() {
            return creationDate;
        }

        public LocalDate getDepartureDate() {
            return departureDate;
        }

        public String getDestination() {
            return destination;
        }

        public String getEmail() {
            return email;
        }

        public String getFlightClass() {
            return flightClass;
        }

        public String getOrigin() {
            return origin;
        }

        public List getPassengers() {
            return passengers;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public Double getPrice() {
            return price;
        }

        public String getState() {
            return state;
        }

        public static class Passenger {
            private final String bookerName;
            private final String email;

            public Passenger(String bookerName, String email) {
                this.bookerName = bookerName;
                this.email = email;
            }

            public String getBookerName() {
                return bookerName;
            }

            public String getEmail() {
                return email;
            }
        }
    }

}
