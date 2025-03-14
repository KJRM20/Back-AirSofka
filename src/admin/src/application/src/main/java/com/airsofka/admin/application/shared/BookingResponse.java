package com.airsofka.admin.application.shared;

public class BookingResponse {

    private final String bookingId;
    private final String bookingCode;
    private final String state;

    public BookingResponse(String bookingId, String bookingCode, String state) {
        this.bookingId = bookingId;
        this.bookingCode = bookingCode;
        this.state = state;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public String getState() {
        return state;
    }
}
