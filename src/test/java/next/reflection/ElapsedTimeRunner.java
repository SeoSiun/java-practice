package next.reflection;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class ElapsedTimeRunner {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    public void run() throws Exception {
        Class clazz = ElapsedTimeTest.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ElapsedTime.class)) {
                ElapsedTime annotation = method.getAnnotation(ElapsedTime.class);

                long currentTimeMillis = System.currentTimeMillis();
                method.invoke(clazz.newInstance());
                long elapsedTime = System.currentTimeMillis() - currentTimeMillis;

                String unit = annotation.unit();
                if (unit.equals("ms")) {
                    logger.debug(method.getName() + ": " + elapsedTime + unit);
                } else {
                    logger.debug(method.getName() + ": " + elapsedTime / 1000 + unit);
                }

            }
        }
    }
}


