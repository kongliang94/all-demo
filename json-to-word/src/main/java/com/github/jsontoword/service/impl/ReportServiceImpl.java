package com.github.jsontoword.service.impl;


import com.github.jsontoword.entity.ReportExportWordRequest;
import com.github.jsontoword.service.ReportService;
import com.github.jsontoword.util.WordGeneratorUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Map;

/**
 * <p>
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Override
    public File exportWord(ReportExportWordRequest exportWordRequest) {

        //解析参数
        Map<String, String> datas = WordGeneratorUtils.parseToMap(exportWordRequest);

        //导出
        File word = WordGeneratorUtils.createDoc(datas);
        return word;
    }
}
