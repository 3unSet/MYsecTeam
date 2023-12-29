package org.hnust.MYSec.Utils;

import com.alibaba.fastjson.JSON;
import org.hnust.MYSec.Service.DockerAPI.ContainerAPI;

import org.hnust.MYSec.Service.DockerAPI.Mode.Container;
import org.hnust.MYSec.Service.DockerAPI.Mode.RemoteHost;

import java.util.List;

public class test {
    public static void main(String[] args) {
        String host="http://192.168.120.128:2375";
        //ContainerAPI.RemoteStartContainer(new RemoteHost(),"/var/www/html/vulhub/flask/ssti");
        //ContainerAPI.RemoteStopContainer(new RemoteHost(),"/var/www/html/vulhub/flask/ssti");
        List a= ContainerAPI.getAllContainer(host);
       // Container container= JSON.parseObject(String.valueOf(a.get(0)),Container.class);
        System.out.println(a);
    }
}
