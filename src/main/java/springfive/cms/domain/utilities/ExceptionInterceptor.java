package springfive.cms.domain.utilities;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import springfive.cms.domain.utilities.Constants.DATE_TIME_LOCALES;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

    static final Logger logger = LogManager.getLogger(ExceptionInterceptor.class);

    @ExceptionHandler(NewsAppException.class)
    public final ResponseEntity<Object> handleAllExceptions(NewsAppException exception){
        logger.info("In Handle Exceptions class");
        NewsAppExceptionSchema exceptionResponse =
                new NewsAppExceptionSchema(exception.getMessage(), exception.getDetails(), exception.getTime());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<Object> handleAllExceptions(NoSuchElementException exception){
        logger.info("In Handle Exceptions class");
        String y = LocalDate.now(ZoneId.of(DATE_TIME_LOCALES.INDIA.getRegion())).toString() + " " +
                LocalTime.now(ZoneId.of(DATE_TIME_LOCALES.INDIA.getRegion())).toString();
        NewsAppExceptionSchema exceptionResponse =
                new NewsAppExceptionSchema(exception.getMessage(), "exception.getDetails()", y);
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
