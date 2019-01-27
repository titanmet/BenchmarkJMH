package ru.ratnikov.Bench;
import org.openjdk.jmh.annotations.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class BenchJmh {

    @State(Scope.Benchmark)
    public static class BenchmarkState{

        int max = 9_999_999;
        Collection<Integer> example = new HashSet<>();

        @Setup
        public void initState(){
            int min = 0;
            for (int i = min; i < max + 1; i++) {
                example.add(i);
        }
    }
    }

        @Benchmark
        public void test(BenchmarkState state) {
            state.example.contains(state.max);
        }

}