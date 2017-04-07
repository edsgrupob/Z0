; SternDiatomicSeries.nasm

; Calcula a série Stern’s Diatomic, a quantidade de elementos gerados é RAM[0]*2+1
; Os resultados são armazenados na RAM[1], RAM[2], etc....
; A série deve gerar: 1,1,2,1,3,2,3,1,4,3,5,2,5,3,4,1,5,4,7,3,8,5,7,2,7,5, etc...


; Pega o valor de RAM[0] e subtrai 1

leaw $1, %A
movw %A, %D
leaw $0, %A
subw (%A), %D, (%A)

; Primeiro seta 1 como o primeiro item da lista e depois coloca esse valor na RAM[1]; então se RAM[0] menor ou igual a zero pula pro end, senão continua

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

; Primeiro seta 1 como o primeiro item da lista e depois coloca esse valor na RAM[2]; então se RAM[0] menor ou igual a zero pula pro end, senão continua

leaw $1, %A 
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


; Primeiro seta 2 como o primeiro item da lista e depois coloca esse valor na RAM[3]; então se RAM[0] menor ou igual a zero pula pro end, senão continua

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

;repete os passos anteriores

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

leaw $3, %A 
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

leaw $3, %A 
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

leaw $1, %A 
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

leaw $4, %A 
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

leaw $3, %A 
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

leaw $5, %A 
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

leaw $2, %A 
movw %A, %D 
leaw $12, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jle

leaw $5, %A 
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

leaw $3, %A 
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

leaw $4, %A 
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

leaw $5, %A 
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

leaw $4, %A 
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

leaw $7, %A 
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

leaw $3, %A 
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

leaw $8, %A 
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

leaw $5, %A 
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

leaw $7, %A 
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

leaw $7, %A 
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

leaw $5, %A 
movw %A, %D 
leaw $26, %A
movw %D, (%A) 
leaw $1, %A 
movw %A, %D 
leaw $0, %A
subw (%A), %D, (%A) 
movw (%A), %D
leaw $END,%A
jmp

END:
leaw $END, %A
jmp