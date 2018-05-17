package game;

import game.utils.MineSweeper;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainRunner extends Application
{
    public int rows;
    public int columns;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        MineSweeper mineSweeper = new MineSweeper(20, 20, 10);

        mineSweeper.printBoard();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
