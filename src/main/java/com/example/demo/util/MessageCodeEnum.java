package com.example.demo.util;

public enum MessageCodeEnum {

    CREATING_NEW_PERSON("creating.new.person"),
    FETCHING_ALL_PERSON("fetching.all.person"),
    FETCHING_PERSON_BY_ID("fetching.person.by.id");

    private final String messageKey;

    MessageCodeEnum(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getMessageKey() {
        return messageKey;
    }

    @Override
    public String toString() {
        return "MessageCodeEnum{" +
            "messageKey='" + messageKey + '\'' +
            '}';
    }
}
