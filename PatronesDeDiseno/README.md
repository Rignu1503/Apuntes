
# _Propositos de los patrones creacionales_
# **Singleton**

El patrón Singleton asegura que solo se cree la instancia de objeto de una clase en particular, lo que puede ser útil cuando se necesita exactamente un objeto para coordinar acciones en todo el sistema

### Ejemplo de aplicación:
Imagina que estás desarrollando una aplicación de registro de usuarios para una red social. Quieres asegurarte de que solo haya una instancia de la clase `UserManager` que maneje la creación y gestión de usuarios. Aquí es donde el patrón Singleton entra en juego. Puedes implementar `UserManager` como un Singleton para garantizar que siempre haya una única instancia activa, evitando problemas como la creación accidental de múltiples instancias o conflictos en los datos de usuario. De esta manera, el patrón Singleton te ayuda a mantener la coherencia y la integridad en tu aplicación. 

# **Factory Method**
El Factory Method consiste en crear una interfaz o una clase abstracta que define los métodos necesarios para crear un objeto, pero deja la implementación de esos métodos en las subclases

### Ejemplo de aplicación:
Imagina que estás desarrollando una aplicación de registro de usuarios para una red social. Quieres asegurarte de que solo haya una instancia de la clase `UserManager` que maneje la creación y gestión de usuarios. Aquí es donde el **patrón Factory Method** también puede ser útil.
En lugar de crear directamente instancias de diferentes tipos de usuarios (por ejemplo, usuarios normales, administradores, moderadores), puedes definir una interfaz o clase abstracta llamada `UserFactory`. Cada subclase de `UserFactory` implementaría el método `createUser`, que se encargaría de crear una instancia específica de usuario según el tipo requerido.
Por ejemplo:
- `NormalUserFactory` crea instancias de usuarios normales.
- `AdminUserFactory` crea instancias de administradores.
- `ModeratorUserFactory` crea instancias de moderadores.

De esta manera, el Factory Method te permite crear objetos de diferentes tipos sin acoplar tu código a clases concretas. Además, si en el futuro necesitas agregar nuevos tipos de usuarios, simplemente creas una nueva subclase de `UserFactory` sin afectar el resto del código.

Los patrones de fábrica abstracta funcionan en torno a una superfábrica que crea otras fábricas. Esta fábrica también se denomina fábrica de fábricas. Este tipo de patrón de diseño se incluye en el patrón de creación, ya que proporciona una de las mejores formas de crear un objeto.

# **Abstract Factory**
En el patrón Abstract Factory, una interfaz es responsable de crear una fábrica de objetos relacionados sin especificar explícitamente sus clases. Cada fábrica generada puede proporcionar los objetos según el patrón Factory.

### Ejemplo de aplicación:
Supongamos que estamos desarrollando un videojuego de rol (RPG) y necesitamos crear diferentes tipos de personajes y sus respectivos equipos. Cada personaje tiene una clase (como guerrero, mago o arquero) y un conjunto específico de armas y armaduras asociadas.

En este caso, podríamos utilizar el patrón Abstract Factory de la siguiente manera:

Definición de la interfaz:
Creamos una interfaz FabricaPersonajes que declara métodos para crear personajes `crearPersonaje()` y equipos `crearEquipo()`.
También definimos interfaces para los diferentes tipos de personajes `Personaje` y los elementos de su equipo (Arma, Armadura, etc.).

Implementación concreta:
Creamos dos fábricas concretas: `FabricaFantasia` y `FabricaCienciaFiccion`.
`FabricaFantasia` crea personajes como guerreros, magos y arqueros, junto con espadas, varitas y túnicas.

`FabricaCienciaFiccio` crea personajes como androides, cyborgs y alienígenas, junto con rayos láser, exoesqueletos y trajes espaciales.

Creación de personajes y equipos:
Cuando el jugador elige un mundo (fantasía o ciencia ficción), utilizamos la fábrica correspondiente para crear los personajes y sus equipos.
Por ejemplo, si el jugador selecciona el mundo de fantasía, creamos un guerrero con una espada y una armadura de cuero.

# _Propositos de los patrones Estructurales_
# **Facade**
El patrón de fachada oculta las complejidades del sistema y proporciona una interfaz al cliente mediante la cual este puede acceder al sistema. Este tipo de patrón de diseño se incluye en el patrón estructural, ya que agrega una interfaz al sistema existente para ocultar sus complejidades.

Este patrón involucra una sola clase que proporciona métodos simplificados requeridos por el cliente y delega llamadas a métodos de clases de sistema existentes.

### Ejemplo de aplicación:
Imaginemos que estamos desarrollando una aplicación de comercio electrónico. Esta aplicación necesita realizar varias operaciones complejas, como procesar pagos, verificar el inventario y enviar notificaciones a los clientes. Estas operaciones involucran múltiples subsistemas y clases, lo que puede hacer que el código sea complicado y difícil de mantener. Aquí es donde el patrón Facade puede ser útil.

La interacción directa con cada uno de estos subsistemas puede complicar y hacer que el código sea difícil de mantener. Tendrás que gestionar muchas clases y métodos diferentes, lo que aumenta la posibilidad de errores y hace que el código sea menos claro.

###### Solución con el patrón Facade:
Para simplificar esta complejidad, podemos usar el patrón de diseño Facade. Este patrón te permite crear una "fachada" o una interfaz simple que oculta las complejidades de los subsistemas. La fachada se encarga de interactuar con los subsistemas y proporciona una interfaz unificada y fácil de usar.

*Crear la fachada (`OrderFacade`)
Creamos una clase llamada `OrderFacade`. Esta clase tiene métodos simples que los clientes de la aplicación pueden usar para realizar operaciones complejas de manera sencilla.

Interactuar con los subsistemas:
 La clase `OrderFacade` internamente se encarga de interactuar con los subsistemas de procesamiento de pagos, gestión de inventario y envío de notificaciones. Los clientes de la aplicación no necesitan saber cómo funcionan estos subsistemas; solo necesitan llamar a los métodos de la fachada.

Ejemplo de uso:
Cuando un cliente quiere realizar un pedido, simplemente llama al método `place_order` de la fachada. Este método se encarga de:
   - Verificar si el producto está disponible en el inventario.
   - Procesar el pago del cliente.
   - Enviar una notificación al cliente informando sobre el estado del pedido.

# _Propositos de los patrones de Comportamiento_
# **Strategy**
En el patrón de estrategia, el comportamiento de una clase o su algoritmo se puede modificar en tiempo de ejecución. Este tipo de patrón de diseño se incluye en el patrón de comportamiento.

En el patrón Estrategia, creamos objetos que representan varias estrategias y un objeto de contexto cuyo comportamiento varía según su objeto de estrategia. El objeto de estrategia cambia el algoritmo de ejecución del objeto de contexto.

### Ejemplo de aplicación:
Imaginemos que estamos desarrollando una aplicación de procesamiento de imágenes. Esta aplicación necesita aplicar diferentes filtros a las imágenes, como un filtro de desenfoque, un filtro de escala de grises o un filtro de aumento de contraste. Queremos que la aplicación sea flexible y permita cambiar fácilmente entre diferentes filtros sin modificar el código existente. Aquí es donde el patrón Strategy puede ser útil.


La aplicaión debe poder aplicar diferentes filtros a las imágenes. Si implementamos todos los filtros directamente en la clase principal, el código se volverá complicado y difícil de mantener. Además, cambiar o agregar nuevos filtros requeriría modificar la clase principal, lo que no es ideal.

###### Solución con el patrón Strategy:
Para resolver este problema, podemos usar el patrón de diseño Strategy. Este patrón nos permite definir una familia de algoritmos de filtros, encapsular cada uno de ellos y hacerlos intercambiables. La aplicación puede elegir el filtro adecuado en tiempo de ejecución.

Definir la interfaz de estrategia (`ImageFilter`):

Creamos una interfaz llamada `ImageFilter` que declara un método para aplicar el filtro `apply(image)`.

Implementar estrategias concretas:
Creamos varias clases que implementan la interfaz `ImageFilter`, cada una con un algoritmo de filtro específico:
   - `BlurFilter`: Implementa el filtro de desenfoque.
   - `GrayscaleFilter`: Implementa el filtro de escala de grises.
   - `ContrastFilter`: Implementa el filtro de aumento de contraste.

Contexto (`ImageProcessor`):
Creamos una clase `ImageProcessor` que tiene una referencia a un objeto `ImageFilter`. Esta clase utiliza el filtro configurado para procesar las imágenes.

Ejemplo de uso:
Cuando el usuario desea aplicar un filtro a una imagen, selecciona el filtro adecuado y configura el `ImageProcessor` con la estrategia correspondiente. Luego, llama al método `apply_filter` de `ImageProcessor`, que delega la operación al filtro configurado.
