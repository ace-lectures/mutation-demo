package rewriters;

import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.factory.Factory;

public class InvertCondition extends Rewriter<CtBinaryOperator<?>> {

    @Override
    protected void rewrite(CtBinaryOperator<?> e, Factory factory) {
        switch(e.getKind()) {
            case EQ: e.setKind(BinaryOperatorKind.NE); break;
            case NE: e.setKind(BinaryOperatorKind.EQ); break;
            case GT: e.setKind(BinaryOperatorKind.LE); break;
            case LE: e.setKind(BinaryOperatorKind.GT); break;
            case GE: e.setKind(BinaryOperatorKind.LT); break;
            case LT: e.setKind(BinaryOperatorKind.GE); break;
            case AND: e.setKind(BinaryOperatorKind.OR); break;
            case OR: e.setKind(BinaryOperatorKind.AND); break;
            default: throw new IllegalArgumentException(e.toString());
        }
    }

    @Override
    protected String getName() {
        return "InvertCondition";
    }
}
