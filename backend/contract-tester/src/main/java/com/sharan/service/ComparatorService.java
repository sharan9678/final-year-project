package com.sharan.service;

import org.openapitools.openapidiff.core.OpenApiCompare;
import org.openapitools.openapidiff.core.model.ChangedOpenApi;
import org.openapitools.openapidiff.core.output.HtmlRender;
import org.openapitools.openapidiff.core.output.MarkdownRender;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ComparatorService {

    public static void main(String[] args) {
        File contract1 = new File("/Users/sharan/final-year-project/contractsDB/localhost:8081-old.yaml");
        File contract2 = new File("/Users/sharan/final-year-project/contractsDB/localhost:8081-new.yaml");
        ChangedOpenApi diff = OpenApiCompare.fromFiles(contract1, contract2);

        String render = new HtmlRender("Changelog",
                "http://deepoove.com/swagger-diff/stylesheets/demo.css")
                .render(diff);
        System.out.println(render);
    }

}
