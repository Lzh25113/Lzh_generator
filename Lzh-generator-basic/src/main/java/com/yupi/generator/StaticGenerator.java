package com.yupi.generator;


import cn.hutool.core.io.FileUtil;

import java.io.File;

public class StaticGenerator {
    public static void main(String[] args) {
        //获取整个项目的根路径
        String projectPath=System.getProperty("user.dir");
        File parentFile =new File(projectPath).getParentFile();
       //输入路径：ACM示例代码模板目录
        String inputPath=new File(parentFile,"/Lzh_generator/Lzh-generator-demo-projects/acm-template").getAbsolutePath();
         //输出路径：直接输出到项目的根目录
        String outputPath=projectPath;
        copyFilesByHutool(inputPath,outputPath);
    }
/**
*拷贝文件(Hutoo1实现，会将输入目录完整拷贝到输出目录下)
    米@param inputPath
*
    @param outputPath
*/
    public static void copyFilesByHutool(String inputPath,String outputPath){

        FileUtil.copy(inputPath,outputPath,false);
    }
}
