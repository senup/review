package github.io.review.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ReflectFruitFactory {

    // 方式一：使用Class的newInstance()方法创建对象
    public static Fruit getInstanceByClass() throws Exception {
        Class clazz = Class.forName("github.io.review.reflect.Apple");
        return (Fruit) clazz.newInstance();
    }

    // 方式二：使用Constructor的newInstance方法创建对象
    public static Fruit getInstanceByConstructor() throws Exception {
        Class clazz = Class.forName("github.io.review.reflect.Apple");
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        return (Fruit) constructor.newInstance("Red");
    }

    // 方式三：使用Proxy的newProxyInstance方法创建对象
    public static Fruit getInstanceByProxy() throws Exception {
        Class clazz = Class.forName("github.io.review.reflect.Apple");
        final Constructor constructor = clazz.getDeclaredConstructor(String.class);
        final Fruit apple = (Fruit) constructor.newInstance("Red");
        // 创建代理类
        Fruit proxyApple = (Fruit) Proxy.newProxyInstance(Apple.class.getClassLoader(),
                new Class<?>[]{Fruit.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("前置拓展");
                        Object result = method.invoke(apple, args);
                        System.out.println("后置拓展");
                        return result;
                    }
                });

        return proxyApple;
    }


    public static void main(String[] args) throws Exception {
        System.out.println("--- By class");
        Fruit appleByClass = ReflectFruitFactory.getInstanceByClass();
        appleByClass.eat();

        System.out.println("--- By constructor");
        Fruit appleByConstructor = ReflectFruitFactory.getInstanceByConstructor();
        appleByConstructor.eat();

        System.out.println("--- By proxy");
        Fruit appleByProxy = ReflectFruitFactory.getInstanceByProxy();
        appleByProxy.eat();
    }
}