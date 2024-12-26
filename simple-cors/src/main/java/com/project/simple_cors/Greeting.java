package com.project.simple_cors;

public class Greeting {

    private final long id;
    private final String contents;

    public Greeting() {
        this.id = -1;
        this.contents = "";
    }

    public Greeting(long id, String contents) {
        this.id = id;
        this.contents = contents;
    }

    public long getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }
}
