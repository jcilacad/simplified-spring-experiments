package com.projects.spring_shell.client;

import com.projects.spring_shell.commands.model.JokeResponse;
import org.springframework.web.service.annotation.GetExchange;

public interface JokeClient {

    @GetExchange("/")
    JokeResponse randomJoke();
}
