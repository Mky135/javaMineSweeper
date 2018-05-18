package game;

import game.controller.MainController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainRunner extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Mine Sweeper");

        Parent mainRoot = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));

        Scene mainScene = new Scene(mainRoot);

        stage.setScene(mainScene);
        stage.toFront();
        stage.setResizable(true);
        stage.show();
        stage.setOnCloseRequest(e -> Platform.exit());

        MainController.mineSweeper.printBoard();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
