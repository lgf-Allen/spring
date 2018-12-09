import com.allen.spring.bean.Person;
import com.allen.spring.config.PersonConditionConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by meng on 2018/12/8.
 */
public class ConditionTest {
    //通过修改configuration,可以通过-Dos.name=Linux/Windows/AliOS来模拟不同Condition下的情况
    @Test
    public void testConditionConfig() {
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(PersonConditionConfig.class);
        String[] names = annotationContext.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println("Bean name is --->" + name);
        }
    }
}
