package dao;

import po.FlightsPo;
import po.OrdersPo;

import java.io.Serializable;
import java.util.List;

public interface OrdersDao extends BaseDao<OrdersPo>
{
    /**
     * 获取某位乘客的所有订单记录
     * @return
     */
    List<OrdersPo> getOrderListByUser(String id);

    /**
     * 获取所有订单记录
     * @return
     */
    List<OrdersPo> getAllOrderList();

    /**
     * 删除一个对象
     *
     * @param po
     */
    //void delete(OrdersPo po);
}
