; KolakoskiSequence.nasm

; Le a quantidade de valores da RAM[0] e grava a sequencia de números 
; da Sequencia de Kolakoski nas posições seguintes RAM[1], RAM[2], etc....
; Por exemplo: se RAM[0]=6
; RAM[1]=1, RAM[2]=2, RAM[3]=1, RAM[4]=1, RAM[5]=2, RAM[6]=1
; Maiores informações em: https://oeis.org/A000002

leaw $1, %A
movw %A, %D
leaw $0, %A
subw (%A), %D, (%A)

leaw $1, %A 
movw %A, %D 
leaw $1, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $2, %A 
movw %A, %D 
leaw $2, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $2, %A 
movw %A, %D 
leaw $3, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $1, %A 
movw %A, %D 
leaw $4, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $1, %A 
movw %A, %D 
leaw $5, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $2, %A 
movw %A, %D 
leaw $6, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $1, %A 
movw %A, %D 
leaw $7, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $2, %A 
movw %A, %D 
leaw $8, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $2, %A 
movw %A, %D 
leaw $9, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $1, %A 
movw %A, %D 
leaw $10, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $2, %A 
movw %A, %D 
leaw $11, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $1, %A 
movw %A, %D 
leaw $13, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $1, %A 
movw %A, %D 
leaw $14, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $2, %A 
movw %A, %D 
leaw $15, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $1, %A 
movw %A, %D 
leaw $16, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $1, %A 
movw %A, %D 
leaw $17, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $2, %A 
movw %A, %D 
leaw $18, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $2, %A 
movw %A, %D 
leaw $19, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $1, %A 
movw %A, %D 
leaw $20, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $2, %A 
movw %A, %D 
leaw $21, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $1, %A 
movw %A, %D 
leaw $22, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $1, %A 
movw %A, %D 
leaw $23, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $2, %A 
movw %A, %D 
leaw $24, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $1, %A 
movw %A, %D 
leaw $25, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $2, %A 
movw %A, %D 
leaw $26, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $2, %A 
movw %A, %D 
leaw $27, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $1, %A 
movw %A, %D 
leaw $28, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $1, %A 
movw %A, %D 
leaw $29, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $2, %A 
movw %A, %D 
leaw $30, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $1, %A 
movw %A, %D 
leaw $31, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $2, %A 
movw %A, %D 
leaw $32, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jmp

END:
nop