package po;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class OrdersPoPK implements Serializable
{
    private String userId;
    private String orderitemId;

    @Column(name = "USER_ID", nullable = false, length = 20)
    @Id
    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    @Column(name = "ORDERITEM_ID", nullable = false, length = 20)
    @Id
    public String getOrderitemId()
    {
        return orderitemId;
    }

    public void setOrderitemId(String orderitemId)
    {
        this.orderitemId = orderitemId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersPoPK that = (OrdersPoPK) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (orderitemId != null ? !orderitemId.equals(that.orderitemId) : that.orderitemId != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (orderitemId != null ? orderitemId.hashCode() : 0);
        return result;
    }
}
