package com.tinnkyou.config;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

/**
 * @author wb-cq355812
 * @create 2019/06/19
 */
@Getter@Setter
public class ScanDemo {
    private String url;
    private String requestInfo;
    private String returnInfo;
    private List<ApiModels> modelList;

    @Getter@Setter
    static class ApiModels{
        String desc;
        String rootUrl;
        String modelName;
        List<ApiDoc> doc;
    }
    @Getter@Setter
    static class ApiDoc{
        String desc;
        String url;
        Map<String,String> requestParams;
        Map<String,String> returnParams;

    }
    public static void main(String[] args){
        String packagePath = "com.tinnkyou.config";
        List<ApiModels> apiDocs = getApiDocs(packagePath);
        System.out.println(apiDocs);
    }

    public static List<ApiModels> getApiDocs(String packagePath){
        List<ApiModels> apiModelsList = new ArrayList<>();
        List<File> af = new ArrayList<>();
        fetchFile(pathReplace(packagePath),af);
        //拿到所有controller类
        List<Class> controllerClassList = getControllerClassList(af);
        for (Class aClass : controllerClassList) {
            ApiModels model = new ApiModels();
            ApiAction apiAction = (ApiAction)aClass.getAnnotation(ApiAction.class);
            model.setRootUrl(apiAction.name());
            model.setDesc(apiAction.desc());
            model.setModelName(aClass.getName());
            model.setDoc(getApiDocs(aClass,model));
            apiModelsList.add(model);
        }
        return apiModelsList;
    }
    private static List<ApiDoc> getApiDocs(Class cls,ApiModels model){
        List<ApiDoc> apiDocList = new ArrayList<>();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            ApiDoc doc = new ApiDoc();
            ApiAction apiAction = method.getAnnotation(ApiAction.class);
            doc.setUrl(model.getRootUrl()+""+apiAction.name());
            doc.setDesc(apiAction.desc());
            apiDocList.add(doc);
        }
        return apiDocList;
    }
    private static List<Class> getControllerClassList(List<File> files){
        List<Class> classList = new ArrayList<>();
        for (File file : files) {
            String fileName = file.getAbsolutePath();
            String noSuffixFileName = fileName.substring(8 + fileName.lastIndexOf("classes"), fileName.indexOf(".class"));
            String pack = noSuffixFileName.replace("\\",".");
            Class<?> aClass = null;
            try {
                aClass = Class.forName(pack);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (aClass != null){
                Controller annotation = aClass.getAnnotation(Controller.class);
                if (annotation !=null){
                    classList.add(aClass);
                }
            }
        }
        return classList;
    }
    private static void fetchFile(String dir,List<File> fileList){
        File file = new File(dir);
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File filess : files) {
                fetchFile(filess.getAbsolutePath(),fileList);
            }
        }else {
            fileList.add(new File(dir));
        }
    }

    private static String pathReplace(String pathDir){
        String packageDir = pathDir.replace(".", "/");
        URL resource = Thread.currentThread().getContextClassLoader().getResource(packageDir);
        String decode = null;
        try {
            decode = URLDecoder.decode(resource.getFile(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("路径变换是发生异常");
        }
        return decode;
    }
}
