package com.apache.camel.route;


import com.apache.camel.domain.markdown_candidate.MarkdownCandidateCsv;
import com.apache.camel.domain.markdown_candidate.MarkdownCandidateFormatted;
import com.apache.camel.exception.CustomException;
import com.apache.camel.processor.MarkdownCandidateProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MarkdownCandidateRoute extends RouteBuilder {

    @Autowired
    private MarkdownCandidateProcessor markdownCandidateProcessor;

    @Override
    public void configure() throws Exception {
        DataFormat fromCSV = new BindyCsvDataFormat(MarkdownCandidateCsv.class);
        DataFormat toCSV = new BindyCsvDataFormat(MarkdownCandidateFormatted.class);

        onException(CustomException.class)
                .log(LoggingLevel.ERROR, "EXCEPTION: ${exception.toString()}")
                .handled(true)
                .to("mock:catch");

        from("file:{{mkdwnCandidateInputFolder}}?scheduler=quartz2&scheduler.cron=0+0+*+?+*+*&move={{mkdwnCandidateArchiveFolder}}&moveFailed={{mkdwnCandidateErrorFolder}}")
            .log("Markdown Candidate route started")
            .unmarshal(fromCSV)
            .process(this.markdownCandidateProcessor)
            .marshal(toCSV)
            .to("file:{{mkdwnCandidateOutputFolder}}?fileName=MKC_${header.timestamp}")
            .log("Markdown Candidate route ended");
    }
}
