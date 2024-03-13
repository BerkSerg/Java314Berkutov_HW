package hw25_lambda;

import hw25_lambda.classes.Robot;
import hw25_lambda.enums.Direction;


/**
 * Задание 1. Реализовать класс Robot
 */
public class Main {
    public static void main(String[] args) {
        Robot vacuumCleaner = new Robot();

        moveRobotTo(3,0, vacuumCleaner);
        moveRobotTo(1,5, vacuumCleaner);
        moveRobotTo(4,2, vacuumCleaner);
    }

    private static void moveRobotTo(int targetX, int targetY, Robot robot){
        int currentX = robot.getX();
        int currentY = robot.getY();

        if(currentX == targetX && currentY == targetY){
            System.out.println("Робот в нужной точке");
            return;
        }

        System.out.println("---------------");
        System.out.printf("Текущее положение: x(%d), y(%d), смотрим %s\n", robot.getX(), robot.getY(), robot.getDirection());
        System.out.printf("Идем к x(%d), y(%d)\n", targetX, targetY);

        int totalStepsX = 0;
        if(currentX < targetX){
            turnRobotToDirection(Direction.RIGHT, robot);
            totalStepsX = targetX - currentX;
        } else if(currentX > targetX){
            turnRobotToDirection(Direction.LEFT, robot);
            totalStepsX = currentX - targetX;
        }
        for(int step = 0; step < totalStepsX; step++){
            robot.stepForward();
        }

        int totalStepsY = 0;
        if(currentY < targetY){
            turnRobotToDirection(Direction.UP, robot);
            totalStepsY = targetY - currentY;
        } else if(currentY > targetY){
            turnRobotToDirection(Direction.DOWN, robot);
            totalStepsY = currentY - targetY;
        }
        for(int step = 0; step < totalStepsY; step++){
            robot.stepForward();
        }
        System.out.printf("На месте! Новое положение: x(%d) y(%d)\n", robot.getX(), robot.getY());
    }

    private static void turnRobotToDirection(Direction targetDirection, Robot robot){
        Direction currentDirection = robot.getDirection();

        if(currentDirection.equals(targetDirection)){
            return;
        }

        switch (currentDirection){
            case UP -> {
                switch (targetDirection){
                    case RIGHT -> robot.turnRight();
                    case LEFT -> robot.turnLeft();
                    default -> {
                        robot.turnRight();
                        robot.turnRight();
                    }
                }
            }
            case RIGHT -> {
                switch (targetDirection){
                    case DOWN -> robot.turnRight();
                    case UP -> robot.turnLeft();
                    default -> {
                        robot.turnRight();
                        robot.turnRight();
                    }
                }
            }
            case DOWN -> {
                switch (targetDirection){
                    case LEFT -> robot.turnRight();
                    case RIGHT -> robot.turnLeft();
                    default -> {
                        robot.turnRight();
                        robot.turnRight();
                    }
                }
            }
            case LEFT -> {
                switch (targetDirection){
                    case UP -> robot.turnRight();
                    case DOWN -> robot.turnLeft();
                    default -> {
                        robot.turnRight();
                        robot.turnRight();
                    }
                }
            }
        }
    }
}
