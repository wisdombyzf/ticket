package dao;

import java.io.Serializable;
import java.util.List;

/**
 * dao层基类，实现增删改查
 *
 * @param <T>
 * @author zf
 */
public interface BaseDao<T>
{

    /**
     * 添加一个对象
     *
     * @param entity 对象实体
     */
    void save(T entity);

    /**
     * 更新一个对象，所有属性
     *
     * @param entity 对象实体
     */
    void update(T entity);

    /**
     * 更新一个对象，部分属性
     *
     * @param id     id
     * @param names  键
     * @param values
     */
    void partUpdate(int id, String[] names, Object[] values);


    /**
     * 删除一个对象
     *
     * @param id
     */
    void delete(Serializable id);


    /**
     * 根据id查找一个对象
     *
     * @param id
     * @return
     */
    T findById(Serializable id);

    /**
     * 根据HQL返回对象List
     *
     * @param hql
     * @param params
     * @return
     */
    List<T> findByHQL(String hql, Object... params);

    /**
     * 分页查询
     *
     * @param hql
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<T> queryPage(String hql, int pageNo, int pageSize);
}
