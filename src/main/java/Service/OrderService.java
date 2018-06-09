package Service;


import dao.FlightsDao;
import dao.OrdersDao;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.FlightsPo;
import po.OrdersPo;
import po.OrdersPoPK;
import vo.FlightsVo;
import vo.OrdersVo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

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


    /**
     * 退票
     *
     * @param vo
     * @return
     */
    public boolean deleteOrders(OrdersVo vo)
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

        ordersDao.delete(po);
        //座位加一
        String flightID= po.getOrderitemId();
        FlightsPo flightPo = flightsDao.findById(flightID);
        int leftSeat=flightPo.getSeatLeft();
        leftSeat++;
        flightPo.setSeatLeft(leftSeat);
        flightsDao.update(flightPo);
        System.out.println("预定航班取消成功");
        return true;
    }

    /**
     * 获取所有订单
     * @return
     */
    public List<OrdersVo> getAllOrderList()
    {
        List<OrdersPo> pos = ordersDao.getAllOrderList();
        List<OrdersVo> vos= new ArrayList<OrdersVo>();
        for (OrdersPo po:pos)
        {
            try
            {
                OrdersVo vo=new OrdersVo();
                BeanUtils.copyProperties(vo,po);
                vos.add(vo);
            } catch (IllegalAccessException e)
            {
                e.printStackTrace();
            } catch (InvocationTargetException e)
            {
                e.printStackTrace();
            }
        }
        return vos;
    }

}
