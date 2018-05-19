package action;

import Service.AdminService;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import util.SpringBeanFactory;
import vo.AdminVo;
import vo.UsersVo;

import javax.servlet.http.HttpSession;

/**
 * 登陆控制器
 */

@Controller
public class LoginAction extends BaseAction
{
    private String username;
    private String password;

    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;

    /**
     * 管理员登陆
     * @return
     */
    public String adminLogin()
    {

        AdminVo vo=new AdminVo();
        vo.setId(username);
        vo.setPassword(password);
        if (adminService.IsLogin(vo))
        {
            //设置session
            HttpSession session=getSession();
            session.setAttribute("admin",vo);
            return "success";
        }else
        {
            return "error";
        }
    }


    /**
     * 用户登陆
     * @return
     */
    public String userLogin()
    {
        UsersVo vo=new UsersVo();
        vo.setId(username);
        vo.setAccountNo(username);
        vo.setPassword(password);

        if (userService.IsLogin(vo))
        {
            //设置session
            HttpSession session=getSession();
            session.setAttribute("user",vo);
            return "success";
        }else
        {
            return "error";
        }
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
