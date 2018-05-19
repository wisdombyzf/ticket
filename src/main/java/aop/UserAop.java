package aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;


public class UserAop
{

    public void begin()
    {
        System.out.println("执行之前");
    }


}
