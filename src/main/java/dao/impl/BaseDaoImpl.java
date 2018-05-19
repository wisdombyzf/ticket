package dao.impl;

import dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * dao基类实现类
 *
 * @param <T>
 * @author zf
 * @date 2017/4/3
 */
//TODO 操作是否成功。。。是否应该返回？
public class BaseDaoImpl<T> implements BaseDao<T>
{

    private Class<T> clazz;
    Configuration config;
    SessionFactory sessionFactory;

    /**
     * 通过构造方法指定DAO的具体实现类
     * 通过反射机制获取DAO实现类的泛型具体类型。。。mark一下
     */
    public BaseDaoImpl()
    {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
        //System.out.println("DAO的真实实现类是："+this.clazz.getName());
        //TODO 是不是应该自己建一个静态的hibernateFactory类？
        config = new Configuration().configure();
        sessionFactory = config.buildSessionFactory();
    }

    /**
     * 获取一个session
     *
     * @return session
     */
    private Session getSession()
    {
        return sessionFactory.openSession();
    }

    /**
     * 添加一个对象
     *
     * @param entity 对象实体
     */
    public void save(T entity)
    {
        Session session = null;
        Transaction tx = null;
        try
        {
            session = this.getSession();
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        } catch (Exception ex)
        {
            System.out.println("保存对象出现错误！");
            ex.printStackTrace();
            if (tx != null)
            {
                tx.rollback();
            }
        } finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }

    /**
     * 更新一个对象，所有属性
     *
     * @param entity 对象实体
     */
    public void update(T entity)
    {
        Session session = null;
        Transaction tx = null;
        try
        {
            session = this.getSession();
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        } catch (Exception ex)
        {
            System.out.println("更新对象出现错误！");
            ex.printStackTrace();
            if (tx != null)
            {
                tx.rollback();
            }
        } finally
        {
            if (session != null)
            {
                session.close();
            }
        }

    }

    /**
     * 更新一个对象，部分属性
     *
     * @param id     id
     * @param names  键
     * @param values
     */
    public void partUpdate(int id, String[] names, Object[] values)
    {
        Session session = null;
        Transaction tx = null;
        try
        {
            //不太会
            session = this.getSession();
            tx = session.beginTransaction();

            String tab = clazz.getSimpleName();
            String hql = "update " + tab + " t";
            for (int i = 0; i < names.length; i++)
            {
                hql += " set t." + names[i] + "=?";
            }
            hql += " where t.id=" + id;
            Query query = session.createQuery(hql);
            for (int i = 0; i < values.length; i++)
            {
                query.setParameter(i, values[i]);
            }
            System.out.println("部分更新：" + hql);
            query.executeUpdate();
            tx.commit();

        } catch (Exception ex)
        {
            System.out.println("更新对象部分属性出现错误！");
            ex.printStackTrace();
            if (tx != null)
            {
                tx.rollback();
            }
        } finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }

    /**
     * 删除一个对象
     *
     * @param id
     */
    public void delete(Serializable id)
    {
        T obj = findById(id);

        Session session = null;
        Transaction tx = null;
        try
        {
            session = this.getSession();
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (Exception ex)
        {
            System.out.println("删除对象出现错误！");
            ex.printStackTrace();
            if (tx != null)
            {
                tx.rollback();
            }
        } finally
        {
            if (session != null)
            {
                session.close();
            }
        }
    }

    /**
     * 根据id查找一个对象
     *
     * @param id
     * @return
     */
    public T findById(Serializable id)
    {
        Session session = null;
        Transaction tx = null;
        T obj = null;
        try
        {
            session = this.getSession();
            tx = session.beginTransaction();

            obj = (T) session.get(clazz, id);

            tx.commit();
        } catch (Exception ex)
        {
            System.out.println("查找对象出现错误！");
            ex.printStackTrace();
            if (tx != null)
            {
                tx.rollback();
            }
        } finally
        {
            if (session != null)
            {
                session.close();
            }
        }
        return obj;
    }


    /**
     * 根据HQL返回对象List
     *
     * @param hql
     * @param params
     * @return
     */
    public List<T> findByHQL(String hql, Object... params)
    {
        List<T> list = null;
        Session session = null;
        Transaction tx = null;
        try
        {
            session = this.getSession();
            tx = session.beginTransaction();

            Query query = session.createQuery(hql);
            for (int i = 0; params != null && i < params.length; i++)
            {
                query.setParameter(i, params[i]);
            }
            System.out.println("HQL查询：" + hql);
            list = query.list();

            tx.commit();

        } catch (Exception ex)
        {
            System.out.println("执行HQL查找对象出现错误！");
            ex.printStackTrace();
            if (tx != null)
            {
                tx.rollback();
            }
        } finally
        {
            if (session != null)
            {
                session.close();
            }
        }
        return list;
    }

    /**
     * 分页查询
     *
     * @param hql
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<T> queryPage(String hql, int pageNo, int pageSize)
    {
        List<T> list = null;
        Session session = null;
        Transaction tx = null;
        try
        {
            session = this.getSession();
            tx = session.beginTransaction();

            Query query = session.createQuery(hql);
            list = query.setFirstResult((pageNo - 1) * pageSize)
                    .setMaxResults(pageSize)
                    .list();

            tx.commit();
        } catch (Exception ex)
        {
            System.out.println("分页查询出现错误出现错误！");
            ex.printStackTrace();
            if (tx != null)
            {
                tx.rollback();
            }
        } finally
        {
            if (session != null)
            {
                session.close();
            }
        }
        return list;
    }


}
