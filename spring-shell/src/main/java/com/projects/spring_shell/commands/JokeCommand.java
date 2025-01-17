package com.projects.spring_shell.commands;

import com.projects.spring_shell.client.JokeClient;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class JokeCommand {

    private final JokeClient jokeClient;

    public JokeCommand(JokeClient jokeClient) {
        this.jokeClient = jokeClient;
    }

    @ShellMethod(key = "joke-me", value = "The command provides you a random joke!")
    public String getRandomJoke() {
        return jokeClient.randomJoke().joke();
    }
}
