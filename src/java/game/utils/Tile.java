package game.utils;

import javafx.scene.control.Button;

public class Tile
{
    private String text;

    public Tile(String string)
    {
        this.text = string;
//        setText(string);
    }

    public String getText()
    {
        return text;
    }

    @Override
    public String toString()
    {
        return " " + text + " ";
    }
}
