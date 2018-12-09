import com.allen.spring.bean.Car;
import com.allen.spring.config.LifeCycleConfig;
import com.allen.spring.config.ValidAndPropertySourceConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Unit test for simple App.
 */
public class LifeCycleTest {

    @Test
    public void testLifeCycle(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println("IoC容器创建...");
        Car car = context.getBean(Car.class);
        car.destory();
        //context.close();
        //System.out.println("IoC容器关闭时调用单例bean的destory方法");
    }

    @Test
    public void testLifeCycle2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println("IoC容器创建...");
        context.close();
    }

    @Test
    public void testApplicationContextAware(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ValidAndPropertySourceConfig.class);
        System.out.println("Get IoC container...");
    }
}
