package com.example.droolsdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import com.example.droolsdemo.model.Person;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
public class TestController {
    private final KieSession kieSession;
    // 创建当前类的Logger实例（也可注入其他Logger）
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    public TestController(KieSession kieSession) {
        this.kieSession = kieSession;
    }

    @GetMapping("/test")
    public String testDrools() {
        // 关键：为Drools规则中的全局变量"logger"注入实例
        kieSession.setGlobal("logger", logger);  // 变量名必须与规则中声明的一致
        Person p1 = new Person("张华111", 20, "girl"), p2 = new Person("Bob", 158, "girl"), p3 = new Person("God", 9999, "girl");
        Person p4 = new Person("linus", 88, "girl");
        Person p5 = new Person("linus4", 889, "boy");
        List<Person> people = Arrays.asList(p1, p2, p3, p4, p5);
//        List<Person> people = List.of(p5);
        people.forEach(kieSession::insert);
        int firedRules = kieSession.fireAllRules(); // 执行所有规则
        log.info("fired rules: {}", firedRules);
        log.info("fired rules: {}", firedRules);
        // 销毁会话
        // kieSession.dispose();
//        return p1 + " | " + p2 + " | " + p3;
        // return firedRules + " fired rules";
        return "执行了 " + firedRules + " 条规则。\n结果:\n" + people;
    }
}