package action.user;

import Service.OrderService;
import Service.UserService;
import action.BaseAction;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vo.FlightsVo;
import vo.UsersVo;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class GetFlight extends BaseAction
{

    @Autowired
    UserService userService;

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
     * 获取该乘客的所有订单
     * @return
     * @throws IOException
     */
    public String getFlight() throws IOException
    {
        HttpSession session=getSession();
        UsersVo usersVo= (UsersVo) session.getAttribute("user");
        List<FlightsVo> vos = userService.getUserFlightList(usersVo);

        PrintWriter out=ini();
        JSONArray jsonArray=new JSONArray();
        for (FlightsVo vo:vos)
        {
            jsonArray.add(vo);
        }
        out.print(jsonArray);
        out.flush();
        out.close();
        System.out.println("乘客获取订单成功");
        return "success";
    }

}
