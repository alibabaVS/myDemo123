package com.example.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * PackageName:com.example.apigateway
 * ClassName: AccessFilter
 *
 * @author zha.jiangjiang
 * @Description:
 * @Date: 2018/10/6 14:15
 * @see
 * @since JDK 1.8
 */
public class AccessFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * to classify a filter by type. Standard types in Zuul are "pre" for pre-routing filtering,
     * "route" for routing to an origin, "post" for post-routing filters, "error" for error handling.
     * We also support a "static" type for static responses see  StaticResponseFilter.
     * Any filterType made be created or added and run by calling FilterProcessor.runFilters(type)
     *
     * @return A String representing that type
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filterOrder() must also be defined for a filter. Filters may have the same  filterOrder if precedence is not
     * important for a filter. filterOrders do not need to be sequential.
     *
     * @return the int order of a filter
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * a "true" return from this method means that the run() method should be invoked
     *
     * @return true if the run() method should be invoked. false will not invoke the run() method
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * if shouldFilter() is true, this method will be invoked. this method is the core method of a ZuulFilter
     *
     * @return Some arbitrary artifact may be returned. Current implementation ignores it.
     * @throws ZuulException if an error occurs during execution.
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx =RequestContext.getCurrentContext();
        HttpServletRequest requeset = ctx.getRequest();
        logger.info("send {} request to {}, >>>>>>>>>>>>>>>>>>>>>>>>>>>>",requeset.getMethod(),requeset.getRequestURL().toString() );
        Object accessToken = requeset.getParameter("accessToken");
        if (accessToken == null) {
            logger.info("access token is empty>>>>>>>>>>>>>>>>>>>>>>>>>>");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        logger.info("access token ok, >>>>>>>>>>>>>>>>>>>>>>>>>>>>" );
        return null;
    }
}
