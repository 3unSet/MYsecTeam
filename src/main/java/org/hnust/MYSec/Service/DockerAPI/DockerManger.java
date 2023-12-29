package org.hnust.MYSec.Service.DockerAPI;

import org.hnust.MYSec.Mode.CTFUser;
import org.hnust.MYSec.Service.DockerAPI.Mode.Container;
import org.hnust.MYSec.Service.DockerAPI.Mode.RemoteHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

public class DockerManger {

    public String mode;
    public RemoteHost remoteHost;
    private static final Logger logger = LoggerFactory.getLogger(DockerManger.class);
    public List<Container> activeDocker;
    /**
     * 状态级别:                    <br/>
     * -1 初始化失败，或未初始化       <br/>
     * 1    正常                  <br/>
     * 2    系统超负荷状态         <br/>
     */
    public short status;

    public  HashMap<CTFUser, Container> userDockerMap;

    public DockerManger(){
        this.remoteHost=new RemoteHost();
        try {
            this.activeDocker = ContainerAPI.getAllContainer(remoteHost.dockerApiHost);
        }catch (Exception e){
            this.status=-1;
           logger.error("docker 服务器错误，请检查");
        }
        this.status=1;
        this.userDockerMap=new HashMap<>();

    }
    public DockerManger(String mode){
        this();
        this.mode=mode;
    }

    public void addContainer(){

    }

    public void closeContainer(){

    }


    public void closeAllContainer(){

    }


}
