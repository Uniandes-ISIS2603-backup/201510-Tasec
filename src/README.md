#API Rest
##Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /servicioClub.frontend/webresources/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

###CRUD Básico
Para los servicios de CRUD Básico, Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
{
    totalRecords: 0, //cantidad de registros en la base de datos
    records: [] //collección con los datos solicitados. cada objeto tiene la estructura de la entidad.
}
```

##API de la aplicación servicioClub
###Entidad servicio
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad servicio, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto servicio
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    minAge: '' /*Tipo Integer*/,
    maxAge: '' /*Tipo Integer*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Retorno
:--:|:--:|:--:|:--:|:--:
**GET**|/servicios|Obtener todos los objetos de servicio (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*|Objeto JSON con registros de servicio y el total de registros en la base de datos
**GET**|/servicios/:id|Obtener los atributos de una instancia de servicio (RETRIEVE)|**@PathParam id**: Identificador del registro|Objeto JSON con detalle de la instancia de servicio
**POST**|/servicios|Crear una nueva instancia de la entidad servicio (CREATE)|Objeto JSON de la entidad|Objeto JSON de servicio creado
**PUT**|/servicios/:id|Actualiza una instancia de la entidad servicio (UPDATE)|Objeto JSON de servicio|Objeto JSON servicio actualizado
**DELETE**|/servicios/:id|Borra instancia de servicio en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro| 

###Entidad Stadium
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Stadium, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Stadium
```javascript
{
    name: '' /*Tipo String*/,
    id: '' /*Tipo Long*/,
    capacity: '' /*Tipo Integer*/,
    city: '' /*Tipo City*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Retorno
:--:|:--:|:--:|:--:|:--:
**GET**|/stadiums|Obtener todos los objetos de Stadium (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*|Objeto JSON con registros de Stadium y el total de registros en la base de datos
**GET**|/stadiums/:id|Obtener los atributos de una instancia de Stadium (RETRIEVE)|**@PathParam id**: Identificador del registro|Objeto JSON con detalle de la instancia de Stadium
**POST**|/stadiums|Crear una nueva instancia de la entidad Stadium (CREATE)|Objeto JSON de la entidad|Objeto JSON de Stadium creado
**PUT**|/stadiums/:id|Actualiza una instancia de la entidad Stadium (UPDATE)|Objeto JSON de Stadium|Objeto JSON Stadium actualizado
**DELETE**|/stadiums/:id|Borra instancia de Stadium en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro| 

###Entidad Country
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Country, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Country
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    population: '' /*Tipo Integer*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Retorno
:--:|:--:|:--:|:--:|:--:
**GET**|/countrys|Obtener todos los objetos de Country (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*|Objeto JSON con registros de Country y el total de registros en la base de datos
**GET**|/countrys/:id|Obtener los atributos de una instancia de Country (RETRIEVE)|**@PathParam id**: Identificador del registro|Objeto JSON con detalle de la instancia de Country
**POST**|/countrys|Crear una nueva instancia de la entidad Country (CREATE)|Objeto JSON de la entidad|Objeto JSON de Country creado
**PUT**|/countrys/:id|Actualiza una instancia de la entidad Country (UPDATE)|Objeto JSON de Country|Objeto JSON Country actualizado
**DELETE**|/countrys/:id|Borra instancia de Country en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro| 

###Entidad City
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad City, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto City
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    population: '' /*Tipo Integer*/,
    country: '' /*Tipo Country*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Retorno
:--:|:--:|:--:|:--:|:--:
**GET**|/citys|Obtener todos los objetos de City (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*|Objeto JSON con registros de City y el total de registros en la base de datos
**GET**|/citys/:id|Obtener los atributos de una instancia de City (RETRIEVE)|**@PathParam id**: Identificador del registro|Objeto JSON con detalle de la instancia de City
**POST**|/citys|Crear una nueva instancia de la entidad City (CREATE)|Objeto JSON de la entidad|Objeto JSON de City creado
**PUT**|/citys/:id|Actualiza una instancia de la entidad City (UPDATE)|Objeto JSON de City|Objeto JSON City actualizado
**DELETE**|/citys/:id|Borra instancia de City en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro| 

###Entidad Prize
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Prize, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Prize
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Retorno
:--:|:--:|:--:|:--:|:--:
**GET**|/prizes|Obtener todos los objetos de Prize (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*|Objeto JSON con registros de Prize y el total de registros en la base de datos
**GET**|/prizes/:id|Obtener los atributos de una instancia de Prize (RETRIEVE)|**@PathParam id**: Identificador del registro|Objeto JSON con detalle de la instancia de Prize
**POST**|/prizes|Crear una nueva instancia de la entidad Prize (CREATE)|Objeto JSON de la entidad|Objeto JSON de Prize creado
**PUT**|/prizes/:id|Actualiza una instancia de la entidad Prize (UPDATE)|Objeto JSON de Prize|Objeto JSON Prize actualizado
**DELETE**|/prizes/:id|Borra instancia de Prize en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro| 

###Entidad Record
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Record, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Record
```javascript
{
    measureUnit: '' /*Tipo MeasureUnit*/,
    record: '' /*Tipo Integer*/,
    name: '' /*Tipo String*/,
    id: '' /*Tipo Long*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Retorno
:--:|:--:|:--:|:--:|:--:
**GET**|/records|Obtener todos los objetos de Record (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*|Objeto JSON con registros de Record y el total de registros en la base de datos
**GET**|/records/:id|Obtener los atributos de una instancia de Record (RETRIEVE)|**@PathParam id**: Identificador del registro|Objeto JSON con detalle de la instancia de Record
**POST**|/records|Crear una nueva instancia de la entidad Record (CREATE)|Objeto JSON de la entidad|Objeto JSON de Record creado
**PUT**|/records/:id|Actualiza una instancia de la entidad Record (UPDATE)|Objeto JSON de Record|Objeto JSON Record actualizado
**DELETE**|/records/:id|Borra instancia de Record en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro| 

###Entidad ChampionShip
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad ChampionShip, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto ChampionShip
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    startDate: '' /*Tipo Date*/,
    endDate: '' /*Tipo Date*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Retorno
:--:|:--:|:--:|:--:|:--:
**GET**|/championShips|Obtener todos los objetos de ChampionShip (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*|Objeto JSON con registros de ChampionShip y el total de registros en la base de datos
**GET**|/championShips/:id|Obtener los atributos de una instancia de ChampionShip (RETRIEVE)|**@PathParam id**: Identificador del registro|Objeto JSON con detalle de la instancia de ChampionShip
**POST**|/championShips|Crear una nueva instancia de la entidad ChampionShip (CREATE)|Objeto JSON de la entidad|Objeto JSON de ChampionShip creado
**PUT**|/championShips/:id|Actualiza una instancia de la entidad ChampionShip (UPDATE)|Objeto JSON de ChampionShip|Objeto JSON ChampionShip actualizado
**DELETE**|/championShips/:id|Borra instancia de ChampionShip en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro| 

####Maestros Detalle de ChampionShip
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de ChampionShip son los siguientes:

Tipo|Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:|:--:
Composite|**GET**|championShips/:id/records|Obtener registros de records hijos de ChampionShip|**@PathParam id**: Identificador del registro de ChampionShip||Arreglo de objetos records
Composite|**POST**|championShips/:id/records|Creación de registros records hijos de ChampionShip|**@PathParam id**: Identificador del registro de ChampionShip|Arreglo de objetos records a crear|Arreglo de objetos records creados con sus respectivos ID
Composite|**PUT**|championShips/:id/records|Actualización de registros records hijos de ChampionShip|**@PathParam id**: Identificador del registro de ChampionShip|Arreglo de objetos records a actualizar|Arreglo de objetos records actualizados
Composite|**DELETE**|championShips/:id/records|Eliminación de registros records hijos de ChampionShip|**@PathParam id**: Identificador del registro de ChampionShip|Arreglo de atributo `id` de records a eliminar|
Shared|**GET**|championShips/:id/referees|Obtener registros de referees asociados a ChampionShip|**@PathParam id**: Identificador del registro de ChampionShip||Arreglo de objetos referees asociados a ChampionShip
Shared|**PUT**|championShips/:id/referees|Actualización de referencias a referees desde ChampionShip|**@PathParam id**: Identificador del registro de ChampionShip|Arreglo de objetos referees a asociar|Arreglo de objetos referees asociados
Composite|**GET**|championShips/:id/prizes|Obtener registros de prizes hijos de ChampionShip|**@PathParam id**: Identificador del registro de ChampionShip||Arreglo de objetos prizes
Composite|**POST**|championShips/:id/prizes|Creación de registros prizes hijos de ChampionShip|**@PathParam id**: Identificador del registro de ChampionShip|Arreglo de objetos prizes a crear|Arreglo de objetos prizes creados con sus respectivos ID
Composite|**PUT**|championShips/:id/prizes|Actualización de registros prizes hijos de ChampionShip|**@PathParam id**: Identificador del registro de ChampionShip|Arreglo de objetos prizes a actualizar|Arreglo de objetos prizes actualizados
Composite|**DELETE**|championShips/:id/prizes|Eliminación de registros prizes hijos de ChampionShip|**@PathParam id**: Identificador del registro de ChampionShip|Arreglo de atributo `id` de prizes a eliminar|
Shared|**GET**|championShips/:id/secondaryReferees|Obtener registros de secondaryReferees asociados a ChampionShip|**@PathParam id**: Identificador del registro de ChampionShip||Arreglo de objetos secondaryReferees asociados a ChampionShip
Shared|**PUT**|championShips/:id/secondaryReferees|Actualización de referencias a secondaryReferees desde ChampionShip|**@PathParam id**: Identificador del registro de ChampionShip|Arreglo de objetos secondaryReferees a asociar|Arreglo de objetos secondaryReferees asociados
Shared|**GET**|championShips/:id/stadiums|Obtener registros de stadiums asociados a ChampionShip|**@PathParam id**: Identificador del registro de ChampionShip||Arreglo de objetos stadiums asociados a ChampionShip
Shared|**PUT**|championShips/:id/stadiums|Actualización de referencias a stadiums desde ChampionShip|**@PathParam id**: Identificador del registro de ChampionShip|Arreglo de objetos stadiums a asociar|Arreglo de objetos stadiums asociados
###Entidad DocumentType
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad DocumentType, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto DocumentType
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    length: '' /*Tipo Integer*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Retorno
:--:|:--:|:--:|:--:|:--:
**GET**|/documentTypes|Obtener todos los objetos de DocumentType (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*|Objeto JSON con registros de DocumentType y el total de registros en la base de datos
**GET**|/documentTypes/:id|Obtener los atributos de una instancia de DocumentType (RETRIEVE)|**@PathParam id**: Identificador del registro|Objeto JSON con detalle de la instancia de DocumentType
**POST**|/documentTypes|Crear una nueva instancia de la entidad DocumentType (CREATE)|Objeto JSON de la entidad|Objeto JSON de DocumentType creado
**PUT**|/documentTypes/:id|Actualiza una instancia de la entidad DocumentType (UPDATE)|Objeto JSON de DocumentType|Objeto JSON DocumentType actualizado
**DELETE**|/documentTypes/:id|Borra instancia de DocumentType en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro| 

###Entidad Member
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Member, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Member
```javascript
{
    partner: '' /*Tipo Member*/,
    firstName: '' /*Tipo String*/,
    birthDate: '' /*Tipo Date*/,
    name: '' /*Tipo String*/,
    lastName: '' /*Tipo String*/,
    docNumber: '' /*Tipo String*/,
    enabled: '' /*Tipo Boolean*/,
    id: '' /*Tipo Long*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Retorno
:--:|:--:|:--:|:--:|:--:
**GET**|/members|Obtener todos los objetos de Member (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*|Objeto JSON con registros de Member y el total de registros en la base de datos
**GET**|/members/:id|Obtener los atributos de una instancia de Member (RETRIEVE)|**@PathParam id**: Identificador del registro|Objeto JSON con detalle de la instancia de Member
**POST**|/members|Crear una nueva instancia de la entidad Member (CREATE)|Objeto JSON de la entidad|Objeto JSON de Member creado
**PUT**|/members/:id|Actualiza una instancia de la entidad Member (UPDATE)|Objeto JSON de Member|Objeto JSON Member actualizado
**DELETE**|/members/:id|Borra instancia de Member en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro| 

####Maestros Detalle de Member
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Member son los siguientes:

Tipo|Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:|:--:
Shared|**GET**|members/:id/relatives|Obtener registros de relatives asociados a Member|**@PathParam id**: Identificador del registro de Member||Arreglo de objetos relatives asociados a Member
Shared|**PUT**|members/:id/relatives|Actualización de referencias a relatives desde Member|**@PathParam id**: Identificador del registro de Member|Arreglo de objetos relatives a asociar|Arreglo de objetos relatives asociados
Composite|**GET**|members/:id/addresses|Obtener registros de addresses hijos de Member|**@PathParam id**: Identificador del registro de Member||Arreglo de objetos addresses
Composite|**POST**|members/:id/addresses|Creación de registros addresses hijos de Member|**@PathParam id**: Identificador del registro de Member|Arreglo de objetos addresses a crear|Arreglo de objetos addresses creados con sus respectivos ID
Composite|**PUT**|members/:id/addresses|Actualización de registros addresses hijos de Member|**@PathParam id**: Identificador del registro de Member|Arreglo de objetos addresses a actualizar|Arreglo de objetos addresses actualizados
Composite|**DELETE**|members/:id/addresses|Eliminación de registros addresses hijos de Member|**@PathParam id**: Identificador del registro de Member|Arreglo de atributo `id` de addresses a eliminar|
Shared|**GET**|members/:id/servicios|Obtener registros de servicios asociados a Member|**@PathParam id**: Identificador del registro de Member||Arreglo de objetos servicios asociados a Member
Shared|**PUT**|members/:id/servicios|Actualización de referencias a servicios desde Member|**@PathParam id**: Identificador del registro de Member|Arreglo de objetos servicios a asociar|Arreglo de objetos servicios asociados
###Entidad Address
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Address, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Address
```javascript
{
    street: '' /*Tipo String*/,
    id: '' /*Tipo Long*/,
    city: '' /*Tipo City*/,
    avenue: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Retorno
:--:|:--:|:--:|:--:|:--:
**GET**|/addresss|Obtener todos los objetos de Address (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*|Objeto JSON con registros de Address y el total de registros en la base de datos
**GET**|/addresss/:id|Obtener los atributos de una instancia de Address (RETRIEVE)|**@PathParam id**: Identificador del registro|Objeto JSON con detalle de la instancia de Address
**POST**|/addresss|Crear una nueva instancia de la entidad Address (CREATE)|Objeto JSON de la entidad|Objeto JSON de Address creado
**PUT**|/addresss/:id|Actualiza una instancia de la entidad Address (UPDATE)|Objeto JSON de Address|Objeto JSON Address actualizado
**DELETE**|/addresss/:id|Borra instancia de Address en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro| 

###Entidad MeasureUnit
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad MeasureUnit, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto MeasureUnit
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    description: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Retorno
:--:|:--:|:--:|:--:|:--:
**GET**|/measureUnits|Obtener todos los objetos de MeasureUnit (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*|Objeto JSON con registros de MeasureUnit y el total de registros en la base de datos
**GET**|/measureUnits/:id|Obtener los atributos de una instancia de MeasureUnit (RETRIEVE)|**@PathParam id**: Identificador del registro|Objeto JSON con detalle de la instancia de MeasureUnit
**POST**|/measureUnits|Crear una nueva instancia de la entidad MeasureUnit (CREATE)|Objeto JSON de la entidad|Objeto JSON de MeasureUnit creado
**PUT**|/measureUnits/:id|Actualiza una instancia de la entidad MeasureUnit (UPDATE)|Objeto JSON de MeasureUnit|Objeto JSON MeasureUnit actualizado
**DELETE**|/measureUnits/:id|Borra instancia de MeasureUnit en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro| 

###Entidad User
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad User, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto User
```javascript
{
    firstName: '' /*Tipo String*/,
    birthDate: '' /*Tipo Date*/,
    name: '' /*Tipo String*/,
    lastName: '' /*Tipo String*/,
    docNumber: '' /*Tipo String*/,
    enabled: '' /*Tipo Boolean*/,
    documentType: '' /*Tipo DocumentType*/,
    id: '' /*Tipo Long*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Retorno
:--:|:--:|:--:|:--:|:--:
**GET**|/users|Obtener todos los objetos de User (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*|Objeto JSON con registros de User y el total de registros en la base de datos
**GET**|/users/:id|Obtener los atributos de una instancia de User (RETRIEVE)|**@PathParam id**: Identificador del registro|Objeto JSON con detalle de la instancia de User
**POST**|/users|Crear una nueva instancia de la entidad User (CREATE)|Objeto JSON de la entidad|Objeto JSON de User creado
**PUT**|/users/:id|Actualiza una instancia de la entidad User (UPDATE)|Objeto JSON de User|Objeto JSON User actualizado
**DELETE**|/users/:id|Borra instancia de User en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro| 

###Entidad Referee
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Referee, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Referee
```javascript
{
    ageOfExperience: '' /*Tipo Integer*/,
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    firstName: '' /*Tipo String*/,
    lastName: '' /*Tipo String*/,
    birthDate: '' /*Tipo Date*/,
    enabled: '' /*Tipo Boolean*/,
    docNumber: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Retorno
:--:|:--:|:--:|:--:|:--:
**GET**|/referees|Obtener todos los objetos de Referee (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*|Objeto JSON con registros de Referee y el total de registros en la base de datos
**GET**|/referees/:id|Obtener los atributos de una instancia de Referee (RETRIEVE)|**@PathParam id**: Identificador del registro|Objeto JSON con detalle de la instancia de Referee
**POST**|/referees|Crear una nueva instancia de la entidad Referee (CREATE)|Objeto JSON de la entidad|Objeto JSON de Referee creado
**PUT**|/referees/:id|Actualiza una instancia de la entidad Referee (UPDATE)|Objeto JSON de Referee|Objeto JSON Referee actualizado
**DELETE**|/referees/:id|Borra instancia de Referee en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro| 

