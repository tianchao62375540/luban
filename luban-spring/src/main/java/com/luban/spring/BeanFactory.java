package com.luban.spring;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: tianchao
 * @Date: 2019/11/14 23:01
 * @Description:
 */
public class BeanFactory {
    private Map<String,Object> map = new HashMap<>();
    private Map<Class, List<Object>> mapClass = new HashMap<>();
    public BeanFactory(String xml){
        parseXml(xml);
    }

    private void parseXml(String xml) {
        try {
            File file = new File(BeanFactory.class.getResource("/").getPath(),xml);
            SAXReader reader = new SAXReader();
            Document document = reader.read(file);
            Element root = document.getRootElement();
            String autowire = root.attributeValue("default-autowire");
            boolean flag = false;
            if(autowire!=null){
                flag = true;
            }
            for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
                Element elementFirst = it.next();
                Attribute attr_id = elementFirst.attribute("id");
                String id = attr_id.getValue();
                String clazzStr = elementFirst.attributeValue("class");
                Class<?> clazz = Class.forName(clazzStr);
                Object object = null;
                if(elementFirst.elementIterator().hasNext()){
                    for (Iterator<Element> itchild = elementFirst.elementIterator(); itchild.hasNext();) {
                        Element elementTwo = itchild.next();
                        if(elementTwo.getName().equals("property")){
                            object = clazz.newInstance();
                            String propertyName = elementTwo.attributeValue("name");
                            String ref = elementTwo.attributeValue("ref");
                            Field propertyName1 = clazz.getDeclaredField(propertyName);
                            propertyName1.setAccessible(true);
                            propertyName1.set(object,map.get(ref));
                        }
                        if(elementTwo.getName().equals("constructor-arg")){
                            String ref = elementTwo.attributeValue("ref");
                            Object o = map.get(ref);
                            String fieldName = elementTwo.attributeValue("name");
                            Field declaredField = clazz.getDeclaredField(fieldName);
                            System.out.println(declaredField.getType()+"===");
                            System.out.println(declaredField.getType().getClass()+"===");
                            //Constructor<?> constructor = clazz.getConstructor(o.getClass().getInterfaces()[0]);
                            Constructor<?> constructor = clazz.getConstructor(declaredField.getType());
                            object = constructor.newInstance(o);
                        }
                    }
                }
                if(object == null){
                    object =  clazz.newInstance();
                }
                if(flag){
                    if(autowire.equals("byType")){
                        Field[] declaredFields = clazz.getDeclaredFields();
                        for (Field field : declaredFields) {
                            //得到属性
                            Class<?> type = field.getType();
                            /**
                             * 由于是bytype所以需要便利map当中的对象
                             * 判断对象的类型是不是和这个type相同
                             */
                            List<Class> collect = mapClass.keySet().stream().filter(e -> type.isAssignableFrom(e)).collect(Collectors.toList());
                            if(collect!=null&&collect.size()==1){
                                List<Object> objects = mapClass.get(collect.get(0));
                                if(objects!=null&&objects.size()==1){
                                    field.setAccessible(true);
                                    field.set(object,objects.get(0));
                                }else if(objects!=null&&objects.size()>1){
                                    throw new LubanRuntimeException("==有多余两个实例 无法注入");
                                }else{
                                    throw new LubanRuntimeException("==至少一个实例");
                                }
                            }else if(collect!=null&&collect.size()>1){
                                throw new LubanRuntimeException("有多余两个实例 无法注入");
                            }else{
                                throw new LubanRuntimeException("至少一个实例");
                            }
                        }
                    }
                }

                map.put(id,object);
                List<Object> objects = mapClass.get(object.getClass());
                if(objects==null||objects.isEmpty()){
                    objects = new ArrayList<>();
                    mapClass.put(object.getClass() ,objects);
                }
                objects.add(object);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Object getBean(String name){
        return map.get(name);
    }
}
