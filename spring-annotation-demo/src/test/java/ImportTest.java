import com.allen.spring.config.PersonImportConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by meng on 2018/12/8.
 */
public class ImportTest {

    @Test
    public void testConfig04() {
        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext(PersonImportConfig.class);
        String[] names = annotationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("Bean name is --->" + name);
        }
        //工厂bean获取到的是调用getObject创建的对象
        Object color = annotationContext.getBean("colorFactoryBean");
        System.out.println(color.getClass());

        //获取工厂对象本身
        Object factoryBean = annotationContext.getBean("&colorFactoryBean");
        System.out.println(factoryBean.getClass());
    }

}
