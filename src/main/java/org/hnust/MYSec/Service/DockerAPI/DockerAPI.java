package org.hnust.MYSec.Service.DockerAPI;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hnust.MYSec.Configure.RemoteHost;

@Data
@NoArgsConstructor
public class DockerAPI {

    private String url;
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

