package kr.mjc.dong.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // WebServlet을 스캔함
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
