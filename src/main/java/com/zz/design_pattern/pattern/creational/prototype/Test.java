package com.zz.design_pattern.pattern.creational.prototype;

/**
 * 原型模式是在内存中进行二进制流的拷贝
 * 克隆的时候不会调用构造器
 *
 * 适用场景：类初始化消耗较多资源，new 产生的一个对象需要非常繁琐的过程（数据准备，访问权限等），构造函数比较复杂，循环体中生产大量对象时
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("初始化模版");
        for (int i=0;i<10;i++){
            //使用原型模式 克隆来发送
            //每个克隆出来的都有自己的内存地址
            Mail mailTemp = (Mail) mail.clone();
            mailTemp.setName("姓名"+i);
            mailTemp.setEmailAddress("姓名"+i+"@zz.com");
            mailTemp.setContent("恭喜您中奖了");
            MailUtil.sendMail(mailTemp);
        }

        MailUtil.saveOriginMailRecord(mail);
    }
}
