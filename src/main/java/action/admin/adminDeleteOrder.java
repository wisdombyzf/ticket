package action.admin;

import Service.OrderService;
import action.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vo.OrdersVo;

@Controller
public class adminDeleteOrder extends BaseAction
{
    @Autowired
    OrderService orderService;

    private String userId;
    private String orderitemId;


    public String deleteOrders()
    {
        OrdersVo vo=new OrdersVo();
        vo.setUserId(userId);
        vo.setOrderitemId(orderitemId);
        orderService.deleteOrders(vo);
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

