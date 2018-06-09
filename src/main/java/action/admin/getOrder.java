package action.admin;

import Service.OrderService;
import action.BaseAction;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vo.FlightsVo;
import vo.OrdersVo;
import vo.UsersVo;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class getOrder extends BaseAction
{
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
     * 获取该所有订单
     * @return
     * @throws IOException
     */
    public String getorders() throws IOException
    {
        List<OrdersVo> vos = orderService.getAllOrderList();
        PrintWriter out=ini();
        JSONArray jsonArray=new JSONArray();
        for (OrdersVo vo:vos)
        {
            jsonArray.add(vo);
        }
        out.print(jsonArray);
        out.flush();
        out.close();
        System.out.println("管理员获取所有订单成功");
        return "success";
    }

}
