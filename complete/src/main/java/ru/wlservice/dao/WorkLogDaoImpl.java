package ru.wlservice.dao;

import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import ru.wlservice.model.WorkLogRecord;
import ru.wlservice.model.WorkLogRecordList;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

//@Repository("workLogDao")
@Repository
public class WorkLogDaoImpl implements WorkLogDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public WorkLogRecordList findAll() {
        return new WorkLogRecordList(mongoTemplate.findAll(WorkLogRecord.class));
    }

    @Override
    public void insert(WorkLogRecord workLogRecord) {
        mongoTemplate.insert(workLogRecord);
    }

    @Override
    public WorkLogRecord get(String id) {
        return mongoTemplate.findById(id, WorkLogRecord.class);
    }

    @Override
    public long delete(String id) {
        DeleteResult result = mongoTemplate.remove(query(where("_id").is(id)), WorkLogRecord.class);
        return result.getDeletedCount();
    }

}
