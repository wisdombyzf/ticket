package action;

import Service.FlightService;
import Service.UserService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import util.SpringBeanFactory;
import vo.FlightsVo;
import vo.UsersVo;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class GetData extends BaseAction
{

    @Autowired
    FlightService flightService;
    @Autowired
    UserService userService;


    public PrintWriter ini() throws IOException
    {
        HttpServletResponse response = getResponse();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),"utf-8"),true);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        return out;
    }

    /**
     * 获取所有航班列表
     * @return
     * @throws IOException
     */
    public String getAllFligh() throws IOException
    {
        PrintWriter out=ini();
        List<FlightsVo> vos =flightService.getAllFlightList();
        JSONArray jsonArray=new JSONArray();
        for (FlightsVo vo:vos)
        {
            jsonArray.add(vo);
        }
        out.print(jsonArray);
        out.flush();
        out.close();
        return "success";
    }


    /**
     * 获取乘客列表
     * @return
     * @throws IOException
     */
    public String getUserList() throws IOException
    {

        //进行权限检测

        PrintWriter out=ini();
        List<UsersVo> vos =userService.getUserList();
        JSONArray jsonArray=new JSONArray();
        for (UsersVo vo:vos)
        {
            jsonArray.add(vo);
        }
        out.print(jsonArray);
        out.flush();
        out.close();
        System.out.println("管理员获取乘客列表成功");
        return "success";
    }

}
