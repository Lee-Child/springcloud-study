import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.lwc.generator.AutoGenerator;
import com.lwc.generator.InjectionConfig;
import com.lwc.generator.config.*;
import com.lwc.generator.config.po.TableFill;
import com.lwc.generator.config.po.TableInfo;
import com.lwc.generator.config.rules.NamingStrategy;
import com.lwc.generator.engine.FreemarkerTemplateEngine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MybatisPlusGenerator {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void generatorCode() {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        String projectPath = System.getProperty("user.dir");

        // 全局配置
        GlobalConfig gc = new GlobalConfig()
//                .setOutputDir(projectPath + "/target/generated-sources/")//输出目录
                .setOutputDir("D:/generated-sources/")//输出目录
                .setFileOverride(true)// 是否覆盖文件
                .setActiveRecord(false)// 开启 activeRecord 模式
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(true)// XML columList
                //.setKotlin(true) 是否生成 kotlin 代码
                .setAuthor("Li")
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
//                .setEntityName("%s")
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController")
                .setFeignName("%sApi")
                .setEntityExtName("%sBo")
//                .setDaoName("%sDao")
//                .setDaoImplName("%sDaoImpl")
                .setFallbackName("%sFallback")
//                .setPayloadName("%sPayload")
//                .setHandlerName("%sHandler")
                .setSwagger2(true);

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig ds = new DataSourceConfig();
//        ds.setUrl("jdbc:mysql://120.26.230.73:9306/gtmc_eip_maintenance?Unicode=true&characterEncoding=UTF-8");
//        ds.setUrl("jdbc:mysql://120.26.230.73:9306/gtmc_eip_bonus_point?Unicode=true&characterEncoding=UTF-8");
//        ds.setUrl("jdbc:mysql://120.26.230.73:9306/gtmc_eip_appointment?Unicode=true&characterEncoding=UTF-8");
//        ds.setUrl("jdbc:mysql://120.26.230.73:9306/gtmc_eip_member?Unicode=true&characterEncoding=UTF-8");
//        ds.setUrl("jdbc:mysql://120.26.230.73:9306/gtmc_eip_hr?Unicode=true&characterEncoding=UTF-8");
//        ds.setUrl("jdbc:mysql://120.26.230.73:9306/gtmc_eip_vehicle?Unicode=true&characterEncoding=UTF-8");
        ds.setUrl("jdbc:mysql://localhost:3306/client_user?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false");
//        ds.setSchemaName("client_user");
        ds.setDriverName("com.mysql.cj.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("root");
        mpg.setDataSource(ds);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("user");
        pc.setParent("com.lwc");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/target/generated-sources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilderExt configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setEntity("templates/entity.java")
                .setMapper("templates/mapper.java")
                .setService("templates/service.java")
                .setServiceImpl("templates/serviceImpl.java")
                .setController("templates/controller.java")
                .setFeign("templates/api.java")
                .setEntityExt("templates/entityExt.java")
//                .setDao("templates/dao.java")
//                .setDaoImpl("templates/daoImpl.java")
                .setFallback("templates/fallback.java");
//                .setPayload("templates/payload.java")
//                .setHander("templates/handler.java");


        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setSkipView(true);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setEntityBuilderModel(true);
        List<TableFill> tableFills = new ArrayList<>();
        tableFills.add(new TableFill("create_at", FieldFill.INSERT));
        tableFills.add(new TableFill("update_at", FieldFill.INSERT_UPDATE));
        tableFills.add(new TableFill("create_by", FieldFill.INSERT));
        tableFills.add(new TableFill("update_by", FieldFill.INSERT_UPDATE));
        tableFills.add(new TableFill("del_flag", FieldFill.INSERT));
        strategy.setTableFillList(tableFills);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(false);
        strategy.setLogicDeleteFieldName("delete_flag");
        strategy.setVersionFieldName("version");

//        strategy.setSuperEntityClass("com.gtmc.glaf.framework.data.entity.Entity");
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");
//        strategy.setSuperDaoClass("com.gtmc.glaf.framework.data.mysql.dao.BaseMpDao");
//        strategy.setSuperDaoImplClass("com.gtmc.glaf.framework.data.mysql.dao.impl.BaseMpDaoImpl");
//        strategy.setSuperServiceClass("com.gtmc.glaf.framework.data.mysql.service.BaseMpService");
//        strategy.setSuperServiceImplClass("com.gtmc.glaf.framework.data.mysql.service.impl.BaseMpServiceImpl");

//        strategy.setInclude("base_coop_info");
//        strategy.setSuperEntityColumns("id");
//        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        mpg.execute();
    }
}
