# Design Patterns and Principles

This repository contains concrete implementations of 11 core software design patterns, structured as a multi-module Maven project. These patterns demonstrate structural, creational, and behavioral design principles to build robust, maintainable, and loosely coupled systems.

---

## Project Structure

The component is configured as a parent Maven project containing 11 independent modules:
* **SingletonPatternExample**: Thread-safe Logger utility using volatile double-checked locking.
* **FactoryMethodPatternExample**: Word, PDF, and Excel document creation using factory inheritance.
* **BuilderPatternExample**: Computer construction with optional parameters using a nested static builder.
* **AdapterPatternExample**: Interfacing third-party payment gateways (PayPal, Stripe) via a unified PaymentProcessor interface.
* **DecoratorPatternExample**: Modular notifier extending core email notification with SMS and Slack decorator wrappers.
* **ProxyPatternExample**: Image viewer wrapping a remote image loader with lazy initialization and caching.
* **ObserverPatternExample**: Stock market subject pushing price update events to mobile and web observers.
* **StrategyPatternExample**: Dynamic runtime payment processor using Credit Card or PayPal strategies.
* **CommandPatternExample**: Invoker-based remote control execution of light toggle receiver operations.
* **MVCPatternExample**: Standard Model-View-Controller separation for managing student record synchronization.
* **DependencyInjectionExample**: Service decoupling via constructor injection of Repository interfaces.

---

## Detailed Learnings

### 1. Creational Patterns
* **Singleton**: Ensures a class has only one instance and provides a global point of access. We learned that simple lazy initialization is prone to race conditions in multithreaded environments. By declaring the instance variable `volatile` and using two nested null-checks inside a `synchronized(Logger.class)` block, we prevent multiple threads from instantiating distinct Logger objects.
* **Factory Method**: Defines an interface for creating an object but lets subclasses decide which class to instantiate. This enforces the Open-Closed Principle (OCP); adding a new document type (e.g., HTML) only requires adding a new concrete class and factory without editing existing factories.
* **Builder**: Decouples the construction of a complex object from its representation. This solves the telescoping constructor anti-pattern when an object has many optional attributes, promoting readability and immutability.

### 2. Structural Patterns
* **Adapter**: Converts the interface of a class into another interface clients expect. This enables classes to work together that couldn't otherwise due to incompatible interfaces. For example, Stripe expects charges in cents, while PayPal expects payments in dollars; the adapters handle this data scaling inside their respective implementation wrappers.
* **Decorator**: Dynamically attaches additional responsibilities to an object. Decorators provide a flexible alternative to subclassing for extending functionality. By nesting decorators, we can compose email, SMS, and Slack notifications dynamically.
* **Proxy**: Provides a surrogate or placeholder for another object to control access to it. We implemented a virtual proxy to defer the heavy operation of loading an image from a remote server until the image is actually displayed (lazy loading), and cached the loaded instance to prevent redundant network calls.

### 3. Behavioral Patterns
* **Observer**: Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified automatically. This decouples the subject (StockMarket) from the observers (MobileApp, WebApp).
* **Strategy**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it. It avoids conditional branch statements (if-else) in execution paths.
* **Command**: Encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.
* **MVC (Model-View-Controller)**: Separates business data (Model), presentation logic (View), and control flow (Controller). This separation of concerns prevents UI classes from becoming bloated with business validation rules.

---

## How to Execute

Compile and run all unit tests from the project root:
```bash
mvn clean test
```

### Verified Execution Output

```text
[INFO] Reactor Summary for design-patterns-parent 1.0-SNAPSHOT:
[INFO] 
[INFO] design-patterns-parent ............................. SUCCESS [  0.243 s]
[INFO] singletonpatternexample ............................ SUCCESS [  9.456 s]
[INFO] factorymethodpatternexample ........................ SUCCESS [  1.051 s]
[INFO] builderpatternexample .............................. SUCCESS [  0.932 s]
[INFO] adapterpatternexample .............................. SUCCESS [  0.929 s]
[INFO] decoratorpatternexample ............................ SUCCESS [  0.836 s]
[INFO] proxypatternexample ................................ SUCCESS [  1.927 s]
[INFO] observerpatternexample ............................. SUCCESS [  0.915 s]
[INFO] strategypatternexample ............................. SUCCESS [  0.820 s]
[INFO] commandpatternexample .............................. SUCCESS [  0.869 s]
[INFO] mvcpatternexample .................................. SUCCESS [  0.809 s]
[INFO] dependencyinjectionexample ......................... SUCCESS [  0.808 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  19.769 s
```
