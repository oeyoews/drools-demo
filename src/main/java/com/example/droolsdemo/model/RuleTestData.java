package com.example.droolsdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuleTestData {
    private int firedRulesCount;
    private List<Person> people;
    private long executionTime;
}

