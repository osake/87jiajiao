package com.zjy.realm;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.zjy.domain.Account;
import com.zjy.service.common.AccountService;

public class JDBCRealm extends AuthorizingRealm implements InitializingBean {
	final Logger logger = LoggerFactory.getLogger(JDBCRealm.class);
	@Autowired
	private AccountService accountService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authToken;
		String username = token.getUsername();
		if (StringUtils.isNotBlank(username)) {
			Account account = accountService.findAccountByUserName(username);
			// 账号密码匹配
			if (account != null) {
				if (new String(token.getPassword()).equals(account.getPassword())) {
					// 密码相等时判断账号状态是否被停用
					// 如果已经被停用则抛出LockedAccountException异常
					SimplePrincipalCollection principals = new SimplePrincipalCollection();
					// 添加账号信息
					principals.add(account, getName());
					return new SimpleAccount(principals, token.getPassword(),getName());
				} else {
					throw new IncorrectCredentialsException("账号或密码不匹配");
				}
			} else {
				throw new UnknownAccountException("账号: " + username + "  不存在");
			}
		}
		return null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("JDBC Realm Register");

	}

}
