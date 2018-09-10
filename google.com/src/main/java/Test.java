import scala.util.parsing.combinator.testing.Str;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        ArrayList<Task> tasksOldAlg = new ArrayList<>();
        ArrayList<Task> tasksNewAlg = new ArrayList<>();
        int totalTime = 0, counter = 0;
        int timeForExecute = 3;
        for (int i = 0; i < 7; i++) {
            int random = new Random().nextInt(30);
            totalTime = totalTime + random;
//            while (random % timeForExecute != 0) {
//                random = new Random().nextInt(30);
//            }
            tasksNewAlg.add(new Task("Task " + i, random));
            tasksOldAlg.add(new Task("Task " + i, random));
        }
        totalTime = totalTime * 2;
        while (totalTime > 0) {
            System.out.println("ROUND " + counter);
            for (Task task : tasksOldAlg) {
                if (task.durrion > 0) {
                    if (task.durrion < timeForExecute) {
                        totalTime = totalTime - task.durrion;
                        task.durrion = 0;
                        System.out.print("\t" + task.name + " " + task.durrion + " [FINISHED]");
                    } else {
                        task.durrion = task.durrion - timeForExecute;
                        totalTime = totalTime - timeForExecute;
                        System.out.print("\t" + task.name + " " + task.durrion);
                    }

                }
            }
            System.out.println();
            for (Task task : tasksNewAlg) {
                if (task.durrion > 0) {
                    if (task.durrion > 0 && task.durrion < timeForExecute) {
                        int time = timeForExecute - task.durrion;
                        totalTime = totalTime - task.durrion;

                        System.out.print("\t" + task.name + " " + task.durrion + " EXEC " + "[" + task.durrion + "]");
                        task.durrion = 0;

                        if (time > 0) {
                            for (Task p : tasksNewAlg) {
                                if (time > 0 && p.durrion > 0) {
                                    if (p.durrion >= time) {
                                        int temp = time - p.durrion;
                                        System.out.print("\t" + p.name + " " + p.durrion + " PROC" + "[" + time + "]");
                                        p.durrion = p.durrion - time;
                                        totalTime = totalTime - time;
                                        time = temp;
                                    } else {
//                                        task.durrion = 0;
                                        int temp = time - p.durrion;
                                        totalTime = totalTime - p.durrion;
                                        time = time - p.durrion;
                                        p.durrion = temp;
                                        System.out.print("\t" + p.name + " " + p.durrion + " [FINISHED]");
                                    }
                                }
                            }

                        }
                    } else {
                        task.durrion = task.durrion - timeForExecute;
                        totalTime = totalTime - timeForExecute;
                        System.out.print("\t" + task.name + " " + task.durrion + "[" + timeForExecute + "]");

                    }
                }
            }
            counter = counter + 1;
            System.out.println();
        }


    }


    private static class Task {
        public String name;
        public int durrion;

        public Task(String name, int timeOfExecution) {
            this.name = name;
            this.durrion = timeOfExecution;
        }
    }
}