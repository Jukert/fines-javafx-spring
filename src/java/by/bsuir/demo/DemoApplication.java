package by.bsuir.demo;

import by.bsuir.demo.common.View;
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
        primaryStage.setMaxHeight(679);
        primaryStage.setMaxWidth(950);
        primaryStage.setMinHeight(679);
        primaryStage.setMinWidth(950);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launchApp(DemoApplication.class ,args);
    }
}
