package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod, // HTTP 메소드 조회
                          Locale locale, // 언어 정보 조회
                          @RequestHeader MultiValueMap<String, String> headerMap, // 모든 HTTP 헤더 정보를 Map 형식 조회
                          @RequestHeader("host") String host, // 특정 헤더 정보 조회 (host)
                          @CookieValue(value = "myCookie", required = false) String cookie // 쿠키 조회
                          ){

        log.info("request={}", request); // request=org.apache.catalina.connector.RequestFacade@684ba4db
        log.info("response={}", response); // response=org.apache.catalina.connector.RequestFacade@684ba4db
        log.info("httpMethod={}", httpMethod); // httpMethod=GET
        log.info("locale={}", locale); // locale=ko_KR
        log.info("headerMap={}", headerMap); // {content-type=[application/json], ...}
        log.info("header host={}", host); // header host=localhost:8080
        log.info("myCookie={}", cookie); // myCookie=null

        return "ok";
    }
}
