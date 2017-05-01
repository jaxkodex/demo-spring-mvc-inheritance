# demo-spring-mvc-inheritance
Demo de herencia en spring MVC.

## 1. Metodo heredado
Implementamos el metodo `testMe` en una clase abstracta:

```java
    @RequestMapping("/api/test")
    public ResponseEntity testMe () {
        return ResponseEntity.noContent().build();
    }
```

El metodo se hereda en la clase concreta `class TestMeController extends AbstractController`:

```java
    @Override
    public ResponseEntity testMe() {
        return super.testMe();
    }
```

No hay problemas y el metodo funciona adecuadamente:

```shell
Mapped "{[/api/test]}" onto public org.springframework.http.ResponseEntity io.github.jaxkodex.demos.controller.TestMeController.testMe()

$ curl -v localhost:8080/api/test && echo ""
*   Trying 127.0.0.1...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /api/test HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.47.0
> Accept: */*
> 
< HTTP/1.1 204 
< Date: Mon, 01 May 2017 06:36:49 GMT
< 
* Connection #0 to host localhost left intact

```

## 2. Metodo no implementado

La clase abstracta tiene un metodo que no es implementado en la clase concreta:

```java
    @RequestMapping("/api/test2")
    public ResponseEntity testMe2 () {
        return ResponseEntity.noContent().build();
    }
```

De igual manera es mapeada adecuadamente, pero al metodo de la clase abstracta

```shell
Mapped "{[/api/test2]}" onto public org.springframework.http.ResponseEntity io.github.jaxkodex.demos.controller.AbstractController.testMe2()

$ curl -v localhost:8080/api/test2 && echo ""
*   Trying 127.0.0.1...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /api/test2 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.47.0
> Accept: */*
> 
< HTTP/1.1 204 
< Date: Mon, 01 May 2017 06:39:29 GMT
< 
* Connection #0 to host localhost left intact

```

## 3. Usando parametros

Clase abstracta:

```java
    @RequestMapping("/api/hello/{name}")
    public ResponseEntity hello (@PathVariable String name) {
        return ResponseEntity.ok(String.format("Hello %s\n", name));
    }
```

Clase concreta:

```java
    @Override
    public ResponseEntity hello(@PathVariable String name) {
        return super.hello(name);
    }
```

Test:

```shell
Mapped "{[/api/hello/{name}]}" onto public org.springframework.http.ResponseEntity io.github.jaxkodex.demos.controller.TestMeController.hello(java.lang.String)

curl -v localhost:8080/api/hello/jaxkodex && echo ""
*   Trying 127.0.0.1...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /api/hello/jaxkodex HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.47.0
> Accept: */*
> 
< HTTP/1.1 200 
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 15
< Date: Mon, 01 May 2017 06:44:37 GMT
< 
Hello jaxkodex
* Connection #0 to host localhost left intact
```

## 4. Con parametros sin @Override

implementacion en clase abstracta:

```java
    @RequestMapping("/api/hello2/{name}")
    public ResponseEntity hello2 (@PathVariable String name) {
        return ResponseEntity.ok(String.format("Hello %s\n", name));
    }
```
Test:

```shell
Mapped "{[/api/hello2/{name}]}" onto public org.springframework.http.ResponseEntity io.github.jaxkodex.demos.controller.AbstractController.hello2(java.lang.String)

curl -v localhost:8080/api/hello2/jaxkodex && echo ""
*   Trying 127.0.0.1...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /api/hello2/jaxkodex HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.47.0
> Accept: */*
> 
< HTTP/1.1 200 
< Content-Type: text/plain;charset=UTF-8
< Content-Length: 15
< Date: Mon, 01 May 2017 06:46:43 GMT
< 
Hello jaxkodex
* Connection #0 to host localhost left intact
```

