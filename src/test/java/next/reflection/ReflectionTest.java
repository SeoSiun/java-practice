package next.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.assertj.core.api.Assertions.*;

public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    @DisplayName("테스트1: 리플렉션을 이용해서 클래스와 메소드의 정보를 정확하게 출력해야 한다.")
    public void showClass() throws Exception {
        SoftAssertions s = new SoftAssertions();
        Class<Question> clazz = Question.class;
        logger.debug("Classs Name {}", clazz.getName());
        logger.debug("");
        logger.debug("Fields: ");
        getFields();
        logger.debug("");
        logger.debug("Constructors: ");
        getConstructors();
        logger.debug("");
        logger.debug("Methods: ");
        getMethod();
    }

    @Test
    @DisplayName("테스트2 : 리플렉션을 이용해서 클래스의 접근 가능한 public 필드 목록을 반환")
    public void getFields() {
        Class<Question> clazz = Question.class;
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            logger.debug(field.getName());
            logger.debug("filed type : {}", field.getType());

        }
    }

    @Test
    @DisplayName("테스트3 : 리플렉션을 이용해서 모든 필드 목록을 반환")
    public void getDeclaredFields() {
        Class<Question> clazz = Question.class;
        Field[] fields = clazz.getDeclaredFields();
        assertThat(fields).hasSize(6);
    }

    @Test
    @DisplayName("테스트4 : 리플렉션을 이용해서 클래스의 접근 제어자 반환")
    public void getModifiers() {
        Class<Question> clazz = Question.class;
        int modifiers = clazz.getModifiers();

        assertThat(modifiers).isEqualTo(1);
    }

    @Test
    @DisplayName("테스트5 : 리플렉션을 이용해서 생성자와 각 생성자의 parameter 목록을 반환")
    public void getConstructors() throws Exception {
        Class<Question> clazz = Question.class;
        Constructor[] constructors = clazz.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            logger.debug(constructor.getName());
            Class[] parameterTypes = constructor.getParameterTypes();
            logger.debug("parameter length : {}", parameterTypes.length);
            for (Class paramType : parameterTypes) {
                logger.debug("param type : {}", paramType);
            }
        }
    }
}
