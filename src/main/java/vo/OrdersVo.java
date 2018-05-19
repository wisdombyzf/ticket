package vo;


import javax.persistence.Basic;
import javax.persistence.Column;

public class OrdersVo
{
    private String userId;
    private String orderitemId;
    private String confirm;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getOrderitemId()
    {
        return orderitemId;
    }

    public void setOrderitemId(String orderitemId)
    {
        this.orderitemId = orderitemId;
    }

    public String getConfirm()
    {
        return confirm;
    }

    public void setConfirm(String confirm)
    {
        this.confirm = confirm;
    }
}
