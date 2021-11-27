package trainee.elevators.model.entity;

public abstract class Button {
    private Long id;
    private int floorNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Button(Long id, int floorNumber) {
        this.id = id;
        this.floorNumber = floorNumber;
    }

    public Button() {
    }
}
