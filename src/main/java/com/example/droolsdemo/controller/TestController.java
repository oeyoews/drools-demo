package example.droolsdemo.controller;

import example.droolsdemo.model.Person;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final KieSession kieSession;

    public TestController(KieSession kieSession) {
        this.kieSession = kieSession;
    }

    @GetMapping("/test")
    public String testDrools() {
        Person p1 = new Person("Alice", 20);
        Person p2 = new Person("Bob", 15);

        kieSession.insert(p1);
        kieSession.insert(p2);
        kieSession.fireAllRules();

        return p1 + " | " + p2;
    }
}