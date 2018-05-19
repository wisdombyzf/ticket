package dao;

import po.FlightsPo;
import po.OrdersPo;

import java.util.List;

public interface OrdersDao extends BaseDao<OrdersPo>
{
    /**
     * 获取某位乘客的所有订单记录
     * @return
     */
    List<OrdersPo> getOrderListByUser(String id);
}
