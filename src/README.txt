UTEID: mp34495; soa322;
FIRSTNAME: Ovais; Saleh;
LASTNAME: Panjwani; Alghusson;
CSACCOUNT: mp34495; almto3;
EMAIL: ovais.panjwani@utexas.edu; almto3@hotmail.com;

[Program 1]
[Description]
There is one java file name SecureSystem.java which contains the classes SecureSystem, SecurityLevel, SubjectManager (handles subjects), ReferenceMonitor, ObjectManager, Subject, Object, InstructionObject, BadInstruction, and Reader. The both of us worked together to finish and to compile our program use "javac *.java" and run it with "java SecureSystem instructionList". So the program reads the instructionList then 

[Finish]

[Test Cases]
[Input of test 1]
write hal hobj 
read hal 
write lyle   lobj 10
read hal 		lobj 
write lyle hobj 20
write hal lobj 200
read hal hobj
read lyle lobj
read lyle hobj
foo lyle lobj
Hi lyle, This is hal
The missile launch code is 1234567

[Output of test 1]
Bad Instruction
The current state is: 
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
The current state is: 
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

lyle writes value 10 to lobj
The current state is: 
	lobj has value: 10
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

hal reads lobj
The current state is: 
	lobj has value: 10
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 10

lyle writes value 20 to hobj
The current state is: 
	lobj has value: 10
	hobj has value: 20
	lyle has recently read: 0
	hal has recently read: 10

hal writes value 200 to lobj
The current state is: 
	lobj has value: 10
	hobj has value: 20
	lyle has recently read: 0
	hal has recently read: 10

hal reads hobj
The current state is: 
	lobj has value: 10
	hobj has value: 20
	lyle has recently read: 0
	hal has recently read: 20

lyle reads lobj
The current state is: 
	lobj has value: 10
	hobj has value: 20
	lyle has recently read: 10
	hal has recently read: 20

lyle reads hobj
The current state is: 
	lobj has value: 10
	hobj has value: 20
	lyle has recently read: 0
	hal has recently read: 20

Bad Instruction
The current state is: 
	lobj has value: 10
	hobj has value: 20
	lyle has recently read: 0
	hal has recently read: 20

Bad Instruction
The current state is: 
	lobj has value: 10
	hobj has value: 20
	lyle has recently read: 0
	hal has recently read: 20

Bad Instruction
The current state is: 
	lobj has value: 10
	hobj has value: 20
	lyle has recently read: 0
	hal has recently read: 20


[Input of test 2]
WriTe hAl hObj 10
READ hal HOBJ

[Output of test 2]
hal writes value 10 to hobj
The current state is: 
	lobj has value: 0
	hobj has value: 10
	lyle has recently read: 0
	hal has recently read: 0

hal reads hobj
The current state is: 
	lobj has value: 0
	hobj has value: 10
	lyle has recently read: 0
	hal has recently read: 10


[Input of test 3]
write lyle hobj 10
write hal lobj 10
read lyle hobj
read hal lobj

[Output of test 3]
lyle writes value 10 to hobj
The current state is: 
	lobj has value: 0
	hobj has value: 10
	lyle has recently read: 0
	hal has recently read: 0

hal writes value 10 to lobj
The current state is: 
	lobj has value: 0
	hobj has value: 10
	lyle has recently read: 0
	hal has recently read: 0

lyle reads hobj
The current state is: 
	lobj has value: 0
	hobj has value: 10
	lyle has recently read: 0
	hal has recently read: 0

hal reads lobj
The current state is: 
	lobj has value: 0
	hobj has value: 10
	lyle has recently read: 0
	hal has recently read: 0


[Input of test 4]



write lyle hobj 10

[Output of test 4]
Bad Instruction
The current state is: 
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
The current state is: 
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
The current state is: 
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

lyle writes value 10 to hobj
The current state is: 
	lobj has value: 0
	hobj has value: 10
	lyle has recently read: 0
	hal has recently read: 0