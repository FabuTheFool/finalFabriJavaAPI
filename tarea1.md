# Conceptos Fundamentales

# 1 -¿Qué es un servicio REST?

Un servicio REST (Representational State Transfer) es un estilo de arquitectura para la comunicación entre sistemas en una red, típicamente usado en aplicaciones web.
Es un enfoque para crear servicios web que permite a las aplicaciones intercambiar datos de manera eficiente.

# 2 -¿Cuáles son los principios del diseño RESTful?

El diseño RESTful sigue una serie de principios que aseguran que los servicios web sean eficientes, escalables y fáciles de mantener. Aquí están los principales principios:

1. Arquitectura Cliente-Servidor
   Separación de responsabilidades: El cliente y el servidor deben estar claramente separados. El cliente maneja la interfaz de usuario y la experiencia del usuario, mientras que el servidor maneja el almacenamiento de datos y la lógica de negocio. Esta separación permite que ambos evolucionen de manera independiente.
2. Comunicación Sin Estado (Stateless)
   Independencia de las solicitudes: Cada solicitud del cliente al servidor debe contener toda la información necesaria para que el servidor entienda y procese la solicitud. El servidor no debe almacenar el estado de las sesiones entre las solicitudes. Esto hace que el sistema sea más escalable y menos propenso a errores relacionados con el estado del cliente.
3. Recursos y Representaciones
   Recursos identificables: En REST, los recursos son las entidades principales, como usuarios, productos o artículos. Cada recurso es identificable mediante una URL única. Por ejemplo, un producto con ID 42 podría estar representado por la URL https://api.tienda.com/productos/42.
   Representaciones: Los recursos pueden ser representados en diferentes formatos, como JSON, XML o HTML, dependiendo de la solicitud del cliente.
4. Uso de Métodos HTTP
   Métodos estándar: RESTful utiliza los métodos HTTP estándar (GET, POST, PUT, DELETE) para realizar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en los recursos.
   Semántica adecuada: Cada método debe usarse para lo que está diseñado. Por ejemplo, GET solo debe utilizarse para recuperar datos, mientras que POST es adecuado para crear nuevos recursos.
5. Interfaz Uniforme
   Consistencia y simplicidad: Una de las características principales de REST es tener una interfaz uniforme. Esto significa que la estructura de las URL, los métodos HTTP y las representaciones de los recursos deben ser consistentes en todo el servicio.
   Recursos identificables: Todos los recursos deben ser accesibles de manera uniforme y predecible.
   Autodescriptivo: Las respuestas deben contener suficiente información para que el cliente pueda entender cómo procesarlas sin necesidad de consultar documentación externa.
6. Cacheabilidad
   Mejoras de rendimiento: Las respuestas de los servicios REST pueden ser almacenadas en caché por el cliente o por intermediarios para mejorar el rendimiento y reducir la carga del servidor. Los encabezados HTTP como Cache-Control determinan si una respuesta es cacheable o no.
7. Sistema en Capas (Layered System)
   Arquitectura modular: Un sistema RESTful puede estar compuesto por múltiples capas que se comunican entre sí. Por ejemplo, puede haber una capa de seguridad, una capa de balanceo de carga y una capa de almacenamiento de datos. Cada capa debe ser independiente y no debe estar consciente de las demás capas.
8. Código Bajo Demanda (Opcional)
   Flexibilidad adicional: Aunque no es un principio obligatorio, REST permite que los servidores envíen código ejecutable al cliente bajo demanda, como scripts o applets. Esto puede mejorar la flexibilidad y la funcionalidad del cliente.
9. Autodescripción de Mensajes
   Mensajes claros: Los mensajes en REST deben ser autodescriptivos, lo que significa que deben contener toda la información necesaria para entender cómo procesar la solicitud o la respuesta. Esto incluye encabezados HTTP, cuerpos de solicitud/respuesta y códigos de estad

# 3 -¿Qué es HTTP y cuáles son los métodos HTTP más comunes?

HTTP (Hypertext Transfer Protocol) es un protocolo de comunicación utilizado para transferir datos en la web. Es la base del intercambio de información entre navegadores web (clientes) y servidores, permitiendo la carga de páginas web, la descarga de archivos, y la comunicación con APIs. HTTP define cómo se formatean y transmiten los mensajes, y cómo deben responder los servidores y clientes a estos mensajes.

# Métodos HTTP más Comunes

# GET

Descripción: Solicita la representación de un recurso específico. Este método es utilizado principalmente para recuperar datos sin causar efectos secundarios en el servidor.
Ejemplo de Uso: Recuperar la lista de usuarios de un sitio web: GET /usuarios
Idempotente: Sí. Repetir la solicitud no cambia el estado del recurso.

# POST

Descripción: Envía datos al servidor para crear un nuevo recurso. Los datos son incluidos en el cuerpo de la solicitud.
Ejemplo de Uso: Crear un nuevo usuario en un sistema: POST /usuarios con los detalles del usuario en el cuerpo de la solicitud.
Idempotente: No. Repetir la solicitud puede resultar en la creación de múltiples recursos similares.

# PUT

Descripción: Actualiza un recurso existente con los datos proporcionados, o crea un nuevo recurso si no existe. Se envía una representación completa del recurso.
Ejemplo de Uso: Actualizar los detalles de un usuario: PUT /usuarios/123 con los nuevos detalles del usuario.
Idempotente: Sí. Repetir la solicitud produce el mismo resultado.

# DELETE

Descripción: Elimina un recurso específico en el servidor.
Ejemplo de Uso: Eliminar un usuario específico: DELETE /usuarios/123.
Idempotente: Sí. Repetir la solicitud elimina el recurso o no hace nada si ya ha sido eliminado.

# PATCH

Descripción: Aplica modificaciones parciales a un recurso. A diferencia de PUT, PATCH solo requiere los cambios a realizar, no una representación completa del recurso.
Ejemplo de Uso: Cambiar el correo electrónico de un usuario: PATCH /usuarios/123 con solo el campo de correo electrónico en el cuerpo de la solicitud.
Idempotente: Sí. Aplicar repetidamente la misma solicitud produce el mismo resultado.

# HEAD

Descripción: Solicita los encabezados HTTP de un recurso, sin obtener el cuerpo de la respuesta. Es útil para comprobar la existencia de un recurso o la información de metadatos sin descargar el contenido.
Ejemplo de Uso: Verificar si un archivo existe: HEAD /archivo.zip.
Idempotente: Sí. No cambia el estado del recurso.

# OPTIONS

Descripción: Devuelve los métodos HTTP que el servidor soporta para un recurso específico. Es útil para descubrir las capacidades del servidor.
Ejemplo de Uso: OPTIONS /usuarios podría devolver GET, POST, PUT, DELETE.
Idempotente: Sí. No cambia el estado del recurso.

# 4 -¿Qué es un recurso en el contexto de un servicio REST?

En el contexto de un servicio REST, un recurso es una entidad o un objeto que se puede identificar de manera única y a la que se puede acceder a través de una URL.
Los recursos representan los datos que la API maneja y que el cliente puede manipular mediante las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)(en ingles:Create,Read,Update,Delete).

# 5 -¿Qué es un endpoint?

En el contexto de un servicio REST, un endpoint es una URL específica que expone un recurso particular o una funcionalidad de la API.
Es el punto de entrada donde el cliente puede interactuar con el recurso utilizando uno de los métodos HTTP (GET, POST, PUT, DELETE, etc.).
Cada endpoint es una combinación de la URL base del servicio y una ruta específica que identifica el recurso o la acción que se quiere realizar.

# 6 -Estructura de un Servicio REST

La estructura de un servicio REST se refiere a cómo se organiza y expone la API para interactuar con los recursos. Esta estructura es fundamental para asegurar que el servicio sea coherente, fácil de usar y mantener. A continuación, se describen los componentes principales de la estructura de un servicio REST:

1. Recursos y URIs
   Recursos: En un servicio REST, los recursos son las entidades principales (por ejemplo, usuarios, productos, pedidos) que se manipulan a través de la API. Cada recurso debe tener una representación clara y bien definida.
   URI (Uniform Resource Identifier): Cada recurso tiene una URI única que lo identifica dentro del servicio. Las URIs deben ser claras y predecibles, siguiendo una estructura lógica.
   Ejemplo:
   https://api.miservicio.com/usuarios (para acceder a todos los usuarios)
   https://api.miservicio.com/usuarios/123 (para acceder a un usuario específico con ID 123)
2. Métodos HTTP
   Los métodos HTTP estándar (GET, POST, PUT, DELETE, PATCH) se utilizan para realizar operaciones sobre los recursos. La elección del método adecuado es crucial para mantener la coherencia y la previsibilidad del servicio.
   GET: Obtener información sobre un recurso o una colección de recursos.
   POST: Crear un nuevo recurso.
   PUT: Actualizar un recurso existente, o crear uno si no existe.
   DELETE: Eliminar un recurso.
   PATCH: Aplicar actualizaciones parciales a un recurso.
3. Encabezados HTTP
   Los encabezados HTTP son importantes para el control de la comunicación entre el cliente y el servidor. Incluyen información sobre el tipo de contenido (Content-Type), la autenticación (Authorization), el control de cache (Cache-Control), y otros aspectos relevantes.
   Ejemplo de Encabezados:
   Content-Type: application/json: Indica que la solicitud o respuesta contiene datos en formato JSON.
   Authorization: Bearer <token>: Proporciona el token de autenticación.
4. Códigos de Estado HTTP
   Los códigos de estado en las respuestas del servidor indican el resultado de la solicitud. Estos códigos son esenciales para que el cliente entienda cómo manejar la respuesta.
   2xx: Éxito (por ejemplo, 200 OK, 201 Created).
   4xx: Error del cliente (por ejemplo, 400 Bad Request, 404 Not Found).
   5xx: Error del servidor (por ejemplo, 500 Internal Server Error).
5. Cuerpo de la Solicitud y Respuesta
   Solicitud: Cuando se envían datos al servidor (en métodos como POST o PUT), el cuerpo de la solicitud contiene la representación del recurso. Normalmente, se utiliza JSON o XML

Ejemplo:

```json
	this.desktopConnection = new DesktopConnection("OpenFinDesktopDemo");
```

Respuesta: El servidor envía una respuesta que contiene la representación del recurso solicitado o el resultado de la operación. El cuerpo de la respuesta también suele estar en JSON o XML. 6. Parámetros de URL y Query
Parámetros de Ruta: Se incluyen en la URI para identificar recursos específicos.
Ejemplo: https://api.miservicio.com/usuarios/123
Parámetros de Consulta (Query): Se añaden al final de la URI para filtrar o modificar las solicitudes.
Ejemplo: https://api.miservicio.com/usuarios?activo=true&rol=admin 7. Versionamiento
Para mantener la compatibilidad con versiones anteriores mientras se introducen nuevas funcionalidades, las APIs RESTful suelen versionarse.
Ejemplo: https://api.miservicio.com/v1/usuarios y https://api.miservicio.com/v2/usuarios
El versionamiento puede hacerse en la URL, en los encabezados HTTP, o como un parámetro de consulta. 8. Autenticación y Autorización
Autenticación: Verifica la identidad del cliente que hace la solicitud. Esto suele hacerse mediante tokens (por ejemplo, JWT), claves API, o mecanismos OAuth.
Autorización: Determina si el cliente autenticado tiene permiso para realizar la acción solicitada. Esto asegura que solo los usuarios autorizados puedan acceder o manipular ciertos recursos. 9. Documentación
Una API REST bien estructurada debe incluir documentación clara y detallada, que explique los endpoints disponibles, los métodos HTTP soportados, los códigos de estado, ejemplos de solicitud y respuesta, y cualquier otra información relevante.
Herramientas como Swagger o OpenAPI se utilizan comúnmente para generar y mantener esta documentación.
Ejemplo de Estructura de un Servicio REST:

```
https://api.miservicio.com/v1/
├── usuarios
│   ├── GET /usuarios (Recuperar todos los usuarios)
│   ├── POST /usuarios (Crear un nuevo usuario)
│   ├── GET /usuarios/{id} (Recuperar un usuario por ID)
│   ├── PUT /usuarios/{id} (Actualizar un usuario por ID)
│   └── DELETE /usuarios/{id} (Eliminar un usuario por ID)
├── productos
│   ├── GET /productos (Recuperar todos los productos)
│   ├── POST /productos (Crear un nuevo producto)
│   └── ...
└── pedidos
    ├── GET /pedidos (Recuperar todos los pedidos)
    ├── POST /pedidos (Crear un nuevo pedido)
    └── ...
```

# 7 - ¿Qué es un URI y cómo se define?

Un URI (Uniform Resource Identifier) es una secuencia de caracteres que identifica de manera unívoca un recurso en Internet o en una red privada. Un URI puede referirse a recursos que se acceden a través de un servicio web, un archivo en un sistema local, o incluso a recursos conceptuales.

Componentes de un URI
Un URI se compone de varios elementos que en conjunto permiten localizar y acceder a un recurso. Aunque no todos los URIs contienen todos los componentes, aquí están los principales:

Esquema:

Indica el protocolo o método utilizado para acceder al recurso.
Ejemplos: http, https, ftp, mailto.
Ejemplo en un URI: https://
Autoridad:

Indica la ubicación del recurso, generalmente un nombre de dominio o dirección IP, y opcionalmente un puerto.
Ejemplo: www.ejemplo.com, api.miservicio.com:8080.
Ejemplo en un URI: https://www.ejemplo.com
Ruta:

Especifica la localización exacta del recurso en el servidor. Generalmente sigue la estructura de directorios.
Ejemplo: /usuarios/123, /docs/manual.pdf.
Ejemplo en un URI: https://www.ejemplo.com/usuarios/123
Consulta (Query):

Opcionalmente, proporciona parámetros adicionales para la solicitud. Se añade después del signo ? y consiste en pares clave-valor separados por &.
Ejemplo: ?nombre=Juan&edad=30.
Ejemplo en un URI: https://www.ejemplo.com/busqueda?q=rest+api
Fragmento:

Referencia una parte específica de un recurso, como una sección de una página web. Se añade después del signo #.
Ejemplo: #seccion2.
Ejemplo en un URI: https://www.ejemplo.com/manual#seccion2

#Ejemplo Completo de un URI:

```
https://www.ejemplo.com:8080/usuarios/123?activo=true#perfil
```

Esquema: https
Autoridad: www.ejemplo.com:8080
Ruta: /usuarios/123
Consulta: activo=true
Fragmento: perfil

# 8 -¿Qué es una API RESTful?

Una API RESTful es una interfaz de programación de aplicaciones (API) que sigue los principios y restricciones del estilo arquitectónico REST (Representational State Transfer). REST es un enfoque para la comunicación entre sistemas, basado en el uso de HTTP para interactuar con recursos definidos a través de URIs (Uniform Resource Identifiers). Las APIs RESTful permiten a los desarrolladores interactuar con los servicios web de una manera predecible y escalable.

Características Clave de una API RESTful
Cliente-Servidor:

La arquitectura REST se basa en una separación clara entre el cliente (que realiza las solicitudes) y el servidor (que maneja los recursos y responde a las solicitudes). Esto permite que el cliente y el servidor evolucionen de manera independiente.
Stateless (Sin Estado):

Cada solicitud del cliente al servidor debe contener toda la información necesaria para que el servidor entienda y procese la solicitud. El servidor no almacena información sobre el estado del cliente entre solicitudes. Esto simplifica la escalabilidad y la gestión del sistema.
Cacheable:

Las respuestas de una API RESTful deben ser marcadas como cacheables o no cacheables. Si una respuesta es cacheable, el cliente puede almacenar la respuesta para evitar realizar la misma solicitud repetidamente, lo que mejora la eficiencia.
Sistema en Capas:

La arquitectura REST permite que las funciones del sistema se organicen en capas. Por ejemplo, un intermediario (como un servidor proxy) podría manejar la autenticación sin que el cliente o el servidor final tengan que cambiar.
Interfaz Uniforme:

Una API RESTful utiliza una interfaz uniforme para interactuar con los recursos. Esto significa que la API debe usar métodos HTTP estándar (GET, POST, PUT, DELETE) de manera coherente, y los recursos deben estar bien identificados a través de URIs.
Representación de Recursos:

Los recursos en una API RESTful se representan en formatos estándar, como JSON, XML o HTML. La representación se envía al cliente como respuesta a una solicitud y puede variar según las necesidades del cliente y las capacidades del servidor.

# 9 -¿Qué son los códigos de estado HTTP y cómo se usan en REST?

Los códigos de estado HTTP son números que el servidor devuelve en respuesta a una solicitud HTTP realizada por un cliente. Estos códigos indican el resultado de la solicitud, informando al cliente si fue exitosa, si ocurrió un error, o si se requiere alguna acción adicional. En el contexto de una API RESTful, los códigos de estado HTTP son fundamentales para la comunicación clara entre el cliente y el servidor.

Categorías de Códigos de Estado HTTP
Los códigos de estado HTTP se agrupan en cinco categorías principales, cada una con un propósito específico:

1xx (Informativos):

Indican que la solicitud ha sido recibida y el proceso continúa.
Ejemplo: 100 Continue.
2xx (Éxito):

Indican que la solicitud fue recibida, entendida y procesada correctamente.
Ejemplos:
200 OK: La solicitud se completó con éxito. Se utiliza, por ejemplo, cuando se obtiene un recurso con GET o se actualiza un recurso con PUT.
201 Created: Indica que un nuevo recurso ha sido creado exitosamente. Generalmente se devuelve en respuesta a un POST.
204 No Content: La solicitud se completó con éxito, pero no hay contenido para devolver. Se usa comúnmente con DELETE o PUT.
3xx (Redirecciones):

Indican que se requiere una acción adicional para completar la solicitud, generalmente una redirección a otra URL.
Ejemplos:
301 Moved Permanently: El recurso solicitado ha sido movido a una nueva URI permanentemente.
302 Found: El recurso solicitado se encuentra temporalmente en una URI diferente.
304 Not Modified: Indica que el recurso no ha cambiado y se puede usar una versión en caché.
4xx (Errores del Cliente):

Indican que hubo un problema con la solicitud del cliente.
Ejemplos:
400 Bad Request: La solicitud es inválida o malformada. Puede deberse a parámetros incorrectos o datos mal estructurados.
401 Unauthorized: La autenticación es necesaria para acceder al recurso, pero no se proporcionó o es inválida.
403 Forbidden: El servidor entiende la solicitud, pero se niega a autorizarla.
404 Not Found: El recurso solicitado no se encuentra disponible en la URI proporcionada.
405 Method Not Allowed: El método HTTP utilizado no está permitido para el recurso solicitado.
5xx (Errores del Servidor):

Indican que el servidor falló al completar una solicitud válida.
Ejemplos:
500 Internal Server Error: Se produjo un error inesperado en el servidor.
501 Not Implemented: El servidor no reconoce el método de solicitud o no tiene la capacidad de cumplir con ella.
503 Service Unavailable: El servidor no está disponible temporalmente, generalmente debido a mantenimiento o sobrecarga.
Uso de Códigos de Estado HTTP en una API RESTful
En una API RESTful, los códigos de estado HTTP se utilizan para proporcionar retroalimentación clara al cliente sobre el estado de su solicitud. Aquí te muestro algunos ejemplos de cómo se usan en las diferentes operaciones RESTful:

Operaciones con GET:
200 OK: Se devuelve cuando un recurso solicitado se ha recuperado con éxito.
404 Not Found: Se devuelve cuando el recurso solicitado no existe.
Operaciones con POST:
201 Created: Se devuelve cuando un nuevo recurso se ha creado con éxito.
400 Bad Request: Se devuelve cuando los datos proporcionados en la solicitud no son válidos o están malformados.
Operaciones con PUT:
200 OK: Se devuelve cuando un recurso se actualiza con éxito.
204 No Content: Se devuelve cuando la actualización se realizó correctamente pero no hay contenido para devolver.
404 Not Found: Se devuelve cuando se intenta actualizar un recurso que no existe.
Operaciones con DELETE:
204 No Content: Se devuelve cuando un recurso se elimina con éxito.
404 Not Found: Se devuelve cuando se intenta eliminar un recurso que no existe.
Autenticación y Autorización:
401 Unauthorized: Se devuelve cuando una solicitud no está autenticada.
403 Forbidden: Se devuelve cuando el usuario autenticado no tiene permisos para realizar la acción solicitada.

# 10 -Agregar una tabla con los códigos HTTP de respuesta más comunes, y su significado.

```
| **Código** | **Nombre**                  | **Significado**                                                                                                  |
|------------|-----------------------------|------------------------------------------------------------------------------------------------------------------|
| 200        | OK                          | La solicitud se ha completado con éxito. Se utiliza para respuestas exitosas a solicitudes GET, POST, PUT.       |
| 201        | Created                     | Un nuevo recurso ha sido creado exitosamente. Generalmente se usa en respuestas a solicitudes POST.              |
| 204        | No Content                  | La solicitud se ha completado con éxito, pero no hay contenido que devolver. Se usa comúnmente con DELETE o PUT. |
| 400        | Bad Request                 | La solicitud es inválida o malformada. Se debe a parámetros incorrectos o datos mal estructurados.               |
| 401        | Unauthorized                | La solicitud requiere autenticación. El cliente debe proporcionar credenciales válidas para acceder.             |
| 403        | Forbidden                   | El servidor entiende la solicitud, pero se niega a autorizarla. Puede deberse a permisos insuficientes.          |
| 404        | Not Found                   | El recurso solicitado no se encuentra en la URI proporcionada.                                                   |
| 405        | Method Not Allowed          | El método HTTP utilizado no está permitido para el recurso solicitado.                                           |
| 409        | Conflict                    | La solicitud no pudo completarse debido a un conflicto con el estado actual del recurso.                         |
| 415        | Unsupported Media Type      | El tipo de medio de la solicitud no es compatible con el recurso solicitado.                                     |
| 500        | Internal Server Error       | El servidor encontró un error interno al procesar la solicitud.                                                  |
| 501        | Not Implemented             | El servidor no reconoce el método de solicitud o no tiene la capacidad de cumplir con ella.                      |
| 503        | Service Unavailable         | El servidor no está disponible temporalmente, generalmente debido a mantenimiento o sobrecarga.                  |

```

# 11 - ¿Qué es JSON y por qué se usa comúnmente en APIs REST?

JSON (JavaScript Object Notation) es un formato ligero de intercambio de datos que es fácil de leer y escribir para los humanos, y fácil de analizar y generar para las máquinas.
Es un formato de texto que se basa en la sintaxis de los objetos de JavaScript, pero es independiente del lenguaje, lo que lo hace adecuado para el intercambio de datos entre sistemas heterogéneos.

Estructura de JSON
JSON está compuesto por dos estructuras principales:

Objetos:

Un objeto en JSON es una colección desordenada de pares clave-valor, donde cada clave es una cadena de texto y cada valor puede ser un número, una cadena de texto, un booleano, un objeto, una lista o null.
Se representan entre llaves {}.
Ejemplo:

```json
{
  "nombre": "Juan",
  "edad": 30,
  "activo": true
}
```

Arrays (Listas):

Un array en JSON es una lista ordenada de valores, donde cada valor puede ser un número, una cadena de texto, un booleano, un objeto, otro array o null.
Se representan entre corchetes [].

Ejemplo:

```json
["manzana", "banana", "cereza"]
```

Razones por las que JSON se usa comúnmente en APIs REST
Legibilidad y Simplicidad:

JSON es fácil de leer y escribir para los humanos debido a su formato claro y estructurado. La sintaxis es simple y evita la complejidad innecesaria.
Compatibilidad con JavaScript:

JSON se basa en una sintaxis que es nativa de JavaScript, lo que facilita su uso en aplicaciones web. Los navegadores pueden analizar y generar JSON de manera eficiente con JavaScript.
Formato Ligero:

JSON es menos verboso que otros formatos como XML, lo que reduce el tamaño de los datos transmitidos y mejora la eficiencia en términos de ancho de banda y tiempo de procesamiento.
Interoperabilidad:

JSON es un formato de intercambio de datos independiente del lenguaje. Esto significa que puede ser usado en una amplia variedad de lenguajes de programación y plataformas, facilitando la comunicación entre sistemas diferentes.
Facilidad de Análisis:

La mayoría de los lenguajes de programación modernos tienen bibliotecas o funciones integradas para analizar y generar JSON, lo que simplifica el desarrollo y la integración.
Estructura Flexibles:

JSON permite estructuras de datos anidadas, lo que proporciona flexibilidad para representar datos complejos. Los objetos y arrays anidados pueden usarse para modelar relaciones y jerarquías de datos de manera intuitiva.
Ejemplo de JSON en una API REST
Supongamos que tienes una API RESTful que devuelve información sobre usuarios. La respuesta de la API podría ser algo así:

Respuesta JSON para una solicitud GET /usuarios/123:

```json
{
  "id": 123,
  "nombre": "Juan Pérez",
  "edad": 30,
  "email": "juan.perez@ejemplo.com",
  "activo": true,
  "direcciones": [
    {
      "tipo": "casa",
      "direccion": "123 Mcal Lopez",
      "ciudad": "Asuncion",
      "pais": "Paraguay"
    },
    {
      "tipo": "trabajo",
      "direccion": "456 Bruno Guggiari",
      "ciudad": "Lambaré",
      "pais": "Paraguay"
    }
  ]
}
```
