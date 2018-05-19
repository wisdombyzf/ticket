package action.admin;

import Service.UserService;
import action.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import util.SpringBeanFactory;
import vo.UsersVo;

@Controller
public class AddUser extends BaseAction
{
    private String id;
    private String accountNo;
    private String name;
    private String password;
    private String sex;
    private String phone;
    private String email;

    @Autowired
    UserService userService;

    public String execute() throws Exception
    {
        UsersVo vo=new UsersVo();
        vo.setAccountNo(accountNo);
        vo.setId(id);
        vo.setPassword(password);
        vo.setEmail(email);
        vo.setPhone(phone);
        vo.setName(name);
        vo.setSex(sex);

        userService.AddUser(vo);
        return "success";
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setAccountNo(String accountNo)
    {
        this.accountNo = accountNo;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
