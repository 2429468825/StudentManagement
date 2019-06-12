/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp.gui;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aaa
 */
public class ClassRefect 
{
    //************��ȡ���й��е��ֶ�********************
    public static  Field[] getAllPublicAttribute(Object obj)
    {
        Class refClass = obj.getClass();
        //System.out.println(refClass);
        return refClass.getFields();
    }
    
    //************��ȡ���ж�����ֶ�(����˽�С��ܱ�����Ĭ�ϵ�)********************
    public static Field[] getAllAttribute(Object obj)
    {
        Class refClass = obj.getClass();
        //System.out.println(refClass);
        return refClass.getDeclaredFields();
    }
    
    //************��ȡ���й��еķ���********************
    public static Method[] getAllPublicMethod(Object obj)
    {
        Class refClass = obj.getClass();
        //System.out.println(refClass);
        return refClass.getMethods();
    }
    
     //************��ȡ���е�Get����********************
    public static List<Method> getAllGetMethod(Object obj)
    {
        List<Method> getMethods=new ArrayList<>();
        Class refClass = obj.getClass();
        //System.out.println(refClass);
        Method[] methodArray = refClass.getMethods();
        for(Method m:methodArray)
        {
             if(m.getName().contains("get")){
             getMethods.add(m);
             System.out.println(m.getName());
             }
        }
        return getMethods;
    }
    
    //************�������е�Get����********************
    public static void invokeAllGetMethod(Object obj)
    {
        Class refClass = obj.getClass();
        //System.out.println(refClass);
        Method[] methodArray = refClass.getMethods();
        for (Method m : methodArray) {
            //System.out.println(m);
            if(m.getName().contains("get")){
                try {
                    System.out.println(m.getName());
                    System.out.println(m.invoke(obj, null));
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ClassRefect.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ClassRefect.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(ClassRefect.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }
}
