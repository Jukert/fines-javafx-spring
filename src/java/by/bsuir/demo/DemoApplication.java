package by.bsuir.demo;

import by.bsuir.demo.common.View;
import by.bsuir.demo.configuration.ControllersConfiguration;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

@Lazy
@SpringBootApplication
public class DemoApplication extends AbstractJavaFxApplicationSupport {

    @Qualifier("searchFines")
    @Autowired
    private View view;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Fines");
        primaryStage.setScene(new Scene(view.getView()));
        primaryStage.setResizable(true);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launchApp(DemoApplication.class ,args);
    }
}
