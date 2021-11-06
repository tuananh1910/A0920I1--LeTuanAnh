package problem1.model;

public class Elevator
//        implements ActiveElevator
{
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Elevator(String name, String status, int numberCurrentFloor) {
        this.name = name;
        this.status = status;
        this.numberCurrentFloor = numberCurrentFloor;
    }

    public Elevator(String name, String status, int numberCurrentFloor, HistoryActive historyActive) {
        this.name = name;
        this.status = status;
        this.numberCurrentFloor = numberCurrentFloor;
        this.historyActive = historyActive;
    }

    public HistoryActive getHistoryActive() {
        return historyActive;
    }

    public void setHistoryActive(HistoryActive historyActive) {
        this.historyActive = historyActive;
    }

    private String status;
    private int numberCurrentFloor;
    private HistoryActive historyActive;

    public Elevator() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberCurrentFloor() {
        return numberCurrentFloor;
    }

    public void setNumberCurrentFloor(int numberFloor) {
        this.numberCurrentFloor = numberFloor;
    }


//    @Override
//    public int increase(int numberCurrentFloor) {
//        return numberCurrentFloor++;
//    }
//
//    @Override
//    public int decrease(int numberCurrentFloor) {
//        return numberCurrentFloor--;
//    }
}
