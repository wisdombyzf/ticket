package dao.impl;

import dao.UsersDao;
import org.springframework.stereotype.Repository;
import po.FlightsPo;
import po.UsersPo;

import java.util.List;


@Repository("UsersDao")
public class UsersDaoImpl extends BaseDaoImpl<UsersPo> implements UsersDao
{
    /**
     * 获取乘客表中的所有乘客记录
     *
     * @return
     */
    public List<UsersPo> getAllUserList()
    {
        return findByHQL("from UsersPo");
    }
}
