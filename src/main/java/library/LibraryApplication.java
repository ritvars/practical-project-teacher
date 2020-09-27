package library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import library.configuration.DbSessionHolder;

public class LibraryApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ui/main/main.fxml"));
        primaryStage.setTitle("Library");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        //init session factory in different thread so
        //first operation with database would be quicker
        new Thread(DbSessionHolder::getInstance).start();

        //new DummyData().insert();

        launch(args);

        DbSessionHolder.shutdown();
    }
}
