## Creational

### 1.simple factory

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

### 2.factory method

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