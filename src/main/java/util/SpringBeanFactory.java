package util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * spring 上下文工具类
 * 可获取spring的bean和ApplicationContext
 */
public class SpringBeanFactory implements ApplicationContextAware
{

    public static ApplicationContext context = null;

    //@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        if (context == null)
        {
            context = applicationContext;
        }
        System.out.println("ApplicationContext 已设置");
    }

    public static ApplicationContext getApplicationContext()
    {

        if (context == null)
        { //本地调试
            context = new ClassPathXmlApplicationContext("application.xml");
        }
        return context;

    }

    /**
     * 根据类名来获取对应bean
     *
     * @param name
     * @return
     */
    public static Object getBean(String name)
    {
        if (context == null)
        {
            context = getApplicationContext();
        }
        return context.getBean(name);
    }

    /**
     * 通过类型获取上下文中的bean
     *
     * @param requiredType
     * @return
     */
    public static <T> T getBean(Class<T> requiredType)
    {
        if (context==null)
        {
            context=getApplicationContext();
        }
        return context.getBean(requiredType);
    }


}