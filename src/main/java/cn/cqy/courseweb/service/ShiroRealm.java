package cn.cqy.courseweb.service;

import cn.cqy.courseweb.repository.UserRepository;
import cn.cqy.courseweb.domain.Permission;
import cn.cqy.courseweb.domain.Role;
import cn.cqy.courseweb.domain.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserRepository userRepository;

    /**
     * 登陆认证，最后一步是自动验证密码
     *
     * @param authenticationToken
     * @return AuthenticationInfo
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //查出是否有此用户

        String username = token.getUsername();
        User user = userRepository.findUserByUsername(username);
        //存在此用户时验证密码

        if (user != null) {
            return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        }
        return null;
    }

    /**
     * 验证权限，在用户权限信息里面添加用户角色与权限信息
     *
     * @param principalCollection
     * @return authorrizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //查找用户是否存在
        User user = (User) principalCollection.getPrimaryPrincipal();
        //用户存在时，添加用户的角色和权限信息，可根据角色或权限来控制用户可访问内容。
        if (user != null) {
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            Role role = user.getRole();
            authorizationInfo.addRole(role.getName());
            for (Permission permission : role.getPermissions()) {
                authorizationInfo.addStringPermission(permission.getName());
            }
            return authorizationInfo;
        }
        return null;
    }
}
