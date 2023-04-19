package otan.tos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX Aplikace
 */
public class TOSApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TOSApplication.class.getResource("tos-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(TOSApplication.class.getResource("style.css").toString());
        stage.setResizable(false);
        stage.setTitle("SPSMB - PMP2023");
        stage.getIcons().add(new Image(TOSApplication.class.getResource("images/logo.png").toString()));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Spuštění aplikace
     * @param args - argumenty
     */
    public static void main(String[] args) {
        launch();
    }
}