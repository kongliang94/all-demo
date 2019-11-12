package com.github.jsontoword.service;


import com.github.jsontoword.entity.ReportExportWordRequest;

import java.io.File;

/**
 *
 */
public interface ReportService {

    File exportWord(ReportExportWordRequest exportWordRequest);
}
