package cn.cqy.courseweb.service;

import cn.cqy.courseweb.repository.UserRepository;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

public class CredentialsMatcher extends SimpleCredentialsMatcher {
    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken utoken=(UsernamePasswordToken)token;
        String username=new String(utoken.getUsername());
        String inPassword=new String(utoken.getPassword());
        String dbPassword=userRepository.findUserByUsername(username).getPassword();
        return this.equals(inPassword,dbPassword);
    }
}
