package dao.impl;

import dao.FlightsDao;
import org.springframework.stereotype.Repository;
import po.FlightsPo;
import vo.FlightsVo;

import java.util.List;

@Repository("FlightsDao")
public class FlightsDaoImpl extends BaseDaoImpl<FlightsPo> implements FlightsDao
{
    /**
     * 获取航班表中的所有航班记录
     *
     * @return
     */
    public List<FlightsPo> getAllFlightList()
    {
        return findByHQL("from FlightsPo");
    }
}
