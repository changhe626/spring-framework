分支使用5.2.x  
oracle jdk 1.8
gradle gradle-5.6.4
win10
配置使用了阿里的maven仓库

2021年2月7日  已经编译成功了.

1.在当前父工程的基础上,新建一个gradle子项目(不要建maven的),
以spring-mytest为名字
2.在build.gradle中添加spring-context的依赖, 在dependencies
 中添加上  compile(project(":spring-context"))
3.开始写最初始的spring应用代码.


注入方式:
构造方法和set方法注入.


@Autowired
默认使用type的,如果type没有找到,就根据属性名再找,
否则就报错了,
在属性上的时候, 通过反射的方式进行属性的注入,不适用set方法


@Resource()
可以指定名字和类型, 根据属性名注入.跟set方法的名字无关


The following has been tested against IntelliJ IDEA 2016.2.2

## Steps

_Within your locally cloned spring-framework working directory:_

1. Precompile `spring-oxm` with `./gradlew :spring-oxm:compileTestJava`
2. Import into IntelliJ (File -> New -> Project from Existing Sources -> Navigate to directory -> Select build.gradle)
3. When prompted exclude the `spring-aspects` module (or after the import via File-> Project Structure -> Modules)
4. Code away

## Known issues

1. `spring-core` and `spring-oxm` should be pre-compiled due to repackaged dependencies.
See `*RepackJar` tasks in the build and https://youtrack.jetbrains.com/issue/IDEA-160605).
2. `spring-aspects` does not compile due to references to aspect types unknown to
IntelliJ IDEA. See https://youtrack.jetbrains.com/issue/IDEA-64446 for details. In the meantime, the
'spring-aspects' can be excluded from the project to avoid compilation errors.
3. While JUnit tests pass from the command line with Gradle, some may fail when run from
IntelliJ IDEA. Resolving this is a work in progress. If attempting to run all JUnit tests from within
IntelliJ IDEA, you will likely need to set the following VM options to avoid out of memory errors:
    -XX:MaxPermSize=2048m -Xmx2048m -XX:MaxHeapSize=2048m
4. If you invoke "Rebuild Project" in the IDE, you'll have to generate some test
resources of the `spring-oxm` module again (`./gradlew :spring-oxm:compileTestJava`)    


## Tips

In any case, please do not check in your own generated .iml, .ipr, or .iws files.
You'll notice these files are already intentionally in .gitignore. The same policy goes for eclipse metadata.

## FAQ

Q. What about IntelliJ IDEA's own [Gradle support](https://confluence.jetbrains.net/display/IDEADEV/Gradle+integration)?

A. Keep an eye on https://youtrack.jetbrains.com/issue/IDEA-53476
