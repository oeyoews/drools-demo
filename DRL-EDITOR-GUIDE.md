# DRL 规则编辑器使用指南

## 概述

DRL 规则编辑器是一个可视化的 Web 编辑器，帮助您快速生成 Drools 规则文件(.drl)。无需编写复杂的代码，通过简单的表单操作即可创建完整的 DRL 规则。

## 功能特性

- 📝 **可视化编辑**: 通过表单输入生成 DRL 规则代码
- 🔄 **实时预览**: 左侧编辑，右侧实时查看生成的代码
- 📥 **下载文件**: 一键下载生成的 .drl 文件
- 📋 **复制代码**: 快速复制生成的规则代码
- ⚡ **示例模板**: 内置示例规则，快速上手
- 📱 **响应式设计**: 适配移动端和桌面端

## 如何使用

### 1. 访问编辑器

启动项目后，访问以下地址：

```
http://localhost:8080/drl-editor.html
```

或者在首页点击 "📝 DRL 规则编辑器" 按钮。

### 2. 配置全局设置

#### 包名 (Package)
定义规则所属的 Java 包，例如：
```
com.example.rules
```

#### Unit 名称
可选的单元名称，用于规则组织：
```
PersonRules
```

#### 导入语句 (Import)
每行一个导入语句：
```
import com.example.droolsdemo.model.Person;
import com.example.droolsdemo.util.RuleUtils;
```

#### 全局变量 (Global)
定义全局对象：
```
global org.slf4j.Logger logger;
```

#### 声明类型 (Declare)
可选，用于声明新的类型：
```
declare Animal
    name: String
    age: int
end
```

### 3. 添加和配置规则

#### 添加规则
点击右上角的 "+ 添加规则" 按钮。

#### 规则配置项

- **规则名称**: 规则的唯一标识符，如 `CheckAdult`
- **启用 (Enabled)**: 是否启用该规则
- **优先级 (Salience)**: 数值越大越先执行
- **No-Loop**: 防止规则循环触发
- **Lock-Active**: 防止规则被重复激活

#### When 条件
输入规则的条件部分（LHS - Left Hand Side）：
```
$p: Person($age: age >= 18)
```

#### Then 动作
输入规则的动作部分（RHS - Right Hand Side）：
```
$p.setAdult(true);
update($p);
```

### 4. 查看代码预览

右侧会实时显示生成的 DRL 代码，您可以随时查看和检查。

### 5. 保存规则

#### 方法一：下载文件
点击 "下载 DRL 文件" 按钮，将规则保存为 .drl 文件。

#### 方法二：复制代码
点击 "复制代码" 按钮，复制生成的代码到剪贴板。

### 6. 加载示例

点击 "加载示例" 按钮，可以加载预设的示例规则，包括：
- `CheckAdult`: 检查成年人规则
- `CheckSex`: 检查性别规则

## 示例规则说明

### CheckAdult 规则
```drl
rule "CheckAdult"
    enabled true
    salience 10
    no-loop true
when
    $p: Person($age: age >= 18)
then
    $p.setAdult(true);
    logger.info("{} 已成年",$p.getName());
    update($p);
end
```

这个规则的作用是：
- 匹配年龄大于等于18岁的人员
- 标记其为成年人
- 记录日志
- 更新对象以触发其他相关规则

### CheckSex 规则
```drl
rule "CheckSex"
    enabled true
    salience 15
when
    $p : Person(sex == "girl")
then
    logger.warn("{} 是一个女孩", $p.getName());
    $p.setSex("boy");
    update($p);
end
```

这个规则的作用是：
- 匹配性别为女孩的人员
- 记录警告日志
- 修改性别信息

## DRL 语法说明

### 规则属性

| 属性 | 说明 | 示例 |
|------|------|------|
| enabled | 是否启用规则 | `enabled true` |
| salience | 优先级 | `salience 10` |
| no-loop | 防止循环 | `no-loop true` |
| lock-on-active | 防止重复激活 | `lock-on-active true` |

### When 条件语法

```drl
// 基本语法
$variable: Type(property == value)

// 示例
$p: Person(age >= 18)
$p: Person(name == "张三", age >= 18)
$p: Person($age: age >= 18)  // 绑定变量
```

### Then 动作语法

```drl
// 基本操作
$p.setProperty(value);
update($p);     // 更新对象，触发其他规则
insert(obj);    // 插入新对象
retract($p);    // 移除对象

// 使用全局变量
logger.info("message {}", $p.getName());
```

## 常见问题

### Q: 如何防止规则循环执行？
A: 勾选 "No-Loop" 选项。

### Q: 多个规则如何控制执行顺序？
A: 通过 "Salience" 优先级设置，数值越大的规则越先执行。

### Q: 如何在规则中使用日志？
A: 在全局变量中添加：
```
global org.slf4j.Logger logger;
```
然后在 Then 部分使用：
```
logger.info("日志消息");
```

### Q: 规则没有被触发怎么办？
A: 检查以下几点：
1. 规则是否正确启用（enabled）
2. When 条件是否匹配数据
3. 数据是否正确插入到 KieSession

## 技术栈

- **前端**: Vue.js 3 + HTML5 + CSS3
- **样式**: TailwindCSS (使用 CDN)
- **后端**: Spring Boot + Drools
- **规则引擎**: Drools 8.x

## 文件结构

```
src/main/resources/static/
├── index.html           # 首页
├── drl-editor.html     # DRL 规则编辑器
└── lib/
    └── css/
        └── tw.js       # TailwindCSS CDN

src/main/resources/rules/
├── person-rules.drl           # 主规则文件
├── person-rules-test.drl      # 测试规则文件
└── ...
```

## 开发说明

### 技术架构

编辑器采用 **Vue.js 3** 框架，使用 Composition API 风格：

- **数据响应式**: 使用 `data()` 返回响应式对象
- **双向绑定**: 使用 `v-model` 实现表单数据绑定
- **事件处理**: 使用 `@click` 等指令处理用户交互
- **计算属性**: 代码预览使用模板插值自动更新

### 添加新的功能

编辑 `src/main/resources/static/drl-editor.html` 文件：

1. **添加新的配置项**:
   - 在 `config` 对象中添加新字段
   - 在模板中添加输入框并绑定 `v-model`

2. **添加新的规则属性**:
   - 在规则对象中添加新属性
   - 更新模板中的规则表单

3. **扩展代码生成逻辑**: 修改 `generateDRL()` 方法

### Vue.js 核心概念

```javascript
// 数据定义
data() {
  return {
    config: { ... },
    rules: []
  }
}

// 方法定义
methods: {
  addRule() { ... },
  generateDRL() { ... }
}
```

### 自定义样式

编辑器使用 TailwindCSS，可以在 `<style>` 标签中添加自定义样式。

## 联系与支持

如有问题或建议，请查看项目 README 或提交 Issue。

---

**祝您使用愉快！** 🎉

