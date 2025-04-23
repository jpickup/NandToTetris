// Multiply RAM[0] by RAM[1] putting the result in RAM[2]
// RAM[1] must be >= 0
//
// reset the ouput, RAM[2]
@R0
D=A
@R2
M=D
// copy the second value RAM[1] to RAM[3], this will be the counter
@R1
D=M
@R3
M=D
// while RAM[3]>0 do {
(WHILE)
// exit loop if RAM[3] <= 0
@R3
D=M
@END
D;JLE
// get the first value, RAM[0] and add it to RAM[2]
@R0
D=M
@R2
D=D+M
M=D
// decrement RAM[3]
@R3
D=M
D=D-1
M=D
// go back to start of while loop
@WHILE
0;JMP
(END)
// infinite loop to terminate
@END
0;JMP