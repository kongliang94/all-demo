package com.github;

import com.github.format.FormatProcessor;

public class FormatTemplate {

    private FormatProcessor formatProcessor;

    public FormatTemplate(FormatProcessor formatProcessor) {
        this.formatProcessor = formatProcessor;
    }

    public <T> String doFormat(T obj){
        return formatProcessor.format(obj);
    }
}
