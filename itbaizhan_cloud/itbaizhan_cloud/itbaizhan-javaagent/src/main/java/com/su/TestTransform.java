package com.su;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class TestTransform implements ClassFileTransformer {
    //com/su/controller/HelloController
    public final String CLASSNAME= "com.su.controller.HelloController";
    public final String METHOD_NAME= "hello";
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        /*System.out.println("classname:"+className);*/
        String finalClassName = className.replace("/", ".");
        if(finalClassName.equals(CLASSNAME)){
            System.out.println("className匹配成功");
            CtClass ctClass;
            try {
                ctClass = ClassPool.getDefault().get(CLASSNAME);
                System.out.println("class is ok");
                CtMethod declaredMethod = ctClass.getDeclaredMethod(METHOD_NAME);
                System.out.println("method is ok");
                declaredMethod.insertBefore("System.out.println(\"字节码添加成功打印日志\");");
                return ctClass.toBytecode();
            }catch (Exception e){
                throw new RuntimeException();
            }

        }
        return null;
    }
}
