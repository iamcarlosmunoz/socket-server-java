# **Calculate the check digit in an ISBN**

International Standard Book Number, abbreviated ISBN, is a unique identifier for any book whose use is commercial. Here's how the check digit listed as the last digit is decomposed and calculated.

The format of a 10-digit ISBN code is as follows:
  1. Group code (1 digit)
  2. Publisher code (4 digits)
  3. Book code (4 digits)
  4. Character / check digit (1 character / digit)

For example, the ISBN code for a certain book is 0675209935. The character or check digit (5 in the example) is obtained in two steps:

  1. Each digit is multiplied by the index corresponding to its position, and the resulting numbers are added. In the example:
     ![image](https://raw.githubusercontent.com/iamcarlosmunoz/socket-server-java/isbn-code/img/calculoISBN.PNG)
  2. The sum is divided by 11, and the remainder is taken as a check digit, taking into account that if the remainder is 10, the character X is used as a check character. In the example, the remainder of the integer division of 225 by 11 is 5, which is the check digit.

**The program should do the following:** 
---
The client sends the 9-digit ISBN code to the server, the server processes it, calculates the check digit, and returns two outputs to the client: the control code and the new 10-digit ISBN that includes the check digit.
