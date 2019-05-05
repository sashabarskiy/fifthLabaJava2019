package ua.com.radmirtech.lora.app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import ua.com.radmirtech.lora.app.configuration.ApplicationConfiguration;
import ua.com.radmirtech.lora.app.entity.GroupEntity;
import ua.com.radmirtech.lora.app.repository.GroupRepository;

import java.util.List;

@SpringBootApplication(scanBasePackageClasses = {ApplicationConfiguration.class})
@EnableScheduling
public class Application extends javafx.application.Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        String fxmlFile = "/fxml/view.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}