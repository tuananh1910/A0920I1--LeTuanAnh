package trainee.elevators.service;

import trainee.elevators.model.dto.Request;

public interface ElevatorRequestHandle {
    void handleRequest(Request request);
}
