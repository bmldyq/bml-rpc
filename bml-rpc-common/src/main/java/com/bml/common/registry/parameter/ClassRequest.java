package com.bml.common.registry.parameter;

import java.io.Serializable;

public class ClassRequest implements Serializable {


    private static final long serialVersionUID=1L;
    private String className;

    private String methodName;


    private Class<?>[] parametersType;

    private Object [] parameters;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParametersType() {
        return parametersType;
    }

    public void setParametersType(Class<?>[] parametersType) {
        this.parametersType = parametersType;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
