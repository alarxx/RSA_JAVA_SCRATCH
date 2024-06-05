# RSA_JAVA_SCRATCH  
Учебный проект. Реализация RSA на Java. 

+aiym's project with random number generator and password generator.

Application of Number Theory, modular arithmetic and big numbers to implement RSA encryption and electronic digital signature

m - integer message  
p1, p2 - random big prime numbers  
n = p1 * p2  
phi(n) = (p1 - 1) x (p2 - 1) - Euler's Function  

m^e mod n = c, c - encrypted message  

Suppose:  
c^d mon n = m  
m^(e * d) mod n = m,  
(n, e) - Public key,  
(n, d) - Private key.  

Euler's Theorem:  
m^phi(n) = 1 mod n  

m^(k * phi(n) + 1) mod n = m mod n = m^ed mod n  
k * phi(n) + 1 = e * d, e - given open key,  

How to find d?  

First Method:  
d = (k * phi(n) + 1) / e  

Second Method:  
d * e = 1 mod n  
By Modular Multiplicative Inverse:  
e * e^(-1) = 1 mod n  
d = e^(-1)  

