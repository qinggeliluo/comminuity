package com.zh.controller;

import com.zh.dto.AccessTokenDTO;
import com.zh.dto.GithubUser;
import com.zh.mapper.UserMapper;
import com.zh.model.User;
import com.zh.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * @author xmr
 * @date 2019/7/27 17:39
 * @description
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                           HttpServletRequest request)
    {
        AccessTokenDTO accessTokenDTO =new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRediret_uri(redirectUri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        try {
            GithubUser githubUser =githubProvider.getuser(accessToken);
            System.out.println(githubUser.getName());
            if(githubUser !=null)
            {
                User user = new User();
                user.setToken(UUID.randomUUID().toString());
                user.setName(githubUser.getName());
                user.setAccountId(String.valueOf(githubUser.getId()));
                user.setGmtCreate(System.currentTimeMillis());
                user.setGmtModified(user.getGmtCreate());
                userMapper.insert(user);
                request.getSession().setAttribute("user",user);
                return "redirect:/";
            }else {
                return "redirect:/";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

}
