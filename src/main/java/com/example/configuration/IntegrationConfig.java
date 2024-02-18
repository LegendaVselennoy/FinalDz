package com.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel textInput(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileWriter(){
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "textInput",outputChannel = "fileWriter")
    public GenericTransformer<String,String> transfer(){
       return text->text;
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriter")
    public FileWritingMessageHandler messageHandler(){
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File("D://Export"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }
}
