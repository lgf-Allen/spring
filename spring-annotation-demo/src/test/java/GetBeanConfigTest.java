import com.allen.spring.bean.BeanService;
import com.allen.spring.bean.Person;
import com.allen.spring.config.GetBeanConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by meng on 2018/12/9.
 */
public class GetBeanConfigTest {

    //@Autowired
    //Person autowiredPerson;

    //@Inject
    //Person injectPerson;

    @Test
    public void testAutowired() {
        ApplicationContext context = new AnnotationConfigApplicationContext(GetBeanConfig.class);
        Person p = context.getBean(Person.class);
        Person autowiredPerson = context.getBean(BeanService.class).getPerson();
        System.out.println(autowiredPerson == p);
    }
}
