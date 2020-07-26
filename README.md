# SpringBootDemo
1. 构建工程依赖
2. 配置MySQL数据库
3. Thymeleaf使用方法
4. LayUI前端组件化
5. 整合Mybatis

# 步骤
1. 新建spring boot + mybatis 基础项目
    * 必须连接数据：在 application.yml 文件中设置数据库连接信息
2. 引入layuiadmin  或者其他主题模板
    * 布局
3. 整合Mybatis   
    * 代码生成器
           * 在pom 文件中添加 插件
           * 修改 generatorConfig.xml 中对应的内容
    * application.yml 配置映射文件的位置
    * 在 Demo2Application 中添加 @MapperScan("?????")
    * 在 application.yml 配置sql 语句的日志信息
    * 分页器