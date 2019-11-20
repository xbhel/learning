package com.xbhel.ut.mock.api;

import lombok.Getter;

/**
 * @Author: xbhel
 * @Date: 2019/11/20 22:23
 * @Description:
 */
@Getter
public class ArticleManager {
    /**
     * field setter
     */
    private ArticleCalculator  calculator;
    private ArticleDatabase database;

    /**
     * Constructor injection 构造注入会使用该构造
     * @param calculator
     * @param database
     */
    public ArticleManager(ArticleCalculator calculator, ArticleDatabase database) {
        this.calculator=calculator;
        this.database=database;
        // parameterized constructor
        System.out.println("two params");
    }

    public ArticleManager(ArticleCalculator calculator) {
        this.calculator = calculator;
        System.out.println("one params");
    }

    /**
     * Property setter
     * @param calculator
     */
    public void setCalculator(ArticleCalculator calculator) {
        this.calculator = calculator;
    }

    /**
     * Property setter
     * @param database
     */
    public void setDatabase(ArticleDatabase database) {
        this.database = database;
    }
}
