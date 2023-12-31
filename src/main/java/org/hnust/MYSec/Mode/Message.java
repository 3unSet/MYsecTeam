package org.hnust.MYSec.Mode;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Message {
	private int code=400;
	private boolean ok=false;
	private Object info;


	public void setOK(){
		this.code=200;
		this.ok=true;
	}

	public void setFail(){
		this.code=400;
		this.ok=false;
	}
}

