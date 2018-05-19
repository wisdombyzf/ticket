package Service;


import dao.FlightsDao;
import dao.OrdersDao;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.FlightsPo;
import po.OrdersPo;
import vo.OrdersVo;

import java.lang.reflect.InvocationTargetException;

/**
 * 订单服务类
 */
@Service
public class OrderService
{
    @Autowired
    OrdersDao ordersDao;
    @Autowired
    FlightsDao flightsDao;
    /**
     * 添加订单信息
     *
     * @param vo
     * @return
     */
    public boolean AddOrders(OrdersVo vo)
    {
        OrdersPo po = new OrdersPo();
        try
        {
            BeanUtils.copyProperties(po, vo);
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        //进行座位数量判定

        String flightID= po.getOrderitemId();
        FlightsPo flightPo = flightsDao.findById(flightID);
        int leftSeat=flightPo.getSeatLeft();
        if (leftSeat<1)
        {
            return false;
        }else
        {
            //将剩余座位减一

            leftSeat--;
            flightPo.setSeatLeft(leftSeat);
            flightsDao.update(flightPo);
            ordersDao.save(po);
        }
        return true;
    }


}
