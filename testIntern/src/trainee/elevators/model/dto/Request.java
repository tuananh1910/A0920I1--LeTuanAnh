package trainee.elevators.model.dto;

import trainee.elevators.common.Direction;

public class Request {
    private long requestTime;
    private int floor;
    private Direction direction;

    public long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Request() {
    }

    public Request(long requestTime, int floor, Direction direction) {
        this.requestTime = requestTime;
        this.floor = floor;
        this.direction = direction;
    }
}
