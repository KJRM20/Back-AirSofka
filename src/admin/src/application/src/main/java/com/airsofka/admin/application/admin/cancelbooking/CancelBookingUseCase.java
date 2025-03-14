package com.airsofka.admin.application.admin.cancelbooking;

import com.airsofka.admin.application.shared.AdminMapper;
import com.airsofka.admin.application.shared.BookingResponse;
import com.airsofka.admin.application.shared.ports.IEventRepositoryBookingPort;
import com.airsofka.admin.domain.admin.entities.Booking;
import com.airsofka.admin.domain.admin.values.BookingCode;
import com.airsofka.admin.domain.admin.values.BookingId;
import com.airsofka.admin.domain.admin.values.State;
import com.airsofka.shared.application.ICommandUseCase;

public class CancelBookingUseCase implements ICommandUseCase<CancelBookingRequest, BookingResponse> {

    private final IEventRepositoryBookingPort bookingRepository;

    public CancelBookingUseCase( IEventRepositoryBookingPort bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingResponse execute(CancelBookingRequest request) {
                    Booking booking = new Booking(
                            BookingId.of(request.getId()), State.of(request.getState()), BookingCode.of(request.getBookingCode())
                    );

                    booking.setState(State.of("CANCELED"));

                    bookingRepository.updateStatus(booking.getIdentity().getValue());
                    bookingRepository.saveBooking(booking);

                    return AdminMapper.mapToBooking(booking);
    }
}
