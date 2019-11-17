package com.luban.Proxy;

import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;
import sun.misc.ProxyGenerator;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.SQLOutput;

/**
 * .java
 * .class
 * .new
 *
 * @Auther: tianchao
 * @Date: 2019/10/30 23:22
 * @Description:
 */
public class ProxyUtil {
    private static final String tab = "\t";
    private static final String enter = "\n";


    public static Object getInstance(Object target) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        StringBuilder sb = new StringBuilder();
        Class<?> clazz = target.getClass();
        Package proxyPackage = clazz.getPackage();
        Class<?> anInterface = clazz.getInterfaces()[0];
        String name = anInterface.getName();
        sb.append("package " + proxyPackage.getName() + ";").append(enter)
                .append(enter).append(enter);
        sb.append("import " + anInterface.getName() + ";")
                .append(enter);
        sb.append("public class $Proxy0 implements "+anInterface.getSimpleName()+"{").append(enter);
        sb.append(tab).append("private ").append(anInterface.getSimpleName()).append(" target;").append(enter);
        sb.append(tab).append("public $Proxy0 (").append(anInterface.getSimpleName()).append(" target){").append(enter)
                .append(tab + tab).append("this.target = target;").append(enter)
                .append(tab).append("}").append(enter);
        //处理方法
        Method[] methods = anInterface.getDeclaredMethods();
        String methodStr = "";
        for (Method method : methods) {
            String methodName = method.getName();
            Parameter[] parameters = method.getParameters();
            String args = "";
            String argName = "";
            for (Parameter parameter : parameters) {
                args += parameter.getType().getName() + " " + parameter.getName() + ",";
                argName += " " + parameter.getName() + ",";
            }
            if (args.length() != 0) {
                args = args.substring(0, args.length() - 1);
                argName = argName.substring(0, argName.length() - 1);
            }
            Class<?> returnType = method.getReturnType();
            String returnName = returnType.getName();
            methodStr += enter + tab + "public " + returnType.getName() + " " + methodName + "(" + args + "){" + enter;
            if ("void".equals(returnName)) {
                methodStr += tab + tab + "this.target." + methodName + "(" + argName + ");";
            } else {
                methodStr += tab + tab + returnName + " returnVal = (" + returnName + ")this.target." + methodName + "(" + argName + ");" + enter;
                methodStr += tab + tab + "System.out.println(123);"+enter;
                methodStr += tab + tab + "return returnVal;";
            }

            methodStr += enter + tab + "}" + enter;
        }
        sb.append(methodStr);
        sb.append("}");
        System.out.println(sb.toString());
        System.out.println(ProxyUtil.class.getClassLoader().getResource("/"));
        File file = new File("D:\\fight\\workspace-luban\\luban\\aop\\src\\main\\java\\com\\luban\\Proxy\\$Proxy0.java");
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            fw.write(sb.toString());
            fw.flush();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(file);
        JavaCompiler.CompilationTask task = compiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
        task.call();
        try {
            standardFileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("file:D:\\fight\\workspace-luban\\luban\\aop\\src\\main\\java\\")});
        Class<?> aClass = urlClassLoader.loadClass("com.luban.Proxy.$Proxy0");
        Object o = aClass.getConstructor(anInterface).newInstance(target);

        System.out.println(file.getAbsolutePath());
        return o;
    }

    private static Class<?> compile(String name, String content) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        return null;
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, MalformedURLException, ClassNotFoundException {
        ItemDao instance = (ItemDao)getInstance(new ItemDaoImpl());
        System.out.println("    :"+instance);
        System.out.println(instance.sum(5,9));
        byte[] $Proxy18s = ProxyGenerator.generateProxyClass("$Proxy18", new Class[]{ItemDao.class});
        try {
            FileOutputStream fos = new FileOutputStream("D:\\$Proxy18.class");
            fos.write($Proxy18s);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
