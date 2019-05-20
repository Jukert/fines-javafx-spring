package by.bsuir.demo.controller;

import by.bsuir.demo.common.Car;
import by.bsuir.demo.common.Fine;
import by.bsuir.demo.common.FineModel;
import by.bsuir.demo.common.User;
import by.bsuir.demo.dao.CarDao;
import by.bsuir.demo.dao.FineDao;
import by.bsuir.demo.dao.UserDao;
import by.bsuir.demo.filter.FineFilter;
import by.bsuir.demo.util.FxElementsUtil;
import by.bsuir.demo.util.StringUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FineController {

    //@Autowired
    private FineDao fineDao;

    private CarDao carDao;

    private UserDao userDao;

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

    @FXML
    private TextField markField;

    @FXML
    private TextField colorField;

    @FXML
    private TextField numberField;

    @FXML
    private ComboBox<String> userNumber;

    @FXML
    private TextField weightNumber;

    @FXML
    private TextField speedNumber;

    @FXML
    private Button btnSaveCar;

    @FXML
    private Button btnClear;

    @FXML
    private TableView<Car> carsTable;

    private ObservableList<FineModel> fineObservableList = FXCollections.observableArrayList();

    public FineController(FineDao fineDao, CarDao carDao, UserDao userDao) {
        this.fineDao = fineDao;
        this.carDao = carDao;
        this.userDao = userDao;
    }

    @FXML
    void initialize() {

        finesTable.getColumns().setAll(FxElementsUtil.getColumns(fineNameColumns));

        carsTable.getColumns().setAll(FxElementsUtil.getColumns(carNameColumns));

        loadFineData();

        loadCarsData();

        List<String> fio = new ArrayList<>();
        for (User u: userDao.findAll()) {
            fio.add(String.format("%s, %s %s %s", u.getCnum(), u.getSurname(), u.getName(), u.getFathername()));
        }
        userNumber.setItems(FXCollections.observableArrayList(fio));

        btnClear.setOnAction(event -> clear());
    }

    private void loadCarsData() {
        carsTable.setItems(FXCollections.observableArrayList(carDao.findAll()));
    }

    @FXML
    void saveCarAct(ActionEvent event) {
        Car car = new Car();
        car.setWeight(Integer.valueOf(weightNumber.getText()));
        car.setUser(new User(
                userNumber.getSelectionModel().getSelectedItem().split(",")[0]
        ));
        car.setMaxSpeed(speedNumber.getText());
        car.setMark(markField.getText());
        car.setGovernmentNumber(numberField.getText());
        car.setColor(colorField.getText());

        carDao.save(car);

        loadCarsData();
    }

    @FXML
    void searchFines(ActionEvent event) {
       loadFineData();
    }


    private void clear() {
        markField.setText("");
        colorField.setText("");
        numberField.setText("");
        weightNumber.setText("");
        speedNumber.setText("");
    }

    public void setFineDao(FineDao fineDao) {
        this.fineDao = fineDao;
    }

    private void loadFineData() {
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
    }

    private Map<String, String> fineNameColumns = new HashMap<String, String>() {{
        put("fio", "FIO");
        put("car", "About car");
        put("phone", "Phone");
        put("region", "Region");
        put("speed", "Max speed");
    }};

    private Map<String, String> carNameColumns = new HashMap<String, String>() {{
        put("mark", "Mark");
        put("color", "Color");
        put("governmentNumber", "Government number");
        put("weight", "Weight");
        put("maxSpeed", "Max speed");
    }};

}
