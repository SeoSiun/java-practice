package next.reflection;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class Junit4Runner {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    public void run() throws Exception {
        Class clazz = Junit4Test.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)) {
                method.invoke(clazz.newInstance());
            }
        }
    }
}


