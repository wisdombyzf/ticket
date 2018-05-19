package dao;

import po.FlightsPo;

import java.util.List;

public interface FlightsDao extends BaseDao<FlightsPo>
{
    /**
     * 获取航班表中的所有航班记录
     * @return
     */
    List<FlightsPo> getAllFlightList();
}
