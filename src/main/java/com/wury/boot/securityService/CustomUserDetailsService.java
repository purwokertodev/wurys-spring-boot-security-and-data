package com.wury.boot.securityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.wury.boot.model.UserBlog;
import com.wury.boot.model.UserBlogRole;
import com.wury.boot.repository.UserBlogRepository;
import com.wury.boot.service.api.UserBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by WURI on 16/03/2016.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserBlogService userBlogService;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserBlog userBlog = userBlogService.findOneByEmail(username);
        List<GrantedAuthority> authorities = buildUserAuthority(userBlog.getUserRoles());

        return buildUserForAuthentication(userBlog, authorities);
    }

    private User buildUserForAuthentication(UserBlog userBlog, List<GrantedAuthority> authorities) {

        return new User(userBlog.getEmail(), userBlog.getPassword(),
                true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserBlogRole> userRoles) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(0);
        for (UserBlogRole userRole : userRoles) {
            authorities.add(new SimpleGrantedAuthority(userRole.getRoleName()));
        }

        return authorities;
    }
}
