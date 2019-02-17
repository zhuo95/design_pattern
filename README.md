## Creational

### [1.simple factory](https://github.com/zhuo95/design_pattern/tree/master/src/main/java/com/zz/design_pattern/pattern/creational/simplefactory)

<img src="https://github.com/zhuo95/design_pattern/blob/master/src/main/resources/static/simple_factory.png" width = "400" height = "300" align=center />
  
<br/>

```
public abstract class Video {
    public abstract void produce();
}
```

```$xslt
public class VideoFactory {
    //反射优化
    public Video getVideo(Class clazz){
        Video video = null;
        try {
            video = (Video) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return video;
    }
    
     public static void main(String[] args) {
            VideoFactory videoFactory = new VideoFactory();
            Video video = videoFactory.getVideo(JavaVideo.class);
            if (video==null) return;
            video.produce();
       }
}

```

### [2.factory method](https://github.com/zhuo95/design_pattern/tree/master/src/main/java/com/zz/design_pattern/pattern/creational/factorymethod)

<img src="https://github.com/zhuo95/design_pattern/blob/master/src/main/resources/static/factory_method.png" width = "400" height = "300" align=center />
<br/>

factory method defines a interface to create objects, lets the classes which extends itself produce the object.
Initiation of products is delayed into children class.
  
Factory abstraction:
```$xslt
public abstract class VideoFactory {
    public abstract Video getVideo();
}
```

JavaVideo factory:
```$xslt
public class JavaVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
```

PythonVideo factory:
```$xslt
public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("python video");
    }
}

```

Compare with simple factory, it is more expansible

### [3. abstract factory](https://github.com/zhuo95/design_pattern/tree/master/src/main/java/com/zz/design_pattern/pattern/creational/abstractfactory)

<img src="https://github.com/zhuo95/design_pattern/blob/master/src/main/resources/static/abstract_factory.png" width = "400" height = "300" align=center />
<br/>

In Abstract Factory pattern an interface is responsible for creating a factory of related objects without explicitly specifying their classes.

```$xslt
// interface for creating the factory
public interface CourseFactory {
    Video getVideo();

    Note getNote();
}
```

A factory implements the interface:
```$xslt
public class JavaCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Note getNote() {
        return new JavaNote();
    }
}
```

Abstract factory creates products from the same product family(like JavaNote and JavaVideo, they are all from JavaCourse family)

### [4. singleton](https://github.com/zhuo95/design_pattern/tree/master/src/main/java/com/zz/design_pattern/pattern/creational/singleton)

guarantee the class just has one object, can be used in threadpool or database connection cache

* private constructor
* thread safe
* delayed loading
* serialization
* reflect

##### implementation:

1. HungrySingleton

```$xslt
public class HungrySingleton implements Cloneable {
    private final static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }

}
```
2. LazySingleton
  
need to use synchronized to make it thread safe
```$xslt
public class LazySingleton {
    private static LazySingleton lazySingleton = null;
    private LazySingleton(){

    }

//    //not thread safe
//    public static LazySingleton getInstance(){
//        if(lazySingleton == null){
//            lazySingleton = new LazySingleton();
//        }
//        return lazySingleton;
//    }

    public synchronized static LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
```

3. Enum

```$xslt
public class SingletonExample {
    
    private SingletonExample(){}

    private static SingletonExample getInstance(){
        return Singleton.INSTANCE.getSingleton();
    }

    //enum
    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        //jvm guarantee this function is just executed once
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getSingleton(){
            return singleton;
        }
    } 
}
```

### [5. builder](https://github.com/zhuo95/design_pattern/tree/master/src/main/java/com/zz/design_pattern/pattern/creational/builder)
The Builder is a design pattern designed to provide a flexible solution to various object creation problems.
It can be used when a class has many fields 
  
  inner static class, every build function returns itself
```$xslt
public class Course {
    private String name;
    private String PPT;
    private String video;
    private String note;
    private String QA;

    public Course(CourseBuilder courseBuilder){
        this.name = courseBuilder.name;
        this.note = courseBuilder.note;
        this.PPT = courseBuilder.PPT;
        this.QA = courseBuilder.QA;
        this.video = courseBuilder.video;
    }

    public static class CourseBuilder{
        private String name;
        private String PPT;
        private String video;
        private String note;
        private String QA;

        public CourseBuilder buildNmae(String courseName){
            this.name = courseName;
            return this;
        }

        public CourseBuilder buildPPT(String coursePPT) {
            this.PPT = coursePPT;
            return this;
        }

        public CourseBuilder buildVideo(String courseVideo) {
            this.video = courseVideo;
            return this;
        }

        public CourseBuilder buildNote(String courseNote) {
            this.note = courseNote;
            return this;
        }

        public CourseBuilder buildQA(String courseQA) {
            this.QA = courseQA;
            return this;
        }

        public Course build(){
            return new Course(this);
        }

    }
}

```

StringBuilder append function in Java
```$xslt
public StringBuilder append(String var1) {
    super.append(var1);
    return this;
}

```

### [6. prototype](https://github.com/zhuo95/design_pattern/tree/master/src/main/java/com/zz/design_pattern/pattern/creational/prototype)

prototype pattern creates objects through clone instead of new, it can be used when initiating a instance takes a lot of time
  
class should implement Cloneable and have getter and setter
```$xslt
public class Mail implements Cloneable{
    private String name;
    private String emailAddress;
    private String content;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone method");
        return super.clone();
    }

    public Mail(){
        System.out.println("Mail class Constructor");
    }

    @Override
    public String toString() {
        return "Mail{" +
                "name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
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
```

## structural

### [1. facade](https://github.com/zhuo95/design_pattern/tree/master/src/main/java/com/zz/design_pattern/pattern/structural/facade)

<img src="https://github.com/zhuo95/design_pattern/blob/master/src/main/resources/static/facade.png" width = "400" height = "300" align=center />
  
<br/>
this is a gift-exchange system which contains 2 sub services.
GiftExchangeService provides apis to visit two sub services.
Customer(Test) just need to interact with GiftExchangeService.



### [1. adaptor](https://github.com/zhuo95/design_pattern/tree/master/src/main/java/com/zz/design_pattern/pattern/structural/adapter)

provide a adaptor of one class to another, make them be able to work together

<img src="https://github.com/zhuo95/design_pattern/blob/master/src/main/resources/static/adapter.png" width = "400" height = "300" align=center />
  
<br/>

two ways of implementation

1. object adapter (target is the interface you want to adjust)
```$xslt
//adaptee被适配的类
public class Adaptee {
    public void adapteeRequest(){
        System.out.println("被适配者的方法");
    }
}

//adapter 在适配器中new 一个 被适配的类
public class Adapter implements Target {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
```

2. class adapter
```$xslt
public class Adaptee {
    public void adapteeRequest(){
        System.out.println("被适配者的方法");
    }
}


/**
 * 类适配器模式
 * Adaptee 是被适配的类
 * 通过继承来获取Adaptee 的方法
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        super.adapteeRequest();
    }
}

```