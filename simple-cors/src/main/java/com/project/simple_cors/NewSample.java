package com.project.simple_cors;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Stream;

public class NewSample {

    public String attach1(List<String> data) {
        return data.parallelStream().reduce("w", (n, m) -> n + m,
                String::concat);
    }
    public String attach2(List<String> data) {
        return data.parallelStream().reduce((l, p) -> l + p).get();
    }
    record Product(String name, double price) {}
    public static void main(String[] args) {
        Path p1 = Paths.get("fldrl\\fldr2\\file1.txt");
        Path p2 = Paths.get("fldr3\\file1.txt");
        System.out.println(p1.resolve(p2));
        System.out.println(p1.relativize(p2));

    }

}
