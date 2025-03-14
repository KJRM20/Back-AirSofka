package com.airsofka.admin.application.admin.getallbookings;

import java.time.LocalDateTime;
import java.util.List;

public class BookingConfirmedResponse {

        private String id;
        private String state;
        private LocalDateTime departureDate;
        private LocalDateTime arrivalDate;
        private String origin;
        private String destination;
        private String reservationCode;
        private LocalDateTime creationDate;
        private String paymentMethod;
        private String passengers;
        private String email;
        private double taxes;
        private int numberPassengers;
        private double totalPrice;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BookingConfirmedResponse(String id, String state, LocalDateTime departureDate, LocalDateTime arrivalDate, String origin, String destination, String reservationCode, LocalDateTime creationDate, String paymentMethod, String passengers, String email, double taxes, int numberPassengers, double totalPrice) {
        this.id = id;
        this.state = state;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.origin = origin;
        this.destination = destination;
        this.reservationCode = reservationCode;
        this.creationDate = creationDate;
        this.paymentMethod = paymentMethod;
        this.passengers = passengers;
        this.email = email;
        this.taxes = taxes;
        this.numberPassengers = numberPassengers;
        this.totalPrice = totalPrice;
    }

    public int getNumberPassengers() {
        return numberPassengers;
    }

    public void setNumberPassengers(int numberPassengers) {
        this.numberPassengers = numberPassengers;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public BookingConfirmedResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }
}
