# **Calcule el dígito de control en un ISBN**

El número de libro estándar internacional, abreviado ISBN, es un identificador único para cualquier libro cuyo uso sea comercial. Así es como se descompone y calcula el dígito de control que figura como último dígito.

El formato de un código ISBN de 10 dígitos es el siguiente:
  1. Código de grupo (1 dígito)
  2. Código de editor (4 dígitos)
  3. Código de libro (4 dígitos)
  4. Carácter / dígito de control (1 carácter / dígito)

Por ejemplo, el código ISBN de un libro determinado es 0675209935. El carácter o dígito de control (5 en el ejemplo) se obtiene en dos pasos:

  1. Cada dígito se multiplica por el índice correspondiente a su posición y se suman los números resultantes. En el ejemplo:
      <br>
     ![image](https://raw.githubusercontent.com/iamcarlosmunoz/socket-server-java/isbn-code/img/calculoISBN.PNG)
  2. La suma se divide por 11 y el resto se toma como dígito de control, teniendo en cuenta que si el resto es 10, se usa el carácter X como carácter de control. En el ejemplo, el resto de la división entera de 225 por 11 es 5, que es el dígito de control.

**El programa debe hacer lo siguiente:** 
---
El cliente envía el código ISBN de 9 dígitos al servidor, el servidor lo procesa, calcula el dígito de control y devuelve dos salidas al cliente: el código de control y el nuevo ISBN de 10 dígitos que incluye el dígito de control.
