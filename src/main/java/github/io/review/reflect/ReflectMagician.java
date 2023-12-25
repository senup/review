package github.io.review.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectMagician {
    public static void main(String[] args) throws Exception {
        Class magicianClass = Class.forName("github.io.review.reflect.Magician");

        // 获取构造函数并创建对象
        Constructor constructor = magicianClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Object magician = constructor.newInstance("Harry");

        // 获取私有方法
        Method method = magicianClass.getDeclaredMethod("showMagic", String.class, int.class);
        method.setAccessible(true);

        // 调用方法
        String result = (String) method.invoke(magician, "Levitation", 3);
        System.out.println(result);
    }
}