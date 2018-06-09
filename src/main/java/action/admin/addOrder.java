package action.admin;

import Service.OrderService;
import action.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vo.OrdersVo;
import vo.UsersVo;

@Controller
public class addOrder extends BaseAction
{
    @Autowired
    OrderService orderService;

    private String userId;
    private String orderitemId;


    public String addOrders()
    {
        OrdersVo vo=new OrdersVo();
        vo.setUserId(userId);
        vo.setOrderitemId(orderitemId);
        orderService.AddOrders(vo);
        return "success";
    }


    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void setOrderitemId(String orderitemId)
    {
        this.orderitemId = orderitemId;
    }
}
