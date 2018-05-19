package Service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.AdminVo;

import static org.junit.Assert.*;

public class AdminServiceTest
{

    @Test
    public void isLogin()
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        AdminService service=context.getBean(AdminService.class);
        AdminVo vo=new AdminVo();
        vo.setId("admin");
        vo.setPassword("123456");
        service.IsLogin(vo);
    }
}