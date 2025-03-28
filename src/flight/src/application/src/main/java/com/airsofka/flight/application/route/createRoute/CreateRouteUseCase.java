package com.airsofka.flight.application.route.createRoute;

import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.application.shared.ports.IRouteRepositoryPort;
import com.airsofka.flight.application.shared.route.RouteResponse;
import com.airsofka.flight.domain.route.Route;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import static com.airsofka.flight.application.shared.route.RouteMapper.mapToResponse;

public class CreateRouteUseCase implements ICommandUseCase<CreateRouteRequest, Mono<RouteResponse>> {
    private final IEventsRepositoryPort repository;
    private final IRouteRepositoryPort routeRepositoryPort;

    public CreateRouteUseCase(IEventsRepositoryPort repository, IRouteRepositoryPort routeRepositoryPort) {
        this.repository = repository;
        this.routeRepositoryPort = routeRepositoryPort;
    }

    @Override
    public Mono<RouteResponse> execute(CreateRouteRequest request) {
        Route route = new Route(
                request.getOrigin(),
                request.getDuration(),
                request.getDestination()
        );

        routeRepositoryPort.saveRoute(route);
        route.getUncommittedEvents().forEach(repository::save);
        route.markEventsAsCommitted();

        return Mono.just(mapToResponse(route));
    }
}