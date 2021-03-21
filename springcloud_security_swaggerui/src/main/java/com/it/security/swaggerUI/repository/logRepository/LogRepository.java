package com.it.security.swaggerUI.repository.logRepository;

import com.it.security.swaggerUI.mongodb.LogBean;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogBean, String> {

}
