package hw25_lambda.interfaces;

import hw25_lambda.enums.Direction;

public interface IRobot {
    Direction getDirection();
    int getX();
    int getY();
    void turnLeft();
    void turnRight();
    void stepForward();
}
