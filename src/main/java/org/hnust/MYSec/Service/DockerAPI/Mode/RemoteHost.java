package org.hnust.MYSec.Service.DockerAPI.Mode;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RemoteHost {
    public  String host = "192.168.120.128";
    public  String username = "kali";
    public  String password = "20041009qq";
    public  String dockerApiHost="http://192.168.120.128:2375";

    public RemoteHost(){}

}
