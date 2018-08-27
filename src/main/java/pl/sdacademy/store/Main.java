package pl.sdacademy.store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Application application = applicationContext.getBean("application", Application.class);
        application.start();
    }
}
