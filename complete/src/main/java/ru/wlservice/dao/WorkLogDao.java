package ru.wlservice.dao;

import ru.wlservice.model.WorkLogRecord;
import ru.wlservice.model.WorkLogRecordList;

public interface WorkLogDao {

    WorkLogRecordList findAll();

    void insert(WorkLogRecord workLogRecord);

    WorkLogRecord get(String id);

    long delete(String id);

}

