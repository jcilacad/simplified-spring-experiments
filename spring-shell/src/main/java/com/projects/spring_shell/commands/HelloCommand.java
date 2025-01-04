package com.projects.spring_shell.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class HelloCommand {

    @ShellMethod(key = "hello", value = "This command prints 'Hello'")
    public String hello(@ShellOption(defaultValue = "World") String arg) {
        return String.format("Hello %s", arg);
    }
}
