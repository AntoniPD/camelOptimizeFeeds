package com.apache.camel.processor;


import ch.qos.logback.classic.Logger;
import com.apache.camel.domain.markdown_candidate.MarkdownCandidateCsv;
import com.apache.camel.domain.markdown_candidate.MarkdownCandidateFormatted;
import com.apache.camel.exception.CustomException;
import com.apache.camel.route.StoreIdRoute;

import java.util.Arrays;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.util.CastUtils;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MarkdownCandidateProcessor implements Processor {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(MarkdownCandidateProcessor.class);


    private static final String MKDOWN = "MKDOWN";
    private static final String MKDOWN_DELETE = "MKDOWN-DELETE";
    private static final String CL_TO_ACTIVE = "CL-TO-ACTIVE";
    private static final String CL_TO_ACTIVE_DELETE = "CL-TO-ACTIVE-DELETE";
    private static final String ADD = "ADD";
    private static final String CTA = "CTA-";
    private static final String CMD = "-CMD-";
    private static final String CSV = ".csv";
    private static final String CAMEL_FILE_NAME = "CamelFileName";
    private static final String NOT_VALID_FILE_EXTENSION = "Not valid file extension";
    private static final int MKDWN_CMD_EVENT_ID_START = 0;
    private static final int MKDWN_CMD_EVENT_ID_END = 3;
    private static final int MKDWN_CTA_EVENT_ID_START = 4;
    private static final int MKDWN_CTA_EVENT_ID_END = 7;

    @Override
    public void process(Exchange exchange) throws CustomException {
        // List<MarkdownCandidateCsv> test = CastUtils.cast(exchange.getIn().getBody(List.class), MarkdownCandidateCsv.class);
        List<MarkdownCandidateCsv> inputItems = (List<MarkdownCandidateCsv>) exchange.getIn().getBody();
        List<MarkdownCandidateFormatted> formattedItems = new ArrayList<>();

        String fileName = exchange.getIn().getHeader(CAMEL_FILE_NAME).toString();

        logger.info("Example log from {}", MarkdownCandidateProcessor.class.getSimpleName());

        if (!fileName.contains(CSV)) {
            logger.error("Error from {}", MarkdownCandidateProcessor.class.getSimpleName());
            throw new CustomException(NOT_VALID_FILE_EXTENSION);
        }

        inputItems.forEach(item -> {
            String reasonCode = item.getReasonCode();
            try {
                if (reasonCode.contains(CMD)) {
                    MarkdownCandidateFormatted tempItem = new MarkdownCandidateFormatted();
                    tempItem.setEventId(reasonCode.substring(MKDWN_CMD_EVENT_ID_START, MKDWN_CMD_EVENT_ID_END));
                    tempItem.setSkuId(item.getItem());
                    tempItem.setNodeKey(item.getZoneId());
                    tempItem.setSkuLocStatusCode(cmdActnTranslation(item.getActnCde()));
                    tempItem.setSkuStorePrice(item.getChangeAmount());
                    tempItem.setSourceCreateDate(item.getExtrctDate());
                    tempItem.setMkdwnEffDate(item.getEffectiveDate());
                    tempItem.setSkuStoreMkdwnPerc(item.getChangePercent());
                    formattedItems.add(tempItem);
                } else if (reasonCode.contains(CTA)) {
                    StoreIdRoute.getStoreIds().forEach(id -> {
                        MarkdownCandidateFormatted tempItemCTA = new MarkdownCandidateFormatted();
                        tempItemCTA.setEventId(reasonCode.substring(MKDWN_CTA_EVENT_ID_START, MKDWN_CTA_EVENT_ID_END));
                        tempItemCTA.setSkuId(item.getItem());
                        tempItemCTA.setNodeKey(id);
                        tempItemCTA.setSkuLocStatusCode(ctaActnTranslation(item.getActnCde()));
                        tempItemCTA.setSkuStorePrice(item.getChangeAmount());
                        tempItemCTA.setSourceCreateDate(item.getExtrctDate());
                        tempItemCTA.setMkdwnEffDate(item.getEffectiveDate());
                        tempItemCTA.setSkuStoreMkdwnPerc(item.getChangePercent());
                        formattedItems.add(tempItemCTA);
                    });

                }
            } catch (Exception e) {
                logger.error("Error in {}", MarkdownCandidateProcessor.class.getSimpleName());
                throw new CustomException(e.toString());

            }
        });

        exchange.getIn().setHeader("timestamp", Arrays.stream(exchange.getIn().getHeader("CamelFileName").toString().split("_")).reduce((first, second) -> second)
                .orElse(null));
        exchange.getIn().setBody(formattedItems);
    }

    private String cmdActnTranslation(String actnCde) {
        String skuLocStatusCode;

        if (actnCde.equals(ADD)) {
            skuLocStatusCode = MKDOWN;
        } else {
            skuLocStatusCode = MKDOWN_DELETE;
        }
        return skuLocStatusCode;
    }

    private String ctaActnTranslation(String actnCde) {
        String skuLocStatusCode;

        if (actnCde.equals(ADD)) {
            skuLocStatusCode = CL_TO_ACTIVE;
        } else {
            skuLocStatusCode = CL_TO_ACTIVE_DELETE;
        }
        return skuLocStatusCode;
    }
}