package com.example.demo.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class Messages {

    private final MessageSource source;
    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
        this.accessor = new MessageSourceAccessor(this.source, Locale.getDefault());
    }

    public String get(MessageCodeEnum message) {
        return this.accessor.getMessage(message.getMessageKey());
    }

    public String get(MessageCodeEnum message, Object... params) {
        return this.accessor.getMessage(message.getMessageKey(), params);
    }
}
