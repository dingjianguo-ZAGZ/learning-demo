package com.su.springdataesdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "product", createIndex = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    private Integer id;
    @Field(type = FieldType.Text, store = true, index = true, analyzer = "ik_max_words", searchAnalyzer = "ik_max_words")
    private String productName;
    @Field(type = FieldType.Text, store = true, index = true, analyzer = "ik_max_words", searchAnalyzer = "ik_max_words")
    private String productDesc;
}
