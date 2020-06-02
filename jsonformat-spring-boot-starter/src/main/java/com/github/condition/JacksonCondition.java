package com.github.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class JacksonCondition implements Condition {
    public final static String FORMAT_TYPE_KEY="json.format.type";
    public final static String FORMAT_TYPE="jackson";

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return conditionContext.getEnvironment().getProperty(FORMAT_TYPE_KEY).equalsIgnoreCase(FORMAT_TYPE);
    }
}
