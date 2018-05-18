package game.utils;

import javafx.scene.control.Button;

public class Tile extends Button
{
    private String text;

    public Tile(String string)
    {
        super(string);
        this.text = string;
        setMaxSize(30,30);
    }


    @Override
    public String toString()
    {
        return " " + text + " ";
    }
}
