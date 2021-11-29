package elevators.model.entity;

import trainee.elevators.common.Direction;

// hall call button inheritance class Button
public class HallCallButton extends Button
{
    private Direction direction;

    public HallCallButton(Long id, int floorNumber, Direction direction) {
        super(id, floorNumber);
        this.direction = direction;
    }

    public HallCallButton(Direction direction) {
        this.direction = direction;
    }

    public HallCallButton() {
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
