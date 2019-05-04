package actioner;

import authorization.form.controler.Registration;
import cluster.system.db.SystemNodeDbController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import system.node.SystemStatusOfNodeController;

@SpringBootApplication
@EnableJpaRepositories({"cluster.system.db", "authorization.form.controler"})
@EntityScan({"cluster.system.db.entity", "authorization.form"})
@ComponentScan("authorization/form/config")
public class SampleController {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{SystemNodeDbController.class, SystemStatusOfNodeController.class,
                        GreetingController.class, InformationController.class, Registration.class},
                args);
    }
}