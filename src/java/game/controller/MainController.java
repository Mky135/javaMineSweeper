package game.controller;

import game.utils.MineSweeper;
import game.utils.Tile;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable
{
    private int rows;
    private int columns;
    public static MineSweeper mineSweeper;
    private Tile[][] board;

    @FXML
    GridPane grid;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        rows = 10;
        columns = 10;

        mineSweeper = new MineSweeper(rows, columns, 10);
        board = mineSweeper.getBoard();
//        grid.setMaxWidth(columns * board[0][0].getWidth());
//        grid.setMaxHeight(rows * board[0][0].getHeight());
        grid.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[0].length; col++)
            {
                grid.add(board[row][col], col, row);
            }
        }

        System.out.println(grid.getWidth());
        System.out.println(grid.getHeight());
    }
}
