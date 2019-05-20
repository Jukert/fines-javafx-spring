package by.bsuir.demo.configuration;

import by.bsuir.demo.common.View;
import by.bsuir.demo.controller.FineController;
import by.bsuir.demo.dao.CarDao;
import by.bsuir.demo.dao.FineDao;
import by.bsuir.demo.dao.UserDao;
import javafx.fxml.FXMLLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class ControllersConfiguration {

    @Autowired
    private FineDao fineDao;

    @Autowired
    private CarDao carDao;

    @Autowired
    private UserDao userDao;


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
            loader.setController(new FineController(fineDao, carDao, userDao));
            loader.load(fxmlStream);
            return new View(loader.getRoot(), loader.getController());
        } finally {
            if (fxmlStream != null) {
                fxmlStream.close();
            }
        }
    }

}
