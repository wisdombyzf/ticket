package action.admin;

import Service.AdminService;
import Service.FlightService;
import Service.UserService;
import action.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import util.SpringBeanFactory;
import vo.AdminVo;
import vo.FlightsVo;
import vo.UsersVo;

import java.util.List;


/**
 * 管理员
 */
@Controller
public class DeleteFlight extends BaseAction
{

    private String flightId;

    @Autowired
    FlightService flightService;



    /**
     * 删除航班
     * @return
     */
    public String deleteFlight()
    {
        FlightsVo vo=new FlightsVo();
        vo.setId(flightId);
        flightService.deleteFlight(vo);
        return "success";
    }


    public void setFlightId(String flightId)
    {
        this.flightId = flightId;
    }
}
