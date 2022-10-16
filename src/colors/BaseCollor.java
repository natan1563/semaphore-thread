package colors;

abstract public class BaseCollor {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void showCollor() {
        System.out.println("Sinal está na luz " + this.getColor());
    }
}
