package org.hnust.MYSec.Service.DockerAPI;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DockerAPI {

    private String url="http://192.168.120.128:2375";
    private String port;
    private RemoteHost remoteHost;

}

