package com.tinnkyou.config;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wb-cq355812
 * @create 2019/06/19
 */
public class ScanDemo {
    public static void main(String[] args) throws UnsupportedEncodingException, ClassNotFoundException {
        String packagePath = "com.tinnkyou.config";
        String packageDir = packagePath.replace(".", "/");
        URL resource = Thread.currentThread().getContextClassLoader().getResource(packageDir);
        String protocol = resource.getProtocol();
        System.out.println(protocol);
        String decode = URLDecoder.decode(resource.getFile(), "utf-8");
        System.out.println(decode);
        File file = new File(decode);
        List<File> af = new ArrayList<>();
        fetchFile(file,af);
        System.out.println(af.size());
        for (File file1 : af) {
            String fileName = file1.getAbsolutePath();
            String noSuffixFileName = fileName.substring(8 + fileName.lastIndexOf("classes"), fileName.indexOf(".class"));
            String pack = noSuffixFileName.replace("\\",".");
            Class<?> aClass = Class.forName(pack);
            Controller annotation = aClass.getAnnotation(Controller.class);
            if (annotation != null){
                Method[] methods = aClass.getMethods();
                for (Method method : methods) {
                    ApiAction annotation1 = method.getAnnotation(ApiAction.class);
                    if (annotation1 != null){
                        String apiPath = annotation1.name();
                        RequestMethod me = annotation1.method();
                        String[] params = annotation1.params();
                        System.out.println(apiPath+"\t"+me.name()+"\t"+params.toString());
                    }

                }
            }
        }
    }

    public static void fetchFile(File dir,List<File> fileList){
        if (dir.isDirectory()){
            File[] files = dir.listFiles();
            for (File file : files) {
                fetchFile(file,fileList);
            }
        }else {
            fileList.add(dir);
        }
    }
}
