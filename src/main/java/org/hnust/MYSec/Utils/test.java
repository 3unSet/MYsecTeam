package org.hnust.MYSec.Utils;

import org.hnust.MYSec.Service.DockerAPI.ContainerAPI;

import org.hnust.MYSec.Service.DockerAPI.RemoteHost;

import java.util.List;

public class test {
    public static void main(String[] args) {
        String host="http://192.168.120.128:2375";
        //ContainerAPI.RemoteStartContainer(new RemoteHost(),"/var/www/html/vulhub/flask/ssti");
        ContainerAPI.RemoteStopContainer(new RemoteHost(),"/var/www/html/vulhub/flask/ssti");
        List a= ContainerAPI.getAllContainer(host);
        System.out.println(a);
    }
}
