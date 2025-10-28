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
@RequiredArgsConstructor  // Lombok 自动生成构造函数，实现依赖注入
public class TestController {

    // KieSession 来自 org.kie.api.runtime 包（Drools 官方库）
    // 通过构造器注入，Spring 会自动从容器中找到 KieSession Bean 并注入
    private final KieSession kieSession;

    /** API 版本号 */
    private static final String API_VERSION = "1.0.0";

    /**
     * 执行 Drools 规则测试
     *
     * @return 规则执行结果
     */
    @GetMapping("/ruleTest")
    public RuleTestResponse testDrools() {
        long startTime = System.currentTimeMillis();

        try {
            // 检查 KieSession 是否为 null
            if (kieSession == null) {
                log.warn("KieSession 为 null，规则编译可能失败，应用无法执行规则");
                long executionTime = System.currentTimeMillis() - startTime;
                RuleTestData data = new RuleTestData(0, null, executionTime);
                return new RuleTestResponse(false, "规则引擎未初始化，可能是规则文件编译失败。请检查规则文件语法。", data, API_VERSION);
            }

            // 为 Drools 规则中的全局变量注入 Logger 实例
            kieSession.setGlobal("logger", log);

            // 创建测试数据
            List<Person> people = createTestPeople();

            // 将数据插入到 KieSession
            people.forEach(kieSession::insert);

            // 执行所有规则
            int firedRules = kieSession.fireAllRules();
            log.info("成功触发并执行了 {} 次规则", firedRules);

            long executionTime = System.currentTimeMillis() - startTime;

            // 构建响应数据
            RuleTestData data = new RuleTestData(firedRules, people, executionTime);
            return new RuleTestResponse(true, "规则执行成功", data, API_VERSION);

        } catch (Exception e) {
            log.error("规则执行失败", e);
            long executionTime = System.currentTimeMillis() - startTime;
            RuleTestData data = new RuleTestData(0, null, executionTime);
            return new RuleTestResponse(false, "规则执行失败: " + e.getMessage(), data, API_VERSION);
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