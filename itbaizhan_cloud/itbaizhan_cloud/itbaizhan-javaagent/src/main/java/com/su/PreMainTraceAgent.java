package com.su;

import java.lang.instrument.Instrumentation;
import java.security.DrbgParameters;

public class PreMainTraceAgent {
    public static void premain(String agentars, Instrumentation instrumentation) {
        System.out.println("===============premain已经执行===============");
        instrumentation.addTransformer(new TestTransform());
    }
}
