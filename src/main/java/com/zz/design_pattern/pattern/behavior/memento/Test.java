package com.zz.design_pattern.pattern.behavior.memento;

/**
 * 备忘录模式，后悔药
 */
public class Test {

    public static void main(String[] args) {
        ArticleMementoManager articleMementoManager = new ArticleMementoManager();
        Article article = new Article("zz教学","zz老师","123");
        ArticleMemento articleMemento1 = article.saveToMemento();
        articleMementoManager.addMemento(articleMemento1);
        System.out.println(article.toString());
        article.setContent("zz2");
        article.setTitle("zz教学2");
        System.out.println(article.toString());
        article.undoFromMemento(articleMementoManager.getMemento());
        System.out.println(article.toString());
    }
}
