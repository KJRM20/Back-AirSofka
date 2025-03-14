package com.airsofka.admin.infra.mysql.adapters;

import com.airsofka.admin.domain.admin.entities.Booking;
import com.airsofka.admin.domain.admin.values.BookingCode;
import com.airsofka.admin.domain.admin.values.BookingId;
import com.airsofka.admin.domain.admin.values.State;
import com.airsofka.admin.infra.mysql.entities.BookingEntity;

public class BookingAdapter {
    public static BookingEntity toEntity(Booking booking){
        BookingEntity entity = new BookingEntity();

        entity.setId(booking.getIdentity().getValue());
        entity.setState(booking.getState().getValue());
        entity.setReservationCode(booking.getBookingCode().getValue());

        return entity;
    }

    public static Booking toDomain(BookingEntity entity){
        return new Booking(
                BookingId.of(entity.getId()),
                State.of(entity.getState()),
                BookingCode.of(entity.getReservationCode())

        );
    }
}
