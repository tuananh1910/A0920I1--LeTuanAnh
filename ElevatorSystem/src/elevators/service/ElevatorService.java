package elevators.service;

import java.util.List;

public interface ElevatorService {
    void moveUp();
    void moveDown();
    void updateIntermediateStops(List<Integer> floors);
}
