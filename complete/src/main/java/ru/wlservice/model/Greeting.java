package ru.wlservice.model;

import lombok.AccessLevel;
import lombok.Value;
import lombok.experimental.FieldDefaults;

@Value
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Greeting {
    long id;
    String content;
}
