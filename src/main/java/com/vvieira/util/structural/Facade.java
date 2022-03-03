package com.vvieira.util.structural;

import com.vvieira.exceptions.ManagementException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Facade {

    @Autowired
    private AutowireCapableBeanFactory factory;

    @SneakyThrows
    public <T> T run(UseCase t) {
        try {
            factory.autowireBean(t);
           return (T) t.run();
        } catch (Exception exception) {
            log.error("Error ao tentar rodar metodo: {} -> {}", t.getClass(), exception.getStackTrace());
            throw new ManagementException("Erro interno");
        }
    }
}
