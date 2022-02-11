package util.JwtUtil;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    /**
     * 这个方法在HandlerMapping找到对应的处理对象,但还没有请求这个对象时处理
     * 也就是在Controller的方法之前执行
     *  @param request
     * @param response
     * @param handler  这个参数就是代码着Controller的方法
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        if (!(handler instanceof HandlerMethod)) {
//            return true;
//        }
//
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        Method method = handlerMethod.getMethod();
//
//
//        if(method.isAnnotationPresent(Myzhu.class)){
//            //判断方法上是否打标签
//
//                StringBuffer requestURL = request.getRequestURL();
//                System.out.println("不需要登录校验");
//                System.out.println("前置拦截器1 preHandle： 请求的uri为："+requestURL.toString());
//                return true;
//
//        }else{
//            String token=request.getHeader("token");
////        System.out.println(token);
//            JwtUtil jwtUtil =new JwtUtil();
//            if (jwtUtil.checkToken(token)){
////                System.out.println(1);
//                return true;
//            }else{
//                HashMap<String, Object> map = new HashMap<String, Object>();
//                map.put("code",101);
//                map.put("msg","token无效!");
//                String json = new ObjectMapper().writeValueAsString(map);
//                response.setContentType("application/json; charset=UTF-8");
//                response.getWriter().println(json);
//
//                return false;
//            }
//
//        }




        System.out.println("这是拦截");
        return true;
    }

    /**
     * 在Handler/controller的方法处理完逻辑,渲染视图之前执行
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在视图渲染完之后执行,常用于资源清理等等
     *
     * @param request
     * @param response
     * @param handler
     * @param e
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {

    }

}

