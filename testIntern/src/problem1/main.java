package problem1;

import problem1.model.Elevator;
import problem1.model.HistoryActive;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class main {
    static boolean noExit = true;
    static Scanner scanner = new Scanner(System.in);
    static List numberFloorTo = new ArrayList();
    static List<Elevator> elevators = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        double randomDouble = Math.random();
        randomDouble = randomDouble * 10 + 1;
        int randomInt = (int) randomDouble;
        board();
    }
    public static void board() throws InterruptedException {
        int idElevator;
        HistoryActive historyActive = new HistoryActive();  // log history (Aspect)
        // number floor req elevator

        // init elevator list
        double randomDouble = Math.random();
        randomDouble = randomDouble * 10 + 1;
        int randomInt = (int) randomDouble;

        Elevator elevatorA = new Elevator("A","active",1);
        Elevator elevatorB = new Elevator("B","active",2);
        Elevator elevatorC = new Elevator("C","active",3);
        elevators.add(elevatorA);
        elevators.add(elevatorB);
        elevators.add(elevatorC);
        do {
            System.out.println("Welcome");
            System.out.println("1. Call Elevator A, " +
                    "2. Call Elevator B, " +
                    "3. Call Elevator C, 4. Exit");
            idElevator = scanner.nextInt();
            System.out.println("you are on floor number "+ randomInt);

            switch (idElevator){
                case 1:
                    statusElevator(elevators, randomInt,0);
                    break;
                case 2:
                    statusElevator(elevators, randomInt,1);
                    break;

                case 3:
                    statusElevator(elevators, randomInt,2);
                    break;

                default:
                    noExit = false;
                    break;
            }
        }while (noExit);
    }
    // display status of elevator this
    private static void statusElevator(List<Elevator> elevators, int randomInt, int idElevator) throws InterruptedException {
        int numberFloorTo;
        noExit =true;
        Elevator elevator = elevators.get(idElevator);
        int tempNumberCurrentFloor =elevator.getNumberCurrentFloor();

        do {
            System.out.println(" -------------- ");
            System.out.println("Name Elevator : " + elevator.getName());
            System.out.println("Status : " + elevator.getStatus());
            if (randomInt==tempNumberCurrentFloor){
                elevators.get(idElevator).setNumberCurrentFloor(tempNumberCurrentFloor);
                System.out.println("Floor Current : " + tempNumberCurrentFloor);
                System.out.println("Please enter the floor number to (1-10): ");
                numberFloorTo = scanner.nextInt();
                transElevator(elevators,numberFloorTo, idElevator);
//                numberFloorTo.add(numberFloor);
                noExit= false;
            }else {
                System.out.println("Please wait for the elevator");
                System.out.println("Floor current..... :" +tempNumberCurrentFloor);

                if (randomInt>tempNumberCurrentFloor){
                    TimeUnit.SECONDS.sleep(2); //each 2s elevator up to 1 floor

                    tempNumberCurrentFloor++;  // elevator up
                    // check req egg: floor 9 call : elevator from 1 to 9 ,
                    // number floor 5 call
//                    board(tempNumberCurrentFloor);
                }
                else {
                    TimeUnit.SECONDS.sleep(2); //each 2s elevator down to 1 floor
                    tempNumberCurrentFloor--;

//                    board(tempNumberCurrentFloor);
                }
            }
        }while (noExit);
        board();
    }

    private static void transElevator(List<Elevator> elevators, int numberFloorTo, int idElevator) throws InterruptedException {
        // elevator transporting
        System.out.println("transporting....");
        Elevator elevator = elevators.get(idElevator);
        int temp = elevators.get(idElevator).getNumberCurrentFloor();
        do {
            if (numberFloorTo>temp){
                temp++;
            }if (numberFloorTo<temp){
                temp--;
            }if (numberFloorTo==temp){
                elevators.get(idElevator).setNumberCurrentFloor(temp);
                System.out.println("----------------");
                System.out.println("Ting Ting Ting ! Done");
                System.out.println("Name Elevator : " + elevator.getName());
                System.out.println("Status : " + elevator.getStatus());
                System.out.println("Floor current : " + temp);
            }
        }while (!(numberFloorTo==temp));
        board();

    }


}
