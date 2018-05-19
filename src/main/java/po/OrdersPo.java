package po;

import javax.persistence.*;

@Entity
@Table(name = "orders", schema = "orderticket", catalog = "")
@IdClass(OrdersPoPK.class)
public class OrdersPo
{
    private String userId;
    private String orderitemId;
    private String confirm;

    @Id
    @Column(name = "USER_ID", nullable = false, length = 20)
    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    @Id
    @Column(name = "ORDERITEM_ID", nullable = false, length = 20)
    public String getOrderitemId()
    {
        return orderitemId;
    }

    public void setOrderitemId(String orderitemId)
    {
        this.orderitemId = orderitemId;
    }

    @Basic
    @Column(name = "confirm", nullable = true, length = 255)
    public String getConfirm()
    {
        return confirm;
    }

    public void setConfirm(String confirm)
    {
        this.confirm = confirm;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersPo ordersPo = (OrdersPo) o;

        if (userId != null ? !userId.equals(ordersPo.userId) : ordersPo.userId != null) return false;
        if (orderitemId != null ? !orderitemId.equals(ordersPo.orderitemId) : ordersPo.orderitemId != null)
            return false;
        if (confirm != null ? !confirm.equals(ordersPo.confirm) : ordersPo.confirm != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (orderitemId != null ? orderitemId.hashCode() : 0);
        result = 31 * result + (confirm != null ? confirm.hashCode() : 0);
        return result;
    }
}
