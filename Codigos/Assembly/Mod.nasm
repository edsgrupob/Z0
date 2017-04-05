; Mod.nasm

; Divide o número posicionado na RAM[1] pelo número posicionado no RAM[2] e armazena o resultado na RAM[0].
leaw $2, %A
movw (%A), %D
leaw $1, %A
subw (%A), %D, %D
leaw $4, %A
movw %D, (%A) #Resultado da sub em R4
leaw $3, %A
addw (%A), $1, (%A)  ;Adiciona um ao numero de vezes subtraidos
leaw $4, %A
movw (%A), %D        ;Move pra D o valor depois da sub
leaw $1, %A
movw %D, (%A)        ;coloca o valor na Ram1: novo valor a ser subtraido
leaw $1, %A
movw (%A), %D
leaw $2, %A
subw %D, (%A), %D
leaw $0, %A
jge
leaw $1, %A
movw (%A), %D
leaw $0, %A
movw %D, (%A)
nop
