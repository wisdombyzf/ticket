package Service;

import dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.AdminPo;
import vo.AdminVo;

/**
 * 管理员服务类
 */

@Service
public class AdminService
{
    @Autowired
    AdminDao adminDao;
    public AdminService()
    {
    }


    /**
     * 能否以管理员权限登陆
     *
     * @param vo
     * @return
     */
    public boolean IsLogin(AdminVo vo)
    {
        AdminPo adminPo = adminDao.findById(vo.getId());
        if (adminPo == null || !adminPo.getPassword().equals(vo.getPassword()))
        {
            return false;
        } else
        {
            return true;
        }
    }

}
