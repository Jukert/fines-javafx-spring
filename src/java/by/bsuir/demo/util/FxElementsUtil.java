package by.bsuir.demo.util;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FxElementsUtil {

    public static <M, T> List<TableColumn<M, T>> getColumns(Map<String, String> columnNames) {

        List<TableColumn<M, T>> columns = new ArrayList<>();

        for (Map.Entry<String, String> entry : columnNames.entrySet()) {
            TableColumn<M, T> column = new TableColumn<>(entry.getValue());
            column.setCellValueFactory(new PropertyValueFactory<>(entry.getKey()));
            columns.add(column);
        }
        return columns;
    }

}
