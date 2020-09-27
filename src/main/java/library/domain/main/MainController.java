package library.domain.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainController {

    @FXML private AnchorPane navigation;

    @FXML private BorderPane content;

    @FXML
    public void switchPanel(ActionEvent event) throws Exception {
        Pane pane = FXMLLoader.load(getClass().getResource("/ui/book/list_books.fxml"));
        content.setCenter(pane);
    }
}
