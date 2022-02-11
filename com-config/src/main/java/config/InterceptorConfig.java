package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import util.JwtUtil.AuthenticationInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticationInterceptor())
                // 只拦截test路径
                .addPathPatterns("/**")
                // 不拦截pass路径
                .excludePathPatterns("/pass/**");
    }

    /**
     * 添加一些虚拟路径的映射
     * 静态资源路径和上传文件的路径
     *
     * @param registry
     *
     */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * @Description: 对文件的路径进行配置, 创建一个虚拟路径/Path/** ，即只要在< img src="/Path/picName.jpg" />便可以直接引用图片
         *这是图片的物理路径  "file:/+本地图片的地址"
         */
//轮播图
        registry.addResourceHandler("/Path2/**").addResourceLocations("file:/D:/java/uploadImg/lunbo/");
//        头像
        registry.addResourceHandler("/Path/**").addResourceLocations("file:/D:/java/uploadImg/title/");
        registry.addResourceHandler("/video/**").addResourceLocations("file:/D:/java/uploadImg/video/");
    }



}

