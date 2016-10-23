package org.houor.spring.rest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.houor.spring.rest.domain.CustomerUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

	private Map<String, CustomerUser> userMap = new HashMap<String, CustomerUser>();
	private SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority("ROLE_USER");
	private SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");

	public CustomerUserDetailsService() {
		userMap.put("admin", new CustomerUser("admin", "password"));
		userMap.put("user", new CustomerUser("user", "password"));

	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		CustomerUser cu = userMap.get(username);
		if (cu != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(userAuthority);
			if (username.equals("admin")) {
				authorities.add(adminAuthority);
			}

			User user = new User(cu.getUsername(), cu.getPassword(), authorities);
			return user;
		} else {
			throw new UsernameNotFoundException("User " + username + " is not found.");
		}

	}

}
