package by.bsuir.demo.controller;

import by.bsuir.demo.common.Fine;
import by.bsuir.demo.common.FineModel;
import by.bsuir.demo.dao.FineDao;
import by.bsuir.demo.filter.FineFilter;
import by.bsuir.demo.util.StringUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class FineController {

    @Autowired
    private FineDao fineDao;

    @FXML
    private TableView<FineModel> finesTable;

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField fathernameField;

    @FXML
    private TextField governmentNumberField;

    @FXML
    private TextField userCnumField;

    @FXML
    private Button btnSearch;

    private ObservableList<FineModel> fineObservableList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        List<Fine> fines = new ArrayList<>();

        TableColumn<FineModel, String> fioColumn = new TableColumn<>("FIO");
        fioColumn.setCellValueFactory(new PropertyValueFactory<>("fio"));

        TableColumn<FineModel, String> carInfoColumn = new TableColumn<>("About car");
        carInfoColumn.setCellValueFactory(new PropertyValueFactory<>("car"));

        TableColumn<FineModel, String> phoneNumberColumn = new TableColumn<>("Phone");
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        TableColumn<FineModel, String> locationColumn = new TableColumn<>("Region");
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("region"));

        TableColumn<FineModel, String> speedColumn = new TableColumn<>("Max speed");
        speedColumn.setCellValueFactory(new PropertyValueFactory<>("speed"));

        finesTable.getColumns().setAll(fioColumn, carInfoColumn, phoneNumberColumn, locationColumn, speedColumn);
        finesTable.setItems(fineObservableList);
    }

    @FXML
    void searchFines(ActionEvent event) {
        finesTable.getItems().clear();
        FineFilter filter = new FineFilter();
        filter.setCnum(StringUtil.trim(userCnumField.getText()));
        filter.setFathername(StringUtil.trim(fathernameField.getText()));
        filter.setGovernmentNumber(StringUtil.trim(governmentNumberField.getText()));
        filter.setName(StringUtil.trim(nameField.getText()));
        filter.setSurname(StringUtil.trim(surnameField.getText()));

        List<Fine> fines = fineDao.findAll(filter);

        for (Fine fine: fines) {
            fineObservableList.add(new FineModel(
                    String.format("%s %s %s", fine.getUser().getName(), fine.getUser().getSurname(), fine.getUser().getFathername()),
                    String.format("%s %s color, weight %s, maxSpeed %s", fine.getCar().getMark(), fine.getCar().getColor(), fine.getCar().getWeight(), fine.getCar().getMaxSpeed()),
                    fine.getUser().getPhone(),
                    fine.getLocation().getRegion(),
                    String.valueOf(fine.getBorderSpeed().getMax())
            ));

        }

        finesTable.setItems(fineObservableList);

        //finesTable.setItems(FXCollections.observableArrayList(fineDao.findAll(filter)));
    }
}
