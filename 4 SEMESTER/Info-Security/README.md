# Information-Security
Block cipher algorithms written in Java for Information Security class.

### TASK1 - Vigenere cipher
Console based application. Encrypts and decrypts vigenere cipher. 

### TASK2 - AES algorithm
GUI based application. Saves encrypted text into a database file. 

**Encryption** - Takes plaintext and key information from input fields and encrypts the text. Encrypted text is saved into a database file.

**Decryption** - To decrypt text a key is needed which was entered during text encryption. Encryption key is stored with encrypted text, which needs to be fixed.

### TASK3 - RSA algorithm
Console based application. Saves encrypted text and key into a database file. 

Takes in the message and two prime numbers. Big prime numbers (1000+) are not recommended to enter, since it will take a while to calculate and computer goes *whooosh*.

### TASK4 - RSA digital signature and information exchange with server

To implement RSA digital signature and information exchange with server (server – class, website or another desktop application, which receive information). If using libraries, need explain how it works. In RSA digital signature hash functions is mandatory.

**Requirements:**
Develop desktop (website) application, which communicate with server. Insert text and use hash function. When get the hash value use RSA digital signature. When message and signature value are sent to the server, it is possible to change message and signature value. In server is checked digital signature authentication. If the signature value was changed at the time of sending the signature is not verified, if the signature value wasn’t changed the signature is verified.
