package Sample_Day5_Programs;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

interface WorkTask {
    void executeTask();
}

class AttendMeeting implements WorkTask {
    public void executeTask() {
        System.out.println("Task Started: Attend Meeting at " + new Date());
        System.out.println("Joining meeting...");
    }
}

class CompleteTask implements WorkTask {
    public void executeTask() {
        System.out.println("Task Started: Complete Assigned Work at " + new Date());
        System.out.println("Completing tasks...");
    }
}

class WriteCode implements WorkTask {
    public void executeTask() {
        System.out.println("Task Started: Write Code at " + new Date());
        System.out.println("Writing code...");
    }
}

class ReviewExecution implements WorkTask {
    public void executeTask() {
        System.out.println("Task Started: Review Execution at " + new Date());
        System.out.println("Reviewing work...");
    }
}

class TaskReminder extends TimerTask {
    int count = 0;
    WorkTask[] taskList = {
        new AttendMeeting(),
        new CompleteTask(),
        new WriteCode(),
        new ReviewExecution()
    };

    public void run() {
        if (count == taskList.length) {
            count = 0; 
        }

        WorkTask task = taskList[count];
        task.executeTask();
        count++;

        System.out.println("=> Task accepted.\n");
    }
}

public class Task_Reminder {
    public static void main(String[] args) {
        Timer timer = new Timer();
        System.out.println("Reminder started at: " + new Date());

        long interval = 10 * 1000;
        timer.schedule(new TaskReminder(), 0, interval);
    }
}
