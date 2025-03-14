package com.airsofka.admin.infra.mainservice.controllers;

import com.airsofka.admin.application.admin.cancelbooking.CancelBookingRequest;
import com.airsofka.admin.application.admin.cancelbooking.CancelBookingUseCase;
import com.airsofka.admin.application.shared.BookingResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cancel-booking")
public class CancelBookingController {
    private final CancelBookingUseCase useCase;

    public CancelBookingController(CancelBookingUseCase useCase) {
        this.useCase = useCase;
    }

    @PutMapping
    public BookingResponse cancelBooking(@RequestBody CancelBookingRequest request) {
        return useCase.execute(request);
    }

}
