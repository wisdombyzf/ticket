package action.admin;

import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vo.UsersVo;

@Controller
public class DeleteUser
{

    private String userAccountNo;

    @Autowired
    UserService userService;

    /**
     * 删除对应用户
     * @return
     */
    public String deleteUser()
    {
        UsersVo vo=new UsersVo();
        vo.setAccountNo(userAccountNo);
        userService.deleteUser(vo);
        return "success";
    }

    public void setUserAccountNo(String userAccountNo)
    {
        this.userAccountNo = userAccountNo;
    }
}
