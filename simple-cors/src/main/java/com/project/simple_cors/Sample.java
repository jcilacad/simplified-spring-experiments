package com.project.simple_cors;

import java.io.Console;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample {

    public String attach1(List<String> data) {
        return data.parallelStream().reduce("w", (n, m) -> n + m,
                String::concat);
    }
    public String attach2(List<String> data) {
        return data.parallelStream().reduce((l, p) -> l + p).get();
    }

    public enum Designation {
        CEO('A'), CMO('B'), CTO('C'), CFO('D');
        char c;
        private Designation(char c) {
            this.c = c;
        }
    }


    public enum Forecast {
        SUNNY, CLOUDY, RAINY;
        @Override
        public String toString() {
            return "SNOWY";
        }
    }
    public static void main(String[] args) {
        System.out.print(Forecast.SUNNY.ordinal() + " ");
        System.out.print(Forecast.valueOf("cloudy".toUpperCase()));
    }
    public static int findSq(int x) { // line n3
        var x1 = 10; // line n4
        return x1 * x;
    }

}

class Product {
    String name;
    double price;
    Product(String s, double d) {
        this.name = s;
        this.price = d;
    }
}
class ElectricProduct extends Product {
    ElectricProduct(String name, double price) {
        super(name, price);
    }
}

