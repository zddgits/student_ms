package com.example.generator.teacher;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class CodeGenerator {

    @Test
    public void test() {
        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        // 代码生成的位置
        gc.setOutputDir("D:\\IdeaProjects\\student_ms" + "/src/main/java");
        gc.setAuthor("XXX");
        gc.setOpen(false);  // 生成后是否打开资源管理器
        gc.setFileOverride(false); // 重新生成时文件是否覆盖

        //UserServie
        gc.setServiceName("%sService");    // 去掉 Service 接口的首字母I
        gc.setIdType(IdType.ID_WORKER_STR); // 主键策略
        gc.setDateType(DateType.ONLY_DATE); // 定义生成的实体类中日期类型
        gc.setSwagger2(true); // 开启 Swagger2 模式
        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/stu_ms?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("1614697428");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();

        // 包 com.demo.empms
        pc.setParent("com.example.stums");  // 设置根包
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        pc.setServiceImpl("serviceImpl");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();

        strategy.setInclude("course","course_student","admin","schedule","notice","teacher","student"); // 数据库中的表名,多个表名中间使用逗号隔开
        strategy.setNaming(NamingStrategy.underline_to_camel); // 数据库表映射到实体的命名策略
        strategy.setTablePrefix(pc.getModuleName() + "_"); // 生成实体时去掉表前缀
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); // 数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter 链式操作
        strategy.setRestControllerStyle(true); // restful api 风格控制器
        strategy.setControllerMappingHyphenStyle(true); // url 中驼峰转连字符
        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }

}


