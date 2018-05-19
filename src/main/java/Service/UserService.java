package Service;

import dao.FlightsDao;
import dao.OrdersDao;
import dao.UsersDao;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.OrdersPo;
import po.UsersPo;
import vo.FlightsVo;
import vo.UsersVo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    UsersDao usersDao;
    @Autowired
    FlightsDao flightsDao;
    @Autowired
    OrdersDao ordersDao;


    /**
     * 能否权限登陆
     *
     * @param vo
     * @return
     */
    public boolean IsLogin(UsersVo vo)
    {
        UsersPo usersPo = usersDao.findById(vo.getId());
        if (usersPo == null || !usersPo.getPassword().equals(vo.getPassword()))
        {
            return false;
        } else
        {
            return true;
        }
    }


    /**
     * 查看到自己订单后的订单信息情况
     *
     * @param usersVo
     * @return
     */
    public List<OrdersPo> getOrdersList(UsersVo usersVo)
    {
        String key = usersVo.getAccountNo();
        return ordersDao.getOrderListByUser(key);
    }


    /**
     * 查看到自己订单后的详细航班信息情况
     *
     * @param usersVo
     * @return
     */
    public List<FlightsVo> getUserFlightList(UsersVo usersVo)
    {
        List<OrdersPo> list = getOrdersList(usersVo);
        List<FlightsVo> flightsPoList=new ArrayList<FlightsVo>();
        for (OrdersPo po:list)
        {
            FlightsVo vo=new FlightsVo();
            //po转vo
            try
            {
                BeanUtils.copyProperties(vo,flightsDao.findById(po.getOrderitemId()));
            } catch (IllegalAccessException e)
            {
                e.printStackTrace();
            } catch (InvocationTargetException e)
            {
                e.printStackTrace();
            }
            flightsPoList.add(vo);
        }
        return flightsPoList;
    }


    /**
     * 获取乘客表
     * @return
     */
    public List<UsersVo> getUserList()
    {
        List<UsersPo> pos=usersDao.getAllUserList();
        List<UsersVo> vos=new ArrayList<UsersVo>();
        for (UsersPo po:pos)
        {
            try
            {
                UsersVo vo=new UsersVo();
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

    /**
     * 添加用户信息
     *
     * @param vo
     * @return
     */
    public boolean AddUser(UsersVo vo)
    {
        UsersPo po = new UsersPo();
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
        usersDao.save(po);
        return true;
    }


    /**
     * 删除对应用户账户
     * @param vo
     * @return
     */
    public boolean deleteUser(UsersVo vo)
    {
        usersDao.delete(vo.getAccountNo());
        return true;
    }
}
