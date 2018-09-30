package com.zou.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.zou.entity.SLogin;
import com.zou.entity.SPermission;
import com.zou.mapper.SLoginMapper;
import com.zou.redis.RedisCacheUtil;
import com.zou.shiro.util.JWTUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 *
 * @Author zou 1195447819@qq.com
 * @Description 自定义 Realm
 * @Date 2018-04-09
 * @Time 16:58
 */
@Component
public class CustomRealm extends AuthorizingRealm {
	
    @Autowired
    @Lazy//懒加载,不然用不了
    private SLoginMapper sLoginMapper;
	@Autowired
    public RedisTemplate<String, ?> redisTemplate;
	@Autowired
	private RedisCacheUtil<?> redisCacheUtil;
    
    public static final Logger logger = LoggerFactory.getLogger(CustomRealm.class);

    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws UnauthenticatedException{
//      System.out.println("————身份认证方法————");
        String token = (String) authenticationToken.getCredentials();
//      解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        System.out.println(username);
        if (username == null || !JWTUtil.verify(token, username)) {
//        	logger.info("token认证失败！");
			throw new AuthenticationException("token认证失败！");
        }
        SLogin pwd=sLoginMapper.SelectLogin(Long.valueOf(username));
        Long phone = pwd.getUserIphone();
        if (phone == null) {
				throw new AuthenticationException("该用户不存在！");
        }
//        int ban = userMapper.checkUserBanStatus(username);
//        if (ban == 1) {
//            throw new AuthenticationException("该用户已被封号！");
//        }
        return new SimpleAuthenticationInfo(token, token, "MyRealm");
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	logger.info("开始鉴权");
        String user_iphone = JWTUtil.getUsername(principals.toString());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        //需要将 role, permission 封装到 Set 作为 info.setRoles(), info.setStringPermissions() 的参数
        //redis存储
        String role = sLoginMapper.SelectRole(Long.valueOf(user_iphone));//分配角色
        logger.info("你的角色是:"+role);
        Set<String> roleSet = new HashSet<>();
        roleSet.add(role);
        logger.info("鉴权开始"+principals.toString());
        Set<String> permissionSet = new HashSet<>();
//        if(redisTemplate.hasKey(user_iphone)) {
//        	List<SPermission> SelectPermission=redisCacheUtil.getCacheList(user_iphone);
//        	for(SPermission sPermission:SelectPermission) {
//            	permissionSet.add(sPermission.getPermission());
//            }
//        }else {
//            List<SPermission> SelectPermission=sLoginMapper.SelectPermission(Long.valueOf(user_iphone));//拿权
//            redisCacheUtil.setCacheList(user_iphone,SelectPermission);
//            redisTemplate.expire(user_iphone, 7, TimeUnit.DAYS);
//            for(SPermission sPermission:SelectPermission) {
//            	permissionSet.add(sPermission.getPermission());
//            }
//        }
        
      List<SPermission> SelectPermission=sLoginMapper.SelectPermission(Long.valueOf(user_iphone));//拿权
//      redisCacheUtil.setCacheList(user_iphone,SelectPermission);
//      redisTemplate.expire(user_iphone, 7, TimeUnit.DAYS);
      for(SPermission sPermission:SelectPermission) {
      	permissionSet.add(sPermission.getPermission());
        System.out.println(sPermission.getPermission());
      }
        
        logger.info("查看权限"+permissionSet);
      //设置该用户拥有的角色和权限
        info.setRoles(roleSet);
        info.setStringPermissions(permissionSet);
        return info;
    }
}
