package org.hnust.MYSec.Conteller;

import com.alibaba.fastjson.JSONObject;
import com.github.dockerjava.api.DockerClient;

import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.core.DockerClientBuilder;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ctf/api")
public class ctfAPI {
    //获取所有活跃的靶机
    @GetMapping("/all")
    public String getall(){

        return null;
    }
    //获取某个靶机的运行状态
    @PostMapping("/query")
    public String query(){
        return null;
    }



    //开启靶机
    @GetMapping ("/v")
    public String startDocker(){
        String host="tcp://192.168.120.128:2375";
        DockerClient dockerClient = null;
        dockerClient = DockerClientBuilder.getInstance(host).build();
        // 获取服务器信息
        Info info = dockerClient.infoCmd().exec();
        String infoStr = JSONObject.toJSONString(info);
        return infoStr;

    }
    //关闭靶机
    public String stopDocker(){
        return null;
    }
    //创建队伍
    @PostMapping("/create")
    public String createTeam(){
        return null;
    }
}
