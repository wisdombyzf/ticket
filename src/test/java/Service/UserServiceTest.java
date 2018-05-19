package Service;

import org.junit.Test;
import vo.FlightsVo;
import vo.UsersVo;

import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest
{

    @Test
    public void getUserFlightList()
    {
        UserService service=new UserService();
        UsersVo vo=new UsersVo();
        vo.setAccountNo("1");
        List<FlightsVo> temp = service.getUserFlightList(vo);
        System.out.println(temp);
    }
}