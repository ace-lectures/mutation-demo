package finders;

import spoon.Launcher;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Condition implements Finder<CtBinaryOperator<?>> {

    private Set<BinaryOperatorKind> targets;

    public Condition() {
        targets = new HashSet<>();
        targets.add(BinaryOperatorKind.EQ);
        targets.add(BinaryOperatorKind.NE);
        targets.add(BinaryOperatorKind.GT);
        targets.add(BinaryOperatorKind.LE);
        targets.add(BinaryOperatorKind.GE);
        targets.add(BinaryOperatorKind.LT);
        targets.add(BinaryOperatorKind.AND);
        targets.add(BinaryOperatorKind.OR);
    }

    @Override
    public Set<CtBinaryOperator<?>> findCandidates(Launcher program, int howMany) {
        List<CtBinaryOperator<?>> queried = program.getModel().getRootPackage().filterChildren(
                (CtBinaryOperator<?> e)  -> targets.contains(e.getKind())
        ).list();
        return queried.stream().limit(howMany).collect(Collectors.toSet());
    }

}
