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



### [2. adaptor](https://github.com/zhuo95/design_pattern/tree/master/src/main/java/com/zz/design_pattern/pattern/structural/adapter)

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

### [3. decorator](https://github.com/zhuo95/design_pattern/tree/master/src/main/java/com/zz/design_pattern/pattern/structural/decorator)

add new feature to the object without changing the original object
it is more flexible than inheritance

add new features to a class without decorator:  based on extends
```$xslt
public class Cake {
    protected String getName(){
        return "煎饼";
    }

    protected int cost(){
        return 8;
    }
}
// add egg by overriding the function
public class CakeWithEgg extends Cake {
    @Override
    protected String getName() {
        return super.getName() + "加一个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost()+ 1;
    }
}

public class CakeWithEggAndSausage extends CakeWithEgg {
    @Override
    protected String getName() {
        return super.getName() + "加一个香肠";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }
}

```

improve with decorator pattern:

```$xslt
public abstract class ACake {
    protected abstract String getName();

    protected abstract int cost();
}
```
abstraction of decorator:
```$xslt
//composite the Acake into decorator
public abstract class AbstractDecorator extends ACake {
    private ACake aCake;

    public AbstractDecorator(ACake aCake) {
        this.aCake = aCake;
    }

    @Override
    protected String getName() {
        return this.aCake.getName();
    }

    @Override
    protected int cost() {
        return this.aCake.cost();
    }

    protected abstract void dosomething();
}

```

```$xslt
public class Cake extends ACake {
    @Override
    protected String getName() {
        return "普通煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}

public class EggDecorator extends AbstractDecorator{
    public EggDecorator(ACake aCake) {
        super(aCake);
    }

    @Override
    protected void dosomething() {

    }

    @Override
    protected String getName() {
        return super.getName()+"加鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost() +1;
    }
}

public class SausageDecorator extends AbstractDecorator{
    public SausageDecorator(ACake aCake) {
        super(aCake);
    }

    @Override
    protected void dosomething() {

    }

    @Override
    protected String getName() {
        return super.getName() + "加一根香肠";
    }

    @Override
    protected int cost() {
        return super.cost() +2;
    }
}

 public static void main(String[] args) {
        ACake aCake = new Cake();

        aCake = new EggDecorator(aCake);

        ACake bCake = new SausageDecorator(aCake);

        ACake cCake = new EggDecorator(aCake);

        System.out.println(aCake.getName()+ " 价格：" + aCake.cost());
  }

```

It is better than extends because all decorations can be dynamically removed

##### Implementation in JDK:  
Java IO: inputStream
```$xslt
FileInputStream fileInputStream = new FileInputStream(filePath);
BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
```
BufferedInputStream is a decorator of FileInputStream, provide buffer functionality


### [4. composite](https://github.com/zhuo95/design_pattern/tree/master/src/main/java/com/zz/design_pattern/pattern/structural/composite)

<img src="https://github.com/zhuo95/design_pattern/blob/master/src/main/resources/static/composite.png" width = "400" height = "300" align=center />
  
<br/>

composite the objects to a tree structure, then we can treat the whole structure as a simple object

e.g.  
we have course object and courseCatalog(composite with course) object, if we make them extend
from the same abstract class, they can be treated as the same object but with different operations.

```$xslt
/**
 * 课程目录
 */
public abstract class CatalogComponent {
    public void add(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持添加课程");
    }

    public void remove(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持删除课程");
    }

    public String getName(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取课程");
    }

    public Double getPrice(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取课程价格");
    }

    public void print(){
        throw new UnsupportedOperationException("不支持打印");
    }
}
```

```$xslt
// course class
public class Course extends CatalogComponent {
    private String name;
    private double price;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public Double getPrice(CatalogComponent catalogComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println("Course name: "+this.name+", price: "+price);
    }
}
// catalog class
public class CourseCatalog extends CatalogComponent {
    private List<CatalogComponent> items = new ArrayList<CatalogComponent>();
    private Integer level;

    private String name;

    public CourseCatalog(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
       items.remove(catalogComponent);
    }

    /**
     * 这里有个坑，组合模式的缺点，难以区别组合的对象到底是谁，这里用level区别
     */
    @Override
    public void print() {
        System.out.println(this.name);
        for (CatalogComponent catalogComponent: items){
            if (this.level!=null){
                for (int i=0;i<this.level;i++){
                    System.out.print("    ");
                }
            }
            catalogComponent.print();
        }
    }
}
```

implementation in java  
java.awt.Container  (GUI)


### [5. proxy](https://github.com/zhuo95/design_pattern/tree/master/src/main/java/com/zz/design_pattern/pattern/structural/proxy)

provide a proxy of a object to control the access to this object.  
* protect the object
* reinforce the object(implement some new features)  


e.g. we want to do a database hash algorithm to decide insert into which database before the insert operation


##### static proxy
```$xslt
public class OrderServiceStaticProxy {
    private IOrderService iOrderService;

    public int saveOrder(Order order){
        beforeMethod(order);
        iOrderService = new OrderServiceImpl();
        int res = iOrderService.saveOrder(order);
        afterMethod();
        return res;
    }

    //数据库分库
    private void beforeMethod(Order order){
        int userid = order.getUserId();
        int dbRouter = userid%2;
        System.out.println("静态代理分配到 【db "+dbRouter +"】处理数据");
        //todo 设置datasource 用于分库
        DataSourceContextHolder.setDBType(String.valueOf(dbRouter));
        System.out.println("before called");
    }

    private void afterMethod(){
        System.out.println("after called");
    }
    
    
    public static void main(String[] args) {
            Order order = new Order();
            // order.setUserId(1);
            order.setUserId(2);
            OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
            orderServiceStaticProxy.saveOrder(order);
    }
}
```
##### dynamic proxy

* implement InvocationHandler
* override invoke
* Proxy.newProxyInstance bind

```$xslt
/**
 * 动态代理不止可以代理orderservice，可以代理多个service.
 */
public class OrderServiceDynamicProxy implements InvocationHandler {
    private Object target;

    //target 是代理的目标类
    public OrderServiceDynamicProxy(Object target){
        this.target = target;
    }


    public Object bind(){
        Class clss = target.getClass();
        return Proxy.newProxyInstance(clss.getClassLoader(),clss.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object argObject = args[0];
        beforMethod(argObject);
        Object object = method.invoke(target, args);
        afterMethod();
        return object;
    }


    public void beforMethod(Object obj) {
        int userId = 0;
        System.out.println("动态代理，before called");
        if (obj instanceof Order) {
            Order order = (Order) obj;
            int dbRouter = userId % 2;
            System.out.println("动态代理分配到 【db " + dbRouter + "】处理数据");
            //todo 设置datasource 用于分库
            DataSourceContextHolder.setDBType(String.valueOf(dbRouter));

        }
    }

    private void afterMethod(){
        System.out.println("after called");
    }
    
     public static void main(String[] args) {
            Order order = new Order();
            // order.setUserId(1);
            order.setUserId(2);
            IOrderService orderService =(IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
            orderService.saveOrder(order);
     }

}

```

## behavior

#### [1. strategy](https://github.com/zhuo95/design_pattern/tree/master/src/main/java/com/zz/design_pattern/pattern/behavior/strategy)

design a algorithm family, make them interchangeable, and this pattern doesn't interfere clients to use the algorithm

you can use it when:  
* system has a lot of classes, but just with different behaviors
* system need to choose a algorithm dynamically

```$xslt
// different promotion strategies

//打折
public class DaZhePromotion implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.printf("\n打折促销");
    }
}


//返现
public class FanXianPromotion implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("\n返回现金促销");
    }
}

// strategy interface
public interface PromotionStrategy {
    void doPromotion();
}
```
```
// factory
public class PromotionStrategyFactory {
    private static Map<String,PromotionStrategy> PROMOTION_MAP = new HashMap<>();

    private PromotionStrategyFactory() {
    }

    static {
        PROMOTION_MAP.put("DAZHE",new DaZhePromotion());
        PROMOTION_MAP.put("DIJIAN",new FanXianPromotion());
        PROMOTION_MAP.put("EMPTY", new EmptyPromotion());
    }

    public static PromotionStrategy getPromotionStrategy(String key) {
        if(!PROMOTION_MAP.containsKey(key)) return PROMOTION_MAP.get("EMPTY");
        return PROMOTION_MAP.get(key);
    }
}

public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void executePromotionStrategy(){
        promotionStrategy.doPromotion();
    }
}



```
