package hw25_lambda.classes;

import hw25_lambda.enums.Direction;
import hw25_lambda.interfaces.IRobot;

public class Robot implements IRobot {
    private Direction direction;
    private int x;
    private int y;

    public Robot() {
        this.x = 0;
        this.y = 0;
        this.direction = Direction.UP;
    }

    public Robot(int initX, int initY, Direction initDirection) {
        this.x = initX;
        this.y = initY;
        this.direction = initDirection;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void turnLeft() {
        switch (direction){
            case UP -> direction=Direction.LEFT;
            case DOWN -> direction=Direction.RIGHT;
            case LEFT -> direction=Direction.DOWN;
            case RIGHT -> direction=Direction.UP;
        }
        System.out.println("Повернули влево");
    }

    @Override
    public void turnRight() {
        switch (direction){
            case UP -> direction=Direction.RIGHT;
            case DOWN -> direction=Direction.LEFT;
            case LEFT -> direction=Direction.UP;
            case RIGHT -> direction=Direction.DOWN;
        }
        System.out.println("Повернули вправо");
    }

    @Override
    public void stepForward() {
        switch (direction){
            case UP -> y++;
            case DOWN -> y--;
            case LEFT -> x--;
            case RIGHT -> x++;
        }
        System.out.println("Шаг вперед");
    }
}
