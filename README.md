Extract from spring-framework guide
- # Instantiating beans
  
  1. ## Instantiation with a Constructor
    Most Spring users prefer actual JavaBeans with only a default (no-argument) constructor and appropriate setters and getters modeled after the properties in the container

```xml
      <bean id="exampleBean" class="examples.ExampleBean"/>
      <bean name="anotherExample" class="examples.ExampleBeanTwo"/>
```

  2. ## Instantiation with a Static Factory Method
```java
public class ClientService {
    private static ClientService clientService = new ClientService();
    private ClientService() {}

    public static ClientService createInstance() {
        return clientService;
    }
}
```xml
<bean id="clientService" class="examples.ClientService" factory-method="createInstance"/>
```
  3. ## Instantiation by Using an Instance Factory Method
```java
  public class DefaultServiceLocator {

  private static ClientService clientService = new ClientServiceImpl();

  public ClientService createClientServiceInstance() {
      return clientService;
  }
}
```
```xml
  <!-- the factory bean, which contains a method called createInstance() -->
  <bean id="serviceLocator" class="examples.DefaultServiceLocator">
  <!-- inject any dependencies required by this locator bean -->
  </bean>

  <!-- the bean to be created via the factory bean -->
  <bean id="clientService" factory-bean="serviceLocator" factory-method="createClientServiceInstance"/>
 ```
>   Note:One factory class can also hold more than one factory method
- # <ins> Dependency Injection </ins>
  1. ## Constructor-based DI
    - #### When no ambiguity exists in argumnets.
      -If no potential ambiguity exists in the constructor arguments of a bean definition, the order in which the constructor arguments are defined in a bean definition is the order in which those arguments are supplied to the appropriate constructor when the bean is being instantiated. 
```java
package x.y;
public class ThingOne {

    public ThingOne(ThingTwo thingTwo, ThingThree thingThree) {
        // ...
    }
}

```
```xml
<beans>
      <bean id="beanOne" class="x.y.ThingOne">
          <constructor-arg ref="beanTwo"/>
          <constructor-arg ref="beanThree"/>
      </bean>

      <bean id="beanTwo" class="x.y.ThingTwo"/>

      <bean id="beanThree" class="x.y.ThingThree"/>
</beans>
```
  - #### When ambiguity exists, type or index has to be specified.

```java
package examples;

public class ExampleBean {

    // Number of years to calculate the Ultimate Answer
    private int years;

    // The Answer to Life, the Universe, and Everything
    private String ultimateAnswer;

    public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }
}

```
```xml
<bean id="exampleBean" class="examples.ExampleBean">
    <constructor-arg type="int" value="7500000"/>
    <constructor-arg type="java.lang.String" value="42"/>
</bean>
```
```xml
<bean id="exampleBean" class="examples.ExampleBean">
    <constructor-arg index="0" value="7500000"/>
    <constructor-arg index="1" value="42"/>
</bean>
```
   2. ## Setter-Based DI
```java
public class ExampleBean {

  private AnotherBean beanOne;

  private YetAnotherBean beanTwo;

  private int i;

  public void setBeanOne(AnotherBean beanOne) {
      this.beanOne = beanOne;
  }

  public void setBeanTwo(YetAnotherBean beanTwo) {
      this.beanTwo = beanTwo;
  }

  public void setIntegerProperty(int i) {
      this.i = i;
  }
}
```

```xml
  <bean id="exampleBean" class="examples.ExampleBean">
  <!-- setter injection using the nested ref element -->
  <property name="beanOne">
      <ref bean="anotherExampleBean"/>
  </property>

    <!-- setter injection using the neater ref attribute -->
    <property name="beanTwo" ref="yetAnotherBean"/>
    <property name="integerProperty" value="1"/>
  </bean>

  <bean id="anotherExampleBean" class="examples.AnotherBean"/>
  <bean id="yetAnotherBean" class="examples.YetAnotherBean"/>
```
   3. constructor-arg to static factory method
```xml
<bean id="exampleBean" class="examples.ExampleBean" factory-method="createInstance">
    <constructor-arg ref="anotherExampleBean"/>
    <constructor-arg ref="yetAnotherBean"/>
    <constructor-arg value="1"/>
</bean>

<bean id="anotherExampleBean" class="examples.AnotherBean"/>
<bean id="yetAnotherBean" class="examples.YetAnotherBean"/>
```

```java
public class ExampleBean {

    // a private constructor
    private ExampleBean(...) {
        ...
    }

    // a static factory method; the arguments to this method can be
    // considered the dependencies of the bean that is returned,
    // regardless of how those arguments are actually used.
    public static ExampleBean createInstance (
        AnotherBean anotherBean, YetAnotherBean yetAnotherBean, int i) {

        ExampleBean eb = new ExampleBean (...);
        // some other operations...
        return eb;
    }
}
```
- # Dependency Resolution Process
  1. The `ApplicationContext` is created and initialized with configuration metadata that describes all the beans.       Configuration metadata can be specified by XML, Java code, or annotations.
  2. For each bean, its dependencies are expressed in the form of properties, constructor arguments, or arguments to the static-factory method (if you use that instead of a normal constructor). These dependencies are provided to the bean, when the bean is actually created.
  3. Each property or constructor argument is an actual definition of the value to set, or a reference to another bean in the container.
  4. Each property or constructor argument that is a value is converted from its specified format to the actual type of that property or constructor argument. By default, Spring can convert a value supplied in string format to all built-in types, such as `int`, `long`, `String`, `boolean`, and so forth.
  - Other important points
  1. The Spring container validates the configuration of each bean as the container is created. However, the bean properties themselves are not set until the bean is actually created.
    2. Beans that are singleton-scoped and set to be pre-instantiated (the default) are created when the container is created. Otherwise, the bean is created only when it is requested.
    3. Creation of a bean potentially causes a graph of beans to be created, as the bean’s dependencies and its dependencies' dependencies (and so on) are created and assigned. 

