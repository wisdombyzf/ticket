package action.admin;


import Service.FlightService;
import action.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Commit;
import util.SpringBeanFactory;
import vo.FlightsVo;

/**
 * 添加航班
 */
@Controller
public class AddFlight extends BaseAction
{
    private String id;
    private String flightNo;
    private String startPlace;
    private String endPlace;
    private String time;
    private double price;
    private int seatLeft;
    private String endTime;
    private String discount;

    @Autowired
    FlightService flightService;

    public String execute() throws Exception
    {
        FlightsVo vo=new FlightsVo();
        vo.setId(id);
        vo.setEndPlace(endPlace);
        vo.setFlightNo(flightNo);
        vo.setPrice(price);
        vo.setTime(time);
        vo.setStartPlace(startPlace);
        vo.setSeatLeft(seatLeft);
        vo.setEndTime(endTime);
        vo.setDiscount(discount);
        if (flightService.AddFlight(vo))
        {
            System.out.println("航班添加成功");
            return "success";
        }else
        {
            return "error";
        }
    }



    public void setId(String id)
    {
        this.id = id;
    }

    public void setFlightNo(String flightNo)
    {
        this.flightNo = flightNo;
    }

    public void setStartPlace(String startPlace)
    {
        this.startPlace = startPlace;
    }

    public void setEndPlace(String endPlace)
    {
        this.endPlace = endPlace;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setSeatLeft(int seatLeft)
    {
        this.seatLeft = seatLeft;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public void setDiscount(String discount)
    {
        this.discount = discount;
    }
}
