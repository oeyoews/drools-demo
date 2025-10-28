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
* 规则组

* 第一篇： https://blog.csdn.net/huanglu0314/article/details/118524705?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522d0382687d73ab76aea27ba02a3d59ff1%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=d0382687d73ab76aea27ba02a3d59ff1&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-8-118524705-null-null.nonecase&utm_term=%E8%A7%84%E5%88%99%E5%BC%95%E6%93%8E&spm=1018.2226.3001.4450
* 02: https://blog.csdn.net/huanglu0314/article/details/118542387?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522c4b3816a1d90c69999b8c2c3d57bfdaa%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=c4b3816a1d90c69999b8c2c3d57bfdaa&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-2-118542387-null-null.nonecase&utm_term=%E8%A7%84%E5%88%99%E5%BC%95%E6%93%8E&spm=1018.2226.3001.4450
* 03: https://blog.csdn.net/huanglu0314/article/details/118542441?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522facb03f54ead8d8160d850af4180d9eb%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=facb03f54ead8d8160d850af4180d9eb&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-2-118542441-null-null.nonecase&utm_term=%E7%AC%AC%E4%B8%89%E7%AF%87&spm=1018.2226.3001.4450
* 04: https://blog.csdn.net/huanglu0314/article/details/118525630?ops_request_misc=%257B%2522request%255Fid%2522%253A%25221e8737ef71a1b96263cd19f1dc2dbadc%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=1e8737ef71a1b96263cd19f1dc2dbadc&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-2-118525630-null-null.nonecase&utm_term=%E7%AC%AC%E5%9B%9B%E7%AF%87&spm=1018.2226.3001.4450
* 05: https://blog.csdn.net/huanglu0314/article/details/118543048?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522c33c8419ef40679a5145b8a15b6bbd33%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=c33c8419ef40679a5145b8a15b6bbd33&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-2-118543048-null-null.nonecase&utm_term=%E7%AC%AC%E4%BA%94%E7%AF%87&spm=1018.2226.3001.4450
* 06: https://blog.csdn.net/huanglu0314/article/details/118543151?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522f8d9ecd97743d8e6b236ac67b85e8bc3%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=f8d9ecd97743d8e6b236ac67b85e8bc3&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-1-118543151-null-null.nonecase&utm_term=%E7%AC%AC%E5%85%AD%E7%AF%87&spm=1018.2226.3001.4450
* 07: https://blog.csdn.net/huanglu0314/article/details/118565577?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522368cffe9ffe7fd6da5763a20488ad247%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=368cffe9ffe7fd6da5763a20488ad247&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-3-118565577-null-null.nonecase&utm_term=%E7%AC%AC%E4%B8%83%E7%AF%87&spm=1018.2226.3001.4450
* 08: https://blog.csdn.net/huanglu0314/article/details/118565816?ops_request_misc=%257B%2522request%255Fid%2522%253A%25228407daa145a5a4ce6b25f928e6c95d4e%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=8407daa145a5a4ce6b25f928e6c95d4e&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-3-118565816-null-null.nonecase&utm_term=%E7%AC%AC%E5%85%AB%E7%AF%87&spm=1018.2226.3001.4450
* 09: https://blog.csdn.net/huanglu0314/article/details/118565994?ops_request_misc=%257B%2522request%255Fid%2522%253A%252278e39b16bfa30f5bb1c7b19b74d76807%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=78e39b16bfa30f5bb1c7b19b74d76807&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-3-118565994-null-null.nonecase&utm_term=%E7%AC%AC%E4%B9%85%E7%AF%87&spm=1018.2226.3001.4450
* 10: https://blog.csdn.net/huanglu0314/article/details/118566128?ops_request_misc=%257B%2522request%255Fid%2522%253A%252200d80cad0566979d5ddd234846f5d01f%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=00d80cad0566979d5ddd234846f5d01f&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-2-118566128-null-null.nonecase&utm_term=%E7%AC%AC%E5%8D%81%E7%AF%87&spm=1018.2226.3001.4450
* 11: https://blog.csdn.net/huanglu0314/article/details/118566128?ops_request_misc=%257B%2522request%255Fid%2522%253A%252200d80cad0566979d5ddd234846f5d01f%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=00d80cad0566979d5ddd234846f5d01f&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-2-118566128-null-null.nonecase&utm_term=%E7%AC%AC%E5%8D%81%E7%AF%87&spm=1018.2226.3001.4450
* 13: https://blog.csdn.net/huanglu0314/article/details/118566473?ops_request_misc=%257B%2522request%255Fid%2522%253A%25229590ca0249ccaa1b06932a575948009d%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=9590ca0249ccaa1b06932a575948009d&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-1-118566473-null-null.nonecase&utm_term=%E7%AC%AC%E5%8D%81%E4%B8%89%E7%AF%87&spm=1018.2226.3001.4450
* 14: https://blog.csdn.net/huanglu0314/article/details/118566552?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522e21014651f2f407b0485c3503b499a9d%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=e21014651f2f407b0485c3503b499a9d&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-1-118566552-null-null.nonecase&utm_term=%E7%AC%AC%E5%8D%81%E5%9B%9B%E7%AF%87&spm=1018.2226.3001.4450

* https://github.com/gx304419380/dynamic-drools-web
* https://blog.csdn.net/justlpf/article/details/127010130
* https://zhuanlan.zhihu.com/p/603826111
* https://www.cnblogs.com/ityml/p/15993391.html

* go rules: https://editor.gorules.io/

* CSDN 05: https://blog.csdn.net/weixin_53900003/article/details/126935176