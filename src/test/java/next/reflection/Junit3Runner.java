package next.reflection;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class Junit3Runner {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    public void runner() throws Exception {
        Class clazz = Junit3Test.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            logger.debug(method.getName());
            if (method.getName().startsWith("test")) {
                method.invoke(clazz.newInstance());
            }
        }
    }
}
