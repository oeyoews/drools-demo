package example.droolsdemo.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.KieBuilder;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.io.ResourceType;
import org.drools.template.ObjectDataCompiler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class DroolsConfig {

    private static final String RULES_PATH = "rules/";

    @Bean
    public KieContainer kieContainer() throws Exception {
        // Drools 的服务入口点，提供各种服务的访问。
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // write existing .drl files
        Resource[] files = resolver.getResources("classpath*:" + RULES_PATH + "**/*.drl");

        for (Resource file : files) {
            kieFileSystem.write(kieServices.getResources().newClassPathResource(RULES_PATH + file.getFilename(), "UTF-8"));
        }

        KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(kieRepository::getDefaultReleaseId);

        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();

        return kieServices.newKieContainer(kieRepository.getDefaultReleaseId());
    }

    @Bean
    // 规则执行的会话，用于插入事实和执行规则。
    public KieSession kieSession(KieContainer kieContainer) {
        System.out.println("create kieSession");
        return kieContainer.newKieSession();
    }
}