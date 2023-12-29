package org.hnust.MYSec.Service.DockerAPI;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hnust.MYSec.Service.DockerAPI.Mode.RemoteHost;

@Data
@NoArgsConstructor
public class DockerAPI {

    private String url="http://192.168.120.128:2375";
    private String port;
    private RemoteHost remoteHost;

    //读取docker-compose文件
    public Object readConfig(String fileDir){

        return null;

    }



    //获取docker-compose配置中的services名字
    public String getServiceName(){
        return null;
    }

}

