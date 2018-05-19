package action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 封装的一个BaseAction 异常处理等待完成。。。不太会。。好迷
 */
public class BaseAction extends ActionSupport
{

    public HttpServletRequest getRequest()
    {
        return ServletActionContext.getRequest();
    }


    public HttpServletResponse getResponse()
    {
        return ServletActionContext.getResponse();
    }


    public HttpSession getSession()
    {
        return getRequest().getSession();
    }

    public ServletContext getServletContext()
    {
        return ServletActionContext.getServletContext();
    }

}
