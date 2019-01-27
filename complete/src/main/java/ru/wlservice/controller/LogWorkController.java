package ru.wlservice.controller;

import ru.wlservice.controller.helper.ResponseResult;
import ru.wlservice.dao.WorkLogDao;
import ru.wlservice.model.Greeting;
import ru.wlservice.model.WorkLogRecord;
import ru.wlservice.model.WorkLogRecordList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@RestController
public class LogWorkController {

//    static final Logger log = LoggerFactory.getLogger(LogWorkController.class);

    private static final String CONTROLLER_CONTEXT = "/worklog";
    private final AtomicLong counter = new AtomicLong();

    private final WorkLogDao workLogService;

    @Autowired
    public LogWorkController(WorkLogDao workLogService) {
        this.workLogService = workLogService;
    }


    @RequestMapping(value = CONTROLLER_CONTEXT, method = GET)
    public WorkLogRecordList getAll() {
        log.trace("Get All");
        return workLogService.findAll();
        // return new Greeting(counter.incrementAndGet(), "");
    }


    // http://localhost:8080/worklog?id=1
    @RequestMapping(value = CONTROLLER_CONTEXT, params = "id", method = GET)
    public ResponseEntity<WorkLogRecord> getOne(@RequestParam("id") String id) {
        log.trace("getOne by Id: " + id);
        WorkLogRecord workLogRecord = workLogService.get(id);
        return new ResponseEntity<>(workLogRecord, workLogRecord == null ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }


    @RequestMapping(value = CONTROLLER_CONTEXT, params = "name", method = GET)
    public ResponseEntity<Greeting> getOneByName(@RequestParam("name") String name) {
        log.trace("getOneByName: " + name);
        return new ResponseEntity<>(new Greeting(counter.incrementAndGet(), name), HttpStatus.OK);
    }


    @RequestMapping(value = CONTROLLER_CONTEXT, method = RequestMethod.POST)
    public ResponseEntity<ResponseResult> add(@RequestBody WorkLogRecord workLogRecord) {
        log.trace("add: " + workLogRecord);
        workLogService.insert(workLogRecord);
//        return new ResponseEntity<>(new ResponseResult("workLogRecord added"), HttpStatus.OK);
        return new ResponseEntity<>(new ResponseResult("workLogRecord added"), HttpStatus.CREATED);
    }


    // http://localhost:8080/worklog?id=1
    @RequestMapping(value = CONTROLLER_CONTEXT, params = "id", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseResult> delete(@RequestParam("id") String id) {
        log.trace("delete: " + id);
        long deletedRecordsCount = workLogService.delete(id);
//        return new ResponseEntity<>(new ResponseResult("workLogRecord deleted"), deletedRecordsCount <= 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK);
        return new ResponseEntity<>(new ResponseResult("workLogRecord deleted: " + deletedRecordsCount), HttpStatus.OK);
    }


}
