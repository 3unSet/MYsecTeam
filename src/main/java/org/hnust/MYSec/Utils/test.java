package org.hnust.MYSec.Utils;

import org.hnust.MYSec.Service.DockerAPI.ContainerAPI;

import org.hnust.MYSec.Service.DockerAPI.DockerManger;

import java.util.List;

public class test {
    public static void main(String[] args) {
        String host="http://192.168.120.128:2375";
        //String host="http://101.35.221.221:2375";
        //ContainerAPI.RemoteStartContainer(new RemoteHost(),"/var/www/html/vulhub/flask/ssti");
        //ContainerAPI.RemoteStopContainer(new RemoteHost(),"/var/www/html/vulhub/flask/ssti");
        List a= ContainerAPI.getAllContainer(host);
      // Container container= JSON.parseObject(String.valueOf(a.get(0)),Container.class);
        DockerManger dockerManger = new DockerManger();
        //dockerManger.addContainer();

        //Map usermap=dockerManger.getUserDockerMap();
        System.out.println();
    }
}
