package ru.wlservice.service;

import ru.wlservice.model.WorkLogRecord;
import ru.wlservice.model.WorkLogRecordList;

//@Service
public interface WorkLogService {

    WorkLogRecordList findAll();

    void insert(WorkLogRecord workLogRecord);

    WorkLogRecord get(String id);

}
