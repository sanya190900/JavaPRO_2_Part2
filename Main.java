package com;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TextContainer container = new TextContainer("Second task is completed");
        boolean isSaverHere = false;
        String path;
        Class<?> cls = container.getClass();
        if(cls.isAnnotationPresent(SaveTo.class)){
            SaveTo saveTo = cls.getAnnotation(SaveTo.class);
            path = saveTo.path();
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods){
                if(method.isAnnotationPresent(Saver.class)){
                    isSaverHere = true;
                    method.invoke(container, path);
                }
            }
            if(!isSaverHere){
                System.out.println("Methods with annotation \"Saver\" were not found.");
            }
        }else{
            System.out.println("Class \"TextContainer\" is not annotated by \"SaveTo\" annotation.");
        }
    }
}
