# Drools 规则引擎演示项目

一个基于 Spring Boot 和 Drools 8.44 的规则引擎演示项目，展示了如何集成和使用 Drools 规则引擎进行业务规则管理。

## 📋 项目简介

本项目演示了如何使用 Drools 规则引擎在 Spring Boot 应用中执行业务规则。主要功能包括：

- 🔧 集成 Drools 8.44 与 Spring Boot 3.5
- 📝 使用 DRL (Drools Rule Language) 编写业务规则
- 🌐 提供 RESTful API 接口测试规则执行
- 💻 提供友好的 Web 界面进行交互式测试
- 📊 返回结构化的 JSON 数据

## 🚀 技术栈

- **Java**: 17
- **Spring Boot**: 3.5.7
- **Drools**: 8.44.0.Final
- **Lombok**: 1.18.26
- **前端**: HTML + Tailwind CSS

## 📁 项目结构

```
drools-demo/
├── src/main/java/com/example/droolsdemo/
│   ├── config/
│   │   └── DroolsConfig.java          # Drools 配置类
│   ├── controller/
│   │   └── TestController.java        # 规则测试控制器
│   ├── model/
│   │   ├── Person.java                # 人员模型
│   │   ├── RuleTestData.java          # 规则测试数据模型
│   │   └── RuleTestResponse.java      # 规则响应模型
│   ├── util/
│   │   └── RuleUtils.java             # 规则工具类
│   └── DroolsApplication.java         # 应用主类
├── src/main/resources/
│   ├── rules/
│   │   ├── person-rules.drl           # 人员规则定义
│   │   ├── person-discount-template.drt  # 人员折扣模板
│   │   └── user-rules-template.drt    # 用户规则模板
│   ├── META-INF/
│   │   └── kmodule.xml                # Drools 模块配置
│   ├── static/
│   │   └── index.html                 # Web 测试界面
│   └── application.properties        # 应用配置
└── pom.xml                            # Maven 依赖配置
```

## 🛠️ 快速开始

### 环境要求

- JDK 17 或更高版本
- Maven 3.6+

### 安装步骤

1. **克隆项目**
   ```bash
   git clone <repository-url>
   cd drools-demo
   ```

2. **构建项目**
   ```bash
   mvn clean install
   ```

3. **运行应用**
   ```bash
   mvn spring-boot:run
   ```

4. **访问应用**
   - Web 界面: http://localhost:8080
   - API 接口: http://localhost:8080/ruleTest

## 📖 使用指南

### 规则文件 (DRL)

规则文件位于 `src/main/resources/rules/` 目录，使用 DRL 语言编写：

```drl
package com.example.rules;

import com.example.droolsdemo.model.Person;

global org.slf4j.Logger logger;

rule "CheckAdult"
    salience 10
    no-loop true
when
    $p: Person($age: age >= 18)
then
    $p.setAdult(true);
    logger.info("{} 已成年", $p.getName());
    update($p);
end
```

### API 接口

#### 测试规则执行

**请求**
```http
GET /ruleTest
```

**响应**
```json
{
  "success": true,
  "message": "规则执行成功",
  "data": {
    "firedRulesCount": 5,
    "executionTime": 15,
    "people": [
      {
        "name": "张华111",
        "age": 20,
        "adult": true,
        "sex": "girl"
      }
    ]
  }
}
```

### Web 界面

访问 http://localhost:8080 使用交互式界面测试规则执行：

- 📊 **卡片式界面**: 现代化的设计，清晰展示执行结果
- 🎨 **实时状态**: 状态指示器显示执行进度
- 📋 **结构化输出**: JSON 格式的可读结果展示

## 🔍 规则示例

### 1. 成年检查规则

判断人员是否成年，并设置 `adult` 属性：

```drl
rule "CheckAdult"
    salience 10
    no-loop true
when
    $p: Person($age: age >= 18)
then
    $p.setAdult(true);
    logger.info("{} 已成年", $p.getName());
    update($p);
end
```

### 2. 性别检查规则

检查人员性别：

```drl
rule "CheckSex"
    salience 15
when
    $p : Person(sex == "girl")
then
    logger.warn("{} 是一个女孩", $p.getName());
end
```

### 关键概念

- **when**: 规则条件部分（LHS - Left Hand Side）
- **then**: 规则执行部分（RHS - Right Hand Side）
- **salience**: 规则优先级（数字越大越先执行）
- **no-loop**: 防止规则循环执行
- **update()**: 更新对象以触发依赖此对象的其他规则

## 🎯 核心功能

### Person 模型

```java
@Data
public class Person {
    private String name;    // 姓名
    private int age;        // 年龄
    private boolean adult;  // 是否成年
    private String sex;     // 性别
}
```

### 规则执行流程

1. 创建测试数据（Person 对象）
2. 将数据插入到 KieSession
3. 设置全局变量（如 logger）
4. 执行所有规则
5. 返回执行结果

## 🔧 配置说明

### DroolsConfig.java

负责配置 Drools 环境：

- 加载 classpath 下的所有 `.drl` 规则文件
- 创建 KieContainer 和 KieSession Bean
- 自动扫描并加载规则文件

### kmodule.xml

Drools 模块配置：

```xml
<kbase name="rulesKBase" packages="rules">
    <ksession name="ksession-rules" default="true"/>
</kbase>
```

## 🧪 开发指南

### 添加新规则

1. 在 `src/main/resources/rules/` 目录创建 `.drl` 文件
2. 使用 DRL 语法编写规则
3. 重启应用自动加载新规则

### 修改现有规则

直接编辑规则文件，应用会自动重新加载（开发模式）。

### 添加新的数据模型

1. 在 `model` 包下创建新的实体类
2. 在规则文件中 import 该类型
3. 编写相应的规则逻辑

## 📚 学习资源

- [Drools 官方文档](https://docs.drools.org/8.44.0.Final/drools-docs/drools/language-reference/index.html)
- [Drools 语法参考](https://docs.drools.org/8.44.0.Final/drools-docs/drools/language-reference/index.html)
- [Spring Boot 文档](https://docs.spring.io/spring-boot/docs/current/reference/html/)

## 🐛 常见问题

### 规则未执行？

检查以下几个方面：
1. 规则文件是否在正确的路径下
2. 规则条件是否匹配数据
3. 查看日志输出排查问题

### 规则无限循环？

使用 `no-loop true` 或 `lock-on-active true` 防止规则重复触发。

### 如何调试规则？

- 在规则中使用 `logger.info()` 输出调试信息
- 查看应用日志了解规则执行情况
- 使用 IDE 调试功能逐步执行

## 📝 TODO

- [ ] 添加规则模板支持
- [ ] 实现动态规则加载
- [ ] 添加规则版本管理
- [ ] 支持规则热更新

## 📄 许可证

本项目仅用于学习和演示目的。

## 👥 贡献

欢迎提交 Issue 和 Pull Request！

---

**注意**: 这是一个演示项目，生产环境使用需要考虑更多因素，如规则版本管理、规则测试、性能优化等。

