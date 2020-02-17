package com.apache.camel.route;

import com.apache.camel.domain.markdown_candidate.MarkdownCandidateCsv;
import com.apache.camel.domain.markdown_candidate.MarkdownCandidateFormatted;
import com.apache.camel.processor.MarkdownCandidateProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CandidateTest extends CamelTestSupport {


    public void setUp() throws Exception {
        deleteDirectory("data/output");
        super.setUp();
    }

    DataFormat fromCSV = new BindyCsvDataFormat(MarkdownCandidateCsv.class);
    DataFormat toCSV = new BindyCsvDataFormat(MarkdownCandidateFormatted.class);

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new MarkdownCandidateRoute();
    }


}