package org.example.TestNG.ListenerDemo;

import org.testng.IExecutionListener;

public class CustomListener implements IExecutionListener  {
    @Override
    public void onExecutionStart() {
        long entTime = System.currentTimeMillis();
        System.out.println(" *****   *** Started Execution at - " + entTime   +  " ***   *****");
    }

    @Override
    public void onExecutionFinish() {
        long startTime = System.currentTimeMillis();
        System.out.println(" *****   *** Started Execution at - " + startTime   +  " ***   *****");
    }
}
