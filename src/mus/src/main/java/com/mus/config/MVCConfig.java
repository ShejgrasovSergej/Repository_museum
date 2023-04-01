package com.mus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;//хранит регистрации обработчиков ресурсов для обслуживания статических ресурсов
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;//Определяет методы обратного вызова для настройки конфигурации

@Configuration//это аннотация на уровне класса, указывающая на то, что объект является источником определений бина
public class MVCConfig implements WebMvcConfigurer {
    @Value("${upload.css}") //для ввода значений в поля в компонентах
    private String uploadCss;
    @Value("${upload.fonts}")
    private String uploadFonts;
    @Value("${upload.img}")
    private String uploadImg;
    @Value("${upload.js}")
    private String uploadJs;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("file:" + uploadCss + "/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("file:" + uploadFonts + "/");
        registry.addResourceHandler("/js/**").addResourceLocations("file:" + uploadJs + "/");
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + uploadImg + "/");
    }
}
