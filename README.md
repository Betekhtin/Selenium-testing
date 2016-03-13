# Selenium-testing
Acquaintance with Selenium WebDriver
##1. Preparing IDE
- Install [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- Install [Java Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)  for your platform
- In project parameters choose Maven as a build tool and JDK as a project SDK
- In [pom.xml](/pom.xml) include dependencies for WebDriver and TestNG: [Web Driver for Java](http://www.seleniumhq.org/docs/03_webdriver.jsp#introducing-webdriver), [Test NG for Maven](http://testng.org/doc/maven.html)<br />
It should look like this:

        ```
        <project>
        ...
           <dependencies>
              <dependency>
                <groupId>org.seleniumhq.selenium</groupId>
                <artifactId>selenium-java</artifactId>
                <version>2.52.0</version>
              </dependency>
              <dependency>
                <groupId>org.testng</groupId>
                <artifactId>testng</artifactId>
                <version>6.8</version>
                <scope>test</scope>
              </dependency>
            </dependencies>
        ...
        </project>
        ```


##2. Setting up Firefox
- Download [Firefox](https://www.mozilla.org/ru/firefox/new/?scene=2)
- Install [Firepath](https://addons.mozilla.org/rU/firefox/addon/firepath/) and [Firebug](https://getfirebug.com/firstrun#Firebug 2.0.14) plugins. (You can also do it using Firefox plugin manager in Menu > Plugins)

##Useful links
- Selenium Java API [documentation](http://selenium.googlecode.com/svn@7074/trunk/docs/api/java/index.html).
- [Selenium official website](http://www.seleniumhq.org/)

##Commit errors
To avoid commit error with CRLF you can use git shell commands: <br />
$ git config --global core.autocrlf false <br />
$ git config --global core.safecrlf false
