package org.example.springboot2pra07.annotation;

import org.example.springboot2pra07.bean.User;
import org.junit.Test;

import java.lang.reflect.Field;

public class AnnotationTest {

    @Test
    public void test() throws IllegalAccessException {

        User user = new User();
        initUser(user);

        boolean checkResult = checkUser(user);
        printResult(checkResult);

        user.setAge(22);
        checkResult = checkUser(user);
        printResult(checkResult);


    }


    private static void initUser(User user) throws IllegalAccessException {

        /*
        user.getClass()
        用途：取得 user 實例的 Class 物件（例如 User.class）。
        這是反射的起點，從這裡才能取得欄位、方法、註解等資訊。

        getDeclaredFields()
        用途：取得類別中「所有欄位（不分公開/私有）」，以 Field[] 形式回傳。

        包含 private 欄位
        不包含父類別的欄位（要用 getFields() 才會包含公開的繼承欄位）
        */
        Field[] fields = user.getClass().getDeclaredFields();

        for (Field field : fields) {
            /*
            field.isAnnotationPresent(...)
            用途：檢查該欄位上是否有特定註解（這裡是 @InitSex）
            回傳值：true/false

            field.getAnnotation(...)
            用途：取得註解實例，可以讀取註解裡的屬性（像 init.sex()）
            型別是對應的註解類別（這裡是 InitSex）

            field.setAccessible(true)
            用途：關閉 Java 的安全檢查，允許存取 private 欄位或方法。
            否則無法 get() 或 set() 私有欄位，會丟出 IllegalAccessException

            field.set(object, value)
            用途：將指定值設到指定物件的欄位上
            在這裡：把 @InitSex 中的 sex() 設到 user 的某個欄位
            */
            if(field.isAnnotationPresent(InitSex.class)){
                InitSex init = field.getAnnotation(InitSex.class);
                field.setAccessible(true);
                field.set(user, init.sex().toString());
                System.out.println("完成修改, 修改值為: " + init.sex().toString());
            }
        }

    }

    private static boolean checkUser(User user) throws IllegalAccessException {

        Field[] fields = user.getClass().getDeclaredFields();

        boolean result = true;
        for (Field field : fields) {
            if(field.isAnnotationPresent(ValidateAge.class)){
                ValidateAge validateAge = field.getAnnotation(ValidateAge.class);
                field.setAccessible(true);
                /*
                field.get(object)
                用途：從 user 實例取得這個欄位的當前值（即反射取值）
                必須先 setAccessible(true) 才能使用在私有欄位上
                */
                int age = (int)field.get(user);
                if(age < validateAge.min() || age > validateAge.max()){
                    result =  false;
                    System.out.println("年齡不符合條件");
                }
            }
        }
        return result;

    }

    private static void printResult(boolean checkResult) {
        if(checkResult){
            System.out.println("檢驗通過");
        } else{
            System.out.println("檢驗未通過");
        }
    }

}
