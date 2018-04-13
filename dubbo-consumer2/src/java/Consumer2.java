import com.lyh.dubbo.demo.IDemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer2 {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("consumer2.xml");
        context.start();
        System.err.println("consumer2启动");
        IDemoService demoService=context.getBean(IDemoService.class);
        System.err.println("consumer2");
        System.err.println(demoService.getPermissions(2L));
    }
}
