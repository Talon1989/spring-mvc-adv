package com.fabio.springmvc.services.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TextMessageListener {

    @JmsListener(destination = "text.messagequeue")
    public void onMessage(String msg){
        System.out.println("-#-#-#-#");
        System.out.println("-#-#-#-#");
        System.out.println("MESSAGE RECEIVED");
        System.out.println(msg);
        System.out.println("-#-#-#-#");
        System.out.println("-#-#-#-#");
    }

}
