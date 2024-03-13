package hw25_lambda.enums;

public enum Direction {
    LEFT("влево"),
    RIGHT("вправо"),
    UP("вверх"),
    DOWN("вниз");

    private final String description;
    Direction(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
