package action.user;

import Service.OrderService;
import Service.UserService;
import action.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vo.OrdersVo;
import vo.UsersVo;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

@Controller
public class DeleteOrder extends BaseAction
{
    private String username;
    private String password;
    private String flightId;
    private String userAccountNo;

    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;



    /**
     * PrintWriter初始化
     * @return
     * @throws IOException
     */
    public PrintWriter ini() throws IOException
    {
        HttpServletResponse response = getResponse();
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"utf-8"),true);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        return printWriter;
    }



    /**
     * 取消航班
     * @return
     */
    public String deleteOrder()
    {
        OrdersVo vo=new OrdersVo();
        HttpSession session=getSession();
        UsersVo usersVo=(UsersVo)session.getAttribute("user");
        vo.setUserId(usersVo.getAccountNo());
        vo.setOrderitemId(flightId);
        orderService.deleteOrders(vo);
        return "success";
    }




    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }


    public void setFlightId(String flightId)
    {
        this.flightId = flightId;
    }

    public void setUserAccountNo(String userAccountNo)
    {
        this.userAccountNo = userAccountNo;
    }


}
