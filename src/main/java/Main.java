public class Main {

    public static void main(String[] args) {
        // Extract CLI arguments
        String project = args[0];
        int howMany = Integer.parseInt(args[1]);
        String mutantId = args[2];

        // Run the mutation tool
        Runner runner = new Runner(project, howMany, mutantId);
        runner.run();
    }

}
