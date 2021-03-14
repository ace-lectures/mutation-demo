import mutators.FixCondition;
import mutators.IntroduceNullPointer;
import mutators.Mutator;
import mutators.SwitchCondition;
import rewriters.Trace;
import spoon.Launcher;
import spoon.MavenLauncher;

import java.util.*;

public class Runner {

    private String project;
    private int howMany;
    private String mutantId;

    public Runner(String project, int howMany, String mutantId) {
        this.project = project;
        this.howMany = howMany;
        this.mutantId = mutantId;
    }

    public void run() {
        Launcher program = new MavenLauncher(project, MavenLauncher.SOURCE_TYPE.APP_SOURCE); // Spoon
        program.buildModel();

        Mutator<?> mutator = randomMutator();
        Set<Trace> traces =  mutator.mutate(program, howMany);
        for(Trace t: traces)
            System.out.println(mutantId+","+t);
        program.prettyprint();
    }

    private Mutator<?> randomMutator() {
        List<Mutator<?>> available = new ArrayList<>();
        available.add(new IntroduceNullPointer());
        available.add(new SwitchCondition());
        available.add(new FixCondition());
        Collections.shuffle(available);
        return available.get(0);
    }
}
