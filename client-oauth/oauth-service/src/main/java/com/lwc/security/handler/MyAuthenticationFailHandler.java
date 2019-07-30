package com.lwc.security.handler;

import cn.hutool.json.JSONUtil;
import com.lwc.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义登录失败处理器
 * Created by Fant.J.
 */
@Component
@Slf4j
public class MyAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        log.info("登录失败");
        //设置状态码
        response.setStatus(401);
        response.setContentType("application/json;charset=UTF-8");
        //将 登录失败 信息打包成json格式返回
        response.getWriter().write(JSONUtil.toJsonStr(Result.FAILED(exception.getMessage())));
    }
}
