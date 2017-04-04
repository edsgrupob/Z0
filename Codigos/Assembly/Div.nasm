; Div.nasm

; Divide R0 por R1 e armazena o resultado em R2.
; (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)
; divisao para numeros inteiros positivos

leaw $1, %A
movw (%A), %D
leaw $0, %A
movw (%A), %A
subw %A, %D, %D
leaw $3, %A
movw %D, (%A)
leaw $2, %A
addw (%A), $1, (%A)
leaw $3, %A
movw (%A), %D
leaw $0, %A
movw %D, (%A)
leaw $0, %A
movw (%A), %D
leaw $1, %A
subw %D, (%A), %D
jge
nop
