JWT or JSON Web Token  -> used for securely transmitting the information 
between client and a server. JWT - authentication and authorization purpose

IT has different components:
a) Header -- 1) token (JWT) and the signature algorithm (SHA26 or RSA)
b) Payload:-contains claims : reserved(iss,sub,exp,iat) , public(Authority ) and private (parties should be agreed on using those claims )

c) Signature : a secret Key 

JWT.io

How JWT Works:

Authentication -- User name and Password
Authorization : Claims/ Payload
Stateless : JWT are stateless 