package rewriters;

import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.factory.Factory;

public class ConditionAlwaysTrue extends Rewriter<CtBinaryOperator<?>> {

    @Override
    protected void rewrite(CtBinaryOperator<?> e, Factory factory) {
        CtCodeSnippetExpression<?> left = factory.Core().createCodeSnippetExpression();
        left.setValue("true");
        e.setLeftHandOperand(left);
        CtCodeSnippetExpression<?> right = factory.Core().createCodeSnippetExpression();
        right.setValue("false");
        e.setRightHandOperand(right);
        e.setKind(BinaryOperatorKind.NE);
    }

    @Override
    protected String getName() {
        return "ConditionAlwaysTrue";
    }
}
