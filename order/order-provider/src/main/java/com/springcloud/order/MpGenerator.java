package com.springcloud.order;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：郭建锋.
 * @ Date       ：Created in 14:38 2020/4/3
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class MpGenerator {

    private static final String AUTHOR = "郭建锋";
    private static final String OUTPUT_DIR = "D://" + "\\generator\\" + System.currentTimeMillis();
    private static final String JAVA_DIR = OUTPUT_DIR + "\\java";
    private static final String MAPPER_XML_DIR = OUTPUT_DIR + "\\mapper";
//    private static final String JDBC_URL = "jdbc:mysql://qx1lha1u5e4s5460public.drds.aliyuncs.com:3306/edu_dev?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8";
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/goods?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";

    /**
     * <p>
     *
     * </p>
     */
    public static void main(String[] args) throws IOException {
        //清空输出文件
        try {
            Path outPutPath = Paths.get(OUTPUT_DIR);
            Files.createDirectories(outPutPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Veloctiy 需要增加Veloctiy maven 依赖

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(JAVA_DIR);
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor(AUTHOR);
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName(gc.getMapperName());
        gc.setControllerName("%sController");
        //注意 %s 会自动填充表实体属性！

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                if("tinyint(1)".equals(fieldType)) {
                    return DbColumnType.BOOLEAN;
                }
                return super.processTypeConvert(fieldType);
            }
        });

        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUsername("edu_dev");
        dsc.setUsername("root");
//        dsc.setPassword("edu2019deV");
        dsc.setPassword("123456");
        dsc.setUrl(JDBC_URL);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude("product_category","product_info");
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);

        mpg.setStrategy(strategy);

        // 包配置
        final PackageConfig pc = new PackageConfig();
        // 其他配置使用默认值
        pc.setParent("com.springcloud.product");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();

        // xml生成目录
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                Path xmlDirPath = Paths.get(MAPPER_XML_DIR, pc.getParent().replaceAll("\\.", "\\\\"),"mapper");
                File xmlDir = xmlDirPath.toFile();
                if(!xmlDir.exists()) {
                    xmlDir.mkdirs();
                }
                return Paths.get(xmlDirPath.toString(), tableInfo.getEntityName() + "Mapper.xml").toString();
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();
        System.out.println("=============文件生成完成===============");
    }
}


