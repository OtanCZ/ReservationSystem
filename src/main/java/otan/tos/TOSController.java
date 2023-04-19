package otan.tos;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import otan.tos.DAO.MovieDAO;
import otan.tos.DAO.SeatDAO;
import otan.tos.entities.Movie;
import otan.tos.entities.Seat;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TOSController implements Initializable {
    private MovieDAO movieDOA = new MovieDAO();
    private SeatDAO seatDAO = new SeatDAO();
    @FXML
    private VBox titleSelectionBox;

    @FXML
    private VBox seatSelectionBox;

    @FXML
    private HBox moviePane;

    private ListView<String> movieView;

    private HBox titleBox = new HBox();

    private Movie selectedMovie;
    private Label movieInfo = new Label("Film: \nTyp: \nDatum: \nPG:");

    private GridPane seatGrid = new GridPane();
    private ChoiceBox ticketType = new ChoiceBox<String>();
    private Label ticketPrice = new Label("Cena za vstupenku: 205");
    private Label statusLabel = new Label("Vyberte si film");
    private int tPrice = 205;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("TOSController initialized");
        moviePane.setPadding(new javafx.geometry.Insets(0, 0, 0, 0));
        moviePane.setSpacing(0);

        //logo a title
        ImageView logo = new ImageView(TOSApplication.class.getResource("images/logo.png").toString());
        Label title = new Label("Kino rezervace");
        title.setFont(new Font("Comic Sans MS", 48));
        logo.setFitHeight(128);
        logo.setFitWidth(128);
        titleBox.getChildren().add(logo);
        titleBox.getChildren().add(title);
        titleBox.setSpacing(32);
        titleBox.setAlignment(Pos.CENTER_LEFT);

        //listview movies
        movieView = new ListView<>();
        List<Movie> movies = movieDOA.getAll();
        for (Movie movie : movies) {
            movieView.getItems().add(movie.getName());
        }
        movieView.setOnMouseClicked(this::onMovieClick);

        //gridpane seats
        seatGrid.setHgap(32);
        seatGrid.setVgap(32);
        seatGrid.setAlignment(Pos.CENTER);

        String letters = "ABCDE";
        for (int i = 0; i < 6; i++) {
            seatGrid.add(new Label(i+1 + ""), i + 1, 0);
            for (int j = 0; j < 5; j++) {
                seatGrid.add(new Label(letters.charAt(j) + ""), 0, j + 1);
                seatGrid.add(new CheckBox(), i + 1, j + 1);
            }
        }

        //objednání ticketů
        HBox ticketHBox = new HBox();
        ticketHBox.setSpacing(8);
        ticketHBox.setAlignment(Pos.CENTER);
        Button orderButton = new Button("Objednat");
        orderButton.setOnMouseClicked(this::onOrderClick);

        ticketType.getItems().add("Dospělý");
        ticketType.getItems().add("Student");
        ticketType.getSelectionModel().select(0);
        ticketType.setOnAction(this::onTicketTypeClick);

        VBox ticketBox = new VBox();
        VBox labelBox = new VBox();
        labelBox.getChildren().addAll(ticketPrice, statusLabel);
        labelBox.setSpacing(8);
        labelBox.setAlignment(Pos.CENTER_RIGHT);
        ticketBox.setSpacing(8);
        ticketBox.setAlignment(Pos.CENTER);
        ticketBox.getChildren().addAll(ticketType, orderButton);
        ticketHBox.getChildren().addAll(ticketBox, labelBox);

        titleSelectionBox.getChildren().add(titleBox);
        titleSelectionBox.getChildren().add(movieView);
        seatSelectionBox.getChildren().add(seatGrid);
        seatSelectionBox.setAlignment(Pos.CENTER);
        seatSelectionBox.getChildren().add(ticketHBox);
        seatSelectionBox.getChildren().add(movieInfo);
        seatSelectionBox.setSpacing(32);
    }


    /**
     * nastavení ceny vstupenky
     * @param event - kliknutí na typ vstupenky
     */
    private void onTicketTypeClick(Event event) {
        if(ticketType.getSelectionModel().getSelectedItem().equals("Dospělý")) {
            tPrice = 205;
        } else {
            tPrice = 175;
        }
        ticketPrice.setText("Cena za vstupenku: " + tPrice);
    }

    /**
     * načtení filmu z db
     *
     * @param mouseEvent - kliknutí na film
     */
    private void onMovieClick(MouseEvent mouseEvent) {
        System.out.println("Movie clicked");
        for (Node node : seatGrid.getChildren()) {
            if(node instanceof CheckBox) {
                ((CheckBox) node).setSelected(false);
                ((CheckBox) node).setDisable(false);
            }
        }
        String movieName = movieView.getSelectionModel().getSelectedItem();
        List<Movie> movies = movieDOA.getAll();
        statusLabel.setText("Vyberte si sedadla");
        statusLabel.setTextFill(javafx.scene.paint.Color.BLACK);

        for (Movie movie : movies) {
            if(movie.getName().equals(movieName)) {
                selectedMovie = movie;
                movieInfo.setText("Film: " + movie.getName() + "\nTyp: " + movie.getType() +"\nDatum: " + movie.getDate() + "\nPG: " + movie.getPg());
                loadSeats();
                break;
            }
        }
    }

    /**
     * Nakoupení vstupenek
     *
     * @param mouseEvent - kliknutí na objednávací tlačítko
     */
    private void onOrderClick(MouseEvent mouseEvent) {
        int seatCount = 0;
        if (selectedMovie == null) {
            statusLabel.setText("Nebyl vybrán žádný film");
            statusLabel.setTextFill(javafx.scene.paint.Color.RED);
            return;
        }

        if(ticketType.getSelectionModel().getSelectedItem() == null) {
            statusLabel.setText("Vyberte si typ vstupenky");
            statusLabel.setTextFill(javafx.scene.paint.Color.RED);
            return;
        }

        for (Node node : seatGrid.getChildren()) {
            if (node instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) node;
                if (checkBox.isSelected() && !checkBox.isDisable()) {
                    int row = GridPane.getRowIndex(node);
                    int column = GridPane.getColumnIndex(node);
                    Seat newSeat = new Seat(0, row, column, selectedMovie.getId(), tPrice);
                    System.out.println(newSeat);
                    seatDAO.save(newSeat);
                    checkBox.setDisable(true);
                    seatCount++;
                }
            }
        }

        if(seatCount == 0) {
            statusLabel.setText("Nebyla vybraná žádná sedadla");
            statusLabel.setTextFill(javafx.scene.paint.Color.RED);
            return;
        }

        statusLabel.setText("Objednávka provedena");
        statusLabel.setTextFill(javafx.scene.paint.Color.GREEN);
    }

    /**
     * Načte sedadla z databáze a nastaví je jako disabled aby se nedali znovu objednat
     */
    private void loadSeats() {
        List<Seat> seats = seatDAO.getAll(selectedMovie);

        for (Seat seat : seats) {
            CheckBox checkBox = findCheckbox(seat.getRow(), seat.getColumn());
            checkBox.setDisable(true);
            checkBox.setSelected(true);
        }
    }

    /**
     * Nachází checkbox podle řádku a sloupce
     * @param row - řádek v GridPane
     * @param column - sloupec v GridPane
     * @return CheckBox - checkbox na daném řádku a sloupci
     */
    private CheckBox findCheckbox(int row, int column) {
        for (Node node : seatGrid.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                return (CheckBox) node;
            }
        }
        return null;
    }
}