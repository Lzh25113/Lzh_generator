package com.yupi.generator;

import com.yupi.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void doGenerator(Object model) throws TemplateException, IOException {
        final String projectPath = System.getProperty("user.dir");
        //项目的根目录路径
        final File parentFile = new File(projectPath).getParentFile();
        //输入路径
        final String inputPath = new File(parentFile, "Lzh_generator/Lzh-generator-demo-projects/acm-template").getAbsolutePath();
        final String outputPath = projectPath;
        //生成静态文件
        StaticGenerator.copyFilesByHutool(inputPath,outputPath);
        //生成动态文件
        String inputDoGeneratorPath =projectPath+File.separator +"Lzh-generator-basic/src/main/resources/templates/MainTemplate.java.ftl";
        String outputoGeneratorPath=projectPath+File.separator +"acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDoGeneratorPath,outputoGeneratorPath,model);

    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig=new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和s结果：");
        doGenerator(mainTemplateConfig);
    }
}
