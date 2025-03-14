package com.airsofka.admin.application.admin.cancelbooking;

import com.airsofka.admin.application.shared.AdminMapper;
import com.airsofka.admin.application.shared.BookingResponse;
import com.airsofka.admin.application.shared.ports.IEventRepositoryBookingPort;
import com.airsofka.admin.domain.admin.entities.Booking;
import com.airsofka.admin.domain.admin.values.State;
import com.airsofka.shared.application.ICommandUseCase;

public class CancelBookingUseCase implements ICommandUseCase<CancelBookingRequest, BookingResponse> {
//    private final IEventRepositoryPort repository;
    private final IEventRepositoryBookingPort bookingRepository;

    public CancelBookingUseCase( IEventRepositoryBookingPort bookingRepository) {

        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingResponse execute(CancelBookingRequest request) {
//        return repository.findEventsByAggregateId(request.getAggregateId())
//                .collectList()
//                .map(events -> {
//                    Admin admin = Admin.from(request.getAggregateId(), events);
//
//                    admin.cancelBooking(
//                            request.getId(),
//                            request.getBookingCode(),
//                            request.getState()
//                    );


                    Booking booking = new Booking();
                    booking.setState(State.of("CANCELED"));

                    bookingRepository.updateStatus(booking);
                    bookingRepository.saveBooking(booking);

//                    admin.getUncommittedEvents().forEach(repository::save);
//                    admin.markEventsAsCommitted();

                    return AdminMapper.mapToBooking(booking);
//                });
    }
}
