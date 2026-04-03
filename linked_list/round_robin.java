import java.util.Scanner;

class RoundRobinScheduling {

    static class Process {
        int processId;
        int burstTime;
        int priority;
        Process next;

        Process(int processId, int burstTime, int priority) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.priority = priority;
            this.next = null;
        }
    }

    private Process tail;

    // Add a new process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (tail == null) {
            tail = newProcess;
            tail.next = tail;
            return;
        }
        newProcess.next = tail.next;
        tail.next = newProcess;
        tail = newProcess;
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (tail == null) {
            System.out.println("No processes in the queue");
            return;
        }
        Process current = tail.next;
        Process prev = tail;
        do {
            if (current.processId == processId) {
                if (current == tail && current.next == tail) {
                    tail = null;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != tail.next);
        System.out.println("Process not found");
    }

    // Simulate the round-robin scheduling
    public void simulateRoundRobin(int timeQuantum) {
        if (tail == null) {
            System.out.println("No processes to schedule");
            return;
        }
        Process current = tail.next;
        int totalProcesses = 0;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;

        while (true) {
            boolean allDone = true;
            Process temp = tail.next;
            do {
                if (temp.burstTime > 0) {
                    allDone = false;
                    int executionTime = Math.min(temp.burstTime, timeQuantum);
                    System.out.println("Executing Process ID: " + temp.processId + " for " + executionTime + " units");
                    temp.burstTime -= executionTime;
                    if (temp.burstTime == 0) {
                        System.out.println("Process ID: " + temp.processId + " completed");
                        totalTurnAroundTime += executionTime;
                        totalProcesses++;
                    }
                }
                temp = temp.next;
            } while (temp != tail.next);

            if (allDone) {
                break;
            }
        }

        System.out.println("Average Waiting Time: " + (totalWaitingTime / totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTurnAroundTime / totalProcesses));
    }

    // Display the list of processes in the circular queue
    public void displayProcesses() {
        if (tail == null) {
            System.out.println("No processes in the queue");
            return;
        }
        Process temp = tail.next;
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != tail.next);
    }

    public static void main(String[] args) {
        RoundRobinScheduling scheduler = new RoundRobinScheduling();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nRound Robin CPU Scheduling");
            System.out.println("1. Add Process");
            System.out.println("2. Remove Process");
            System.out.println("3. Simulate Scheduling");
            System.out.println("4. Display Processes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    int processId = scanner.nextInt();
                    System.out.print("Enter Burst Time: ");
                    int burstTime = scanner.nextInt();
                    System.out.print("Enter Priority: ");
                    int priority = scanner.nextInt();
                    scheduler.addProcess(processId, burstTime, priority);
                    break;
                case 2:
                    System.out.print("Enter Process ID to remove: ");
                    int removeId = scanner.nextInt();
                    scheduler.removeProcess(removeId);
                    break;
                case 3:
                    System.out.print("Enter Time Quantum: ");
                    int timeQuantum = scanner.nextInt();
                    scheduler.simulateRoundRobin(timeQuantum);
                    break;
                case 4:
                    scheduler.displayProcesses();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}