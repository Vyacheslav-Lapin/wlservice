package ru.wlservice.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class WorkLogRecord {
    ObjectId id;
    String category;
    boolean placedToJira;

    //    private LocalDateTime started;
    //    private LocalDateTime finished;
}
