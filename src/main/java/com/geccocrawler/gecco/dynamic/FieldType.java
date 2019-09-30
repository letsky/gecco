package com.geccocrawler.gecco.dynamic;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

/**
 * 类属性类型
 * 
 * @author huchengyi
 *
 */
public class FieldType {
	
	public static final CtClass intType = CtClass.intType;
	
	public static final CtClass longType = CtClass.longType;
	
	//public static CtClass booleanType = CtClass.booleanType;
	
	public static final CtClass doubleType = CtClass.doubleType;
	
	public static final CtClass floatType = CtClass.floatType;
	
	public static CtClass shortType = CtClass.shortType;
	
	public static final CtClass voidType = CtClass.voidType;
	
	public static CtClass stringType;
	static {
		try {
			stringType = ClassPool.getDefault().get("java.lang.String");
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static CtClass requestType;
	static {
		try {
			requestType = ClassPool.getDefault().get("com.geccocrawler.gecco.request.HttpRequest");
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static CtClass type(Class<?> clazz) {
		try {
			return ClassPool.getDefault().get(clazz.getName());
		} catch (NotFoundException e) {
			e.printStackTrace();
			return voidType;
		}
	}
	
	public static CtClass listType(String className) {
		try {
			return ClassPool.getDefault().get(className+"[]");
		} catch (NotFoundException e) {
			e.printStackTrace();
			return voidType;
		}
	}
}
