package game.utils;

import java.util.Random;

public class MineSweeper
{
    private Tile[][] titles;

    private int rows;
    private int columns;
    private String mine = "m";
    private int ratio;

    public MineSweeper(int rows, int columns, int ratio)
    {
        this.rows = rows;
        this.columns = columns;
        this.ratio = ratio;

        titles = new Tile[rows][columns];

        genBoard();
    }

    private void genBoard()
    {
        genMines();
        for(int row = 0; row < rows; row++)
        {
            for(int col = 0; col < columns; col++)
            {
                if(titles[row][col] == null)
                {
                    titles[row][col] = new Tile(String.valueOf(minesNearBy(row, col)));
                }
            }
        }
    }

    private void genMines()
    {
        Random r = new Random();

        System.out.println("Total Mines: " + (rows * columns) / ratio);

        for(int i = 0; i < (rows * columns) / ratio; i++)
        {
            int tile = Math.abs(r.nextInt((rows - 1) * (columns - 1)));

            if(titles[(tile / rows)][tile % rows] != null)
            {
                if(tile < ((rows - 1) * (columns - 1)))
                { tile++; }
                else { tile--; }
            }

            //set tile
            titles[(tile / rows)][tile % rows] = new Tile(mine);
        }
    }

    private int minesNearBy(int row, int column)
    {
        int count = 0;

        if(row != 0 && row != rows - 1 && column != 0 && column != columns - 1)
        {
            for(int r = -1; r <= 1; r++)
            {
                for(int c = -1; c <= 1; c++)
                {
                    if(titles[row + r][column + c] != null)
                    {
                        if(titles[row + r][column + c].getText().equalsIgnoreCase(mine))
                        { count++; }
                    }
                }
            }
        }
        else
        {
            count += minesOnSide(row, column);
        }

        return count;
    }

    private int minesOnSide(int row, int column)
    {
        int count = 0;

        if(row == 0)
        {
            if(column == 0)
            {
                for(int r = 0; r <= 1; r++)
                {
                    for(int c = 0; c <= 1; c++)
                    {
                        if(titles[row + r][column + c] != null)
                        {
                            if(titles[row + r][column + c].getText().equalsIgnoreCase(mine))
                            { count++; }
                        }
                    }
                }
            }
            else if(column == columns - 1)
            {
                for(int r = 0; r <= 1; r++)
                {
                    for(int c = -1; c <= 0; c++)
                    {
                        if(titles[row + r][column + c] != null)
                        {
                            if(titles[row + r][column + c].getText().equalsIgnoreCase(mine))
                            { count++; }
                        }
                    }
                }
            }
            else
            {
                for(int r = 0; r <= 1; r++)
                {
                    for(int c = -1; c <= 1; c++)
                    {
                        if(titles[row + r][column + c] != null)
                        {
                            if(titles[row + r][column + c].getText().equalsIgnoreCase(mine))
                            { count++; }
                        }
                    }
                }
            }
        }
        else if(row == rows - 1)
        {
            if(column == 0)
            {
                for(int r = -1; r <= 0; r++)
                {
                    if(titles[row + r][column] != null)
                    {
                        if(titles[row + r][column].getText().equalsIgnoreCase(mine))
                        { count++; }
                    }
                    if(titles[row + r][column + 1] != null)
                    {
                        if(titles[row + r][column + 1].getText().equalsIgnoreCase(mine))
                        { count++; }
                    }
                }
            }
            else if(column == columns - 1)
            {
                for(int r = -1; r <= 0; r++)
                {
                    for(int c = -1; c <= 0; c++)
                    {
                        if(titles[row + r][column + c] != null)
                        {
                            if(titles[row + r][column + c].getText().equalsIgnoreCase(mine))
                            { count++; }
                        }
                    }
                }
            }
            else
            {
                for(int r = -1; r <= 0; r++)
                {
                    for(int c = -1; c <= 1; c++)
                    {
                        if(titles[row + r][column + c] != null)
                        {
                            if(titles[row + r][column + c].getText().equalsIgnoreCase(mine))
                            { count++; }
                        }
                    }
                }
            }
        }
        else if(column == 0)
        {
            for(int r=-1; r<=1; r++)
            {
                if(titles[row + r][column] != null)
                {
                    if(titles[row + r][column].getText().equalsIgnoreCase(mine))
                    { count++; }
                }
                if(titles[row + r][column + 1] != null)
                {
                    if(titles[row + r][column + 1].getText().equalsIgnoreCase(mine))
                    { count++; }
                }
            }
        }
        else if(column == columns - 1)
        {
            for(int r=-1; r<=1; r++)
            {
                if(titles[row + r][column + -1] != null)
                {
                    if(titles[row + r][column + -1].getText().equalsIgnoreCase(mine))
                    { count++; }
                }
                if(titles[row + r][column] != null)
                {
                    if(titles[row + r][column].getText().equalsIgnoreCase(mine))
                    { count++; }
                }
            }
        }

        return count;
    }

    public void printBoard()
    {
        for(Tile[] rows : titles)
        {
            for(Tile column : rows)
            {
                System.out.print(column);
            }

            System.out.println();
        }
    }
}
