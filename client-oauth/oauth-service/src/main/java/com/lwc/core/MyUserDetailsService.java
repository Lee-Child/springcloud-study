//package com.lwc.core;
//
//import com.lwc.bo.UserBo;
//import com.lwc.user.api.UserApi;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserApi userApi;
//
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("收到的账号"+username);
//        UserBo userBo = userApi.selectByUsername(username);
//        if(userBo == null) {
//            throw new RuntimeException("登录账号不存在");
//        }
//        System.out.println("查到的密码"+ userBo.getPassword());
//        return new User(username, userBo.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
//    }
//}
