package finders;

import spoon.Launcher;
import spoon.reflect.code.CtReturn;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ObjectReturn implements Finder<CtReturn<?>> {

    @Override
    public Set<CtReturn<?>> findCandidates(Launcher program, int howMany) {
        List<CtReturn<?>> queried =
                program.getModel().getRootPackage().filterChildren(
                (CtReturn<?> r) -> !r.getReturnedExpression().getType().isPrimitive()
        ).list();
        Collections.shuffle(queried);
        return queried.stream().limit(howMany).collect(Collectors.toSet());
    }
}
