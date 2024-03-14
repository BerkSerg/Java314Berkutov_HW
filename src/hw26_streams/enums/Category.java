package hw26_streams.enums;

public enum Category {
    FRUITS("Фрукты"),
    VEGETABLES("Овощи"),
    DAIRY("Молочка");

    String description;
    Category(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
