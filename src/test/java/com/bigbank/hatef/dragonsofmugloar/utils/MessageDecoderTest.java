package com.bigbank.hatef.dragonsofmugloar.utils;

import com.bigbank.hatef.dragonsofmugloar.model.message.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
public class MessageDecoderTest {
    
    @Test
    public void givenMessageProvided_thenReturnDecodedMessage() {
        Message expectedMessage = new Message("sampleId", "sampleMessage", "1", 1, 1, "Risky");
        Message actualMessage = MessageDecoder.decode(new Message("c2FtcGxlSWQ=", "c2FtcGxlTWVzc2FnZQ==", "1", 1, 1, "Umlza3k="));
        assertThat(actualMessage).hasToString(expectedMessage.toString());
        assertThat(actualMessage.adId()).isEqualTo(expectedMessage.adId());
    }
}