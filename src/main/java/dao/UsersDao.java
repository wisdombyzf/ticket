package dao;

import po.FlightsPo;
import po.UsersPo;

import java.util.List;

public interface UsersDao extends BaseDao<UsersPo>
{
    /**
     * 获取乘客表中的所有乘客记录
     * @return
     */
    List<UsersPo> getAllUserList();
}
