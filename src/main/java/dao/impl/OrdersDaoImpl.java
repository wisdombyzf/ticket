package dao.impl;

import dao.OrdersDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import po.FlightsPo;
import po.OrdersPo;

import java.util.List;

@Repository("OrdersDao")
public class OrdersDaoImpl extends BaseDaoImpl<OrdersPo> implements OrdersDao
{
    /**
     * 获取某位乘客的所有订单记录
     *
     * @param id
     * @return
     */
    public List<OrdersPo> getOrderListByUser(String id)
    {
        return findByHQL("from OrdersPo where userId like '"+id+"'");
    }

    /**
     * 获取所有订单记录
     *
     * @return
     */
    public List<OrdersPo> getAllOrderList()
    {
        return findByHQL("from OrdersPo");
    }


}
