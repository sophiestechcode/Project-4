package com.example.ruben.project4.data;

/**
 * Created by elif on 05/07/16.
 */
public class MonthCount implements Comparable<MonthCount> {
    final int month;
    int count;

    public MonthCount(int month) {
        this.month = month;
        this.count = 1;
    }

    public int compareTo(MonthCount another) {
        return month - another.month;
    }
}
