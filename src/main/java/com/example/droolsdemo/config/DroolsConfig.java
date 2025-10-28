package com.example.droolsdemo.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.KieBuilder;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * Drools 规则引擎配置类
 *
 * 该类负责初始化 Drools 规则引擎环境，包括：
 * - 扫描并加载规则文件（.drl 文件）
 * - 编译规则文件并进行语法检查
 * - 创建 KieContainer（规则容器）Bean
 * - 创建 KieSession（规则执行会话）Bean
 *
 * 工作流程：
 * 1. 扫描 classpath 下 rules/ 目录的所有 .drl 规则文件
 * 2. 将规则文件加载到 KieFileSystem
 * 3. 使用 KieBuilder 编译规则（检查语法错误）
 * 4. 创建 KieContainer 作为规则容器
 * 5. 从容器创建 KieSession 供业务代码使用
 *
 * @author Drools Demo Team
 * @since 1.0.0
 */
@Configuration
public class DroolsConfig {

    /** 规则文件路径常量 */
    private static final String RULES_PATH = "rules/";

    /**
     * 创建并配置 Drools 规则容器（KieContainer）
     *
     * 该方法在应用启动时执行，负责：
     * - 获取 KieServices 服务入口
     * - 扫描 resources/rules/ 目录下的所有 .drl 规则文件
     * - 将规则文件加载到 KieFileSystem
     * - 编译规则文件（验证语法）
     * - 创建并返回 KieContainer Bean
     *
     * 生命周期：该 Bean 在应用启动时创建一次，单例模式。
     *
     * @return KieContainer 规则容器，包含编译后的所有规则
     * @throws Exception 规则文件加载或编译失败时抛出
     *
     * @see KieServices
     * @see KieFileSystem
     * @see KieBuilder
     */
    @Bean
    public KieContainer kieContainer() throws Exception {
        // ① 获取 Drools 核心服务入口点
        // KieServices 提供了工厂方法，用于创建各种 Drools 组件
        KieServices kieServices = KieServices.Factory.get();

        // ② 创建 KieFileSystem，用于管理规则文件
        // KieFileSystem 是 Drools 的内部文件系统，用于存放规则文件
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();

        // ③ 使用 Spring 的资源解析器扫描规则文件
        // 扫描 classpath 下 rules/ 目录及其子目录的所有 .drl 文件
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] files = resolver.getResources("classpath*:" + RULES_PATH + "**/*.drl");

        // ④ 将所有 .drl 规则文件加载到 KieFileSystem
        // 遍历所有找到的规则文件并写入 Drools 文件系统
        for (Resource file : files) {
            kieFileSystem.write(
                kieServices.getResources().newClassPathResource(RULES_PATH + file.getFilename(), "UTF-8")
            );
        }

        // ⑤ 获取规则仓库（KieRepository）
        // KieRepository 管理规则的版本和仓库信息
        KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(kieRepository::getDefaultReleaseId);

        // ⑥ 创建 KieBuilder 并编译所有规则
        // buildAll() 会编译所有规则并检查语法错误
        // 如果编译失败，buildAll() 不会抛出异常，需要在后续检查结果
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();

        // ⑦ 创建并返回 KieContainer Bean
        // KieContainer 是规则容器，包含了编译后的所有规则
        return kieServices.newKieContainer(kieRepository.getDefaultReleaseId());
    }

    /**
     * 创建规则执行会话（KieSession）
     *
     * KieSession 是规则执行的核心组件，用于：
     * - 插入事实（Facts）到工作内存：insert()
     * - 设置全局变量：setGlobal()
     * - 执行规则：fireAllRules()
     * - 查询结果：getQueryResults()
     *
     * 生命周期：默认单例，可通过 @Scope 修改作用域。
     *
     * 注意：如果修改为多例（PROTOTYPE），需要在用完后续手动调用 dispose() 释放资源。
     *
     * @param kieContainer 规则容器，由上一个 Bean 方法创建
     * @return KieSession 规则执行会话
     *
     * @see KieSession#insert(Object)
     * @see KieSession#setGlobal(String, Object)
     * @see KieSession#fireAllRules()
     */
    @Bean
    public KieSession kieSession(KieContainer kieContainer) {
        // 从规则容器创建新的会话
        // 每个会话都有独立的工作内存，可以插入不同的数据并执行规则
        KieSession session = kieContainer.newKieSession();

        System.out.println("KieSession 已创建");

        return session;
    }
}