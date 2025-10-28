package com.example.droolsdemo.controller;

import com.example.droolsdemo.model.Person;
import com.example.droolsdemo.model.RuleTestData;
import com.example.droolsdemo.model.RuleTestResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Drools 规则引擎测试控制器
 *
 * @author Demo
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    private final KieSession kieSession;

    /**
     * 执行 Drools 规则测试
     *
     * @return 规则执行结果
     */
    @GetMapping("/ruleTest")
    public RuleTestResponse testDrools() {
        long startTime = System.currentTimeMillis();

        try {
            // 为 Drools 规则中的全局变量注入 Logger 实例
            kieSession.setGlobal("logger", log);

            // 创建测试数据
            List<Person> people = createTestPeople();

            // 将数据插入到 KieSession
            people.forEach(kieSession::insert);

            // 执行所有规则
            int firedRules = kieSession.fireAllRules();
            log.info("成功执行 {} 条规则", firedRules);

            long executionTime = System.currentTimeMillis() - startTime;

            // 构建响应数据
            RuleTestData data = new RuleTestData(firedRules, people, executionTime);
            return new RuleTestResponse(true, "规则执行成功", data);

        } catch (Exception e) {
            log.error("规则执行失败", e);
            long executionTime = System.currentTimeMillis() - startTime;
            RuleTestData data = new RuleTestData(0, null, executionTime);
            return new RuleTestResponse(false, "规则执行失败: " + e.getMessage(), data);
        }
    }

    /**
     * 创建测试人员数据
     *
     * @return 人员列表
     */
    private List<Person> createTestPeople() {
        Person p1 = new Person("张华111", 20, "girl");
        Person p2 = new Person("Bob", 158, "girl");
        Person p3 = new Person("God", 9999, "girl");
        Person p4 = new Person("linus", 88, "girl");
        Person p5 = new Person("linus4", 889, "boy");

        return List.of(p1, p2, p3, p4, p5);
    }
}