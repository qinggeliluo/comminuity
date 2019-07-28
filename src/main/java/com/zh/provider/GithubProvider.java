package com.zh.provider;

import com.alibaba.fastjson.JSON;
import com.zh.dto.AccessTokenDTO;
import com.zh.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author xmr
 * @date 2019/7/27 17:51
 * @description
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                  String string =response.body().string();
                  String token = string.split("&")[0].split("=")[1];
                return token;
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
    }
    public GithubUser getuser(String accessToken) throws IOException {
        OkHttpClient client =new OkHttpClient();
        Request request =new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
       try (Response response = client.newCall(request).execute()){
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        }catch (IOException e)
       {
           e.printStackTrace();
       }
       return null;
    }

}
