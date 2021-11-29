package elevators.service.impl;

import trainee.elevators.model.dto.Request;
import trainee.elevators.service.DoorService;
import trainee.elevators.service.ElevatorRequestHandle;
import trainee.elevators.service.ElevatorService;

import java.util.LinkedHashMap;

public class ElevatorRequestHandleImpl implements ElevatorRequestHandle {
    // request thang máy được đưa vào 1 LinkedHashMap store dưới dạng Key - Value
    // Key : idElevator
    // Value : request cần xử lí
    // lưu yêu cầu đến thang máy N.
    // (ở đây thang máy N được đại diện là idElevator, mỗi thang máy có 1 id)
    LinkedHashMap<Long,Request> requestQueue = new LinkedHashMap<>();
    ElevatorService elevatorService;
    DoorService doorService;

    @Override
    public void handleRequest(Request request) {
        //

    }
}
