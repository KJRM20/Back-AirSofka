package com.airsofka.admin.application.admin.issuebooking;

import com.airsofka.admin.application.shared.AdminMapper;
import com.airsofka.admin.application.shared.BookingResponse;
import com.airsofka.admin.application.shared.ports.IEventRepositoryBookingPort;
import com.airsofka.admin.domain.admin.entities.Booking;
import com.airsofka.admin.domain.admin.values.BookingCode;
import com.airsofka.admin.domain.admin.values.BookingId;
import com.airsofka.admin.domain.admin.values.State;
import com.airsofka.shared.application.ICommandUseCase;

public class IssueBookingUseCase implements ICommandUseCase<IssueBookingRequest, BookingResponse> {
    private final IEventRepositoryBookingPort bookingRepository;

    public IssueBookingUseCase(IEventRepositoryBookingPort bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingResponse execute(IssueBookingRequest request) {
        Booking booking = new Booking(
                BookingId.of(request.getId()), State.of(request.getState()), BookingCode.of(request.getBookingCode())
        );

        booking.setState(State.of("ISSUED"));

        bookingRepository.updateStatusIssue(booking.getIdentity().getValue());
        bookingRepository.saveBooking(booking);

        return AdminMapper.mapToBooking(booking);
    }
}
