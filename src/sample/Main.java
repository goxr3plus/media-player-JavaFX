package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Media Player -prototype #004");
        primaryStage.setScene(new Scene(root, 698, 366+125));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
