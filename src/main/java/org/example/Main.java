package org.example;

public class Main {
    public static void main(String[] args) {

        AnimalController controller = new AnimalController(new AnimalServiceImpl());

        test(controller);
        System.out.println("------------------------");
    }

    private static void test(AnimalController controller) {
        long startTime = System.currentTimeMillis();

        System.out.println(controller.getAll());
        System.out.println(controller.get(2));
        System.out.println(controller.get(3));
        System.out.println(controller.getAll());
        System.out.println(controller.get(5));
        System.out.println(controller.get(3));

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time elapsed: " + estimatedTime + "m/s");
    }
}