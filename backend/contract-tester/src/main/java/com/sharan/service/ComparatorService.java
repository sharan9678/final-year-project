package com.sharan.service;

import com.sharan.model.ComparatorResult;
import org.checkerframework.checker.units.qual.C;
import org.openapitools.openapidiff.core.OpenApiCompare;
import org.openapitools.openapidiff.core.model.ChangedOpenApi;
import org.openapitools.openapidiff.core.output.HtmlRender;
import org.openapitools.openapidiff.core.output.JsonRender;
import org.openapitools.openapidiff.core.output.MarkdownRender;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ComparatorService {

//    public static void main(String[] args) {
//
//        File contract1 = new File("/Users/sharan/final-year-project/backend/contractsDB/localhost:8081-old.yaml");
//        File contract2 = new File("/Users/sharan/final-year-project/backend/contractsDB/localhost:8081-new.yaml");
//        ChangedOpenApi diff = OpenApiCompare.fromFiles(contract1, contract2);
//
////        String render = new HtmlRender("Changelog",
////                "http://deepoove.com/swagger-diff/stylesheets/demo.css")
////                .render(diff);
//        String render = new MarkdownRender().render(diff);
//        System.out.println(render);
//    }

    public ComparatorResult getHtmlRender(File contract1, File contract2) {
        ComparatorResult comparatorResult = new ComparatorResult();
        ChangedOpenApi diff = OpenApiCompare.fromFiles(contract1, contract2);
        comparatorResult.setContract1(contract1.getName());
        comparatorResult.setContract2(contract2.getName());
        comparatorResult.setCompatible(diff.isCompatible());
        comparatorResult.setResult(new HtmlRender().render(diff));
        return comparatorResult;
    }

    public ComparatorResult getMarkdownRender(File contract1, File contract2) {
        ComparatorResult comparatorResult = new ComparatorResult();
        ChangedOpenApi diff = OpenApiCompare.fromFiles(contract1, contract2);
        comparatorResult.setContract1(contract1.getName());
        comparatorResult.setContract2(contract2.getName());
        comparatorResult.setCompatible(diff.isCompatible());
        comparatorResult.setResult(new MarkdownRender().render(diff));
        return comparatorResult;
    }

    public ComparatorResult getJsonRender(File contract1, File contract2) {
        ComparatorResult comparatorResult = new ComparatorResult();
        ChangedOpenApi diff = OpenApiCompare.fromFiles(contract1, contract2);
        comparatorResult.setContract1(contract1.getName());
        comparatorResult.setContract2(contract2.getName());
        comparatorResult.setCompatible(diff.isCompatible());
        comparatorResult.setResult(new JsonRender().render(diff));
        return comparatorResult;
    }
}
