package dao.impl;

import dao.AdminDao;
import org.springframework.stereotype.Repository;
import po.AdminPo;


@Repository("AdminDao")
public class AdminDaoImpl extends BaseDaoImpl<AdminPo> implements AdminDao
{

}
