# Drools Getting Started

Drools 是一组专注于智能自动化和决策管理的项目，其中最引人注目的是提供了基于前向推理和后向推理的规则引擎 、DMN 决策引擎和其他项目。规则引擎是创建专家系统的基本构建块。在人工智能领域，专家系统是一种模拟人类专家决策能力的计算机系统。

## Prerequisites

* JDK11 +

* https://docs.drools.org/8.38.0.Final/drools-docs/docs-website/drools/rule-engine/index.html

## 前端设计点

* 导出预览
* 转drl
* 单规则/多规则 设计
* 技术栈调研

## Drools 动态化实践方案

1. drt文件，创建模板，动态生成drl文件，也是我们目前所用的方式。
2. excel文件导入，实际上和模板文件类似，依然无法直接交给业务人员来使用。
3. 自己拼装String，动态生成drl文件，网上大多数博文使用方式，过于原始。
4. api方式，drools的api方式复杂，使用需要对drl文件有足够的了解。

## Drools 相关文章

* drools 官方文档：https://docs.drools.org/8.44.0.Final/drools-docs/drools/introduction/index.html
* drools 系列文章(CSDN): https://blog.csdn.net/huanglu0314/article/details/118524705?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522d0382687d73ab76aea27ba02a3d59ff1%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=d0382687d73ab76aea27ba02a3d59ff1&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-8-118524705-null-null.nonecase&utm_term=%E8%A7%84%E5%88%99%E5%BC%95%E6%93%8E&spm=1018.2226.3001.4450
* DRL 语法规则: https://docs.drools.org/8.44.0.Final/drools-docs/drools/language-reference/index.html
* https://tech.meituan.com/2020/05/14/meituan-security-zeus.html
* https://rules.bctools.cn/#/policyproject/index
* https://agent.doubao.com.cn/obj/eden-cn/upnbsw-tss/ljhwZthlaukjlkulzlp/super_doubao/25854952546185474/ce825d4087d07a8e6b6717a89a074742/WebsiteDeploy/java-rules-engine-guide.html
* 规则引擎示例(参考): http://www.tony2y.top
* https://blog.csdn.net/lvyuanj/article/details/137002245
* drools 模板用法：https://www.doubao.com/chat/25922453785345538
* drools规则动态化实践: https://zhuanlan.zhihu.com/p/603826111
* drools template example: https://github.com/selrahal/drools-template-example
* drools api: https://blog.csdn.net/huanglu0314/article/details/118566413
* 美团自研规则引擎: https://tech.meituan.com/2020/05/14/meituan-security-zeus.html
* Drools 详细介绍：https://blog.csdn.net/weixin_43344005/article/details/141173891
* 示例：https://www.bilibili.com/opus/921973532538175512 (类似于 iPhone 手机指令)
* 示例：https://github.com/springboot-community/springboot-drools-redis

* 第一篇： https://blog.csdn.net/huanglu0314/article/details/118524705?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522d0382687d73ab76aea27ba02a3d59ff1%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=d0382687d73ab76aea27ba02a3d59ff1&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-8-118524705-null-null.nonecase&utm_term=%E8%A7%84%E5%88%99%E5%BC%95%E6%93%8E&spm=1018.2226.3001.4450