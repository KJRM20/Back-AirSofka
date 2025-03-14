package com.airsofka.admin.infra.mysql.adapters;

import com.airsofka.admin.application.shared.ports.IEventRepositoryBookingPort;
import com.airsofka.admin.domain.admin.entities.Booking;
import com.airsofka.admin.infra.mysql.entities.BookingEntity;
import com.airsofka.admin.infra.mysql.repositories.BookingJpaRepository;

import java.util.Optional;

public class MysqlAdapter implements IEventRepositoryBookingPort {

    private BookingJpaRepository bookingJpaRepository;

    private BookingAdapter bookingAdapter;

    public MysqlAdapter(BookingJpaRepository bookingJpaRepository) {
        this.bookingJpaRepository = bookingJpaRepository;
    }

    @Override
    public void saveBooking(Booking booking) {
        BookingEntity bookingEntity = BookingAdapter.toEntity(booking);
        bookingJpaRepository.save(bookingEntity);
    }

    @Override
    public void updateStatus(String bookingId) {
       BookingEntity existingBooking = bookingJpaRepository.findById(bookingId).orElse(null);
        if (existingBooking != null) {
            existingBooking.setState("CANCELED");
            bookingJpaRepository.save(existingBooking);
        }
    }

    @Override
    public void updateStatusIssue(String bookingId) {
        BookingEntity existingBooking = bookingJpaRepository.findById(bookingId).orElse(null);
        if (existingBooking != null) {
            existingBooking.setState("ISSUED");
            bookingJpaRepository.save(existingBooking);
        }
    }

    @Override
    public Booking getBooking(String aggregateId) {
        return null;
    }


}
