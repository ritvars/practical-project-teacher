package library.domain.book;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.domain.book.add.BookAddController;
import library.view.ViewLoader;

public class BooksController implements Initializable {

    private final BookRepository bookRepository = new BookRepository();

    @FXML private TableView<Book> table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureTable();
        populateTable();
    }

    @FXML
    private void addBook(ActionEvent event) {
        ViewLoader.load(getClass().getResource("/ui/book/add_book.fxml"), "Add book");
    }

    @FXML
    private void editBook(ActionEvent event) {
        Book book = table.getSelectionModel().getSelectedItem();
        if (book == null) {
            return;
        }
        BookAddController controller = (BookAddController) ViewLoader.load(getClass()
                .getResource("/ui/book/add_book.fxml"), "Edit book");
        controller.setEditable(book);
    }

    @FXML
    private void deleteBook(ActionEvent event) {
        Book book = table.getSelectionModel().getSelectedItem();
        if (book == null) {
            return;
        }
        bookRepository.delete(book);
        populateTable();
    }

    private void configureTable() {
        TableColumn<Book, Long> column1 = new TableColumn<>("Id");
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Book, String> column2 = new TableColumn<>("Title");
        column2.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Book, String> column3 = new TableColumn<>("Description");
        column3.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Book, String> column4 = new TableColumn<>("Author");
        column4.setCellValueFactory(new PropertyValueFactory<>("authorFullName"));

        table.getColumns().add(column1);
        table.getColumns().add(column2);
        table.getColumns().add(column3);
        table.getColumns().add(column4);
    }

    private void populateTable() {
        ObservableList<Book> list = FXCollections.observableArrayList();
        list.addAll(bookRepository.findAll());
        table.setItems(list);
    }
}
