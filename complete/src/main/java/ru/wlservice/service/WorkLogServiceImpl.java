package ru.wlservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.wlservice.dao.WorkLogDao;
import ru.wlservice.model.WorkLogRecord;
import ru.wlservice.model.WorkLogRecordList;

@Service
public class WorkLogServiceImpl implements WorkLogService {
    @Autowired
    WorkLogDao workLogDao;

    @Override
    public WorkLogRecordList findAll() {
        return workLogDao.findAll();
    }

    @Override
    public void insert(WorkLogRecord workLogRecord) {
        workLogDao.insert(workLogRecord);
    }

    @Override
    public WorkLogRecord get(String id) {
        return workLogDao.get(id);
    }

}
