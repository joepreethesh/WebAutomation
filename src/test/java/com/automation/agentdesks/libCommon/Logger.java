package com.automation.agentdesks.libCommon;

public class Logger {

    private static String banner = "* * * * * * * * * * * * *";
    private static String suffix = "- - - - - - - - - - - - -";

    public static void beginTest(String testName) {
        System.out.println(banner);
        System.out.println("Beginning test" + testName);
        System.out.println();
        System.out.println();
    }

    public static void endTest(String testName) {
        System.out.println();
        System.out.println();
        System.out.println("Finishing test" + testName);
        System.out.println(banner);
    }

    public static void logAction(String msg) {

        System.out.println(" " + msg);
        System.out.println(" " + suffix);
    }

    public static void logComment(String msg) {

        System.out.println("       -> " + msg);
        System.out.println(" " + suffix);
    }
}
