# Final project
# Ice Cream Shop Ordering System

A Java console application built for the **Software Design Patterns (SDP)** course that demonstrates the practical collaboration of six classic Gang of Four (GoF) design patterns across Creational, Structural, and Behavioral categories.


---

The **Ice Cream Shop Ordering System** simulates a complete customer order workflow:
1. Choosing a base ice cream flavor (**Vanilla**, **Chocolate**, or **Strawberry**).
2. Dynamically adding multiple toppings (**Chocolate Syrup**, **Sprinkles**, **Waffle Cone**, **Crushed Nuts**).
3. Configuring order preferences (**Serving Style**: Cup/Cone, **Takeaway**, **Spoon inclusion**).
4. Processing payment via **Cash**, **Card**, or an external third-party mobile API (**Kaspi Pay**).

---

## Design Patterns Used

| Pattern | Category | Package | Role in the System |
| :--- | :--- | :--- | :--- |
| **Factory Method** | Creational | `icecreamshop.factory` | Instantiates concrete ice cream flavors (`VanillaIceCream`, `ChocolateIceCream`, `StrawberryIceCream`) via `IceCreamCreator` subclasses. |
| **Decorator** | Structural | `icecreamshop.decorator` | Dynamically wraps a base `IceCream` object with multiple `ToppingDecorator` layers, accumulating descriptions and prices at runtime. |
| **Builder** | Creational | `icecreamshop.builder` | Assembles complex `IceCreamOrder` objects step-by-step using `IceCreamOrderBuilder` with validation and safe defaults. |
| **Strategy** | Behavioral | `icecreamshop.payment` | Encapsulates interchangeable payment algorithms (`CashPayment`, `CardPayment`) behind the `PaymentStrategy` interface. |
| **Adapter** | Structural | `icecreamshop.payment` | `KaspiPayAdapter` adapts the incompatible third-party `ExternalKaspiPayService` (`int` KZT + `merchantId`) to `PaymentStrategy`. |
| **Facade** | Structural | `icecreamshop.facade` | `IceCreamShopFacade` provides a unified interface (`placeFullOrder()`) that orchestrates all subsystems and acts as the Strategy Context. |

---

## Project Structure

```text
SDP-final/
└── src/
    └── icecreamshop/
        ├── Main.java                             
        ├── model/
        │   ├── IceCream.java                     
        │   └── IceCreamOrder.java                
        ├── factory/                              
        │   ├── IceCreamCreator.java
        │   ├── VanillaCreator.java
        │   ├── ChocolateCreator.java
        │   ├── StrawberryCreator.java
        │   ├── VanillaIceCream.java
        │   ├── ChocolateIceCream.java
        │   └── StrawberryIceCream.java
        ├── decorator/                           
        │   ├── ToppingDecorator.java
        │   ├── ChocolateSyrupDecorator.java
        │   ├── SprinklesDecorator.java
        │   ├── WaffleConeDecorator.java
        │   └── CrushedNutsDecorator.java
        ├── payment/                              
        │   ├── PaymentStrategy.java
        │   ├── CashPayment.java
        │   ├── CardPayment.java
        │   ├── ExternalKaspiPayService.java
        │   └── KaspiPayAdapter.java
        ├── builder/                              
        │   └── IceCreamOrderBuilder.java
        └── facade/                               
            └── IceCreamShopFacade.java