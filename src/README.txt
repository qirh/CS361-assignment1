UTEID: mp34495; soa322;
FIRSTNAME: Ovais; Saleh;
LASTNAME: Panjwani; Alghusson;
CSACCOUNT: mp34495; almto3;
EMAIL: ovais.panjwani@utexas.edu; almto3@hotmail.com;

[Program 1]
[Description]
There is one java file name SecureSystem.java which contains the classes SecureSystem, SecurityLevel, SubjectManager (handles subjects), ReferenceMonitor, InstructionObject and Reader. As well as inner classes: ObjectManager (handles Objects), Subject, Object and  BadInstruction. The both of us worked together to finish and to compile our program use "javac *.java" and run it with "java SecureSystem instructionList". So the program reads through the instruction list from the Reader class, then checks if it is a proper instruction by the InstructionObject class, then in ReferenceMonitor the dominates relations are checked to see if they pass and set the variables for the subject/object created in the beginning. We treat white lines in the instruction file as bad instructions.

[Finish]
Finished all requirements

[Test Cases]
There are a total of 6 test cases.
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

[Input of test 5]

write lyle hobj 20
write hal lobj 200
The missile launch code is 1234567
write hal hobj 

read lyle lobj
read lyle hobj
read hal 
write lyle   lobj 10
read hal 		lobj 
read hal hobj
foo lyle lobj
Hi lyle, This is hal

[Output of test 5]
Bad Instruction
The current state is:
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

lyle writes value 20 to hobj
The current state is:
	lobj has value: 0
	hobj has value: 20
	lyle has recently read: 0
	hal has recently read: 0

hal writes value 200 to lobj
The current state is:
	lobj has value: 0
	hobj has value: 20
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
The current state is:
	lobj has value: 0
	hobj has value: 20
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
The current state is:
	lobj has value: 0
	hobj has value: 20
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
The current state is:
	lobj has value: 0
	hobj has value: 20
	lyle has recently read: 0
	hal has recently read: 0

lyle reads lobj
The current state is:
	lobj has value: 0
	hobj has value: 20
	lyle has recently read: 0
	hal has recently read: 0

lyle reads hobj
The current state is:
	lobj has value: 0
	hobj has value: 20
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
The current state is:
	lobj has value: 0
	hobj has value: 20
	lyle has recently read: 0
	hal has recently read: 0

lyle writes value 10 to lobj
The current state is:
	lobj has value: 10
	hobj has value: 20
	lyle has recently read: 0
	hal has recently read: 0

hal reads lobj
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

[Input of test 6]
write lyle hobj a
write lyle hal 6
write hal hobj 
read lyle lobj
write hal 
write lyle   lobj 6
dinner tomorrow at my place
read hal 		lobj 
Hi lyle, This is hal
foo lyle lobj
read hal hobj

[Output of test 6]
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

Bad Instruction
The current state is:
	lobj has value: 0
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

lyle reads lobj
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

lyle writes value 6 to lobj
The current state is:
	lobj has value: 6
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

Bad Instruction
The current state is:
	lobj has value: 6
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0

hal reads lobj
The current state is:
	lobj has value: 6
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 6

Bad Instruction
The current state is:
	lobj has value: 6
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 6

Bad Instruction
The current state is:
	lobj has value: 6
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 6

hal reads hobj
The current state is:
	lobj has value: 6
	hobj has value: 0
	lyle has recently read: 0
	hal has recently read: 0