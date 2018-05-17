package java.com.tianshouzhi.security.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * Created by tianshouzhi on 2018/5/15.
 */
public class MD5PasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(CharSequence rawPassword) {
		return DigestUtils.md5DigestAsHex(((String) rawPassword).getBytes());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encode(rawPassword).equals(encodedPassword);
	}
}
