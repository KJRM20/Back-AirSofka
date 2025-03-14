package com.airsofka.admin.infra.mysql.adapters;

import com.airsofka.admin.application.admin.getallbookings.BookingConfirmedResponse;
import com.airsofka.admin.application.shared.ports.IEventConfirmedPort;
import com.airsofka.admin.infra.mysql.entities.BookingEntity;
import com.airsofka.admin.infra.mysql.repositories.BookingJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConfirmedBookingAdapter implements IEventConfirmedPort {
    private final BookingJpaRepository bookingJpaRepository;

    @Autowired
    public ConfirmedBookingAdapter(BookingJpaRepository bookingJpaRepository) {
        this.bookingJpaRepository = bookingJpaRepository;
    }

    @Override
    public List<BookingConfirmedResponse> findAllBookingsConfirmed() {
        return bookingJpaRepository.findByStateIgnoreCase("CONFIRMED")
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private BookingConfirmedResponse toResponse(BookingEntity booking) {
        return new BookingConfirmedResponse(
                booking.getId(),
                booking.getState(),
                booking.getDepartureDate().atStartOfDay(),
                booking.getArrivalDate().atStartOfDay(),
                booking.getOrigin(),
                booking.getDestination(),
                booking.getReservationCode(),
                booking.getCreationDate().atStartOfDay(),
                booking.getPayment().getPaymentMethod(),
                booking.getPassengers().isEmpty() ? null :
                        (booking.getPassengers().get(0).getFirstName() + " " +
                                (booking.getPassengers().get(0).getFirstName() != null ? booking.getPassengers().get(0).getLastName() : "")).trim(),

        booking.getPassengers().get(0).getEmail(),
                booking.getPayment().getTotal().intValue()*0.84
                ,booking.getPassengers().size()

        );

    }
}
