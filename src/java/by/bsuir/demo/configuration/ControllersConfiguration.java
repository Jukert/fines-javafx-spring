package by.bsuir.demo.configuration;

import by.bsuir.demo.common.View;
import by.bsuir.demo.controller.FineController;
import javafx.fxml.FXMLLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class ControllersConfiguration {

    @Bean(name = "searchFines")
    public View getMainView() throws IOException {
        return loadView("fxml/searchFine.fxml");
    }

    @Bean
    public FineController getMainController() throws IOException {
        return (FineController) getMainView().getController();
    }

    protected View loadView(String url) throws IOException {

        InputStream fxmlStream = null;
        try {
            fxmlStream = getClass().getClassLoader().getResourceAsStream(url);
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            return new View(loader.getRoot(), loader.getController());
        } finally {
            if (fxmlStream != null) {
                fxmlStream.close();
            }
        }
    }

}
