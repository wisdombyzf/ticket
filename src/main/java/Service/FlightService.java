package Service;

import dao.FlightsDao;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.FlightsPo;
import vo.FlightsVo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


/**
 * 航班service类
 */
@Service
public class FlightService
{

    @Autowired
    FlightsDao flightsDao;
    /**
     * 添加航班信息
     *
     * @param vo
     * @return
     */
    public boolean AddFlight(FlightsVo vo)
    {
        FlightsPo po = new FlightsPo();
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
        flightsDao.save(po);
        return true;
    }

    /**
     * 删除对应航班
     * @param vo
     * @return
     */
    public boolean deleteFlight(FlightsVo vo)
    {
        flightsDao.delete(vo.getId());
        return true;
    }

    /**
     * 返回航班列表
     * @return
     */
    public List<FlightsVo> getAllFlightList()
    {
        List<FlightsPo> pos= flightsDao.getAllFlightList();
        List<FlightsVo> vos=new ArrayList<FlightsVo>();
        for (FlightsPo po:pos)
        {
            try
            {
                FlightsVo vo=new FlightsVo();
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
