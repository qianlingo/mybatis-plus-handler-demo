package com.qianlingo.mybatisplushandlerdemo.code;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Mybatis Plus 实体类代码构建类
 * @author qianlingo
 * @date 2020/7/31
 */
public class CodeGenerator {

    /**
     * 系统包名，一般为com.qianlingo
     */
    private static final String PROJECT_PACKING_NAME = "com.qianlingo.mybatisplushandlerdemo";

    /**
     * 作者名，放在类的顶部，用于@author注解后面
     */
    private static final String AUTHOR = "qianlingo";

    /**
     * 当前系统模块名，一般为xxx-service
     */
    private static final String PROJECT_MODULE_NAME = "/code/mybatis-plus-handler-demo";

    /**
     * 数据库 连接地址
     */
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mybatis-plus-handler-demo?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai";

    /**
     * 数据库 用户名
     */
    private static final String DATABASE_DRIVER_NAME = "com.mysql.jdbc.Driver";

    /**
     * 数据库 用户名
     */
    private static final String DATABASE_USER_NAME = "root";
    /**
     * 数据库 密码
     */
    private static final String DATABASE_PASS_WORD = "root";

    public static void main(String[] args) {
        //请在此输入模块、表信息
        action("data", "data_classroom");
        action("sys", "sys_user");
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }



    /**
     * 执行代码构建操作
     *
     * @param modelName 项目模块名，请以包名格式进行填写，如sys.user
     * @param tableName 数据库表名，可以多个英文逗号分隔分别生成
     */
    private static void action(String modelName, String tableName) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir") + File.separator + PROJECT_MODULE_NAME;
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        //实体属性 Swagger2 注解
        gc.setSwagger2(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DATABASE_URL);
        dsc.setDriverName(DATABASE_DRIVER_NAME);
        dsc.setUsername(DATABASE_USER_NAME);
        dsc.setPassword(DATABASE_PASS_WORD);
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        String p = modelName;
        pc.setParent(PROJECT_PACKING_NAME);
        pc.setController("controller."+p);
        pc.setEntity("mybatis.domain." + p);
        pc.setMapper("mybatis.mapper." + p);
        pc.setService("service." + p);
        pc.setServiceImpl("service." + p + ".impl");
        mpg.setPackageInfo(pc);


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mybatis/mapper/" + p.replace(".", "/") + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(tableName.split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setVersionFieldName("version");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }


}
