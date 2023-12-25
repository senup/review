package github.io.review.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectMagic {
    public static void main(String[] args) throws Exception {
        Class bookClass = Class.forName("github.io.review.reflect.Book");

        // 获取私有构造方法
        Constructor constructor = bookClass.getDeclaredConstructor(String.class, String.class);
        //打破 private 的访问限制，访问字段和方法
        constructor.setAccessible(true);
        Book book = (Book) constructor.newInstance("Effective Java", "Joshua Bloch");

        // 获取私有字段
        Field titleField = bookClass.getDeclaredField("title");
        Field authorField = bookClass.getDeclaredField("author");
        titleField.setAccessible(true);
        authorField.setAccessible(true);

        // 输出书籍信息
        System.out.println("Book title: " + titleField.get(book));
        System.out.println("Book author: " + authorField.get(book));

        // 调用私有方法
        Method secretMethod = bookClass.getDeclaredMethod("secret");
        secretMethod.setAccessible(true);
        String secret = (String) secretMethod.invoke(book);
        System.out.println("Secret: " + secret);
    }
}