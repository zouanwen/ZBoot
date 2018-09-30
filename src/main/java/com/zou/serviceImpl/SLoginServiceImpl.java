package com.zou.serviceImpl;

import com.zou.common.Msg;
import com.zou.common.ResultUtil;
import com.zou.entity.SLogin;
import com.zou.entity.SPermission;
import com.zou.entity.SRoleToken;
import com.zou.mapper.SLoginMapper;
import com.zou.service.ISLoginService;
import com.zou.shiro.util.JWTUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zou
 * @since 2018-09-26
 */
@Service
public class SLoginServiceImpl extends ServiceImpl<SLoginMapper, SLogin> implements ISLoginService {

	public static final Logger logger = LoggerFactory.getLogger(SLoginServiceImpl.class);//日志打印
	
	@Autowired
	private SLoginMapper sLoginMapper;

	@Override
	public Msg InsertLogin(SLogin sLogin) {
		// TODO Auto-generated method stub
		if(sLoginMapper.SelectLogin(sLogin.getUserIphone())==null) {
			sLogin.setCreateTime(new Date());
			MessageDigest md;
			 try {
				md = MessageDigest.getInstance("MD5");
		         byte[] messageByte = sLogin.getUserPwd().getBytes("UTF-8");  
		         byte[] md5Byte = md.digest(messageByte);              // 获得MD5字节数组,16*8=128位  
		         String lh_pwd = bytesToHex(md5Byte); 
		         sLogin.setUserPwd(lh_pwd);			
		         } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // 创建一个md5算法对象  
			
			if(sLoginMapper.insert(sLogin)==1) {
				return ResultUtil.success(1, 0);
			}else {
				return ResultUtil.error(0, "添加失败");
			}
		}else {
			return ResultUtil.error(0, "用户已经注册");
		}
	}

	@Override
	public Msg SelectLogin(int start) {
		// TODO Auto-generated method stub
		return ResultUtil.success(sLoginMapper.selectPage(new Page(start,10),new EntityWrapper().orderBy("create_time", false)),sLoginMapper.selectCount(new EntityWrapper()));
	}

	@Override
	public Msg DeleteLogin(int id) {
		// TODO Auto-generated method stub
		if(sLoginMapper.delete(new EntityWrapper().eq("id", id))==1) {
			return ResultUtil.success(1, 0);
		}else {
			return ResultUtil.error(0, "删除失败");
		}
	}
	
	@Override
	public Msg SLong(SLogin sLogin) {
		// TODO Auto-generated method stub
		SLogin SelectLogin=sLoginMapper.SelectLogin(sLogin.getUserIphone());
		logger.info("登录账号:"+SelectLogin.getUserIphone());
		if(SelectLogin!=null) {
			String pwd=SelectLogin.getUserPwd();
		    MessageDigest md;
			 try {
				md = MessageDigest.getInstance("MD5");
				 byte[] messageByte = sLogin.getUserPwd().getBytes("UTF-8");
				 byte[] md5Byte = md.digest(messageByte);              // 获得MD5字节数组,16*8=128位  
				 String lh_pwd = bytesToHex(md5Byte);
				 if(pwd.equals(lh_pwd)) {
					 SRoleToken roletoken=new SRoleToken();
					 roletoken.setToken(JWTUtil.createToken(String.valueOf(SelectLogin.getUserIphone())));
					 roletoken.setRolePermission(sLoginMapper.SelectPermission(sLogin.getUserIphone()));
					 return ResultUtil.success(roletoken, 0);
				 }else {
					 return ResultUtil.error(0, "密码错误");
				 }
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // 创建一个md5算法对象  
			 catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			return ResultUtil.error(0, "账号错误");
		}
		return null;
	}

	@Override
	public Msg UpdateLogin(SLogin sLogin) {
		// TODO Auto-generated method stub
		sLogin.setUpdateTime(new Date());
		
		MessageDigest md;
		 try {
			md = MessageDigest.getInstance("MD5");
	         byte[] messageByte = sLogin.getUserPwd().getBytes("UTF-8");  
	         byte[] md5Byte = md.digest(messageByte);              // 获得MD5字节数组,16*8=128位  
	         String lh_pwd = bytesToHex(md5Byte); 
	         sLogin.setUserPwd(lh_pwd);			
	         } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  // 创建一个md5算法对象  
		 if(sLoginMapper.update(sLogin, new EntityWrapper<SLogin>().eq("id", sLogin.getId()))==1) {
			 return ResultUtil.success(1, 0);
		 }else {
			 return ResultUtil.error(0, "修改错误");
		 }
	}
	
	/*
	 * 调用md5
	 */
	private String  bytesToHex(byte[] bytes) {
		// TODO Auto-generated method stub
		 StringBuffer hexStr = new StringBuffer();  
	        int num;  
	        for (int i = 0; i < bytes.length; i++) {  
	            num = bytes[i];  
	             if(num < 0) {  
	                 num += 256;  
	            }  
	            if(num < 16){  
	                hexStr.append("0");  
	            }  
	            hexStr.append(Integer.toHexString(num));  
	        }  
	        return hexStr.toString().toUpperCase();  
	}

	
}
