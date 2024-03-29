package com.yupi.generator;

import cn.hutool.core.io.FileUtil;
import com.yupi.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        String projectPath=System.getProperty("user.dir")+File.separator +"Lzh-generator-basic";
        String inputPath =projectPath+File.separator +"src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath=projectPath+File.separator +"MainTemplate.java";
        MainTemplateConfig mainTemplateConfig=new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和s结果：");
        doGenerate(inputPath,outputPath,mainTemplateConfig);
    }
    public static void doGenerate(String inputPath,String outputPath,Object model) throws IOException, TemplateException {
            //new出Configuration对象，参数为FreeMarker版本号
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
            //指定模板文件所在的路径
            final File templateDir = new File(inputPath).getParentFile();
            configuration.setDirectoryForTemplateLoading(templateDir);
            //设置模板文件使用的字符集
            configuration.setDefaultEncoding("utf-8");
            //创建模板对象，加载指定模板
            Template template=configuration.getTemplate("MainTemplate.java.ftl");
            MainTemplateConfig mainTemplateConfig=new MainTemplateConfig();
            mainTemplateConfig.setAuthor("yupi");
            mainTemplateConfig.setLoop(false);
            mainTemplateConfig.setOutputText("求值结果");
            Writer out=new FileWriter("MainTemplate.html");
            template.process(mainTemplateConfig,out);
            //生成文件后别忘了关闭哦
            out.close();
    }
}

