package com.bigbank.hatef.dragonsofmugloar.utils;

import com.bigbank.hatef.dragonsofmugloar.model.message.Message;
import org.springframework.stereotype.Component;

import java.util.Base64;


@Component
public class MessageDecoder {
    private MessageDecoder() {
    }
    
    public static Message decode(Message message) {
        Base64.Decoder decoder = Base64.getDecoder();
        message.adId(new String(decoder.decode(message.adId())));
        message.message(new String(decoder.decode(message.message())));
        message.probability(new String(decoder.decode(message.probability())));
        return message;
    }
}
