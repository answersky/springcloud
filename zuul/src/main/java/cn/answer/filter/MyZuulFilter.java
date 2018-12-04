package cn.answer.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * created by liufeng
 * 2018/12/4
 */
@Component
public class MyZuulFilter extends ZuulFilter {

    private Logger logger=LoggerFactory.getLogger(MyZuulFilter.class);

    /**
     * 返回过滤器的类型 ：
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext context=RequestContext.getCurrentContext();
        HttpServletRequest request=context.getRequest();
        String path=request.getServletPath();
        //true 请求还是会继续访问，false 请求将不再继续访问
        context.setSendZuulResponse(false);
        context.setResponseStatusCode(201);
        try {
            context.getResponse().getOutputStream().write(("request path is:"+path+"\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
