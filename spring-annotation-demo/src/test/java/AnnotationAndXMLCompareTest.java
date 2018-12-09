import com.allen.spring.bean.Person;
import com.allen.spring.config.AnnotationAndXMLCompareConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by meng on 2018/12/8.
 */
public class AnnotationAndXMLCompareTest {


    @Test
    public void testXMLBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = applicationContext.getBean(Person.class);
        System.out.println("XML声明的Spring bean--->" + person.toString());
    }

    @Test
    public void testAnnotationBean(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationAndXMLCompareConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println("注解声明的Spring bean--->" + person.toString());

    }

    @Test
    public void testScope() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationAndXMLCompareConfig.class);
        System.out.println("IoC container创建完成...");
        // Singleton mode instantiation person on IoC container loading
        // Prototype mode instantiation person on get.
        Person person = (Person) context.getBean("person");
        Person person1 = (Person) context.getBean("person");
        // Singleton mode , true
        // Prototype mode , false
        System.out.println(person == person1);
    }
}
