package com.airsofka.admin.application.shared.ports;

import com.airsofka.admin.application.admin.generateanalytics.GenerateAnalyticsResponse;
import com.airsofka.admin.domain.admin.entities.Booking;

public interface IEventRepositoryBookingPort {
    void saveBooking(Booking booking);

    void updateStatus(String bookingId);

    void updateStatusIssue(String bookingId);

    Booking getBooking (String aggregateId);
}
