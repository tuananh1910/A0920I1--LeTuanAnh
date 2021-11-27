package trainee.elevators.model.entity;

import trainee.elevators.common.Direction;

public class Status {
    private int currentFloor;
    private Direction direction;
    private int finalDestination;

    // OneToOne
    private Elevator elevator;

    // getter setter
    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getFinalDestination() {
        return finalDestination;
    }

    public void setFinalDestination(int finalDestination) {
        this.finalDestination = finalDestination;
    }



    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    // constructor
    public Status() {
    }
    public Status(int currentFloor, Direction direction, int finalDestination, Elevator elevator) {
        this.currentFloor = currentFloor;
        this.direction = direction;
        this.finalDestination = finalDestination;
        this.elevator = elevator;
    }
}
