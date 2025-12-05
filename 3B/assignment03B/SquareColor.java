package assignment03B;
import java.awt.Color;

public enum SquareColor {
    BLACK(Color.BLACK), WHITE(Color.WHITE), CLICKED(Color.CYAN), NONE(Color.RED);
    Color color;
    SquareColor(Color c) { color = c; }
    public Color color() { return color; }
    public String toString() { return name().substring(0, 1); }
}